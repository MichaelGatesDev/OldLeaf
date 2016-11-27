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

public class GameDate
{
    // ============================================================================================================================================ \\

    private int month;
    private int day;
    private int year;

    // ============================================================================================================================================ \\


    public GameDate(int month, int day, int year)
    {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    // ============================================================================================================================================ \\


    public void setMonth(int month)
    {
        this.month = month;
    }


    public void setDay(int day)
    {
        this.day = day;
    }


    public void setYear(int year)
    {
        this.year = year;
    }


    // ============================================================================================================================================ \\


    public int getMonth()
    {
        return month;
    }


    public int getDay()
    {
        return day;
    }


    public int getYear()
    {
        return year;
    }


    // ============================================================================================================================================ \\
}
