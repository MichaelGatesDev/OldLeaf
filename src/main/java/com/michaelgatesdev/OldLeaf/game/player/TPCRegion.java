package com.michaelgatesdev.OldLeaf.game.player;

public enum TPCRegion
{
// ============================================================================================================================================ \\
    
    UNKNOWN((byte) 0x00),
    JAPAN((byte) 0x01),
    USA((byte) 0x31),
    FRANCE((byte) 0x4D),
    GERMANY((byte) 0x4E);
    
    // ============================================================================================================================================ \\
    
    private final byte data;
    
    // ============================================================================================================================================ \\
    
    
    TPCRegion(byte b)
    {
        this.data = b;
    }
    
    // ============================================================================================================================================ \\
    
    
    /**
     * Parses a {@link TPCRegion} from a string
     *
     * @param str The string to parse
     * @return TPC Region
     */
    public static TPCRegion fromName(String str)
    {
        TPCRegion pr = TPCRegion.UNKNOWN;
        for (TPCRegion region : TPCRegion.values())
        {
            if (region.toString().equalsIgnoreCase(str))
            {
                pr = region;
                break;
            }
        }
        return pr;
    }
    
    
    public static TPCRegion fromByteValue(byte b)
    {
        TPCRegion result = TPCRegion.UNKNOWN;
        for (TPCRegion x : TPCRegion.values())
        {
            if (x.data == b)
            {
                result = x;
                break;
            }
        }
        return result;
    }
    
    // ============================================================================================================================================ \\
    
    
    public byte getData()
    {
        return data;
    }
    
    
    // ============================================================================================================================================ \\
}