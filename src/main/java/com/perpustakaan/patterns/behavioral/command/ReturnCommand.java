package com.perpustakaan.patterns.behavioral.command;

import com.perpustakaan.domain.DigitalItem;
import com.perpustakaan.domain.User;

public class ReturnCommand implements Command {

    private LibraryTransactionService service;
    private User user;
    private DigitalItem item;

    public ReturnCommand(LibraryTransactionService service,
                         User user,
                         DigitalItem item) {
        this.service = service;
        this.user = user;
        this.item = item;
    }

    @Override
    public void execute() {
        service.returnItem(user, item);
    }

    @Override
    public void undo() {
        service.borrow(user, item);
    }
}
