package com.michaelgatesdev.OldLeaf.game;

public class GridLayout
{
    // ============================================================================================================================================ \\
    
    private char[] chars;
    
    // ============================================================================================================================================ \\
    
    
    public GridLayout(char[] chars)
    {
        this.chars = chars;
    }
    
    
    public static GridLayout fromString(String layout)
    {
        return new GridLayout(layout
                .replaceAll("[\n]", "")
                .replaceAll("[\\s]+", "")
                .toCharArray()
        );
    }
    
    // ============================================================================================================================================ \\
    
    
    public char[] getChars()
    {
        return chars;
    }
    
    
    public int getOriginIndex()
    {
        int n = 0;
        for (char c : chars)
        {
            if (c == '2')
            {
                break;
            }
            n++;
        }
        return n;
    }
    
    
    public int getOriginColumn(GridDimension size)
    {
        int n = 0;
        for (int i = 0; i < size.getWidth(); i++)
        {
            for (int j = 0; j < size.getHeight(); j++)
            {
                if (chars[n] == '2')
                {
                    return i;
                }
            }
        }
        return 0;
    }
    
    
    public int getOriginRow(GridDimension size)
    {
        int n = 0;
        for (int i = 0; i < size.getWidth(); i++)
        {
            for (int j = 0; j < size.getHeight(); j++)
            {
                if (chars[n] == '2')
                {
                    return j;
                }
            }
        }
        return 0;
    }
    
    // ============================================================================================================================================ \\
}
