package com.perpustakaan.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

import com.perpustakaan.domain.DigitalItem;

/**
 * Concrete Subject - LibraryCatalog.
 * Mengelola koleksi DigitalItem dan mengirimkan notifikasi
 * kepada observer ketika terdapat buku baru.
 */
public class LibraryCatalog implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private DigitalItem latestBook;

    @Override
    public void addObserver(Observer o){
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o){
        observers.remove(o);
    }

    @Override
    public void notifyObservers(DigitalItem item){
        for(Observer o : observers){
            o.update(item);
        }
    }

    public void addNewBook(DigitalItem item){
        this.latestBook = item;
        notifyObservers(item);
    }
}
