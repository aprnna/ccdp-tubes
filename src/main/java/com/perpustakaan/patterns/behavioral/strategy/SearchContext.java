package com.perpustakaan.patterns.behavioral.strategy;

import com.perpustakaan.domain.DigitalItem;
import java.util.List;

/**
 * Context - class yang menggunakan Strategy.
 * Memungkinkan penggantian strategi pencarian secara dinamis.
 */
public class SearchContext {
    private SearchStrategy strategy;
    
    public SearchContext() {
        // Default strategy
        this.strategy = new SearchByTitle();
    }
    
    public SearchContext(SearchStrategy strategy) {
        this.strategy = strategy;
    }
    
    /**
     * Mengubah strategi pencarian saat runtime
     */
    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }
    
    /**
     * Mendapatkan strategi yang sedang digunakan
     */
    public SearchStrategy getStrategy() {
        return strategy;
    }
    
    /**
     * Menjalankan pencarian menggunakan strategi yang aktif
     */
    public List<DigitalItem> executeSearch(List<DigitalItem> items, String query) {
        System.out.println("Using strategy: " + strategy.getStrategyName());
        return strategy.search(items, query);
    }
}
