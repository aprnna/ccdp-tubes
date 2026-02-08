package com.perpustakaan.domain;

/**
 * Interface untuk semua jenis item digital di perpustakaan.
 * Menggunakan abstraksi untuk mendukung berbagai jenis koleksi.
 */
public interface DigitalItem {
    String getTitle();
    String getAuthor();
    int getYear();
    String getInfo();
    String getItemType();
}
