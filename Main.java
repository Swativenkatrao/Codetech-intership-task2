package com.codetech.task33.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        library.loadItems(); // Load items from file

        while (true) {
            System.out.println("Welcome to the Library Management System");
            System.out.println("1. Login as Librarian");
            System.out.println("2. Login as Patron");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int role = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (role == 1) {
                Librarian librarian = new Librarian(scanner, library);
                librarian.performTasks();
            } else if (role == 2) {
                Patron patron = new Patron(scanner, library);
                patron.performTasks();
            } else if (role == 3) {
                library.saveItems(); // Save items to file
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}

