package com.perpustakaan.patterns.structural.decorator;

/**
 * Component Interface - Decorator Pattern (GOF - Structural).
 * Mendefinisikan perilaku dasar yang dapat diperluas oleh decorator.
 */
public interface ReadableItem {
    void readContent();
    String getDescription();
}
