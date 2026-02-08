package com.perpustakaan.patterns.creational.abstractfactory;

import com.perpustakaan.domain.DigitalItem;

/**
 * Abstract Factory Interface untuk membuat berbagai jenis DigitalItem.
 * Setiap concrete factory akan mengimplementasikan interface ini
 * untuk membuat jenis item yang spesifik.
 */
public interface DigitalItemFactory {
    /**
     * Factory method untuk membuat DigitalItem.
     * @param title Judul item
     * @param author Penulis/pencipta item
     * @param year Tahun terbit
     * @return DigitalItem yang sudah dibuat
     */
    DigitalItem createItem(String title, String author, int year);
}
