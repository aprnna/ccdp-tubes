package com.perpustakaan.app;

import com.perpustakaan.patterns.structural.decorator.DRMDecorator;
import com.perpustakaan.patterns.structural.decorator.ReadableItem;
import com.perpustakaan.patterns.structural.decorator.WatermarkDecorator;

/**
 * TestDecorator - Menguji Decorator Pattern.
 * Menambahkan fitur watermark dan DRM pada proses pembacaan buku.
 */
public class TestDecorator {

    public static void main(String[] args){

        System.out.println("=== TEST DECORATOR ===");

        ReadableItem book =
                new DRMDecorator(
                        new WatermarkDecorator(
                                new ReadableItem() {

                                    @Override
                                    public void readContent() {
                                        System.out.println("Membaca konten buku digital...");
                                    }

                                    @Override
                                    public String getDescription() {
                                        return "Buku Digital";
                                    }
                                }
                        )
                );

        book.readContent();
        System.out.println(book.getDescription());
    }
}
