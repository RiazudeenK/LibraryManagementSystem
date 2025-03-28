package com.library.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // Add a Book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    // View All Books
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // Search Book by ID or Title
    public Book searchBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Update Book Details
    public boolean updateBook(int bookId, String newTitle, String newAuthor, String newGenre, String newAvailability) {
        Book book = searchBook(bookId);
        if (book != null) {
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            book.setGenre(newGenre);
            book.setAvailability(newAvailability);
            System.out.println("Book updated successfully!");
            return true;
        }
        return false;
    }

    // Delete a Book
    public boolean deleteBook(int bookId) {
        Book book = searchBook(bookId);
        if (book != null) {
            books.remove(book);
            System.out.println("Book deleted successfully!");
            return true;
        }
        return false;
    }
}
