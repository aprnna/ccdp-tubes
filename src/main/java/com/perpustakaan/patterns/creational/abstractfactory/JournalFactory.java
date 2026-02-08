package com.perpustakaan.patterns.creational.abstractfactory;

import com.perpustakaan.domain.DigitalItem;
import com.perpustakaan.domain.Journal;

/**
 * Concrete Factory untuk membuat Journal.
 * Factory ini menghasilkan objek Journal dengan volume, issue, dan publisher default.
 */
public class JournalFactory implements DigitalItemFactory {
    private int defaultVolume;
    private int defaultIssue;
    private String defaultPublisher;

    public JournalFactory() {
        this.defaultVolume = 1;
        this.defaultIssue = 1;
        this.defaultPublisher = "Academic Publisher";
    }

    public JournalFactory(int defaultVolume, int defaultIssue, String defaultPublisher) {
        this.defaultVolume = defaultVolume;
        this.defaultIssue = defaultIssue;
        this.defaultPublisher = defaultPublisher;
    }

    @Override
    public DigitalItem createItem(String title, String author, int year) {
        return new Journal(title, author, year, defaultVolume, defaultIssue, defaultPublisher);
    }

    /**
     * Overloaded method untuk membuat Journal dengan parameter lengkap
     */
    public DigitalItem createItem(String title, String author, int year, 
                                  int volume, int issue, String publisher) {
        return new Journal(title, author, year, volume, issue, publisher);
    }
}
