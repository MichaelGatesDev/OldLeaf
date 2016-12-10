package com.michaelgatesdev.OldLeaf.util;

import com.michaelgatesdev.OldLeaf.Main;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class FileUtil
{
    // ============================================================================================================================================ \\
    
    private static final Logger logger = Logger.getLogger(FileUtil.class);
    
    // ============================================================================================================================================ \\
    
    
    /**
     * Creates a {@link File} directory.
     *
     * @param destDir the directory which will parent the created directory
     * @param name    the name of the directory
     * @param log     log the result to console
     * @return created directory
     */
    public static File createDirectory(File destDir, String name, boolean log)
    {
        ResourceBundle locale = Main.getInstance().getLocale();
        
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
    
    
    public static Map<String, String> loadMapFromFile(File f, String delimiter, String patternToMatch)
    {
        Map<String, String> result = new HashMap<>();
        
        if (f != null && f.exists())
        {
            try
            {
                // Read all lines of file
                for (Object o : FileUtils.readLines(f))
                {
                    // current line
                    String line = (String) o;
                    
                    Pattern p = Pattern.compile(patternToMatch);
                    
                    if (!p.matcher(line).matches())
                    {
                        continue;
                    }
                    
                    // split the string
                    String[] ss = line.split(delimiter);
                    // add string to hashmap
                    result.put(ss[0], ss[1]);
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    // ============================================================================================================================================ \\
}
