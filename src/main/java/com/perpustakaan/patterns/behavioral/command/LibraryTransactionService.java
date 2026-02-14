package com.perpustakaan.patterns.behavioral.command;

import com.perpustakaan.domain.DigitalItem;
import com.perpustakaan.domain.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class LibraryTransactionService {

    private static final int MAX_BORROW_LIMIT = 3;

    private Map<String, LoanRecord> activeLoans = new HashMap<>();
    private Map<String, Integer> userBorrowCount = new HashMap<>();

    public void borrow(User user, DigitalItem item) {

        // 1️⃣ Login validation
        if (!user.isLoggedIn()) {
            System.out.println("FAILED: User not logged in.");
            return;
        }

        // 2️⃣ Subscription validation
        if (!user.hasActiveSubscription()) {
            System.out.println("FAILED: No active subscription.");
            return;
        }

        // 3️⃣ Item already borrowed check
        if (activeLoans.containsKey(item.getTitle())) {
            System.out.println("FAILED: Item already borrowed.");
            return;
        }

        int current = userBorrowCount.getOrDefault(user.getUsername(), 0);

        // 4️⃣ Borrow limit check
        if (current >= MAX_BORROW_LIMIT) {
            System.out.println("FAILED: Borrow limit reached.");
            return;
        }

        LoanRecord record = new LoanRecord(
                item.getTitle(),
                user.getUsername(),
                LocalDate.now(),
                LocalDate.now().plusDays(7)
        );

        activeLoans.put(item.getTitle(), record);
        userBorrowCount.put(user.getUsername(), current + 1);

        System.out.println("SUCCESS: " + user.getUsername()
                + " borrowed " + item.getTitle());
        System.out.println("Due Date: " + record.getDueDate());
    }

    public void returnItem(User user, DigitalItem item) {

        if (!activeLoans.containsKey(item.getTitle())) {
            System.out.println("FAILED: Item not borrowed.");
            return;
        }

        activeLoans.remove(item.getTitle());

        int current = userBorrowCount.getOrDefault(user.getUsername(), 0);
        userBorrowCount.put(user.getUsername(), Math.max(0, current - 1));

        System.out.println("SUCCESS: " + user.getUsername()
                + " returned " + item.getTitle());
    }

    public void printActiveLoans() {
        System.out.println("\n=== ACTIVE LOANS ===");
        activeLoans.values().forEach(System.out::println);
    }
}
