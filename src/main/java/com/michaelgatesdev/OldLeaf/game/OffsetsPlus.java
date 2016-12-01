package com.michaelgatesdev.OldLeaf.game;

public class OffsetsPlus
{
    private static final int SECURE_VALUE_SIZE     = 0x80;
    //
    public static final  int TOWN_TREESIZE         = 0x04be86;
    public static final  int TOWN_GRASSTYPE        = 0x053481;
    public static final  int TOWN_PLAYTIME         = 0x0621b0;
    public static final  int TOWN_DAYSPLAYED       = 0x06223e;
    public static final  int TOWN_NATIVEFRUIT      = 0x06223a;
    public static final  int TOWN_ID1              = 0x0621b8;
    public static final  int TOWN_ID2              = 0x0621b9;
    public static final  int TOWN_NAME             = 0x0621ba;
    public static final  int TOWN_AVAILABLEPWPS    = 0x050328;
    //
    public static final  int MUSEUM_ROOM1          = SECURE_VALUE_SIZE + 0x0659d8 + 0x5a20;
    public static final  int MUSEUM_ROOMSIZE       = 0x0b98;
    //
    public static final  int MAP_GRASS             = 0x059900;
    public static final  int MAP_ACRES             = 0x053484;
    public static final  int MAP_BUILDINGS         = 0x04be88;
    public static final  int MAP_ITEMS             = 0x0534d8;
    //
    public static final  int ISLAND_ACRES          = SECURE_VALUE_SIZE + 0x06a408 + 0x5a30;
    public static final  int ISLAND_BUILDINGS      = SECURE_VALUE_SIZE + 0x06b428 + 0x5a30;
    public static final  int ISLAND_ITEMS          = SECURE_VALUE_SIZE + 0x06a428 + 0x5a30;
    //
    public static final  int PLAYERS               = SECURE_VALUE_SIZE + 0x20;
    public static final  int PLAYER_HAIRSTYLE      = 0x04;
    public static final  int PLAYER_HAIRCOLOR      = 0x05;
    public static final  int PLAYER_FACE           = 0x06;
    public static final  int PLAYER_EYECOLOR       = 0x07;
    public static final  int PLAYER_TAN            = 0x08;
    public static final  int PLAYER_HAT            = 0x0a;
    public static final  int PLAYER_ACCESSORY      = 0x0e;
    public static final  int PLAYER_WETSUIT        = 0x12;
    public static final  int PLAYER_TOPWEAR        = 0x16;
    public static final  int PLAYER_BOTTOMWEAR     = 0x1a;
    public static final  int PLAYER_SOCKS          = 0x1e;
    public static final  int PLAYER_SHOES          = 0x22;
    public static final  int PLAYER_HELDITEM       = 0x26;
    public static final  int PLAYER_PATTERNS       = 0x2c;
    public static final  int PLAYER_ID1            = 0x55a6;
    public static final  int PLAYER_ID2            = 0x55a7;
    public static final  int PLAYER_NAME           = 0x55a8;
    public static final  int PLAYER_GENDER         = 0x55ba;
    public static final  int PLAYER_TPCREGION      = 0x55d2;
    public static final  int PLAYER_BIRTHDAYMONTH  = 0x55d4;
    public static final  int PLAYER_BIRTHDAYDAY    = 0x55d5;
    public static final  int PLAYER_REGYEAR        = 0x55d6;
    public static final  int PLAYER_REGMONTH       = 0x55d8;
    public static final  int PLAYER_REGDAY         = 0x55d9;
    public static final  int PLAYER_BADGES         = 0x569c;
    public static final  int PLAYER_TPCPIC         = 0x5738;
    public static final  int PLAYER_PLAYTIME       = 0x6bb0;
    public static final  int PLAYER_MEDALS         = 0x6b9c;
    public static final  int PLAYER_POCKETS        = 0x6bd0;
    public static final  int PLAYER_ENCYCLOPEDIA   = 0x6c20;
    public static final  int PLAYER_BANK           = 0x6b8c;
    public static final  int PLAYER_WALLET         = 0x6e38; /* TO-DO!!! */
    public static final  int PLAYER_ISLANDBOX      = 0x6e40 + 0xd0;
    public static final  int PLAYER_DRESSERS       = 0x8e18 + 0x4d8;
    public static final  int PLAYER_HOUSESIZE      = 0x05d864;
    public static final  int PLAYER_HOUSESTYLE     = 0x05d865;
    public static final  int PLAYER_HOUSEDOORSHAPE = 0x05d866;
    public static final  int PLAYER_HOUSEBRICK     = 0x05d867;
    public static final  int PLAYER_HOUSEROOF      = 0x05d868;
    public static final  int PLAYER_HOUSEDOOR      = 0x05d869;
    public static final  int PLAYER_HOUSEFENCE     = 0x05d86a;
    public static final  int PLAYER_HOUSEPAVEMENT  = 0x05d86b;
    public static final  int PLAYER_HOUSEMAILBOX   = 0x05d86c;
    public static final  int PLAYER_SIZE           = 0xa480;
    /*PLAYER_MEOW=			0x0668a9;*/ /* probably incorrect */
    public static final int PLAYER_STORAGE = 0x07a778;
    //
    public static final int VILLAGERS              = 0x0292d0;
    public static final int VILLAGER_ID            = 0x00;
    public static final int VILLAGER_PERSONALITY   = 0x02;
    public static final int VILLAGER_STOREDLETTER1 = 0x182c; /* TO-DO!!! */
    public static final int VILLAGER_STOREDLETTER2 = 0x186e; /* TO-DO!!! */
    public static final int VILLAGER_STOREDLETTER3 = 0x19f0; /* TO-DO!!! */
    public static final int VILLAGER_SHIRT         = 0x246e;
    public static final int VILLAGER_SONG          = 0x2472;
    public static final int VILLAGER_WALL          = 0x2476;
    public static final int VILLAGER_FLOOR         = 0x247a;
    public static final int VILLAGER_UMBRELLA      = 0x247e;
    public static final int VILLAGER_FURNITURE     = 0x2482;
    public static final int VILLAGER_CATCHPHRASE   = 0x24c6;
    public static final int VILLAGER_STATUS        = 0x24e4; /* is it correct??? */
    public static final int VILLAGER_SIZE          = 0x2518;
    //
    public static final int PAST_VILLAGERS         = 0x408fa;
    //
    public static final int CARAVAN_VILLAGER       = 0x6ae62;
    //
    public static final int SHOP_LOSTFOUND         = SECURE_VALUE_SIZE + 0x05c75e + 0x5a04;
    public static final int SHOP_NOOK              = SECURE_VALUE_SIZE + 0x05c7ec + 0x5a04;
    public static final int SHOP_ABLE1             = SECURE_VALUE_SIZE + 0x05c868 + 0x5a04;
    public static final int SHOP_ABLEPATTERNS      = SECURE_VALUE_SIZE + 0x05c8b4 + 0x5a04;
    public static final int SHOP_ABLE2             = SECURE_VALUE_SIZE + 0x060c34 + 0x5a04;
    public static final int SHOP_LEIF              = SECURE_VALUE_SIZE + 0x060c72 + 0x5a04;
    public static final int SHOP_REDD              = SECURE_VALUE_SIZE + 0x060cac + 0x5a04;
    public static final int SHOP_KICKS             = SECURE_VALUE_SIZE + 0x060daa + 0x5a04;
    public static final int SHOP_RETAIL            = SECURE_VALUE_SIZE + 0x060e30 + 0x5a04;
    public static final int SHOP_MUSEUM            = SECURE_VALUE_SIZE + 0x06523a + 0x5a04;
    public static final int SHOP_LOLGYROIDS        = SECURE_VALUE_SIZE + 0x06530e + 0x5a04;
    public static final int SHOP_ISLAND            = SECURE_VALUE_SIZE + 0x065334 + 0x5a04;
    public static final int SHOP_HOMES             = SECURE_VALUE_SIZE + 0x06524a + 0x5a04;
    public static final int SHOP_GRACIE            = SECURE_VALUE_SIZE + 0x065274 + 0x5a04;
    //
    public static final int MIN_WALL               = 0x234c;
    public static final int MAX_WALL               = 0x23e9;
    public static final int MIN_FLOOR              = 0x23eb;
    public static final int MAX_FLOOR              = 0x2492;
    public static final int MIN_SONG               = 0x212b;
    public static final int MAX_SONG               = 0x2185;
    public static final int MIN_SHIRT              = 0x2495;
    public static final int MAX_SHIRT              = 0x2680;
    public static final int MIN_UMBRELLA           = 0x27e6;
    public static final int MAX_UMBRELLA           = 0x280a;
}
