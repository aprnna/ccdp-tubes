package com.perpustakaan.patterns.structural.composite;

/**
 * Component - base class untuk Composite Pattern.
 * Mendefinisikan interface untuk objek dalam komposisi (Category dan BookItem).
 */
public abstract class CatalogComponent {
    protected String name;

    public CatalogComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Operasi default untuk composite operations
    public void add(CatalogComponent component) {
        throw new UnsupportedOperationException("Cannot add to this component");
    }

    public void remove(CatalogComponent component) {
        throw new UnsupportedOperationException("Cannot remove from this component");
    }

    public CatalogComponent getChild(int index) {
        throw new UnsupportedOperationException("No children in this component");
    }

    // Operasi yang harus diimplementasi oleh semua subclass
    public abstract void display(int depth);
    public abstract int count();
}
