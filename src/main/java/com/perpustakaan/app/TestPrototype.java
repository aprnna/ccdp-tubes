package com.perpustakaan.app;

import com.perpustakaan.domain.AudioBook;
import com.perpustakaan.domain.DigitalItem;
import com.perpustakaan.domain.EBook;
import com.perpustakaan.domain.Journal;
import com.perpustakaan.patterns.creational.prototype.AudioBookPrototype;
import com.perpustakaan.patterns.creational.prototype.EBookPrototype;
import com.perpustakaan.patterns.creational.prototype.JournalPrototype;
import com.perpustakaan.patterns.creational.prototype.Prototype;

/**
 * TestPrototype - Menguji Prototype Pattern.
 * Memastikan proses cloning berjalan pada semua jenis DigitalItem.
 */
public class TestPrototype {

    public static void main(String[] args){

        System.out.println("=== TEST PROTOTYPE ===");

        EBook ebook = new EBook("Clean Code","Robert Martin",2020,"PDF",5.4);
        Journal journal = new Journal("AI Journal","Andrew Ng",2023,10,2,"Springer");
        AudioBook audio = new AudioBook("Java Basics","James Gosling",2019,120,"John Narrator");

        Prototype ebookProto = new EBookPrototype(ebook);
        Prototype journalProto = new JournalPrototype(journal);
        Prototype audioProto = new AudioBookPrototype(audio);

        DigitalItem ebookClone = ebookProto.cloneItem();
        DigitalItem journalClone = journalProto.cloneItem();
        DigitalItem audioClone = audioProto.cloneItem();

        System.out.println(ebookClone.getInfo());
        System.out.println(journalClone.getInfo());
        System.out.println(audioClone.getInfo());
    }
}
