package com.perpustakaan.patterns.behavioral.strategy;

import com.perpustakaan.domain.DigitalItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Strategy - Pencarian berdasarkan kata kunci.
 * Mencari di title, author, dan info lengkap dari item.
 */
public class SearchByKeyword implements SearchStrategy {
    
    @Override
    public List<DigitalItem> search(List<DigitalItem> items, String query) {
        List<DigitalItem> results = new ArrayList<>();
        String lowerQuery = query.toLowerCase();
        
        for (DigitalItem item : items) {
            String searchableContent = (
                item.getTitle() + " " + 
                item.getAuthor() + " " + 
                item.getInfo()
            ).toLowerCase();
            
            if (searchableContent.contains(lowerQuery)) {
                results.add(item);
            }
        }
        
        return results;
    }
    
    @Override
    public String getStrategyName() {
        return "Search by Keyword";
    }
}
