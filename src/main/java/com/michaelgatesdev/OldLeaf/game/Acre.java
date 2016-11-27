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


package com.michaelgatesdev.OldLeaf.game;

import javafx.scene.image.Image;

public final class Acre
{
    // ============================================================================================================================================ \\

    private short value;
    private Image image;


    // ============================================================================================================================================ \\


    public Acre()
    {
    }

    // ============================================================================================================================================ \\


    public void setValue(short value)
    {
        this.value = value;
    }


    public void setImage(Image image)
    {
        this.image = image;
    }

    // ============================================================================================================================================ \\


    public short getValue()
    {
        return value;
    }


    public Image getImage()
    {
        return image;
    }

    // ============================================================================================================================================ \\
}
