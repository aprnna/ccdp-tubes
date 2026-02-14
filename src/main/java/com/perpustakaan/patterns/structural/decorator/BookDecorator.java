package com.perpustakaan.patterns.structural.decorator;

/**
 * Abstract Decorator.
 * Menjadi wrapper dasar yang memungkinkan penambahan fitur
 * tambahan secara dinamis tanpa mengubah class utama.
 */
public abstract class BookDecorator implements ReadableItem {

    protected ReadableItem item;

    public BookDecorator(ReadableItem item){
        this.item = item;
    }

    @Override
    public void readContent(){
        item.readContent();
    }
    
    @Override
    public String getDescription(){
        return item.getDescription();
    }
}
