package com.michaelgatesdev.OldLeaf.game.player.appearance;

public class PlayerAppearance
{
    // ============================================================================================================================================ \\
    
    private int       tan;
    private HairStyle hairStyle;
    private HairColor hairColor;
    private EyeColor  eyeColor;
    private FaceStyle faceStyle;
    
    
    // ============================================================================================================================================ \\
    
    
    public PlayerAppearance()
    {
    }
    
    // ============================================================================================================================================ \\
    
    
    public void setHairStyle(HairStyle hairStyle)
    {
        this.hairStyle = hairStyle;
    }
    
    
    public void setHairColor(HairColor hairColor)
    {
        this.hairColor = hairColor;
    }
    
    
    public void setEyeColor(EyeColor eyeColor)
    {
        this.eyeColor = eyeColor;
    }
    
    
    public void setFaceStyle(FaceStyle faceStyle)
    {
        this.faceStyle = faceStyle;
    }
    
    
    public void setTan(int tan)
    {
        this.tan = tan;
    }
    
    // ============================================================================================================================================ \\
    
    
    public HairStyle getHairStyle()
    {
        return hairStyle;
    }
    
    
    public HairColor getHairColor()
    {
        return hairColor;
    }
    
    
    public EyeColor getEyeColor()
    {
        return eyeColor;
    }
    
    
    public FaceStyle getFaceStyle()
    {
        return faceStyle;
    }
    
    
    public int getTan()
    {
        return tan;
    }
    
    // ============================================================================================================================================ \\
}
