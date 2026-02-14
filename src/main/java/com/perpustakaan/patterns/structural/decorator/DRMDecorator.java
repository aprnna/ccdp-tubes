package com.perpustakaan.patterns.structural.decorator;

/**
 * Concrete Decorator - DRM Protection.
 * Menambahkan proteksi DRM pada proses pembacaan konten buku digital.
 */
public class DRMDecorator extends BookDecorator {

    public DRMDecorator(ReadableItem item){
        super(item);
    }

    @Override
    public void readContent(){
        super.readContent();
        System.out.println("Proteksi DRM aktif...");
    }

    @Override
    public String getDescription(){
        return item.getDescription() + " + DRM Protection";
    }
}
