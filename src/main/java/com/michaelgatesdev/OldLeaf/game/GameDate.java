package com.michaelgatesdev.OldLeaf.game;

public class GameDate
{
    // ============================================================================================================================================ \\
    
    private int month;
    private int day;
    private int year;
    
    // ============================================================================================================================================ \\
    
    
    public GameDate(int month, int day)
    {
        this.month = month;
        this.day = day;
    }
    
    
    public GameDate(int month, int day, int year)
    {
        this.month = month;
        this.day = day;
        this.year = year;
    }
    
    // ============================================================================================================================================ \\
    
    
    public int getMonth()
    {
        return month;
    }
    
    
    public void setMonth(int month)
    {
        this.month = month;
    }
    
    
    public int getDay()
    {
        return day;
    }
    
    
    // ============================================================================================================================================ \\
    
    
    public void setDay(int day)
    {
        this.day = day;
    }
    
    
    public int getYear()
    {
        return year;
    }
    
    
    public void setYear(int year)
    {
        this.year = year;
    }
    
    
    // ============================================================================================================================================ \\
}
