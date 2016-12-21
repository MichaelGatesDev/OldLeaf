package com.michaelgatesdev.OldLeaf.game;

import com.michaelgatesdev.OldLeaf.exceptions.InvalidGridDimensionFormatException;
import com.michaelgatesdev.OldLeaf.util.RegexUtil;

import java.util.regex.Matcher;

public class GridDimension
{
    // ============================================================================================================================================ \\
    
    private int width;
    private int height;
    
    // ============================================================================================================================================ \\
    
    
    public GridDimension(int width, int height)
    {
        this.width = width;
        this.height = height;
    }
    
    // ============================================================================================================================================ \\
    
    
    public void setWidth(int width)
    {
        this.width = width;
    }
    
    
    public void setHeight(int height)
    {
        this.height = height;
    }
    
    // ============================================================================================================================================ \\
    
    
    public int getWidth()
    {
        return width;
    }
    
    
    public int getHeight()
    {
        return height;
    }
    
    
    public static GridDimension fromString(String size) throws InvalidGridDimensionFormatException
    {
        Matcher m = RegexUtil.SIZE_PATTERN.matcher(size);
        if (!m.matches())
        {
            throw new InvalidGridDimensionFormatException(String.format("Invalid dimension string: \"%s\". Should be like \"0x0\", \"13x21\".", size));
        }
        int width = Integer.parseInt(m.group(1));
        int height = Integer.parseInt(m.group(2));
        
        return new GridDimension(width, height);
    }
    
    // ============================================================================================================================================ \\
}
