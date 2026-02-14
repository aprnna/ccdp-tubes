package com.perpustakaan.patterns.behavioral.command;

import com.perpustakaan.domain.DigitalItem;
import com.perpustakaan.domain.User;

public class BorrowCommand implements Command {

    private LibraryTransactionService service;
    private User user;
    private DigitalItem item;

    public BorrowCommand(LibraryTransactionService service,
                         User user,
                         DigitalItem item) {
        this.service = service;
        this.user = user;
        this.item = item;
    }

    @Override
    public void execute() {
        service.borrow(user, item);
    }

    @Override
    public void undo() {
        service.returnItem(user, item);
    }
}
