package com.michaelgatesdev.OldLeaf.util;

import java.util.regex.Pattern;

public class RegexUtil
{
    public static final Pattern BLANK_PATTERN = Pattern.compile("(^\\s*$)|(^\\x00*$)");
    public static final Pattern HEX_PATTERN   = Pattern.compile("((?:0[Xx])(?:[0-9A-Fa-f]+)\\b)");
    public static final Pattern SIZE_PATTERN  = Pattern.compile("([0-9]+)[Xx]([0-9]+)");
}
