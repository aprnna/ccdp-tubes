package com.perpustakaan.patterns.structural.proxy;

import com.perpustakaan.domain.DigitalItem;
import com.perpustakaan.domain.User;

import java.util.HashMap;
import java.util.Map;

public class SecureContentProxy implements ContentService {

    private static Map<String, RealContentService> cache = new HashMap<>();

    private DigitalItem item;
    private User user;

    public SecureContentProxy(DigitalItem item, User user) {
        this.item = item;
        this.user = user;
    }

    @Override
    public void accessContent() {

        System.out.println("\nUser: " + user.getUsername()
                + " attempting to access: " + item.getTitle());

        if (!user.isLoggedIn()) {
            System.out.println("ACCESS DENIED: User not logged in.");
            return;
        }

        if (!user.hasActiveSubscription()) {
            System.out.println("ACCESS DENIED: No active subscription.");
            return;
        }

        if (user.getAge() < 17) {
            System.out.println("ACCESS DENIED: Age restriction (17+ required).");
            return;
        }

        if (!LoanRegistry.hasAccess(user.getUsername(), item.getTitle())) {
            System.out.println("ACCESS DENIED: Item not actively borrowed.");
            return;
        }

        RealContentService realService = cache.get(item.getTitle());

        if (realService == null) {
            realService = new RealContentService(item);
            cache.put(item.getTitle(), realService);
        } else {
            System.out.println("Content loaded from cache.");
        }

        realService.accessContent();
    }
}
