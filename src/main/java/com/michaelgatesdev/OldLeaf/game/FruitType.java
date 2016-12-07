package com.michaelgatesdev.OldLeaf.game;

public enum FruitType
{
    // ============================================================================================================================================ \\
    
    APPLES((byte) 0x01),
    ORANGES((byte) 0x02),
    PEARS((byte) 0x03),
    PEACHES((byte) 0x04),
    CHERRIES((byte) 0x05);
    
    // ============================================================================================================================================ \\
    
    private byte value;
    
    // ============================================================================================================================================ \\
    
    
    FruitType(byte value)
    {
        this.value = value;
    }
    
    // ============================================================================================================================================ \\
    
    
    /**
     * Parses a {@link FruitType} from a byte
     *
     * @param value The byte to parse from
     * @return Parsed {@link FruitType} or null if none
     */
    public static FruitType fromByteValue(byte value)
    {
        for (FruitType ft : FruitType.values())
        {
            if (ft.value == value)
            {
                return ft;
            }
        }
        return null;
    }
    
    
    /**
     * Parses a {@link FruitType} from a {@link String}
     *
     * @param s The string to parse from
     * @return Parsed {@link FruitType} or null if none
     */
    public static FruitType fromString(String s)
    {
        for (FruitType gs : FruitType.values())
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
    }
    
    // ============================================================================================================================================ \\
}