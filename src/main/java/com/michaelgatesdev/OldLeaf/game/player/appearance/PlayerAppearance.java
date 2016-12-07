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
    
    
    public HairStyle getHairStyle()
    {
        return hairStyle;
    }
    
    
    public void setHairStyle(HairStyle hairStyle)
    {
        this.hairStyle = hairStyle;
    }
    
    
    public HairColor getHairColor()
    {
        return hairColor;
    }
    
    
    public void setHairColor(HairColor hairColor)
    {
        this.hairColor = hairColor;
    }
    
    
    public EyeColor getEyeColor()
    {
        return eyeColor;
    }
    
    // ============================================================================================================================================ \\
    
    
    public void setEyeColor(EyeColor eyeColor)
    {
        this.eyeColor = eyeColor;
    }
    
    
    public FaceStyle getFaceStyle()
    {
        return faceStyle;
    }
    
    
    public void setFaceStyle(FaceStyle faceStyle)
    {
        this.faceStyle = faceStyle;
    }
    
    
    public int getTan()
    {
        return tan;
    }
    
    
    public void setTan(int tan)
    {
        this.tan = tan;
    }
    
    // ============================================================================================================================================ \\
}
