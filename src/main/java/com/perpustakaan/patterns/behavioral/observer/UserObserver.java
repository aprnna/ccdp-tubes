package com.perpustakaan.patterns.behavioral.observer;

import com.perpustakaan.domain.DigitalItem;
/**
 * Concrete Observer - User.
 * Mewakili pengguna sistem yang menerima notifikasi buku baru.
 */
public class UserObserver implements Observer {

    private String name;

    public UserObserver(String name){
        this.name = name;
    }

    @Override
    public void update(DigitalItem item){
        System.out.println(name + " menerima notifikasi: " + item.getInfo());
    }
}
