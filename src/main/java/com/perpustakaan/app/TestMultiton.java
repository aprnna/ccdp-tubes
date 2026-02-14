package com.perpustakaan.app;

import com.perpustakaan.domain.DigitalItem;
import com.perpustakaan.domain.EBook;
import com.perpustakaan.domain.Journal;
import com.perpustakaan.patterns.creational.multiton.DigitalItemCategoryManager;

/**
 * TestMultiton
 * Pengujian Multiton Pattern pada sistem perpustakaan digital.
 */
public class TestMultiton {

    public static void main(String[] args) {

        System.out.println("=== TEST MULTITON ===");

        DigitalItem ebook =
                new EBook("Clean Code", "Robert Martin", 2020, "PDF", 5.4);

        DigitalItem journal =
                new Journal("AI Research", "Andrew Ng", 2023, 10, 2, "Springer");

        DigitalItemCategoryManager ebookManager1 =
                DigitalItemCategoryManager.getManager(ebook);
        DigitalItemCategoryManager ebookManager2 =
                DigitalItemCategoryManager.getManager(ebook);
        DigitalItemCategoryManager journalManager =
                DigitalItemCategoryManager.getManager(journal);

        System.out.println("Manager Ebook sama? " + (ebookManager1 == ebookManager2));

        System.out.println("Manager Ebook vs Journal berbeda? " + (ebookManager1 != journalManager));

        ebookManager1.addItem(ebook);
        journalManager.addItem(journal);

        System.out.println("Jumlah Ebook: " + ebookManager2.getItems().size());
        System.out.println("Jumlah Journal: " + journalManager.getItems().size());
    }
}
