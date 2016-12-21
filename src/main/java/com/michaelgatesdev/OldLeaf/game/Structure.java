package com.michaelgatesdev.OldLeaf.game;

public class Structure
{
    // ============================================================================================================================================ \\
    
    public static final Structure NOTHING = new Structure.Builder().withID((short) 0x00F8).withName("(Nothing)").build();
    
    private String        name;
    private String        category;
    private short         id;
    private int           x;
    private int           y;
    private GridDimension size;
    private GridLayout    layout;
    
    // ============================================================================================================================================ \\
    
    
    private Structure(Structure.Builder b)
    {
        this.name = b.name;
        this.category = b.category;
        this.id = b.id;
        this.x = b.x;
        this.y = b.y;
        this.size = b.size;
        this.layout = b.layout;
    }
    
    
    public boolean isNothing()
    {
        return this.id == NOTHING.getID();
    }
    
    
    // ============================================================================================================================================ \\
    
    
    public static class Builder
    {
        private String        name;
        private String        category;
        private short         id;
        private int           x;
        private int           y;
        private GridDimension size;
        private GridLayout    layout;
        
        
        public Structure.Builder withID(short id)
        {
            this.id = id;
            return this;
        }
        
        
        public Structure.Builder withName(String name)
        {
            this.name = name;
            return this;
        }
        
        
        public Structure.Builder withCategory(String category)
        {
            this.category = category;
            return this;
        }
        
        
        public Structure.Builder atPosition(int x, int y)
        {
            this.x = x;
            this.y = y;
            return this;
        }
        
        
        public Structure.Builder withLayout(GridLayout layout)
        {
            this.layout = layout;
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
    
    
    public short getID()
    {
        return id;
    }
    
    
    public String getName()
    {
        return name;
    }
    
    
    public String getCategory()
    {
        return category;
    }
    
    
    public GridLayout getLayout()
    {
        return layout;
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
