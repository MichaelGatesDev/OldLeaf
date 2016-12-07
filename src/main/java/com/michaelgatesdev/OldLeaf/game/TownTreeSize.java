package com.michaelgatesdev.OldLeaf.game;

public enum TownTreeSize
{
    // ============================================================================================================================================ \\
    
    SMALLER((byte) 0x01),
    SMALL((byte) 0x02),
    MEDIUM((byte) 0x03),
    BIG((byte) 0x04),
    BIGGER((byte) 0x05),
    MORE_BIGGER((byte) 0x06),
    FULL_GROWN((byte) 0x07);
    
    // ============================================================================================================================================ \\
    
    private byte value;
    
    // ============================================================================================================================================ \\
    
    
    TownTreeSize(byte value)
    {
        this.value = value;
    }
    
    
    /**
     * Parses a {@link TownTreeSize} from a byte
     *
     * @param value The byte to parse from
     * @return Parsed {@link TownTreeSize}
     */
    public static TownTreeSize fromByteValue(byte value)
    {
        for (TownTreeSize ts : TownTreeSize.values())
        {
            if (ts.value == value)
            {
                return ts;
            }
        }
        return null;
    }
    
    
    /**
     * Parses a {@link TownTreeSize} from a {@link String}
     *
     * @param s The string to parse from
     * @return Parsed {@link TownTreeSize} or null if none
     */
    public static TownTreeSize fromString(String s)
    {
        for (TownTreeSize gs : TownTreeSize.values())
        {
            if (s.equalsIgnoreCase(gs.toString().replace("_", "")))
            {
                return gs;
            }
        }
        return null;
    }
    
    // ============================================================================================================================================ \\
}