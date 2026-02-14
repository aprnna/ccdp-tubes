package com.perpustakaan.patterns.behavioral.observer;

import com.perpustakaan.domain.DigitalItem;
/**
 * Subject Interface.
 * Mengatur proses registrasi dan pengiriman notifikasi
 * kepada seluruh observer yang terdaftar.
 */
public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(DigitalItem item);
}
