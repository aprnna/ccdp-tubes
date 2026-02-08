package com.perpustakaan.patterns.behavioral.strategy;

import com.perpustakaan.domain.DigitalItem;
import java.util.List;

/**
 * Strategy Interface - mendefinisikan kontrak untuk semua strategi pencarian.
 * Setiap concrete strategy akan mengimplementasikan interface ini.
 */
public interface SearchStrategy {
    /**
     * Mencari items berdasarkan query dengan algoritma yang spesifik.
     * @param items Daftar semua items yang akan dicari
     * @param query String pencarian
     * @return List items yang sesuai dengan kriteria pencarian
     */
    List<DigitalItem> search(List<DigitalItem> items, String query);
    
    /**
     * Mendapatkan nama strategi untuk keperluan logging/display
     */
    String getStrategyName();
}
