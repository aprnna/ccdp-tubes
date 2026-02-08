package com.perpustakaan.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite - Kategori yang dapat berisi sub-kategori atau buku.
 * Implementasi dari Composite pattern yang merepresentasikan node dalam tree.
 */
public class Category extends CatalogComponent {
    private List<CatalogComponent> children;

    public Category(String name) {
        super(name);
        this.children = new ArrayList<>();
    }

    @Override
    public void add(CatalogComponent component) {
        children.add(component);
    }

    @Override
    public void remove(CatalogComponent component) {
        children.remove(component);
    }

    @Override
    public CatalogComponent getChild(int index) {
        if (index >= 0 && index < children.size()) {
            return children.get(index);
        }
        throw new IndexOutOfBoundsException("Invalid child index");
    }

    public List<CatalogComponent> getChildren() {
        return new ArrayList<>(children); // Return copy untuk encapsulation
    }

    @Override
    public void display(int depth) {
        // Print dengan indentasi sesuai kedalaman
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indent.append("  ");
        }
        
        System.out.println(indent + "📁 Category: " + name + " (" + count() + " items)");
        
        // Tampilkan semua children
        for (CatalogComponent child : children) {
            child.display(depth + 1);
        }
    }

    @Override
    public int count() {
        int total = 0;
        for (CatalogComponent child : children) {
            total += child.count();
        }
        return total;
    }
}
