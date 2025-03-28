package com.library.management;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Search Book by Title");
            System.out.println("5. Update Book Details");
            System.out.println("6. Delete Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Availability (Available/Checked Out): ");
                    String availability = scanner.nextLine();

                    library.addBook(new Book(id, title, author, genre, availability));
                    break;

                case 2:
                    library.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to search: ");
                    int searchId = scanner.nextInt();
                    Book foundBook = library.searchBook(searchId);
                    System.out.println(foundBook != null ? foundBook : "Book not found.");
                    break;

                case 4:
                    System.out.print("Enter Book Title to search: ");
                    String searchTitle = scanner.nextLine();
                    Book foundBookByTitle = library.searchBook(searchTitle);
                    System.out.println(foundBookByTitle != null ? foundBookByTitle : "Book not found.");
                    break;

                case 5:
                    System.out.print("Enter Book ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter New Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter New Author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter New Genre: ");
                    String newGenre = scanner.nextLine();
                    System.out.print("Enter New Availability: ");
                    String newAvailability = scanner.nextLine();

                    if (!library.updateBook(updateId, newTitle, newAuthor, newGenre, newAvailability)) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter Book ID to delete: ");
                    int deleteId = scanner.nextInt();
                    if (!library.deleteBook(deleteId)) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
