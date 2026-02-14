package com.perpustakaan.patterns.behavioral.command;

import java.time.LocalDate;

public class LoanRecord {

    private String title;
    private String borrower;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    public LoanRecord(String title,
                      String borrower,
                      LocalDate borrowDate,
                      LocalDate dueDate) {
        this.title = title;
        this.borrower = borrower;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return title + " | Borrower: " + borrower +
                " | Due: " + dueDate;
    }
}
