package com.perpustakaan.patterns.behavioral.observer;

import com.perpustakaan.domain.DigitalItem;
/**
 * Concrete Observer - User.
 * Mewakili pengguna sistem yang menerima notifikasi buku baru.
 */
public class User implements Observer {

    private String name;

    public User(String name){
        this.name = name;
    }

    @Override
    public void update(DigitalItem item){
        System.out.println(name + " menerima notifikasi: " + item.getInfo());
    }
}
