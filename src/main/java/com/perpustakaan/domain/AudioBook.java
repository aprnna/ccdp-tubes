package com.perpustakaan.domain;

/**
 * AudioBook - implementasi DigitalItem untuk buku audio.
 * Memiliki atribut khusus: durasi dan narrator.
 */
public class AudioBook implements DigitalItem {
    private String title;
    private String author;
    private int year;
    private int durationMinutes;
    private String narrator;

    public AudioBook(String title, String author, int year, int durationMinutes, String narrator) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.durationMinutes = durationMinutes;
        this.narrator = narrator;
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
        return "AudioBook";
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public String getNarrator() {
        return narrator;
    }

    @Override
    public String getInfo() {
        return String.format("AudioBook: '%s' by %s (%d) | Duration: %d mins | Narrator: %s",
                title, author, year, durationMinutes, narrator);
    }
}
