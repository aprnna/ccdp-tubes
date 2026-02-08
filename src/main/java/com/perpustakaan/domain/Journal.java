package com.perpustakaan.domain;

/**
 * Journal - implementasi DigitalItem untuk jurnal akademik.
 * Memiliki atribut khusus: volume, issue, dan publisher.
 */
public class Journal implements DigitalItem {
    private String title;
    private String author;
    private int year;
    private int volume;
    private int issue;
    private String publisher;

    public Journal(String title, String author, int year, int volume, int issue, String publisher) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.volume = volume;
        this.issue = issue;
        this.publisher = publisher;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public String getItemType() {
        return "Journal";
    }

    public int getVolume() {
        return volume;
    }

    public int getIssue() {
        return issue;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public String getInfo() {
        return String.format("Journal: '%s' by %s (%d) | Vol. %d, Issue %d | Publisher: %s",
                title, author, year, volume, issue, publisher);
    }
}
