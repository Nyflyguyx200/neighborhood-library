package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    public static void main(String[] args) {
        //Create an array to hold the inventory of books
        Book[] inventory = createInventory();

        //Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        //Main loop for the library application
        while (true) {
            //Display the main menu
            System.out.println("\nWelcome to the Neighborhood Library!");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Check out Books");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    showAvailableBooks(inventory, scanner); //Show available books
                    break;
                case 2:
                    showCheckedOutBooks(inventory, scanner); //Show checked out books
                    break;
                case 3:
                    System.out.println("Exiting the Neighborhood Library. Thank you!"); //Exit the application
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    //Method to display available books
    public static void showAvailableBooks(Book[] inventory, Scanner scanner) {
        System.out.println("\nAvailable Books: ");
        boolean foundAvailableBooks = false;
        for (Book book : inventory) {
            if (book != null && !book.isCheckedOut()) {
                System.out.println(book);
                foundAvailableBooks = true;
            }
        }
        if (!foundAvailableBooks) {
            System.out.println("No available books.");
            return;
        }

        //Display options for available books
        System.out.println("\nOptions.");
        System.out.println("1. Check out a book");
        System.out.println("2. Go back to the home screen");
        System.out.print("Select an option: ");
        int option = scanner.nextInt();
        scanner.nextLine();






        switch (option) {
            case 1:
                checkedOutBook(inventory, scanner); //Show available books
                break;
            case 2:
                break;
            default:
                System.out.println("Invalid option. Going back to the home screen.");
        }
    }

    public static void showCheckedOutBooks(Book[] inventory, Scanner scanner) {
        System.out.println("\nChecked Out Books: ");
        boolean foundCheckedOutBooks = false;
        for (Book book : inventory) {
            if (book != null && !book.isCheckedOut()) {
                System.out.println(book);
                foundCheckedOutBooks = true;
            }
        }
        if (!foundCheckedOutBooks) {
            System.out.println("No books are currently checked out.");
            return;
        }

        System.out.println("\nOptions.");
        System.out.println("C - Check In a book");
        System.out.println("X - Go back to the home screen");
        System.out.print("Select an option: ");
        String option = scanner.nextLine().toUpperCase();



        switch (option) {
            case "C":
                checkInBook(inventory, scanner);
                break;
            case "X":
                break;
            default:
                System.out.println("Invalid option. Going back to the home screen.");
        }
    }

    public static void checkedOutBook(Book[] inventory, Scanner scanner) {
        System.out.print("Enter the ID of the book you want to check out: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        for (Book book : inventory) {
            if (book != null && book.getId() == bookId && !book.isCheckedOut()) {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                book.checkOut(name);
                System.out.println("Book checked out successfully!");
                return;
            }
        }
        System.out.println("Book not found or already checked out");
    }

    public static void checkInBook(Book[] inventory, Scanner scanner) {
        System.out.print("Enter the ID of the book you want to check in: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        for (Book book : inventory) {
            if (book != null && book.getId() == bookId && book.isCheckedOut()) {
                book.checkIn();
                System.out.println("Book checked in successfully!");
                return;
            }
        }
        System.out.println("Book not found or already checked out");
    }

    public static Book[] createInventory() {
        Book[] inventory = new Book[20];
        inventory[0] = new Book(1, "9780547928210", "The Hobbit");
        inventory[1] = new Book(2, "9780439139601", "Harry Potter and the Prisoner of Azkaban");
        inventory[2] = new Book(3, "9780140283334", "To Kill a Mockingbird");
        inventory[3] = new Book(4, "9780439139595", "The Fellowship of the Ring");
        inventory[4] = new Book(5, "9780060256654", "Where the Wild Things Are");
        inventory[5] = new Book(6, "9780451524935", "1984");
        inventory[6] = new Book(7, "9780141439587", "Pride and Bravery");
        inventory[7] = new Book(8, "9780743273565", "The Great Gatsby");
        inventory[8] = new Book(9, "9780316769488", "The Catcher in the Rye");
        inventory[9] = new Book(10, "9780590353427", "Harry Potter and the Sorcerer's Stone");
        inventory[10] = new Book(11, "9780316015844", "Twilight");
        inventory[11] = new Book(12, "9780439023480", "Harry Potter and the Chamber of Secrets");
        inventory[12] = new Book(13, "9780545582889", "The Two Towers");
        inventory[13] = new Book(14, "9780143125471", "The Book Thief");
        inventory[14] = new Book(15, "9780061120084", "Where the Sidewalk Ends");
        inventory[15] = new Book(16, "9780763622716", "All American");
        inventory[16] = new Book(17, "9780763648488", "The Lord of the Rings");
        inventory[17] = new Book(18, "9780142413845", "The Hunger Games");
        inventory[18] = new Book(19, "9780439023487", "Harry Potter and the Half-Blood Prince");
        inventory[19] = new Book(20, "9780439136360", "Harry Potter and the Deathly Hallows");

        return inventory;

    }
}