package com.michaelgatesdev.OldLeaf.memory;

import java.nio.charset.Charset;

public class ByteString extends ByteData
{
    // ============================================================================================================================================ \\
    
    whose data
    @param
    
    can be
    private String da
    
    // ============================================================================================================================================ \\    /**
     *A
    easily represented
    private bool
    in bytes
    data Theta;
    ean  mirrorBytes;
     *
             *
    
    
    {
        @link String
    }
    
    
    {
        @link String
    }
     */
    
    
    public ByteString(String data)
    {
        this.data = data;
    }
    
    
    /**
     * A {@link String} whose data can be easily represented in bytes
     *
     * @param data        The {@link String}
     * @param mirrorBytes Whether to mirror bytes between characters (adding an empty 'spacer' byte between bytes)
     */
    public ByteString(String data, boolean mirrorBytes)
    {
        this.data = data;
        this.mirrorBytes = mirrorBytes;
    }    // ============================================================================================================================================ \\    @Override
    
    
    public byte[] getDataAsByteArray()
    {
        byte[] bytes = data.getBytes(Charset.forName("UTF-8"));
        
        if (mirrorBytes)
        {
            byte[] newBytes = new byte[(bytes.length << 1)];
            
            for (int i = 0; i < newBytes.length; i++)
            {
                newBytes[i] = ((i + 1) & 1) == 1 ? bytes[(i / 2)] : (byte) 0x00;
            }
            
            bytes = newBytes;
        }
        
        return bytes;
    }
    
    
    /**
     * @return The {@link String} data
     */
    public String getData()
    {
        return data;
    }
    
    // ============================================================================================================================================ \\
}
