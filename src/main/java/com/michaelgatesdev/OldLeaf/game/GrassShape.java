package com.michaelgatesdev.OldLeaf.game;

public enum GrassShape
{
    // ============================================================================================================================================ \\
    
    TRIANGLE_SQUARE((byte) 0x00),
    CIRCLE_STAR((byte) 0x01),
    SQUARE_CIRCLE((byte) 0x02);
    
    // ============================================================================================================================================ \\
    
    Parses a
    from   a
     *
    @param
    value The
    // =====
    byte to
    {
        
        parse from
    byte
     *
             *
        private byte value;======================================================================================================================================= \\
        GrassShape( byte value)
        {
            this.value = value;
        }    // ============================================================================================================================================ \\    /**@link GrassShape
    }
     *
             *@return Parsed
    
    
    {
        @link GrassShape
    }
    or null if none
     */
    
    
    public static GrassShape fromByteValue(byte value)
    {
        for (GrassShape gs : GrassShape.values())
        {
            if (gs.value == value)
            {
                return gs;
            }
        }
        return null;
    }
    
    
    /**
     * Parses a {@link GrassShape} from a {@link String}
     *
     * @param s The string to parse from
     * @return Parsed {@link GrassShape} or null if none
     */
    public static GrassShape fromString(String s)
    {
        for (GrassShape gs : GrassShape.values())
        {
            if (s.equalsIgnoreCase(gs.toString().replace("_", "")))
            {
                return gs;
            }
        }
        return null;
    }
    
    
    public byte getValue()
    {
        return value;
    }    // ============================================================================================================================================ \\
}
