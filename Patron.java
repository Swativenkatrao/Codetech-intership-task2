package com.codetech.task33.main;

import java.util.Scanner;

public class Patron extends User {
    public Patron(Scanner scanner, Library library) {
        super(scanner, library);
    }

    @Override
    public void performTasks() {
        while (true) {
            System.out.println("Patron Menu");
            System.out.println("1. Search for Items");
            System.out.println("2. Checkout Item");
            System.out.println("3. Return Item");
            System.out.println("4. View Fines");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    searchItems();
                    break;
                case 2:
                    checkoutItem();
                    break;
                case 3:
                    returnItem();
                    break;
                case 4:
                    viewFines();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void searchItems() {
        System.out.print("Enter title (or leave blank): ");
        String title = scanner.nextLine();
        System.out.print("Enter author (or leave blank): ");
        String author = scanner.nextLine();
        System.out.print("Enter category (or leave blank): ");
        String category = scanner.nextLine();
        for (Item item : library.searchItems(title, author, category)) {
            System.out.println(item);
        }
    }

    private void checkoutItem() {
        System.out.print("Enter item ID to checkout: ");
        String itemId = scanner.nextLine();
        System.out.print("Enter your user ID: ");
        String userId = scanner.nextLine();
        library.checkoutItem(itemId, userId);
    }

    private void returnItem() {
        System.out.print("Enter item ID to return: ");
        String itemId = scanner.nextLine();
        System.out.print("Enter your user ID: ");
        String userId = scanner.nextLine();
        library.returnItem(itemId, userId);
    }

    private void viewFines() {
        System.out.print("Enter item ID to view fines: ");
        String itemId = scanner.nextLine();
        double fines = library.calculateFines(itemId);
        System.out.println("Fines for item " + itemId + ": $" + fines);
    }
}

