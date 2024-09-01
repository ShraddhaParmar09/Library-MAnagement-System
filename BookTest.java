package com.example.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BookTest {

    @Test
    void testBookCreation() {
        Book book = new Book("1234567890", "Title", "Author", 2023);

        assertEquals("1234567890", book.getIsbn());
        assertEquals("Title", book.getTitle());
        assertEquals("Author", book.getAuthor());
        assertEquals(2023, book.getPublicationYear());
        assertTrue(book.isAvailable(), "Book should be available upon creation");
    }

    @Test
    void testSetAvailable() {
        Book book = new Book("1234567890", "Title", "Author", 2023);

        // Initially available
        assertTrue(book.isAvailable());

        // Set the book to unavailable
        book.setAvailable(false);
        assertFalse(book.isAvailable(), "Book should be unavailable after setting it to false");

        // Set the book back to available
        book.setAvailable(true);
        assertTrue(book.isAvailable(), "Book should be available after setting it to true");
    }

    @Test
    void testGetters() {
        Book book = new Book("1234567890", "Title", "Author", 2023);

        assertEquals("1234567890", book.getIsbn());
        assertEquals("Title", book.getTitle());
        assertEquals("Author", book.getAuthor());
        assertEquals(2023, book.getPublicationYear());
    }
}
