package com.perpustakaan.patterns.creational.prototype;

import com.perpustakaan.domain.AudioBook;
import com.perpustakaan.domain.DigitalItem;

/**
 * Concrete Prototype - AudioBook.
 * Menghasilkan salinan AudioBook dengan menyalin atribut durasi
 * dan narrator sebagai bagian dari state objek.
 */
public class AudioBookPrototype implements Prototype {

    private final AudioBook audio;

    public AudioBookPrototype(AudioBook audio){
        this.audio = audio;
    }

    @Override
    public DigitalItem cloneItem(){
        return new AudioBook(
                audio.getTitle(),
                audio.getAuthor(),
                audio.getYear(),
                audio.getDurationMinutes(),
                audio.getNarrator()
        );
    }
}
