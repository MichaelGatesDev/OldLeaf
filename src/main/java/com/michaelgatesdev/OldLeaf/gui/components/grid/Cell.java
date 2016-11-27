/*
 * Copyright (C) Michael Gates (MichaelGatesDev@gmail.com) 2015
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 */


package com.michaelgatesdev.OldLeaf.gui.components.grid;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

public class Cell
{
    // ============================================================================================================================================ \\

    private static final Logger logger = Logger.getLogger(Cell.class);

    private Grid parent;

    private int minX;
    private int minY;
    private int maxX;
    private int maxY;

    private int    width;
    private int    height;
    private double size;

    private boolean colored;

    // ============================================================================================================================================ \\


    /**
     * Creates a new instance of a cell with the given coordinates
     *
     * @param parent Parent grid component
     * @param minX   Start X position
     * @param minY   Start Y position
     * @param maxX   End X position
     * @param maxY   End Y position
     */
    public Cell(Grid parent, int minX, int minY, int maxX, int maxY)
    {
        this.parent = parent;

        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;

        this.width = maxX - minX;
        this.height = maxY - minY;

        this.size = width * height;
    }

    // ============================================================================================================================================ \\


    /**
     * Colors the cell
     */
    public void color()
    {
        GraphicsContext graphics = this.parent.getGraphicsContext2D();
        graphics.setFill(randomColor());
        graphics.fillRect(minX + 1, minY + 1, width - 1, height - 1);

        this.colored = true;
    }


    /**
     * Removes color from the cell
     */
    public void uncolor()
    {
        GraphicsContext graphics = this.parent.getGraphicsContext2D();
        graphics.clearRect(minX + 2, minY + 2, width - 2, height - 2);

        this.colored = false;
    }


    /**
     * Fills the cell with an image
     *
     * @param image the image to fill the cell with
     */
    public void fillWithImage(Image image)
    {
        GraphicsContext graphics = this.parent.getGraphicsContext2D();
        graphics.clearRect(minX + 2, minY + 2, width - 2, height - 2);

        graphics.drawImage(image, minX + 1, minY + 1, width - 1, height - 1);
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


    /**
     * @return The minimum X coordinate
     */
    public int getMinX()
    {
        return minX;
    }


    /**
     * @return The minimum Y coordinate
     */
    public int getMinY()
    {
        return minY;
    }


    /**
     * @return The maximum X coordinate
     */
    public int getMaxX()
    {
        return maxX;
    }


    /**
     * @return The maximum Y coordinate
     */
    public int getMaxY()
    {
        return maxY;
    }


    /**
     * @return The size of the cell (length/width)
     */
    public double getSize()
    {
        return size;
    }


    /**
     * @return returns true if the cell is colored or not transparent
     */
    public boolean isColored()
    {
        return colored;
    }

    // ============================================================================================================================================ \\
}
