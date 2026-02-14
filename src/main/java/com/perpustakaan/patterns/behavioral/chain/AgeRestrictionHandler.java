package com.perpustakaan.patterns.behavioral.chain;

import com.perpustakaan.domain.DigitalItem;
import com.perpustakaan.domain.User;

public class AgeRestrictionHandler extends AccessHandler {
    @Override
    public boolean checkAccess(User user, DigitalItem item) {
        // Simulasi logika: Buku "Journal" butuh usia 18+
        if (item.getItemType().equalsIgnoreCase("Journal") && user.getAge() < 18) {
            System.out.println("ACCESS DENIED: Konten dibatasi untuk usia 18+.");
            return false;
        }
        System.out.println("Content OK: Usia memenuhi syarat.");
        return checkNext(user, item);
    }
}