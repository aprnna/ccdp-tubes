package com.perpustakaan.patterns.creational.prototype;

import com.perpustakaan.domain.DigitalItem;
import com.perpustakaan.domain.EBook;

/**
 * Concrete Prototype - EBook.
 * Mengimplementasikan proses cloning khusus untuk objek EBook
 * dengan menyalin seluruh atribut domain seperti format dan ukuran file.
 */
public class EBookPrototype implements Prototype {

    private final EBook ebook;

    public EBookPrototype(EBook ebook){
        this.ebook = ebook;
    }

    @Override
    public DigitalItem cloneItem(){
        return new EBook(
                ebook.getTitle(),
                ebook.getAuthor(),
                ebook.getYear(),
                ebook.getFormat(),
                ebook.getFileSizeMB()
        );
    }
}
