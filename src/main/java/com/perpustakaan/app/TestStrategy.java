package com.perpustakaan.app;

import com.perpustakaan.domain.*;
import com.perpustakaan.patterns.creational.abstractfactory.*;
import com.perpustakaan.patterns.behavioral.strategy.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Test class untuk mendemonstrasikan Strategy Pattern.
 * Menguji berbagai strategi pencarian buku.
 */
public class TestStrategy {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("TESTING STRATEGY PATTERN");
        System.out.println("Domain: Sistem Pencarian Perpustakaan Digital");
        System.out.println("=".repeat(70));
        System.out.println();
        
        // Setup: Membuat koleksi buku
        List<DigitalItem> libraryCollection = new ArrayList<>();
        
        DigitalItemFactory ebookFactory = new EBookFactory();
        DigitalItemFactory audiobookFactory = new AudioBookFactory();
        DigitalItemFactory journalFactory = new JournalFactory();
        
        // Menambahkan berbagai buku ke koleksi
        libraryCollection.add(ebookFactory.createItem("Clean Code", "Robert C. Martin", 2008));
        libraryCollection.add(ebookFactory.createItem("Design Patterns", "Gang of Four", 1994));
        libraryCollection.add(audiobookFactory.createItem("The Pragmatic Programmer", "Andrew Hunt", 1999));
        libraryCollection.add(ebookFactory.createItem("Refactoring", "Martin Fowler", 2018));
        libraryCollection.add(journalFactory.createItem("Software Engineering Practices", "Robert C. Martin", 2023));
        libraryCollection.add(ebookFactory.createItem("Java Programming", "Joshua Bloch", 2017));
        libraryCollection.add(audiobookFactory.createItem("Python for Data Science", "Jake VanderPlas", 2016));
        libraryCollection.add(journalFactory.createItem("Machine Learning Advances", "Andrew Ng", 2024));
        libraryCollection.add(ebookFactory.createItem("Database Systems", "Ramakrishnan", 2020));
        libraryCollection.add(audiobookFactory.createItem("Code Complete", "Steve McConnell", 2004));
        
        System.out.println("Library Collection (" + libraryCollection.size() + " items):");
        for (DigitalItem item : libraryCollection) {
            System.out.println("  - " + item.getInfo());
        }
        System.out.println();
        System.out.println("=".repeat(70));
        System.out.println();
        
        // Membuat SearchContext
        SearchContext searchContext = new SearchContext();
        
        // Test 1: Search by Title
        System.out.println("--- Test 1: Search by Title Strategy ---");
        searchContext.setStrategy(new SearchByTitle());
        
        String titleQuery1 = "Code";
        List<DigitalItem> results1 = searchContext.executeSearch(libraryCollection, titleQuery1);
        System.out.println("Search query: \"" + titleQuery1 + "\"");
        System.out.println("Results found: " + results1.size());
        for (DigitalItem item : results1) {
            System.out.println("  ✓ " + item.getInfo());
        }
        System.out.println();

        // Test 2: Search by Author
        System.out.println("--- Test 2: Search by Author Strategy ---");
        searchContext.setStrategy(new SearchByAuthor());
        
        String authorQuery1 = "Martin";
        List<DigitalItem> results3 = searchContext.executeSearch(libraryCollection, authorQuery1);
        System.out.println("Search query: \"" + authorQuery1 + "\"");
        System.out.println("Results found: " + results3.size());
        for (DigitalItem item : results3) {
            System.out.println("  ✓ " + item.getInfo());
        }
        System.out.println();

        // Test 3: Search by Keyword
        System.out.println("--- Test 3: Search by Keyword Strategy ---");
        searchContext.setStrategy(new SearchByKeyword());
        
        String keywordQuery1 = "PDF";
        List<DigitalItem> results5 = searchContext.executeSearch(libraryCollection, keywordQuery1);
        System.out.println("Search query: \"" + keywordQuery1 + "\"");
        System.out.println("Results found: " + results5.size());
        for (DigitalItem item : results5) {
            System.out.println("  ✓ " + item.getInfo());
        }
        System.out.println();

        // Test 4: Runtime Strategy Switching
        System.out.println("--- Test 4: Runtime Strategy Switching ---");
        String query = "data";
        
        System.out.println("Searching for: \"" + query + "\" using different strategies:");
        System.out.println();
        
        searchContext.setStrategy(new SearchByTitle());
        List<DigitalItem> byTitle = searchContext.executeSearch(libraryCollection, query);
        System.out.println("  Results: " + byTitle.size() + " items");
        
        searchContext.setStrategy(new SearchByAuthor());
        List<DigitalItem> byAuthor = searchContext.executeSearch(libraryCollection, query);
        System.out.println("  Results: " + byAuthor.size() + " items");
        
        searchContext.setStrategy(new SearchByKeyword());
        List<DigitalItem> byKeyword = searchContext.executeSearch(libraryCollection, query);
        System.out.println("  Results: " + byKeyword.size() + " items");
        System.out.println();
    }
}
