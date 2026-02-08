package com.perpustakaan.patterns.creational.abstractfactory;

import com.perpustakaan.domain.DigitalItem;
import com.perpustakaan.domain.EBook;

/**
 * Concrete Factory untuk membuat EBook.
 * Factory ini menghasilkan objek EBook dengan format dan size default.
 */
public class EBookFactory implements DigitalItemFactory {
    private String defaultFormat;
    private double defaultSizeMB;

    public EBookFactory() {
        this.defaultFormat = "PDF";
        this.defaultSizeMB = 5.0;
    }

    public EBookFactory(String defaultFormat, double defaultSizeMB) {
        this.defaultFormat = defaultFormat;
        this.defaultSizeMB = defaultSizeMB;
    }

    @Override
    public DigitalItem createItem(String title, String author, int year) {
        return new EBook(title, author, year, defaultFormat, defaultSizeMB);
    }

    /**
     * Overloaded method untuk membuat EBook dengan parameter lengkap
     */
    public DigitalItem createItem(String title, String author, int year, 
                                  String format, double fileSizeMB) {
        return new EBook(title, author, year, format, fileSizeMB);
    }
}
