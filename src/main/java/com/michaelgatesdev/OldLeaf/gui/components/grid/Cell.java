package com.michaelgatesdev.OldLeaf.gui.components.grid;

import javafx.scene.canvas.GraphicsContext;

public abstract class Cell
{
    // ============================================================================================================================================ \\
    
    private Grid            container;
    private GraphicsContext graphics;
    
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;
    
    private int width;
    private int height;
    
    // ============================================================================================================================================ \\
    
    
    public Cell(Grid container, int minX, int minY, int maxX, int maxY)
    {
        this.container = container;
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
        
        this.width = maxX - minX;
        this.height = maxY - minY;
        
        if (this.container != null)
        {
            this.graphics = this.container.getGraphicsContext2D();
        }
    }
    
    // ============================================================================================================================================ \\
    
    
    public Grid getContainer()
    {
        return container;
    }
    
    
    public GraphicsContext getGraphics()
    {
        return graphics;
    }
    
    
    public int getMinX()
    {
        return minX;
    }
    
    
    public int getMinY()
    {
        return minY;
    }
    
    
    public int getMaxX()
    {
        return maxX;
    }
    
    
    public int getMaxY()
    {
        return maxY;
    }
    
    
    public int getWidth()
    {
        return width;
    }
    
    
    public int getHeight()
    {
        return height;
    }
    
    
    public int getSize()
    {
        return width * height;
    }
    
    // ============================================================================================================================================ \\
}