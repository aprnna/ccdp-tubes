package com.perpustakaan.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class IconFactory {
    private static final Map<String, FormatIcon> iconCache = new HashMap<>();

    public static FormatIcon getIcon(String formatType) {
        FormatIcon icon = iconCache.get(formatType);

        if (icon == null) {
            icon = new ConcreteFormatIcon(formatType);
            iconCache.put(formatType, icon);
        }
        return icon;
    }

    public static int getCacheSize() {
        return iconCache.size();
    }
}