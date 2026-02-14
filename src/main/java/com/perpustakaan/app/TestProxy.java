package com.perpustakaan.app;

import com.perpustakaan.domain.*;
import com.perpustakaan.patterns.structural.proxy.*;

public class TestProxy {

    public static void main(String[] args) {

        System.out.println("=".repeat(70));
        System.out.println("TESTING PROXY PATTERN");
        System.out.println("Domain: DIGITAL CONTENT ACCESS SYSTEM");
        System.out.println("=".repeat(70));

        DigitalItem ebook = new EBook(
                "Clean Code", "Robert", 2008, "PDF", 4.2);

        User validUser = new User("Andi", true, true, 21);
        User noSubscription = new User("Budi", true, false, 25);
        User underAge = new User("Cici", true, true, 15);
        User notLoggedIn = new User("Doni", false, true, 22);

        // Simulasi bahwa Andi sudah meminjam Clean Code
        LoanRegistry.registerLoan("Andi", "Clean Code");

        System.out.println("\n--- Not Logged In Attempt ---");
        new SecureContentProxy(ebook, notLoggedIn).accessContent();

        System.out.println("\n--- No Subscription Attempt ---");
        new SecureContentProxy(ebook, noSubscription).accessContent();

        System.out.println("\n--- Under Age Attempt ---");
        new SecureContentProxy(ebook, underAge).accessContent();

        System.out.println("\n--- Valid User First Access ---");
        new SecureContentProxy(ebook, validUser).accessContent();

        System.out.println("\n--- Valid User Second Access (Cache Expected) ---");
        new SecureContentProxy(ebook, validUser).accessContent();
    }
}
