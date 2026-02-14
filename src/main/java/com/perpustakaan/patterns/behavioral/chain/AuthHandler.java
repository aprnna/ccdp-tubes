package com.perpustakaan.patterns.behavioral.chain;

import com.perpustakaan.domain.DigitalItem;
import com.perpustakaan.domain.User;

public class AuthHandler extends AccessHandler {
    @Override
    public boolean checkAccess(User user, DigitalItem item) {
        if (!user.isLoggedIn()) {
            System.out.println("Access denied: User " + user.getUsername() + " is not logged in.");
            return false;
        }
        System.out.println("AuthHandler: User " + user.getUsername() + " is logged in.");
        return checkNext(user, item);
    }
}
