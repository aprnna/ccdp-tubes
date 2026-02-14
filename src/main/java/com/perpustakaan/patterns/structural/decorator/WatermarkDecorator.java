package com.perpustakaan.patterns.structural.decorator;

/**
 * Concrete Decorator - Watermark.
 * Menambahkan fitur watermark saat konten buku dibaca.
 */
public class WatermarkDecorator extends BookDecorator {

    public WatermarkDecorator(ReadableItem item){
        super(item);
    }

    @Override
    public void readContent(){
        super.readContent();
        System.out.println("Menambahkan watermark...");
    }

    @Override
    public String getDescription(){
        return item.getDescription() + " + Watermark";
    }
}
