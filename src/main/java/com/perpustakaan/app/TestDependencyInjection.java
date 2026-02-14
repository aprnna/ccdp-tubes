package com.perpustakaan.app;

import com.perpustakaan.domain.*;
import com.perpustakaan.patterns.behavioral.chain.*;
import com.perpustakaan.patterns.structural.flyweight.*;
import com.perpustakaan.patterns.creational.abstractfactory.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller Class yang menerima dependency melalui Constructor Injection.
 */
class LibraryAccessController {
    private AccessHandler accessPipeline; // Dependency 1

    // Constructor Injection
    public LibraryAccessController(AccessHandler accessPipeline) {
        this.accessPipeline = accessPipeline;
    }

    public void tryToReadBook(User user, DigitalItem item) {
        System.out.println("\nUser '" + user.getUsername() + "' meminta akses ke: " + item.getTitle());
        if (accessPipeline.checkAccess(user, item)) {
            System.out.println(">> MEMBUKA BUKU: " + item.getTitle() + "...");
        } else {
            System.out.println(">> AKSES DITOLAK.");
        }
    }

    public void displayCatalog(List<DigitalItem> items) {
        System.out.println("\n--- Menampilkan Katalog (Simulasi UI Hemat Memori) ---");
        int y = 0;
        for (DigitalItem item : items) {
            // Mapping tipe item ke tipe icon (Logic UI)
            String iconType = "PDF"; // Default
            if (item.getItemType().equals("AudioBook")) iconType = "AUDIO";
            else if (item.getItemType().equals("EBook")) iconType = "EPUB";

            // Mengambil Flyweight Object
            FormatIcon icon = IconFactory.getIcon(iconType);

            System.out.print("Item: " + item.getTitle() + " | ");
            // Render icon (menggunakan flyweight)
            icon.display(10, y);
            y += 20;
        }
    }
}


public class TestDependencyInjection {
    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("TESTING: CHAIN OF RESPONSIBILITY, FLYWEIGHT, & DI");
        System.out.println("Domain: Validasi Akses & Optimasi Memori");
        System.out.println("=".repeat(70));

        // CONFIGURATION PHASE (DEPENDENCY INJECTION SETUP)

        // Setup Chain of Responsibility Handlers
        AccessHandler auth = new AuthHandler();
        AccessHandler sub = new SubscriptionHandler();
        AccessHandler age = new AgeRestrictionHandler();

        // Merangkai rantai: Auth -> Subscription -> Age
        auth.setNext(sub).setNext(age);

        // INJECTION: Menyuntikkan rantai handler 'auth' (head) ke Controller
        LibraryAccessController controller = new LibraryAccessController(auth);


        // --- 2. RUNTIME PHASE ---

        // Membuat Dummy Data
        DigitalItemFactory ebookFactory = new EBookFactory();
        DigitalItemFactory audioFactory = new AudioBookFactory();

        DigitalItem book1 = ebookFactory.createItem("Clean Code", "Uncle Bob", 2008);
        DigitalItem book2 = audioFactory.createItem("The Pragmatic Programmer", "Andy Hunt", 1999);
        DigitalItem restrictedJournal = new Journal("Medical Advances", "Dr. House", 2024, 1, 1, "Elsevier");

        List<DigitalItem> catalog = new ArrayList<>();
        catalog.add(book1);
        catalog.add(book2);
        catalog.add(restrictedJournal);

        // Skenario A: User Tamu (Belum Login)
        User guest = new User("Guest123", false, false, 20);
        controller.tryToReadBook(guest, book1);

        // Skenario B: Member Biasa (Login, tapi tidak langganan)
        User regular = new User("Budi", true, false, 25);
        controller.tryToReadBook(regular, book1);

        // Skenario C: Anak Kecil (Login, Langganan, tapi buku dibatasi umur)
        User kid = new User("Bocil", true, true, 12);
        controller.tryToReadBook(kid, restrictedJournal); // Harusnya gagal di AgeCheck
        controller.tryToReadBook(kid, book1); // Harusnya berhasil

        // Skenario D: Testing Flyweight di Katalog
        // Perhatikan output "Loading heavy resources..." hanya muncul SEKALI per tipe
        System.out.println("\n\n--- Testing Flyweight Memory Efficiency ---");

        //  duplikasi buku jadi banyak untuk simulasi load besar
        for(int i=0; i<3; i++) catalog.add(book1);
        for(int i=0; i<3; i++) catalog.add(book2);

        controller.displayCatalog(catalog);

        System.out.println("\nTotal Objek Icon di Memori: " + IconFactory.getCacheSize());
        System.out.println("(Padahal menampilkan " + catalog.size() + " item, tapi objek fisik icon hanya dibuat sesuai jumlah tipe unik)");
    }
}