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


package com.michaelgatesdev.OldLeaf.memory;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayImage extends ByteData
{
    // ============================================================================================================================================ \\

    private byte[] data;

    // ============================================================================================================================================ \\


    /**
     * An array of bytes which forms an image
     *
     * @param data The byte data
     */
    public ByteArrayImage(byte[] data)
    {
        this.data = data;
    }


    // ============================================================================================================================================ \\


    @Override
    public byte[] getDataAsByteArray()
    {
        return data;
    }


    /**
     * @return A JavaFX {@link Image} from the byte array
     */
    public Image getImage()
    {
        Image image = null;
        try
        {
            image = SwingFXUtils.toFXImage(ImageIO.read(new ByteArrayInputStream(getDataAsByteArray())), null);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return image;
    }

    // ============================================================================================================================================ \\
}
