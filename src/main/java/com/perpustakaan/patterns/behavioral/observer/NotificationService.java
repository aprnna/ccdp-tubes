package com.perpustakaan.patterns.behavioral.observer;

import com.perpustakaan.domain.DigitalItem;
/**
 * Concrete Observer - NotificationService.
 * Mensimulasikan layanan pengiriman email atau sistem notifikasi.
 */
public class NotificationService implements Observer {

    @Override
    public void update(DigitalItem item){
        System.out.println("Email terkirim: " + item.getInfo());
    }
}
