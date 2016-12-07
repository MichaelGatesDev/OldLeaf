package com.michaelgatesdev.OldLeaf;

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
    private File backupsDir;
    private File templatesDir;
    private File inventoryTemplatesDir;
    private File townTemplatesDir;
    private File islandTemplatesDir;
    private File appearanceTemplatesDir;
    
    private SaveGame           saveGame;
    private Map<Short, String> gameItemNames;
    private Map<Short, String> gameStructureNames;
    
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
        rootDir = new File(System.getProperty("user.dir") + "/");
        resourcesDir = createDirectory(rootDir, "_resources", true);
        backupsDir = createDirectory(rootDir, "_backups", true);
        templatesDir = createDirectory(rootDir, "_templates", true);
        inventoryTemplatesDir = createDirectory(templatesDir, "inventory", true);
        townTemplatesDir = createDirectory(templatesDir, "town", true);
        islandTemplatesDir = createDirectory(templatesDir, "island", true);
        appearanceTemplatesDir = createDirectory(templatesDir, "appearance", true);
        
        // Create/Initialize all files
        File itemsFile = copyResourceFile("text/items.txt", "items.txt", resourcesDir);
        this.gameItemNames = this.loadHexStringMap(itemsFile, "\\|");
        File structuresFile = copyResourceFile("text/structures.txt", "gameStructureNames.txt", resourcesDir);
        this.gameStructureNames = this.loadHexStringMap(structuresFile, "\\|");
        
        
        // Init GUI
        launch();
    }
    
    
    private File copyResourceFile(String resourcePath, String fileName, File dest)
    {
        File file = new File(dest, fileName);
        if (!file.exists())
        {
            try
            {
                FileUtils.copyURLToFile(this.getResourceURL(resourcePath), file);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return file;
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
    
    
    private Map<Short, String> loadHexStringMap(File file, String delimiter)
    {
        /* Game items */
        Map<Short, String> map = new HashMap<>();
        Map<String, String> itemsRaw = FileUtil.loadMapFromFile(file, delimiter);
        
        for (String key : itemsRaw.keySet())
        {
            String value = itemsRaw.get(key);
            byte[] bytes = HexUtil.toByteArray(key);
            short shortValue = HexUtil.byteArrayToShort(bytes);
            
            gameItemNames.put(shortValue, value);
        }
        return map;
    }
    
    
    // ============================================================================================================================================ \\
    
    
    /**
     * Creates a {@link File} directory.
     *
     * @param destDir the directory which will parent the created directory
     * @param name    the name of the directory
     * @param log     log the result to console
     * @return created directory
     */
    private File createDirectory(File destDir, String name, boolean log)
    {
        if (destDir == null || !destDir.exists())
        {
            if (log)
            {
                logger.error(String.format(locale.getString("File.Directory.DestinationNonexistent"), destDir));
            }
            return null;
        }
        
        File folder = new File(destDir, "/" + name + "/");
        if (!folder.exists())
        {
            boolean result = folder.mkdir();
            
            if (log)
            {
                if (result)
                {
                    logger.info(String.format(locale.getString("File.Directory.Created"), name, destDir.toString()));
                }
                else
                {
                    logger.error(String.format(locale.getString("File.Directory.ErrorCreating"), name, destDir.toString()));
                }
            }
        }
        return folder;
    }
    
    
    public URL getResourceURL(String path)
    {
        return Main.class.getClassLoader().getResource(path);
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
    
    
    public Map<Short, String> getGameItemNames()
    {
        return gameItemNames;
    }
    
    
    public Map<Short, String> getStructureNames()
    {
        return gameStructureNames;
    }
    
    // ============================================================================================================================================ \\
}
