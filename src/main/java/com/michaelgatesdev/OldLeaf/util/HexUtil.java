package com.michaelgatesdev.OldLeaf.util;

import javax.xml.bind.DatatypeConverter;

public class HexUtil
{
    public static String toHexString(byte[] array)
    {
        return DatatypeConverter.printHexBinary(array);
    }
    
    
    public static byte[] toByteArray(String s)
    {
        return DatatypeConverter.parseHexBinary(s);
    }
    
    
    public static Short byteArrayToShort(byte[] arr)
    {
        String hexString = toHexString(arr);
        return Short.parseShort(hexString, 16);
    }
    
    
    public static byte[] shortToByteArray(Short s)
    {
        String hex = Integer.toHexString(s & 0xFFFF);
        return toByteArray(hex);
    }
    
    
    public static int intToHex(int tan)
    {
        return Integer.valueOf(String.valueOf(tan), 16);
    }
}