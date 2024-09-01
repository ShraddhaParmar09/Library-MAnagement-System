package com.example.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void borrowBook(String isbn) throws Exception {
        Optional<Book> book = findBookByIsbn(isbn);
        if (book.isPresent() && book.get().isAvailable()) {
            book.get().setAvailable(false);
        } else {
            throw new Exception("Book is not available or doesn't exist.");
        }
    }

    public void returnBook(String isbn) throws Exception {
        Optional<Book> book = findBookByIsbn(isbn);
        if (book.isPresent() && !book.get().isAvailable()) {
            book.get().setAvailable(true);
        } else {
            throw new Exception("Book is not borrowed or doesn't exist.");
        }
    }

    public List<Book> viewAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    private Optional<Book> findBookByIsbn(String isbn) {
        return books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst();
    }
}
