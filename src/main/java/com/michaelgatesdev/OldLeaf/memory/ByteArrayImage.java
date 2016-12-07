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
