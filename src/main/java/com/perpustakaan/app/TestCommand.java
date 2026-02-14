package com.perpustakaan.app;

import com.perpustakaan.domain.*;
import com.perpustakaan.patterns.behavioral.command.*;

public class TestCommand {

    public static void main(String[] args) {

        System.out.println("=".repeat(70));
        System.out.println("TESTING COMMAND PATTERN");
        System.out.println("Domain: DIGITAL LIBRARY TRANSACTION SYSTEM");
        System.out.println("=".repeat(70));
        System.out.println();

        DigitalItem book1 =
                new EBook("Clean Code","Robert",2008,"PDF",4.2);

        DigitalItem book2 =
                new EBook("Refactoring","Fowler",2018,"PDF",5.1);

        User validUser =
                new User("Andi", true, true, 21);

        User noSubscriptionUser =
                new User("Budi", true, false, 25);

        LibraryTransactionService service =
                new LibraryTransactionService();

        CommandInvoker invoker = new CommandInvoker();

        System.out.println("--- Valid User Borrow ---");
        invoker.executeCommand(
                new BorrowCommand(service, validUser, book1));

        invoker.executeCommand(
                new BorrowCommand(service, validUser, book2));

        System.out.println("\n--- No Subscription Attempt ---");
        invoker.executeCommand(
                new BorrowCommand(service, noSubscriptionUser, book1));

        System.out.println("\n--- Undo Last Transaction ---");
        invoker.undoLast();

        service.printActiveLoans();
    }
}
