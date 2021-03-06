package com.michaelgatesdev.OldLeaf.game;

public class GameItem
{
    // ============================================================================================================================================ \\
    
    public static final GameItem AIR = new GameItem.Builder().withID((short) 0x7FFE).withName("Air").build();
    
    private String name;
    private String category;
    
    private byte    flag1;
    private byte    flag2;
    private boolean buried;
    private boolean watered;
    private short   value;
    
    
    // ============================================================================================================================================ \\
    
    
    private GameItem(Builder b)
    {
        this.flag1 = b.flag1;
        this.flag2 = b.flag2;
        this.buried = b.buried;
        this.watered = b.watered;
        this.value = b.id;
        this.name = b.name;
        this.category = b.category;
    }
    
    // ============================================================================================================================================ \\
    
    public static class Builder
    {
        private String  name;
        private String  category;
        private byte    flag1;
        private byte    flag2;
        private boolean buried;
        private boolean watered;
        private short   id;
        
        
        public Builder withName(String name)
        {
            this.name = name;
            return this;
        }
        
        
        public Builder withCategory(String category)
        {
            this.category = category;
            return this;
        }
        
        
        public Builder withWateredStatus(boolean watered)
        {
            this.watered = watered;
            return this;
        }
        
        
        public Builder withBuriedStatus(boolean buried)
        {
            this.buried = buried;
            return this;
        }
        
        
        public Builder withFlag1(byte flag)
        {
            this.flag1 = flag;
            return this;
        }
        
        
        public Builder withFlag2(byte flag)
        {
            this.flag2 = flag;
            return this;
        }
        
        
        public Builder withID(short s)
        {
            this.id = s;
            return this;
        }
        
        
        public GameItem build()
        {
            return new GameItem(this);
        }
        
        
    }
    
    
    // ============================================================================================================================================ \\
    
    
    public byte getFlag1()
    {
        return flag1;
    }
    
    
    public byte getFlag2()
    {
        return flag2;
    }
    
    
    public boolean isBuried()
    {
        return buried;
    }
    
    
    public boolean isWatered()
    {
        return watered;
    }
    
    
    public short getID()
    {
        return value;
    }
    
    
    public String getName()
    {
        return name;
    }
    
    
    public String getCategory()
    {
        return category;
    }
    
    
    public boolean isNothing()
    {
        return (value == 0x7FFE);
    }
    
    // ============================================================================================================================================ \\
}
