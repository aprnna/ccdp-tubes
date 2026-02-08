package com.perpustakaan.patterns.behavioral.strategy;

import com.perpustakaan.domain.DigitalItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Strategy - Pencarian berdasarkan nama penulis.
 * Menggunakan case-insensitive comparison.
 */
public class SearchByAuthor implements SearchStrategy {
    
    @Override
    public List<DigitalItem> search(List<DigitalItem> items, String query) {
        List<DigitalItem> results = new ArrayList<>();
        String lowerQuery = query.toLowerCase();
        
        for (DigitalItem item : items) {
            if (item.getAuthor().toLowerCase().contains(lowerQuery)) {
                results.add(item);
            }
        }
        
        return results;
    }
    
    @Override
    public String getStrategyName() {
        return "Search by Author";
    }
}
