package com.perpustakaan.app;

import com.perpustakaan.domain.DigitalItem;
import com.perpustakaan.domain.EBook;
import com.perpustakaan.patterns.behavioral.observer.LibraryCatalog;
import com.perpustakaan.patterns.behavioral.observer.NotificationService;
import com.perpustakaan.patterns.behavioral.observer.UserObserver;

/**
 * TestObserver - Menguji Observer Pattern.
 * Mengirim notifikasi saat buku baru ditambahkan ke katalog.
 */
public class TestObserver {

    public static void main(String[] args){

        System.out.println("=== TEST OBSERVER ===");

        LibraryCatalog catalog = new LibraryCatalog();

        catalog.addObserver(new UserObserver("Ucok"));
        catalog.addObserver(new NotificationService());

        DigitalItem newBook =
                new EBook("Design Patterns", "GoF", 1994, "PDF", 8.2);

        catalog.addNewBook(newBook);
    }
}
