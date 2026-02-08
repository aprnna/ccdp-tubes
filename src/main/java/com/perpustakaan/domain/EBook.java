package com.perpustakaan.domain;

/**
 * EBook - implementasi DigitalItem untuk buku elektronik.
 * Memiliki atribut khusus: format dan ukuran file.
 */
public class EBook implements DigitalItem {
    private String title;
    private String author;
    private int year;
    private String format; // PDF, EPUB, MOBI
    private double fileSizeMB;

    public EBook(String title, String author, int year, String format, double fileSizeMB) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.format = format;
        this.fileSizeMB = fileSizeMB;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public String getItemType() {
        return "EBook";
    }

    public String getFormat() {
        return format;
    }

    public double getFileSizeMB() {
        return fileSizeMB;
    }

    @Override
    public String getInfo() {
        return String.format("EBook: '%s' by %s (%d) | Format: %s | Size: %.2f MB",
                title, author, year, format, fileSizeMB);
    }
}
