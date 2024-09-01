package com.example.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private Library library;

    @BeforeEach
    public void setup() {
        library = new Library();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("12345", "Test Book", "Author", 2020);
        library.addBook(book);
        List<Book> availableBooks = library.viewAvailableBooks();
        assertEquals(1, availableBooks.size());
        assertEquals("Test Book", availableBooks.get(0).getTitle());
    }

    @Test
    public void testBorrowBook() throws Exception {
        Book book = new Book("12345", "Test Book", "Author", 2020);
        library.addBook(book);
        library.borrowBook("12345");

        List<Book> availableBooks = library.viewAvailableBooks();
        assertEquals(0, availableBooks.size());
    }

    @Test
    public void testBorrowBook_NotAvailable() {
        Book book = new Book("12345", "Test Book", "Author", 2020);
        library.addBook(book);

        assertThrows(Exception.class, () -> {
            library.borrowBook("12345");
            library.borrowBook("12345");
        });
    }

    @Test
    public void testReturnBook() throws Exception {
        Book book = new Book("12345", "Test Book", "Author", 2020);
        library.addBook(book);
        library.borrowBook("12345");
        library.returnBook("12345");

        List<Book> availableBooks = library.viewAvailableBooks();
        assertEquals(1, availableBooks.size());
        assertTrue(availableBooks.get(0).isAvailable());
    }

    @Test
    public void testReturnBook_NotBorrowed() {
        Book book = new Book("12345", "Test Book", "Author", 2020);
        library.addBook(book);

        assertThrows(Exception.class, () -> library.returnBook("12345"));
    }

    @Test
    public void testViewAvailableBooks() {
        Book book1 = new Book("12345", "Test Book 1", "Author", 2020);
        Book book2 = new Book("67890", "Test Book 2", "Author", 2021);
        library.addBook(book1);
        library.addBook(book2);

        List<Book> availableBooks = library.viewAvailableBooks();
        assertEquals(2, availableBooks.size());
    }
}
