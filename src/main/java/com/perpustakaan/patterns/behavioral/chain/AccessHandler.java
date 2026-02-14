package com.perpustakaan.patterns.behavioral.chain;

import com.perpustakaan.domain.DigitalItem;
import com.perpustakaan.domain.User;

public abstract class AccessHandler {
    protected AccessHandler nextHandler;

    public AccessHandler setNext(AccessHandler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public abstract boolean checkAccess(User user, DigitalItem item);

    protected boolean checkNext(User user, DigitalItem item) {
        if (nextHandler == null) {
            return true;
        }
        return nextHandler.checkAccess(user, item);
    }
}
