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


package com.michaelgatesdev.OldLeaf.game.player.appearance;

import javafx.scene.image.Image;

public abstract class Characteristic
{
    // ============================================================================================================================================ \\

    private Image  thumb;
    private Gender gender;
    private Short  value;

    // ============================================================================================================================================ \\


    public Characteristic(Short value, Gender gender, Image thumb)
    {
        this.thumb = thumb;
        this.gender = gender;
        this.value = value;
    }

    // ============================================================================================================================================ \\


    public void setThumb(Image thumb)
    {
        this.thumb = thumb;
    }


    public void setGender(Gender gender)
    {
        this.gender = gender;
    }


    public void setValue(Short value)
    {
        this.value = value;
    }


    // ============================================================================================================================================ \\


    public Image getThumb()
    {
        return thumb;
    }


    public Gender getGender()
    {
        return gender;
    }


    public Short getValue()
    {
        return value;
    }


    // ============================================================================================================================================ \\
}

