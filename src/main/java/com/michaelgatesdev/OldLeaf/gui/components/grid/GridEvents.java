package com.michaelgatesdev.OldLeaf.gui.components.grid;

import javafx.scene.input.MouseButton;

public interface GridEvents
{
    /**
     * Event fired when a cell on a grid is clicked on
     *
     * @param button   The mouse button pressed
     * @param cell     The cell clicked
     * @param gridPosX The X position in the grid (NOT PIXEL)
     * @param gridPosY The Y position in the grid (NOT PIXEL)
     */
    void onCellClick(MouseButton button, Cell cell, int gridPosX, int gridPosY);
    
    
    /**
     * Event fired when mouse is hovering over a cell
     *
     * @param cell  The cell being hovered over
     * @param gridX The grid X position of the mouse
     * @param gridY The grid Y position of the mouse
     */
    void onCellHover(Cell cell, int gridX, int gridY);
}
