package com.perpustakaan.app;

import com.perpustakaan.domain.DigitalItem;
import com.perpustakaan.patterns.creational.abstractfactory.*;

/**
 * Test class untuk mendemonstrasikan Abstract Factory Pattern.
 * Menguji pembuatan berbagai jenis koleksi digital menggunakan factory.
 */
public class TestAbstractFactory {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("TESTING ABSTRACT FACTORY PATTERN");
        System.out.println("Domain: Perpustakaan Digital");
        System.out.println("=".repeat(70));
        System.out.println();
        
        // Test 1: Membuat EBook menggunakan EBookFactory
        System.out.println("--- Test 1: EBook Factory ---");
        DigitalItemFactory ebookFactory = new EBookFactory("EPUB", 3.5);
        DigitalItem ebook1 = ebookFactory.createItem(
            "Clean Code", 
            "Robert C. Martin", 
            2008
        );
        System.out.println(ebook1.getInfo());
        
        DigitalItem ebook2 = ebookFactory.createItem(
            "Design Patterns", 
            "Gang of Four", 
            1994
        );
        System.out.println(ebook2.getInfo());
        System.out.println();
        
        // Test 2: Membuat AudioBook menggunakan AudioBookFactory
        System.out.println("--- Test 2: AudioBook Factory ---");
        DigitalItemFactory audiobookFactory = new AudioBookFactory(240, "John Doe");
        DigitalItem audiobook1 = audiobookFactory.createItem(
            "The Pragmatic Programmer", 
            "Andrew Hunt", 
            1999
        );
        System.out.println(audiobook1.getInfo());
        
        DigitalItem audiobook2 = audiobookFactory.createItem(
            "Refactoring", 
            "Martin Fowler", 
            2018
        );
        System.out.println(audiobook2.getInfo());
        System.out.println();
        
        // Test 3: Membuat Journal menggunakan JournalFactory
        System.out.println("--- Test 3: Journal Factory ---");
        DigitalItemFactory journalFactory = new JournalFactory(15, 3, "IEEE");
        DigitalItem journal1 = journalFactory.createItem(
            "Software Engineering Practices", 
            "Jane Smith", 
            2023
        );
        System.out.println(journal1.getInfo());
        
        DigitalItem journal2 = journalFactory.createItem(
            "Machine Learning Advances", 
            "Alan Turing", 
            2024
        );
        System.out.println(journal2.getInfo());
        System.out.println();
        
        // Test 4: Demonstrasi polymorphism - semua factory menghasilkan DigitalItem
        System.out.println("--- Test 4: Polymorphism Demonstration ---");
        DigitalItemFactory[] factories = {
            new EBookFactory(),
            new AudioBookFactory(),
            new JournalFactory()
        };
        
        String[] titles = {
            "Java Programming",
            "Python for Data Science",
            "AI Research Journal"
        };
        
        for (int i = 0; i < factories.length; i++) {
            DigitalItem item = factories[i].createItem(
                titles[i], 
                "Various Authors", 
                2024
            );
            System.out.println("Factory " + (i+1) + ": " + item.getInfo());
        }
    }
}
