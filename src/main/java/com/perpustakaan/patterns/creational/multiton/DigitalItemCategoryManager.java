package com.perpustakaan.patterns.creational.multiton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.perpustakaan.domain.DigitalItem;

/**
 * Multiton Pattern
 * Manager kategori DigitalItem berdasarkan getItemType().
 */
public class DigitalItemCategoryManager {

    // Registry Multiton
    private static final Map<String, DigitalItemCategoryManager> instances = new HashMap<>();

    private String categoryType;
    private List<DigitalItem> items = new ArrayList<>();

    // Constructor private
    private DigitalItemCategoryManager(String categoryType) {
        this.categoryType = categoryType;
    }

    // Ambil instance berdasarkan tipe
    public static synchronized DigitalItemCategoryManager getInstance(String categoryType) {
        if (!instances.containsKey(categoryType)) {
            instances.put(categoryType, new DigitalItemCategoryManager(categoryType));
        }
        return instances.get(categoryType);
    }

    //  Baca tipe dari domain
    public static DigitalItemCategoryManager getManager(DigitalItem item) {
        return getInstance(item.getItemType());
    }

    public void addItem(DigitalItem item) {
        items.add(item);
    }

    public List<DigitalItem> getItems() {
        return items;
    }

    public String getCategoryType() {
        return categoryType;
    }
}
