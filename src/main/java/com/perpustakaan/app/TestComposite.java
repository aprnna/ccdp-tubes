package com.perpustakaan.app;

import com.perpustakaan.domain.*;
import com.perpustakaan.patterns.structural.composite.*;
import com.perpustakaan.patterns.creational.abstractfactory.*;

/**
 * Test class untuk mendemonstrasikan Composite Pattern.
 * Menguji struktur katalog hierarkis perpustakaan.
 */
public class TestComposite {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("TESTING COMPOSITE PATTERN");
        System.out.println("Domain: Struktur Katalog Perpustakaan Digital");
        System.out.println("=".repeat(70));
        System.out.println();
        
        // Membuat factory untuk membuat items
        DigitalItemFactory ebookFactory = new EBookFactory();
        DigitalItemFactory audiobookFactory = new AudioBookFactory();
        DigitalItemFactory journalFactory = new JournalFactory();
        
        // Membuat root catalog
        Category library = new Category("Digital Library - Main Catalog");
        
        // Kategori Ilmu Komputer
        Category computerScience = new Category("Computer Science");
        Category programming = new Category("Programming");
        Category database = new Category("Database");
        
        // Tambahkan buku programming
        programming.add(new BookItem(
            "Clean Code",
            ebookFactory.createItem("Clean Code", "Robert C. Martin", 2008)
        ));
        programming.add(new BookItem(
            "Design Patterns",
            ebookFactory.createItem("Design Patterns", "Gang of Four", 1994)
        ));
        programming.add(new BookItem(
            "Java Programming",
            audiobookFactory.createItem("Java Programming", "Joshua Bloch", 2017)
        ));
        
        // Tambahkan buku database
        database.add(new BookItem(
            "SQL Fundamentals",
            ebookFactory.createItem("SQL Fundamentals", "Chris Date", 2015)
        ));
        database.add(new BookItem(
            "Database Systems",
            journalFactory.createItem("Database Systems", "Ramakrishnan", 2020)
        ));
        
        // Build hierarchy Computer Science
        computerScience.add(programming);
        computerScience.add(database);
        
        // Kategori Sastra
        Category literature = new Category("Literature");
        Category novelIndonesia = new Category("Indonesian Novels");
        Category poetry = new Category("Poetry");
        
        // Tambahkan novel
        novelIndonesia.add(new BookItem(
            "Laskar Pelangi",
            ebookFactory.createItem("Laskar Pelangi", "Andrea Hirata", 2005)
        ));
        novelIndonesia.add(new BookItem(
            "Bumi Manusia",
            ebookFactory.createItem("Bumi Manusia", "Pramoedya Ananta Toer", 1980)
        ));
        
        // Tambahkan puisi
        poetry.add(new BookItem(
            "Hujan Bulan Juni",
            audiobookFactory.createItem("Hujan Bulan Juni", "Sapardi Djoko Damono", 1994)
        ));
        
        // Build hierarchy Literature
        literature.add(novelIndonesia);
        literature.add(poetry);
        
        // Kategori Science
        Category science = new Category("Science");
        science.add(new BookItem(
            "A Brief History of Time",
            ebookFactory.createItem("A Brief History of Time", "Stephen Hawking", 1988)
        ));
        science.add(new BookItem(
            "Cosmos",
            audiobookFactory.createItem("Cosmos", "Carl Sagan", 1980)
        ));
        
        // Build main library
        library.add(computerScience);
        library.add(literature);
        library.add(science);
        
        // Display struktur lengkap
        System.out.println("--- Test 1: Display Complete Catalog Structure ---");
        library.display(0);
        System.out.println();
        
        // Test counting
        System.out.println("--- Test 2: Counting Items ---");
        System.out.println("Total items in library: " + library.count());
        System.out.println("Total items in Computer Science: " + computerScience.count());
        System.out.println("Total items in Programming: " + programming.count());
        System.out.println("Total items in Literature: " + literature.count());
        System.out.println();
        
        // Test accessing specific category
        System.out.println("--- Test 3: Accessing Specific Category ---");
        System.out.println("Displaying only Programming category:");
        programming.display(0);
        System.out.println();
        
        // Test dynamic addition
        System.out.println("--- Test 4: Dynamic Addition ---");
        Category webDevelopment = new Category("Web Development");
        webDevelopment.add(new BookItem(
            "JavaScript: The Good Parts",
            ebookFactory.createItem("JavaScript: The Good Parts", "Douglas Crockford", 2008)
        ));
        webDevelopment.add(new BookItem(
            "React Design Patterns",
            ebookFactory.createItem("React Design Patterns", "Michele Bertoli", 2017)
        ));
        
        computerScience.add(webDevelopment);
        
        System.out.println("After adding Web Development category:");
        System.out.println("Total items in Computer Science: " + computerScience.count());
        webDevelopment.display(0);
        System.out.println();
    }
}
