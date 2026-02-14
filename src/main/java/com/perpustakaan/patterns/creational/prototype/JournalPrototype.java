package com.perpustakaan.patterns.creational.prototype;

import com.perpustakaan.domain.DigitalItem;
import com.perpustakaan.domain.Journal;

/**
 * Concrete Prototype - Journal.
 * Bertanggung jawab untuk membuat salinan objek Journal
 * dengan mempertahankan seluruh atribut seperti volume, issue, dan publisher.
 */
public class JournalPrototype implements Prototype {

    private final Journal journal;

    public JournalPrototype(Journal journal){
        this.journal = journal;
    }

    @Override
    public DigitalItem cloneItem(){
        return new Journal(
                journal.getTitle(),
                journal.getAuthor(),
                journal.getYear(),
                journal.getVolume(),
                journal.getIssue(),
                journal.getPublisher()
        );
    }
}
