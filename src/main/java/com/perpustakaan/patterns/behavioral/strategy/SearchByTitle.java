package com.perpustakaan.patterns.behavioral.strategy;

import com.perpustakaan.domain.DigitalItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Strategy - Pencarian berdasarkan judul buku.
 * Menggunakan case-insensitive comparison.
 */
public class SearchByTitle implements SearchStrategy {
    
    @Override
    public List<DigitalItem> search(List<DigitalItem> items, String query) {
        List<DigitalItem> results = new ArrayList<>();
        String lowerQuery = query.toLowerCase();
        
        for (DigitalItem item : items) {
            if (item.getTitle().toLowerCase().contains(lowerQuery)) {
                results.add(item);
            }
        }
        
        return results;
    }
    
    @Override
    public String getStrategyName() {
        return "Search by Title";
    }
}
