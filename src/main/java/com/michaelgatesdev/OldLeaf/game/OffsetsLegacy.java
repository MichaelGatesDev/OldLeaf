package com.michaelgatesdev.OldLeaf.game;

public class OffsetsLegacy
{
    private static final int SECURE_VALUE_SIZE      = 0x80;
    //
    public static final  int TOWN_TREESIZE          = SECURE_VALUE_SIZE + 0x049526;
    public static final  int TOWN_GRASSTYPE         = SECURE_VALUE_SIZE + 0x04da01;
    public static final  int TOWN_PLAYTIME          = SECURE_VALUE_SIZE + 0x5c730;
    public static final  int TOWN_DAYSPLAYED        = SECURE_VALUE_SIZE + 0x5c7ba;
    public static final  int TOWN_NATIVEFRUIT       = SECURE_VALUE_SIZE + 0x05c7b6;
    public static final  int TOWN_ID1               = SECURE_VALUE_SIZE + 0x05c738;
    public static final  int TOWN_ID2               = SECURE_VALUE_SIZE + 0x05c739;
    public static final  int TOWN_NAME              = SECURE_VALUE_SIZE + 0x05c73a;
    public static final  int TOWN_AVAILABLEPWPS     = SECURE_VALUE_SIZE + 0x04d9c8;
    //
    public static final  int MUSEUM_ROOM1           = SECURE_VALUE_SIZE + 0x0659d8;
    public static final  int MUSEUM_ROOMSIZE        = 0x0b98;
    //
    public static final  int MAP_GRASS              = SECURE_VALUE_SIZE + 0x053e80;
    public static final  int MAP_ACRES              = SECURE_VALUE_SIZE + 0x04da04;
    public static final  int MAP_BUILDINGS          = SECURE_VALUE_SIZE + 0x049528;
    public static final  int MAP_ITEMS              = SECURE_VALUE_SIZE + 0x04da58;
    //
    public static final  int ISLAND_ACRES           = SECURE_VALUE_SIZE + 0x06a408;
    public static final  int ISLAND_BUILDINGS       = SECURE_VALUE_SIZE + 0x06b428;
    public static final  int ISLAND_ITEMS           = SECURE_VALUE_SIZE + 0x06a428;
    //
    public static final  int PLAYERS                = SECURE_VALUE_SIZE + 0x20;
    public static final  int PLAYER_HAIRSTYLE       = 0x04;
    public static final  int PLAYER_HAIRCOLOR       = 0x05;
    public static final  int PLAYER_FACE            = 0x06;
    public static final  int PLAYER_EYECOLOR        = 0x07;
    public static final  int PLAYER_TAN             = 0x08;
    public static final  int PLAYER_HAT             = 0x0a;
    public static final  int PLAYER_ACCESSORY       = 0x0e;
    public static final  int PLAYER_WETSUIT         = 0x12;
    public static final  int PLAYER_TOPWEAR         = 0x16;
    public static final  int PLAYER_BOTTOMWEAR      = 0x1a;
    public static final  int PLAYER_SOCKS           = 0x1e;
    public static final  int PLAYER_SHOES           = 0x22;
    public static final  int PLAYER_HELDITEM        = 0x26;
    public static final  int PLAYER_PATTERNS        = 0x2c;
    public static final  int PLAYER_ID1             = 0x55a6;
    public static final  int PLAYER_ID2             = 0x55a7;
    public static final  int PLAYER_NAME            = 0x55a8;
    public static final  int PLAYER_GENDER          = 0x55ba;
    public static final  int PLAYER_TPCREGION       = 0x55d2;
    public static final  int PLAYER_BIRTHDAYMONTH   = 0x55d4;
    public static final  int PLAYER_BIRTHDAYDAY     = 0x55d5;
    public static final  int PLAYER_REGYEAR         = 0x55d6;
    public static final  int PLAYER_REGMONTH        = 0x55d8;
    public static final  int PLAYER_REGDAY          = 0x55d9;
    public static final  int PLAYER_BADGES          = 0x569c;
    public static final  int PLAYER_TPCPIC          = 0x5724;
    public static final  int PLAYER_PLAYTIME        = 0x6b90;
    public static final  int PLAYER_MEDALS          = 0x6b9c;
    public static final  int PLAYER_POCKETS         = 0x6bb0;
    public static final  int PLAYER_ENCYCLOPEDIA    = 0x6c00;
    public static final  int PLAYER_BANK            = 0x6b6c;
    public static final  int PLAYER_WALLET          = 0x6e38;
    public static final  int PLAYER_ISLANDBOX       = 0x6e40;
    public static final  int PLAYER_DRESSERS        = 0x8e18;
    public static final  int PLAYER_HOUSESIZE       = 0x057e64;
    public static final  int PLAYER_HOUSESTYLE      = 0x057e65;
    public static final  int PLAYER_HOUSEDOORSHAPE  = 0x057e66;
    public static final  int PLAYER_HOUSEBRICK      = 0x057e67;
    public static final  int PLAYER_HOUSEROOF       = 0x057e68;
    public static final  int PLAYER_HOUSEDOOR       = 0x057e69;
    public static final  int PLAYER_HOUSEFENCE      = 0x057e6a;
    public static final  int PLAYER_HOUSEPAVEMENT   = 0x057e6b;
    public static final  int PLAYER_HOUSEMAILBOX    = 0x057e6c;
    public static final  int PLAYER_SIZE            = 0x9f10;
    //
    public static final  int VILLAGERS              = SECURE_VALUE_SIZE + 0x027c90;
    public static final  int VILLAGER_ID            = 0x00;
    public static final  int VILLAGER_PERSONALITY   = 0x02;
    public static final  int VILLAGER_STOREDLETTER1 = 0x182c;
    public static final  int VILLAGER_STOREDLETTER2 = 0x186e;
    public static final  int VILLAGER_STOREDLETTER3 = 0x19f0;
    public static final  int VILLAGER_SHIRT         = 0x244e;
    public static final  int VILLAGER_SONG          = 0x2452;
    public static final  int VILLAGER_WALL          = 0x2456;
    public static final  int VILLAGER_FLOOR         = 0x245a;
    public static final  int VILLAGER_UMBRELLA      = 0x245e;
    public static final  int VILLAGER_FURNITURE     = 0x2462;
    public static final  int VILLAGER_CATCHPHRASE   = 0x24a6;
    public static final  int VILLAGER_STATUS        = 0x24c4;
    public static final  int VILLAGER_SIZE          = 0x24f8;
    //
    public static final  int PAST_VILLAGERS         = SECURE_VALUE_SIZE + 0x03f17e;
    //
    public static final  int SHOP_LOSTFOUND         = SECURE_VALUE_SIZE + 0x05c75e;
    public static final  int SHOP_NOOK              = SECURE_VALUE_SIZE + 0x05c7ec;
    public static final  int SHOP_ABLE1             = SECURE_VALUE_SIZE + 0x05c868;
    public static final  int SHOP_ABLEPATTERNS      = SECURE_VALUE_SIZE + 0x05c8b4;
    public static final  int SHOP_ABLE2             = SECURE_VALUE_SIZE + 0x060c34;
    public static final  int SHOP_LEIF              = SECURE_VALUE_SIZE + 0x060c72;
    public static final  int SHOP_REDD              = SECURE_VALUE_SIZE + 0x060cac;
    public static final  int SHOP_KICKS             = SECURE_VALUE_SIZE + 0x060daa;
    public static final  int SHOP_RETAIL            = SECURE_VALUE_SIZE + 0x060e30;
    public static final  int SHOP_MUSEUM            = SECURE_VALUE_SIZE + 0x06523a;
    public static final  int SHOP_LOLGYROIDS        = SECURE_VALUE_SIZE + 0x06530e;
    public static final  int SHOP_ISLAND            = SECURE_VALUE_SIZE + 0x065334;
    public static final  int SHOP_HOMES             = SECURE_VALUE_SIZE + 0x06524a;
    public static final  int SHOP_GRACIE            = SECURE_VALUE_SIZE + 0x065274;
    //
    public static final  int MIN_WALL               = 0x2342;
    public static final  int MAX_WALL               = 0x23c6;
    public static final  int MIN_FLOOR              = 0x23c7;
    public static final  int MAX_FLOOR              = 0x2445;
    public static final  int MIN_SONG               = 0x2126;
    public static final  int MAX_SONG               = 0x2180;
    public static final  int MIN_SHIRT              = 0x2448;
    public static final  int MAX_SHIRT              = 0x260b;
    public static final  int MIN_UMBRELLA           = 0x2755;
    public static final  int MAX_UMBRELLA           = 0x2778;
}
