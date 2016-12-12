package com.michaelgatesdev.OldLeaf.game;

public class Structure
{
    // ============================================================================================================================================ \\
    
    public static final Structure NOTHING = new Structure.Builder().withValue((short) 0x00F8).withName("(Nothing)").build();
    
    private short  value;
    private String name;
    private int    x;
    private int    y;
    private int    length;
    private int    width;
    
    // ============================================================================================================================================ \\
    
    
    private Structure(Structure.Builder b)
    {
        this.value = b.value;
        this.name = b.name;
        this.x = b.x;
        this.y = b.y;
        this.length = b.length;
        this.width = b.width;
    }
    
    
    public boolean isNothing()
    {
        return this.value == NOTHING.getValue();
    }
    
    
    // ============================================================================================================================================ \\
    
    
    public static class Builder
    {
        private short  value;
        private String name;
        private int    x;
        private int    y;
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
        
        
        public Structure.Builder atPosition(int x, int y)
        {
            this.x = x;
            this.y = y;
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
    
    
    public void setValue(short value)
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
    
    
    public void setX(int x)
    {
        this.x = x;
    }
    
    
    public void setY(int y)
    {
        this.y = y;
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
    
    
    public int getX()
    {
        return x;
    }
    
    
    public int getY()
    {
        return y;
    }
    
    // ============================================================================================================================================ \\
}
