package com.perpustakaan.patterns.creational.abstractfactory;

import com.perpustakaan.domain.DigitalItem;
import com.perpustakaan.domain.AudioBook;

/**
 * Concrete Factory untuk membuat AudioBook.
 * Factory ini menghasilkan objek AudioBook dengan durasi dan narrator default.
 */
public class AudioBookFactory implements DigitalItemFactory {
    private int defaultDurationMinutes;
    private String defaultNarrator;

    public AudioBookFactory() {
        this.defaultDurationMinutes = 180; // 3 jam
        this.defaultNarrator = "Professional Narrator";
    }

    public AudioBookFactory(int defaultDurationMinutes, String defaultNarrator) {
        this.defaultDurationMinutes = defaultDurationMinutes;
        this.defaultNarrator = defaultNarrator;
    }

    @Override
    public DigitalItem createItem(String title, String author, int year) {
        return new AudioBook(title, author, year, defaultDurationMinutes, defaultNarrator);
    }

}
