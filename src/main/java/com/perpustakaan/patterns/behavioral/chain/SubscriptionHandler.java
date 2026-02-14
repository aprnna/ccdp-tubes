package com.perpustakaan.patterns.behavioral.chain;

import com.perpustakaan.domain.DigitalItem;
import com.perpustakaan.domain.User;

public class SubscriptionHandler extends AccessHandler{
    @Override
    public boolean checkAccess(User user, DigitalItem item) {
        if (!user.hasActiveSubscription()) {
            System.out.println("ACCESS DENIED: User " + user.getUsername() + " tidak memiliki langganan aktif.");
            return false;
        }
        System.out.println("Sub OK: Langganan aktif.");
        return checkNext(user, item);
    }
}
