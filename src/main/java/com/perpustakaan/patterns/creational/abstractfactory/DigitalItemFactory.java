package com.perpustakaan.patterns.creational.abstractfactory;

import com.perpustakaan.domain.DigitalItem;

/**
 * Abstract Factory Interface untuk membuat berbagai jenis DigitalItem.
 * Setiap concrete factory akan mengimplementasikan interface ini
 * untuk membuat jenis item yang spesifik.
 */
public interface DigitalItemFactory {
    DigitalItem createItem(String title, String author, int year);
}
