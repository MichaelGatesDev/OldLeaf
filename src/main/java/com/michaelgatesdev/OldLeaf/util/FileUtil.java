package com.michaelgatesdev.OldLeaf.util;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        if (destDir == null || !destDir.exists())
        {
            if (log)
            {
//                logger.error(String.format(locale.getString("File.Directory.DestinationNonexistent"), destDir));
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
//                    logger.info(String.format(locale.getString("File.Directory.Created"), name, destDir.toString()));
                }
                else
                {
//                    logger.error(String.format(locale.getString("File.Directory.ErrorCreating"), name, destDir.toString()));
                }
            }
        }
        return folder;
    }
    
    
    public static Map<String, String> loadMapFromFile(File f, String delimiter, String... patternsToIgnore)
    {
        Map<String, String> result = new HashMap<>();
        
        if (f != null && f.exists())
        {
            try
            {
                List<Pattern> patterns = Arrays.stream(patternsToIgnore).map(Pattern::compile).collect(Collectors.toList());
                
                // Read all lines of file
                loop:
                for (Object o : FileUtils.readLines(f))
                {
                    // current line
                    String line = (String) o;
                    
                    // check against all patterns
                    for (Pattern p : patterns)
                    {
                        // if line is blank or a comment
                        Matcher m = p.matcher(line);
                        
                        // If the line is a match
                        if (m.find())
                        {
                            // skip it
                            continue loop;
                        }
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
