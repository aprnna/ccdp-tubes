package com.perpustakaan.patterns.structural.proxy;

import java.util.HashSet;
import java.util.Set;

public class LoanRegistry {

    private static Set<String> activeLoans = new HashSet<>();

    public static void registerLoan(String username, String title) {
        activeLoans.add(username + "-" + title);
    }

    public static boolean hasAccess(String username, String title) {
        return activeLoans.contains(username + "-" + title);
    }
}
