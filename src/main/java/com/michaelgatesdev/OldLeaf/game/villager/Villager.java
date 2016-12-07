package com.michaelgatesdev.OldLeaf.game.villager;

import com.michaelgatesdev.OldLeaf.game.player.Gender;

public final class Villager
{
    private String          name;
    private Species         species;
    private Gender          gender;
    private PersonalityType personality;
    
    
    public Villager(String name, Species species, Gender gender, PersonalityType personality)
    {
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.personality = personality;
    }
    
    
    public String getName()
    {
        return name;
    }
    
    
    public Species getSpecies()
    {
        return species;
    }
    
    
    public Gender getGender()
    {
        return gender;
    }
    
    
    public PersonalityType getPersonality()
    {
        return personality;
    }
}
