package com.perpustakaan.patterns.behavioral.strategy;

import com.perpustakaan.domain.DigitalItem;
import java.util.List;

/**
 * Strategy Interface - mendefinisikan kontrak untuk semua strategi pencarian.
 * Setiap concrete strategy akan mengimplementasikan interface ini.
 */
public interface SearchStrategy {
    List<DigitalItem> search(List<DigitalItem> items, String query);
    String getStrategyName();
}
