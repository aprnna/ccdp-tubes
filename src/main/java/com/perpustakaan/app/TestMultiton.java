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

        // Membuat objek domain DigitalItem sebagai data uji
        DigitalItem ebook =
                new EBook("Clean Code", "Robert Martin", 2020, "PDF", 5.4);

        DigitalItem journal =
                new Journal("AI Research", "Andrew Ng", 2023, 10, 2, "Springer");

        // Mengambil manager kategori berdasarkan tipe item
        // Multiton akan membuat manager baru jika belum ada dan mengembalikan manager lama jika sudah ada
        DigitalItemCategoryManager ebookManager1 =
                DigitalItemCategoryManager.getManager(ebook);

        // Mengambil manager Ebook kedua kali
        // Seharusnya TIDAK membuat objek baru
        DigitalItemCategoryManager ebookManager2 =
                DigitalItemCategoryManager.getManager(ebook);

        // Mengambil manager untuk tipe Journal
        // Karena tipe berbeda, Multiton akan membuat manager baru
        DigitalItemCategoryManager journalManager =
                DigitalItemCategoryManager.getManager(journal);

        // Pengujian Instance Multiton

        // Mengecek apakah manager Ebook pertama dan kedua adalah objek yang sama
        // Hasil TRUE berarti Multiton bekerja (1 tipe = 1 instance)
        System.out.println("Manager Ebook sama? " + (ebookManager1 == ebookManager2));

        // Mengecek apakah manager Ebook dan Journal adalah objek yang berbeda
        // Operator != menguji kondisi apakah "berbeda", berarti true
        // TRUE berarti instance memang tidak sama (sesuai konsep Multiton)
        System.out.println("Manager Ebook vs Journal berbeda? " + (ebookManager1 != journalManager));

        // Menambahkan item ke masing-masing manager kategori
        ebookManager1.addItem(ebook);
        journalManager.addItem(journal);

        // Cek jumlah item pada setiap kategori
        System.out.println("Jumlah Ebook: " + ebookManager2.getItems().size());
        System.out.println("Jumlah Journal: " + journalManager.getItems().size());
    }
}
