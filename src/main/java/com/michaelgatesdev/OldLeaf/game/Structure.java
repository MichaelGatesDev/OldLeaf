package com.michaelgatesdev.OldLeaf.game;

public class Structure
{
    // ============================================================================================================================================ \\
    
    public static final Structure NOTHING = new Structure.Builder().withValue((short) 0x00F8).withName("(Nothing)").build();
    
    private short         value;
    private String        name;
    private int           x;
    private int           y;
    private GridDimension size;
    
    // ============================================================================================================================================ \\
    
    
    private Structure(Structure.Builder b)
    {
        this.value = b.value;
        this.name = b.name;
        this.x = b.x;
        this.y = b.y;
        this.size = b.size;
    }
    
    
    public boolean isNothing()
    {
        return this.value == NOTHING.getValue();
    }
    
    
    // ============================================================================================================================================ \\
    
    
    public static class Builder
    {
        private short         value;
        private String        name;
        private int           x;
        private int           y;
        private GridDimension size;
        
        
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
        
        
        public Structure.Builder withSize(GridDimension size)
        {
            this.size = size;
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
    
    
    public void setSize(GridDimension size)
    {
        this.size = size;
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
    
    
    public GridDimension getSize()
    {
        return size;
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
