package com.michaelgatesdev.OldLeaf.game.player.appearance;

import com.michaelgatesdev.OldLeaf.game.player.Gender;
import javafx.scene.image.Image;

public abstract class Characteristic
{
    // ============================================================================================================================================ \\
    
    private Image  thumb;
    private Gender gender;
    private Byte   value;
    
    // ============================================================================================================================================ \\
    
    
    public Characteristic(Byte value, Gender gender, Image thumb)
    {
        this.thumb = thumb;
        this.gender = gender;
        this.value = value;
    }
    
    // ============================================================================================================================================ \\
    
    
    public Image getThumb()
    {
        return thumb;
    }
    
    
    public void setThumb(Image thumb)
    {
        this.thumb = thumb;
    }
    
    
    public Gender getGender()
    {
        return gender;
    }
    
    
    // ============================================================================================================================================ \\
    
    
    public void setGender(Gender gender)
    {
        this.gender = gender;
    }
    
    
    public Byte getValue()
    {
        return value;
    }
    
    
    public void setValue(Byte value)
    {
        this.value = value;
    }
    
    
    // ============================================================================================================================================ \\
}

