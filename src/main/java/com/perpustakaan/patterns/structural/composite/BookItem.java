package com.perpustakaan.patterns.structural.composite;

import com.perpustakaan.domain.DigitalItem;

/**
 * Leaf - Elemen terminal dalam Composite pattern.
 * Merepresentasikan buku individual dalam katalog.
 */
public class BookItem extends CatalogComponent {
    private DigitalItem item;
    private String author;
    private int year;

    public BookItem(String name, DigitalItem item) {
        super(name);
        this.item = item;
        this.author = item.getAuthor();
        this.year = item.getYear();
    }

    public DigitalItem getItem() {
        return item;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public void display(int depth) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indent.append("  ");
        }
        
        System.out.println(indent + "📖 " + item.getInfo());
    }

    @Override
    public int count() {
        return 1; // Leaf node selalu menghitung dirinya sebagai 1 item
    }

    // Override operasi composite untuk mencegah operasi tidak valid
    @Override
    public void add(CatalogComponent component) {
        throw new UnsupportedOperationException("Cannot add to a book item");
    }

    @Override
    public void remove(CatalogComponent component) {
        throw new UnsupportedOperationException("Cannot remove from a book item");
    }

    @Override
    public CatalogComponent getChild(int index) {
        throw new UnsupportedOperationException("Book item has no children");
    }
}
