package com.michaelgatesdev.OldLeaf.gui.components.grid;

import javafx.scene.image.Image;

public class ImageCell extends Cell
{
    // ============================================================================================================================================ \\.
    
    Fills the
    @param
    
    cell with
    image to
    
    
    // ============================================================================================================================================ \\    /**
     *
    an image
    image the
    cell wi
    private I
     *
             *
    fill the
    // =======thmage image;===================================================================================================================================== \\    public ImageCell(Grid container, int minX, int minY, int maxX, int maxY)
    {
        super(container, minX, minY, maxX, maxY);
    }
     */
    
    
    public void fillWithImage(Image image)
    {
        this.getGraphics().clearRect(this.getMinX() + 2, this.getMinY() + 2, this.getWidth() - 2, this.getHeight() - 2);
        
        this.getGraphics().drawImage(image, this.getMinX() + 1, this.getMinY() + 1, this.getWidth() - 1, this.getHeight() - 1);
    }
    
    // ============================================================================================================================================ \\
}
