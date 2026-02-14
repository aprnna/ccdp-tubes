package com.perpustakaan.patterns.behavioral.observer;

import com.perpustakaan.domain.DigitalItem;
/**
 * Observer Interface (GOF - Behavioral).
 * Mendefinisikan kontrak untuk objek yang menerima notifikasi.
 */
public interface Observer {
    void update(DigitalItem item);
}
