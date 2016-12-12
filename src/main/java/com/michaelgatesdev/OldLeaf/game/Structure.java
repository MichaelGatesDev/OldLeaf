package com.michaelgatesdev.OldLeaf.game;

public class Structure
{
    // ============================================================================================================================================ \\
    
    private short  value;
    private String name;
    private int    length;
    private int    width;
    
    // ============================================================================================================================================ \\
    
    
    private Structure(Structure.Builder b)
    {
        this.value = b.value;
        this.name = b.name;
        this.length = b.length;
        this.width = b.width;
    }
    
    
    // ============================================================================================================================================ \\
    
    
    public static class Builder
    {
        private short  value;
        private String name;
        private int    length;
        private int    width;
        
        
        public Structure.Builder withValue(short value)
        {
            this.value = value;
            return this;
        }
        
        
        public Structure.Builder withName(String name)
        {
            this.name = name;
            return this;
        }
        
        
        public Structure.Builder withSize(int length, int width)
        {
            this.length = length;
            this.width = width;
            return this;
        }
        
        
        public Structure build()
        {
            return new Structure(this);
        }
    }
    
    
    // ============================================================================================================================================ \\
    
    
    public void setValue(byte value)
    {
        this.value = value;
    }
    
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    
    public void setLength(int length)
    {
        this.length = length;
    }
    
    
    public void setWidth(int width)
    {
        this.width = width;
    }
    
    
    // ============================================================================================================================================ \\
    
    
    public short getValue()
    {
        return value;
    }
    
    
    public String getName()
    {
        return name;
    }
    
    
    public int getLength()
    {
        return length;
    }
    
    
    public int getWidth()
    {
        return width;
    }
    
    
    // ============================================================================================================================================ \\
}
