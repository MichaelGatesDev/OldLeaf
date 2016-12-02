package com.michaelgatesdev.OldLeaf.gui.components.grid;

import javafx.scene.image.Image;

public class ImageCell extends Cell
{
    // ============================================================================================================================================ \\.

    private Image image;

    // ============================================================================================================================================ \\


    public ImageCell(Grid container, int minX, int minY, int maxX, int maxY)
    {
        super(container, minX, minY, maxX, maxY);
    }

    // ============================================================================================================================================ \\


    /**
     * Fills the cell with an image
     *
     * @param image the image to fill the cell with
     */
    public void fillWithImage(Image image)
    {
        this.getGraphics().clearRect(this.getMinX() + 2, this.getMinY() + 2, this.getWidth() - 2, this.getHeight() - 2);

        this.getGraphics().drawImage(image, this.getMinX() + 1, this.getMinY() + 1, this.getWidth() - 1, this.getHeight() - 1);
    }

    // ============================================================================================================================================ \\
}
