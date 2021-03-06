package com.michaelgatesdev.OldLeaf;

import com.michaelgatesdev.OldLeaf.game.*;
import com.michaelgatesdev.OldLeaf.gui.GuiManager;
import com.michaelgatesdev.OldLeaf.locale.UTF8Control;
import com.michaelgatesdev.OldLeaf.util.FileUtil;
import com.michaelgatesdev.OldLeaf.util.HexUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Main extends Application
{
    // ============================================================================================================================================ \\
    
    private static final Logger logger = Logger.getLogger(Main.class);
    
    private static final int MAIN_WINDOW_WIDTH  = 1000;
    private static final int MAIN_WINDOW_HEIGHT = 650;
    
    private static Main       instance;
    private        GuiManager guiManager;
    
    private ResourceBundle locale;
    
    private File rootDir;
    private File resourcesDir;
    private File imageResDir;
    private File textResDir;
    private File backupsDir;
    private File templatesDir;
    private File inventoryTemplatesDir;
    private File townTemplatesDir;
    private File islandTemplatesDir;
    private File appearanceTemplatesDir;
    
    private SaveGame saveGame;
    
    private Set<GameItem>      gameItems;
    private Set<String>        gameItemNames;
    private Set<String>        gameItemCategories;
    private Map<String, Color> gameItemCategoryColors;
    
    private Set<Structure> gameStructures;
    private Set<String>    gameStructureNames;
    private Set<String>    gameStructureCategories;
    
    private Map<Byte, File> acreImages;
    
    // ============================================================================================================================================ \\
    
    
    /**
     * The main method when the program starts
     *
     * @param args Arguments provided if used by command line
     */
    public static void main(String[] args)
    {
        instance = new Main();
        instance.initialize();
        // this kills the singleton
        Runtime.getRuntime().addShutdownHook(new Thread(() -> instance = null));
    }
    
    
    /**
     * Initializes the program in a non-static way
     */
    private void initialize()
    {
        this.guiManager = new GuiManager(this);
        
        // Grab locale bundle
        locale = ResourceBundle.getBundle("Locale", /*Locale.JAPAN,*/ new UTF8Control());
        
        // Create/Initialize all the directories */
        initializeDirectories();
        
        // load items
        File itemsFile = new File(textResDir, "/items.xml");
        this.loadItems(itemsFile);
        
        // structures
        File structuresFile = new File(textResDir, "/structures.xml");
        this.loadStructures(structuresFile);
        
        // acres
        this.loadAcreImages();
        
        
        // Init GUI
        launch();
    }
    
    
    private void initializeDirectories()
    {
        try
        {
            rootDir = new File(System.getProperty("user.dir") + "/");
            
            resourcesDir = FileUtil.createDirectory(rootDir, "_resources", true);
            FileUtils.copyDirectoryToDirectory(FileUtils.toFile(this.getResourceURL("text/")), resourcesDir);
            textResDir = new File(resourcesDir, "/text/");
            FileUtils.copyDirectoryToDirectory(FileUtils.toFile(this.getResourceURL("img/")), resourcesDir);
            imageResDir = new File(resourcesDir, "/img/");
            
            backupsDir = FileUtil.createDirectory(rootDir, "_backups", true);
            
            templatesDir = FileUtil.createDirectory(rootDir, "_templates", true);
            inventoryTemplatesDir = FileUtil.createDirectory(templatesDir, "inventory", true);
            townTemplatesDir = FileUtil.createDirectory(templatesDir, "town", true);
            islandTemplatesDir = FileUtil.createDirectory(templatesDir, "island", true);
            appearanceTemplatesDir = FileUtil.createDirectory(templatesDir, "appearance", true);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    
    private void loadAcreImages()
    {
        this.acreImages = new HashMap<>();
        
        File acreImgDir = new File(imageResDir, "acre/");
        for (File f : acreImgDir.listFiles())
        {
            String name = f.getName().replace(".png", "").replace("0x", "");
            byte value = (byte) Integer.parseInt(name, 16);
            
            this.acreImages.put(value, f);
        }
    }
    
    
    private void loadItems(File file)
    {
        this.gameItems = new HashSet<>();
        this.gameItemNames = new HashSet<>();
        this.gameItemCategories = new HashSet<>();
        try
        {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            
            NodeList nodes = doc.getElementsByTagName("GameItem");
            
            for (int temp = 0; temp < nodes.getLength(); temp++)
            {
                Node node = nodes.item(temp);
                
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element e = (Element) node;
                    
                    String itemName = e.getElementsByTagName("name").item(0).getTextContent();
                    String itemCategory = e.getElementsByTagName("category").item(0).getTextContent();
                    String rawID = e.getElementsByTagName("id").item(0).getTextContent();
                    
                    byte[] bytes = HexUtil.stringToByteArray(rawID.replace("0x", ""));
                    short itemID = HexUtil.byteArrayToShort(bytes);
                    
                    if (!gameItemCategories.contains(itemCategory))
                    {
                        gameItemCategories.add(itemCategory);
                    }
                    
                    gameItemNames.add(itemName);
                    
                    gameItems.add(new GameItem.Builder()
                            .withName(itemName)
                            .withCategory(itemCategory)
                            .withID(itemID)
                            .build()
                    );
                }
            }
            
            // create colors
            this.createGameItemCategoryColors();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    private void loadStructures(File file)
    {
        this.gameStructures = new HashSet<>();
        this.gameStructureNames = new HashSet<>();
        this.gameStructureCategories = new HashSet<>();
        try
        {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            
            NodeList nodes = doc.getElementsByTagName("Structure");
            
            for (int temp = 0; temp < nodes.getLength(); temp++)
            {
                Node node = nodes.item(temp);
                
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element e = (Element) node;
                    
                    String rawID = e.getElementsByTagName("id").item(0).getTextContent();
                    byte[] bytes = HexUtil.stringToByteArray(rawID.replace("0x", ""));
                    short structureID = HexUtil.byteArrayToShort(bytes);
                    
                    String structureName = e.getElementsByTagName("name").item(0).getTextContent();
                    String structureCategory = e.getElementsByTagName("category").item(0).getTextContent();
                    
                    String rawSize = e.getElementsByTagName("size").item(0).getTextContent();
                    GridDimension structureSize = GridDimension.fromString(rawSize);
                    
                    String rawLayout = e.getElementsByTagName("layout").item(0).getTextContent();
                    GridLayout layout = GridLayout.fromString(rawLayout);
                    
                    if (!gameStructureCategories.contains(structureCategory))
                    {
                        gameStructureCategories.add(structureCategory);
                    }
                    
                    gameStructureNames.add(structureName);
                    
                    gameStructures.add(new Structure.Builder()
                            .withName(structureName)
                            .withID(structureID)
                            .withSize(structureSize)
                            .withCategory(structureCategory)
                            .withLayout(layout)
                            .build()
                    );
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    private void createGameItemCategoryColors()
    {
        this.gameItemCategoryColors = new HashMap<>();
        double offsetAmt = 360.0 / this.gameItemCategories.size();
        int n = 0;
        for (String s : this.gameItemCategories)
        {
            Color color = Color.hsb(offsetAmt * n, 1.0, 1.0);
            this.gameItemCategoryColors.put(s, color);
            n++;
        }
    }
    
    
    @Override
    public void start(Stage stage) throws Exception
    {
        URL res = Main.class.getClassLoader().getResource("fxml/Main.fxml");
        
        if (res == null)
        {
            logger.error("Main resource path does not exist");
            return;
        }
        
        FXMLLoader loader = new FXMLLoader(res);
        Parent root = loader.load();
        
        
        Scene scene = new Scene(root, MAIN_WINDOW_WIDTH, MAIN_WINDOW_HEIGHT);
        
        // Package window
        stage.getIcons().add(new Image("img/logo.png"));
        stage.setTitle("Old Leaf");
        stage.setScene(scene);
        stage.setMinWidth(MAIN_WINDOW_WIDTH);
        stage.setMinHeight(MAIN_WINDOW_HEIGHT);
        stage.show();
    }
    
    
    // ============================================================================================================================================ \\
    
    
    private URL getResourceURL(String path)
    {
        return Main.class.getClassLoader().getResource(path);
    }
    
    
    public File getAcreImage(byte value)
    {
        return acreImages.get(value);
    }
    
    
    public String getItemName(short id)
    {
        for (GameItem item : gameItems)
        {
            if (item.getID() == id)
            {
                return item.getName();
            }
        }
        return null;
    }
    
    
    public List<String> getItemNamesInCategory(String key)
    {
        List<String> list = new ArrayList<>();
        for (GameItem item : gameItems)
        {
            if (item.getCategory().equals(key))
            {
                list.add(item.getName());
            }
        }
        return list;
    }
    
    
    public GameItem getItemFromName(String itemName)
    {
        for (GameItem item : gameItems)
        {
            if (item.getName().equals(itemName))
            {
                return item;
            }
        }
        return null;
    }
    
    
    public String getStructureName(short id)
    {
        for (Structure s : gameStructures)
        {
            if (s.getID() == id)
            {
                return s.getName();
            }
        }
        return null;
    }
    
    
    public GridDimension getStructureSize(short id)
    {
        for (Structure s : gameStructures)
        {
            if (s.getID() == id)
            {
                return s.getSize();
            }
        }
        return null;
    }
    
    
    public GridLayout getStructureLayout(short id)
    {
        for (Structure s : gameStructures)
        {
            if (s.getID() == id)
            {
                return s.getLayout();
            }
        }
        return null;
    }
    
    
    public String getItemCategory(short id)
    {
        for (GameItem item : gameItems)
        {
            if (item.getID() == id)
            {
                return item.getCategory();
            }
        }
        return null;
    }
    
    
    // ============================================================================================================================================ \\
    
    
    public void setSaveGame(SaveGame saveGame)
    {
        this.saveGame = saveGame;
    }
    
    
    // ============================================================================================================================================ \\
    
    
    public static Logger getLogger()
    {
        return logger;
    }
    
    
    public ResourceBundle getLocale()
    {
        return locale;
    }
    
    
    public static Main getInstance()
    {
        return instance;
    }
    
    
    public GuiManager getGuiManager()
    {
        return guiManager;
    }
    
    
    public SaveGame getSaveGame()
    {
        return saveGame;
    }
    
    
    public Set<String> getGameItemCategories()
    {
        return gameItemCategories;
    }
    
    
    public Set<String> getGameStructureCategories()
    {
        return gameStructureCategories;
    }
    
    
    public Set<GameItem> getGameItems()
    {
        return gameItems;
    }
    
    
    public Set<String> getGameItemNames()
    {
        return gameItemNames;
    }
    
    
    public Set<Structure> getGameStructures()
    {
        return gameStructures;
    }
    
    
    public Set<String> getGameStructureNames()
    {
        return gameStructureNames;
    }
    
    
    public Map<String, Color> getGameItemCategoryColors()
    {
        return gameItemCategoryColors;
    }
    
    
    // ============================================================================================================================================ \\
}
