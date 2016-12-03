package com.michaelgatesdev.OldLeaf.gui.components.grid;

import javafx.scene.paint.Color;

public class PaintableCell extends Cell
{
    // ============================================================================================================================================ \\
    
    private boolean colored;
    private Color   color;
    
    // ============================================================================================================================================ \\
    
    
    public PaintableCell(Grid container, int minX, int minY, int maxX, int maxY)
    {
        super(container, minX, minY, maxX, maxY);
    }
    
    // ============================================================================================================================================ \\
    
    
    /**
     * Colors the cell
     */
    public void paint(Color color)
    {
        this.color = color;
        
        this.getGraphics().setFill(color);
        this.getGraphics().fillRect(this.getMinX(), this.getMinY(), this.getWidth(), this.getHeight());
        this.colored = true;
        
        this.getContainer().redrawLines();
    }
    
    
    public void paint()
    {
        this.paint(randomColor());
    }
    
    
    /**
     * Removes color from the cell
     */
    public void clean()
    {
        this.getGraphics().clearRect(this.getMinX(), this.getMinY(), this.getWidth(), this.getHeight());
        this.colored = false;
        
        this.getContainer().redrawLines();
    }
    
    
    // ============================================================================================================================================ \\
    
    
    /**
     * Generates a random color
     *
     * @return a random RGB color
     */
    private Color randomColor()
    {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return Color.rgb(r, g, b);
    }
    
    
    public boolean isPainted()
    {
        return colored;
    }
    
    // ============================================================================================================================================ \\
}
