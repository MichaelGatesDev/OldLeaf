package com.michaelgatesdev.OldLeaf;

import com.michaelgatesdev.OldLeaf.game.GameItem;
import com.michaelgatesdev.OldLeaf.game.SaveGame;
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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

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
    
    private SaveGame                        saveGame;
    private Map<Short, String>              gameItemNames;
    private Map<String, Map<Short, String>> gameItemCategories;
    private Map<String, Color>              gameItemCategoryColors;
    private Map<Short, String>              gameStructureNames;
    private Map<Byte, File>                 acreImages;
    
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
        
        // Create/Initialize all files
        File itemsFile = new File(textResDir, "/items.txt");
        this.gameItemNames = this.loadHexStringMap(itemsFile);
        File structuresFile = new File(textResDir, "structures.txt");
        this.gameStructureNames = this.loadHexStringMap(structuresFile);
        this.loadGameItemCategories();
        
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
    
    
    private void loadGameItemCategories()
    {
        this.gameItemCategories = new HashMap<>();
        
        File f = new File(textResDir, "/items.txt");
        this.gameItemCategories = this.loadTitledHexList(f);
        
        
        gameItemCategoryColors = new HashMap<>();
        double offsetAmt = 360.0 / gameItemCategories.keySet().size();
        int n = 0;
        for (String s : gameItemCategories.keySet())
        {
            Color color = Color.hsb(offsetAmt * n, 1.0, 1.0);
            gameItemCategoryColors.put(s, color);
            n++;
        }
        
        logger.debug(gameItemCategoryColors);
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
    
    
    private Map<Short, String> loadHexStringMap(File file)
    {
        Map<Short, String> map = new HashMap<>();
        Map<String, String> itemsRaw = FileUtil.loadMapFromFile(file, "\\|", "^([A-Fa-f0-9]{4}[|](.*))$");
        
        for (String key : itemsRaw.keySet())
        {
            String value = itemsRaw.get(key);
            byte[] bytes = HexUtil.stringToByteArray(key);
            short shortValue = HexUtil.byteArrayToShort(bytes);
            
            map.put(shortValue, value);
        }
        return map;
    }
    
    
    private Map<String, Map<Short, String>> loadTitledHexList(File file)
    {
        Map<String, Map<Short, String>> result = new HashMap<>();
        Map<String, Map<String, String>> itemsRaw = FileUtil.loadTitledList(file, "\\|", "^([A-Fa-f0-9]{4}[|](.*))$", "^([\\w]+)$");
        
        for (String title : itemsRaw.keySet())
        {
            Map<String, String> rawV = itemsRaw.get(title);
            
            if (!result.containsKey(title))
            {
                result.put(title, new HashMap<>());
            }
            
            for (String key : rawV.keySet())
            {
                String value = rawV.get(key);
                
                byte[] bytes = HexUtil.stringToByteArray(key);
                short shortValue = HexUtil.byteArrayToShort(bytes);
                
                result.get(title).put(shortValue, value);
            }
        }
        
        return result;
    }
    
    
    public String getItemNameFromValue(short id)
    {
        return this.gameItemNames.get(id);
    }
    
    
    public GameItem getItemFromName(String item)
    {
        short v = 0x7FFE;
        for (short key : this.gameItemNames.keySet())
        {
            if (this.gameItemNames.get(key).equalsIgnoreCase(item))
            {
                v = key;
                break;
            }
        }
        return new GameItem.Builder().withName(item).withShortValue(v).build();
    }
    
    
    public String getGameItemCategory(GameItem item)
    {
        for (String category : this.gameItemCategories.keySet())
        {
            if (this.gameItemCategories.get(category).keySet().contains(item.getValue()))
            {
                return category;
            }
        }
        return null;
    }
    
    
    public String getStructureNameFromValue(short id)
    {
        return this.gameStructureNames.get(id);
    }
    
    
    public File getAcreImageFromValue(byte value)
    {
        return acreImages.get(value);
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
    
    
    public Map<String, Map<Short, String>> getGameItemCategories()
    {
        return gameItemCategories;
    }
    
    
    public Map<Short, String> getGameItemNames()
    {
        return gameItemNames;
    }
    
    
    public Map<String, Color> getGameItemCategoryColors()
    {
        return gameItemCategoryColors;
    }
    
    
    // ============================================================================================================================================ \\
}
