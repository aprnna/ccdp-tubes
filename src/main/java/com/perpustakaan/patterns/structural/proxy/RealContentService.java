package com.perpustakaan.patterns.structural.proxy;

import com.perpustakaan.domain.DigitalItem;

public class RealContentService implements ContentService {

    private DigitalItem item;

    public RealContentService(DigitalItem item) {
        this.item = item;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("Loading digital content from secure server for: "
                + item.getTitle());
    }

    @Override
    public void accessContent() {
        System.out.println("Accessing full content of: "
                + item.getTitle());
    }
}
