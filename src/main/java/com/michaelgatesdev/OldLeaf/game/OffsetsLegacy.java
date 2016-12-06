package com.michaelgatesdev.OldLeaf.game;

import com.michaelgatesdev.OldLeaf.game.offsets.OffsetStash;

public class OffsetsLegacy extends OffsetStash
{
    //
    public int TOWN_TREESIZE()
    {
        return SECURE_VALUE_SIZE() + 0x049526;
    }
    
    
    public int TOWN_GRASSTYPE()
    {
        return SECURE_VALUE_SIZE() + 0x04da01;
    }
    
    
    public int TOWN_PLAYTIME()
    {
        return SECURE_VALUE_SIZE() + 0x5c730;
    }
    
    
    public int TOWN_DAYSPLAYED()
    {
        return SECURE_VALUE_SIZE() + 0x5c7ba;
    }
    
    
    public int TOWN_NATIVEFRUIT()
    {
        return SECURE_VALUE_SIZE() + 0x05c7b6;
    }
    
    
    public int TOWN_ID1()
    {
        return SECURE_VALUE_SIZE() + 0x05c738;
    }
    
    
    public int TOWN_ID2()
    {
        return SECURE_VALUE_SIZE() + 0x05c739;
    }
    
    
    public int TOWN_NAME()
    {
        return SECURE_VALUE_SIZE() + 0x05c73a;
    }
    
    
    public int TOWN_AVAILABLEPWPS()
    {
        return SECURE_VALUE_SIZE() + 0x04d9c8;
    }
    
    
    //
    public int MUSEUM_ROOM1()
    {
        return SECURE_VALUE_SIZE() + 0x0659d8;
    }
    
    
    public int MUSEUM_ROOMSIZE()
    {
        return 0x0b98;
    }
    
    
    //
    public int MAP_GRASS()
    {
        return SECURE_VALUE_SIZE() + 0x053e80;
    }
    
    
    public int MAP_ACRES()
    {
        return SECURE_VALUE_SIZE() + 0x04da04;
    }
    
    
    public int MAP_BUILDINGS()
    {
        return SECURE_VALUE_SIZE() + 0x049528;
    }
    
    
    public int MAP_ITEMS()
    {
        return SECURE_VALUE_SIZE() + 0x04da58;
    }
    
    
    //
    public int ISLAND_ACRES()
    {
        return SECURE_VALUE_SIZE() + 0x06a408;
    }
    
    
    public int ISLAND_BUILDINGS()
    {
        return SECURE_VALUE_SIZE() + 0x06b428;
    }
    
    
    public int ISLAND_ITEMS()
    {
        return SECURE_VALUE_SIZE() + 0x06a428;
    }
    
    
    //
    public int PLAYERS()
    {
        return SECURE_VALUE_SIZE() + 0x20;
    }
    
    
    public int PLAYER_HAIRSTYLE()
    {
        return 0x04;
    }
    
    
    public int PLAYER_HAIRCOLOR()
    {
        return 0x05;
    }
    
    
    public int PLAYER_FACE()
    {
        return 0x06;
    }
    
    
    public int PLAYER_EYECOLOR()
    {
        return 0x07;
    }
    
    
    public int PLAYER_TAN()
    {
        return 0x08;
    }
    
    
    public int PLAYER_HAT()
    {
        return 0x0a;
    }
    
    
    public int PLAYER_ACCESSORY()
    {
        return 0x0e;
    }
    
    
    public int PLAYER_WETSUIT()
    {
        return 0x12;
    }
    
    
    public int PLAYER_TOPWEAR()
    {
        return 0x16;
    }
    
    
    public int PLAYER_BOTTOMWEAR()
    {
        return 0x1a;
    }
    
    
    public int PLAYER_SOCKS()
    {
        return 0x1e;
    }
    
    
    public int PLAYER_SHOES()
    {
        return 0x22;
    }
    
    
    public int PLAYER_HELDITEM()
    {
        return 0x26;
    }
    
    
    public int PLAYER_PATTERNS()
    {
        return 0x2c;
    }
    
    
    public int PLAYER_ID1()
    {
        return 0x55a6;
    }
    
    
    public int PLAYER_ID2()
    {
        return 0x55a7;
    }
    
    
    public int PLAYER_NAME()
    {
        return 0x55a8;
    }
    
    
    public int PLAYER_GENDER()
    {
        return 0x55ba;
    }
    
    
    public int PLAYER_TPCREGION()
    {
        return 0x55d2;
    }
    
    
    public int PLAYER_BIRTHDAYMONTH()
    {
        return 0x55d4;
    }
    
    
    public int PLAYER_BIRTHDAYDAY()
    {
        return 0x55d5;
    }
    
    
    public int PLAYER_REGYEAR()
    {
        return 0x55d6;
    }
    
    
    public int PLAYER_REGMONTH()
    {
        return 0x55d8;
    }
    
    
    public int PLAYER_REGDAY()
    {
        return 0x55d9;
    }
    
    
    public int PLAYER_BADGES()
    {
        return 0x569c;
    }
    
    
    public int PLAYER_TPCPIC()
    {
        return 0x5724;
    }
    
    
    public int PLAYER_PLAYTIME()
    {
        return 0x6b90;
    }
    
    
    public int PLAYER_MEDALS()
    {
        return 0x6b9c;
    }
    
    
    public int PLAYER_POCKETS()
    {
        return 0x6bb0;
    }
    
    
    public int PLAYER_ENCYCLOPEDIA()
    {
        return 0x6c00;
    }
    
    
    public int PLAYER_BANK()
    {
        return 0x6b6c;
    }
    
    
    public int PLAYER_WALLET()
    {
        return 0x6e38;
    }
    
    
    public int PLAYER_ISLANDBOX()
    {
        return 0x6e40;
    }
    
    
    public int PLAYER_DRESSERS()
    {
        return 0x8e18;
    }
    
    
    public int PLAYER_HOUSESIZE()
    {
        return 0x057e64;
    }
    
    
    public int PLAYER_HOUSESTYLE()
    {
        return 0x057e65;
    }
    
    
    public int PLAYER_HOUSEDOORSHAPE()
    {
        return 0x057e66;
    }
    
    
    public int PLAYER_HOUSEBRICK()
    {
        return 0x057e67;
    }
    
    
    public int PLAYER_HOUSEROOF()
    {
        return 0x057e68;
    }
    
    
    public int PLAYER_HOUSEDOOR()
    {
        return 0x057e69;
    }
    
    
    public int PLAYER_HOUSEFENCE()
    {
        return 0x057e6a;
    }
    
    
    public int PLAYER_HOUSEPAVEMENT()
    {
        return 0x057e6b;
    }
    
    
    public int PLAYER_HOUSEMAILBOX()
    {
        return 0x057e6c;
    }
    
    
    public int PLAYER_SIZE()
    {
        return 0x9f10;
    }
    
    
    //
    public int VILLAGERS()
    {
        return SECURE_VALUE_SIZE() + 0x027c90;
    }
    
    
    public int VILLAGER_ID()
    {
        return 0x00;
    }
    
    
    public int VILLAGER_PERSONALITY()
    {
        return 0x02;
    }
    
    
    public int VILLAGER_STOREDLETTER1()
    {
        return 0x182c;
    }
    
    
    public int VILLAGER_STOREDLETTER2()
    {
        return 0x186e;
    }
    
    
    public int VILLAGER_STOREDLETTER3()
    {
        return 0x19f0;
    }
    
    
    public int VILLAGER_SHIRT()
    {
        return 0x244e;
    }
    
    
    public int VILLAGER_SONG()
    {
        return 0x2452;
    }
    
    
    public int VILLAGER_WALL()
    {
        return 0x2456;
    }
    
    
    public int VILLAGER_FLOOR()
    {
        return 0x245a;
    }
    
    
    public int VILLAGER_UMBRELLA()
    {
        return 0x245e;
    }
    
    
    public int VILLAGER_FURNITURE()
    {
        return 0x2462;
    }
    
    
    public int VILLAGER_CATCHPHRASE()
    {
        return 0x24a6;
    }
    
    
    public int VILLAGER_STATUS()
    {
        return 0x24c4;
    }
    
    
    public int VILLAGER_SIZE()
    {
        return 0x24f8;
    }
    
    
    //
    public int PAST_VILLAGERS()
    {
        return SECURE_VALUE_SIZE() + 0x03f17e;
    }
    
    
    //
    public int SHOP_LOSTFOUND()
    {
        return SECURE_VALUE_SIZE() + 0x05c75e;
    }
    
    
    public int SHOP_NOOK()
    {
        return SECURE_VALUE_SIZE() + 0x05c7ec;
    }
    
    
    public int SHOP_ABLE1()
    {
        return SECURE_VALUE_SIZE() + 0x05c868;
    }
    
    
    public int SHOP_ABLEPATTERNS()
    {
        return SECURE_VALUE_SIZE() + 0x05c8b4;
    }
    
    
    public int SHOP_ABLE2()
    {
        return SECURE_VALUE_SIZE() + 0x060c34;
    }
    
    
    public int SHOP_LEIF()
    {
        return SECURE_VALUE_SIZE() + 0x060c72;
    }
    
    
    public int SHOP_REDD()
    {
        return SECURE_VALUE_SIZE() + 0x060cac;
    }
    
    
    public int SHOP_KICKS()
    {
        return SECURE_VALUE_SIZE() + 0x060daa;
    }
    
    
    public int SHOP_RETAIL()
    {
        return SECURE_VALUE_SIZE() + 0x060e30;
    }
    
    
    public int SHOP_MUSEUM()
    {
        return SECURE_VALUE_SIZE() + 0x06523a;
    }
    
    
    public int SHOP_LOLGYROIDS()
    {
        return SECURE_VALUE_SIZE() + 0x06530e;
    }
    
    
    public int SHOP_ISLAND()
    {
        return SECURE_VALUE_SIZE() + 0x065334;
    }
    
    
    public int SHOP_HOMES()
    {
        return SECURE_VALUE_SIZE() + 0x06524a;
    }
    
    
    public int SHOP_GRACIE()
    {
        return SECURE_VALUE_SIZE() + 0x065274;
    }
    
    
    //
    public int MIN_WALL()
    {
        return 0x2342;
    }
    
    
    public int MAX_WALL()
    {
        return 0x23c6;
    }
    
    
    public int MIN_FLOOR()
    {
        return 0x23c7;
    }
    
    
    public int MAX_FLOOR()
    {
        return 0x2445;
    }
    
    
    public int MIN_SONG()
    {
        return 0x2126;
    }
    
    
    public int MAX_SONG()
    {
        return 0x2180;
    }
    
    
    public int MIN_SHIRT()
    {
        return 0x2448;
    }
    
    
    public int MAX_SHIRT()
    {
        return 0x260b;
    }
    
    
    public int MIN_UMBRELLA()
    {
        return 0x2755;
    }
    
    
    public int MAX_UMBRELLA()
    {
        return 0x2778;
    }
}
