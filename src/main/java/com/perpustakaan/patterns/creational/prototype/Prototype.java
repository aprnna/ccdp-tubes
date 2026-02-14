package com.perpustakaan.patterns.creational.prototype;

import com.perpustakaan.domain.DigitalItem;

/**
 * Prototype Pattern (GOF - Creational)
 * Interface dasar untuk proses cloning DigitalItem.
 * Digunakan untuk membuat salinan objek tanpa bergantung pada class konkret.
 */
public interface Prototype {
    DigitalItem cloneItem();
}
