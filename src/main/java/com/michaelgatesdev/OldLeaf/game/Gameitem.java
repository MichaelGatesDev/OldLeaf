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

public class GameItem
{
    // ============================================================================================================================================ \\

    public static final GameItem EMPTY = new GameItem.Builder().withShortValue((short) 0x7FFE).withName("Empty").build();

    private byte    flag1;
    private byte    flag2;
    private boolean buried;
    private boolean watered;
    private short   value;
    private String  name;

    // ============================================================================================================================================ \\


    private GameItem(Builder b)
    {
        this.flag1 = b.flag1;
        this.flag2 = b.flag2;
        this.buried = b.buried;
        this.watered = b.watered;
        this.value = b.id;
        this.name = b.name;
    }


    public static class Builder
    {
        private byte    flag1;
        private byte    flag2;
        private boolean buried;
        private boolean watered;
        private short   id;
        private String  name;


        public Builder withName(String name)
        {
            this.name = name;
            return this;
        }


        public Builder withWateredStatus(boolean watered)
        {
            this.watered = watered;
            return this;
        }


        public Builder withBuriedStatus(boolean buried)
        {
            this.buried = buried;
            return this;
        }


        public Builder withFlag1(byte flag)
        {
            this.flag1 = flag;
            return this;
        }


        public Builder withFlag2(byte flag)
        {
            this.flag2 = flag;
            return this;
        }


        public Builder withShortValue(short s)
        {
            this.id = s;
            return this;
        }


        public GameItem build()
        {
            return new GameItem(this);
        }


    }

    // ============================================================================================================================================ \\


    public void setFlag1(byte flag1)
    {
        this.flag1 = flag1;
    }


    public void setFlag2(byte flag2)
    {
        this.flag2 = flag2;
    }


    public void setBuried(boolean buried)
    {
        this.buried = buried;
    }


    public void setWatered(boolean watered)
    {
        this.watered = watered;
    }


    public void setValue(short value)
    {
        this.value = value;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    // ============================================================================================================================================ \\


    public byte getFlag1()
    {
        return flag1;
    }


    public byte getFlag2()
    {
        return flag2;
    }


    public boolean isBuried()
    {
        return buried;
    }


    public boolean isWatered()
    {
        return watered;
    }


    public short getValue()
    {
        return value;
    }


    public String getName()
    {
        return name;
    }


    // ============================================================================================================================================ \\
}
