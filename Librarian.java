package com.codetech.task33.main;

import java.util.Scanner;

public class Librarian extends User {
    public Librarian(Scanner scanner, Library library) {
        super(scanner, library);
    }

    @Override
    public void performTasks() {
        while (true) {
            System.out.println("Librarian Menu");
            System.out.println("1. Add New Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Search for Items");
            System.out.println("4. View Transaction History");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNewItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    searchItems();
                    break;
                case 4:
                    viewTransactionHistory();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addNewItem() {
        System.out.print("Enter item type (book/magazine/dvd): ");
        String type = scanner.nextLine();
        System.out.print("Enter item ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        Item item;
        switch (type.toLowerCase()) {
            case "book":
                item = new Book(id, title, author, category);
                break;
            case "magazine":
                item = new Magazine(id, title, author, category);
                break;
            case "dvd":
                item = new DVD(id, title, author, category);
                break;
            default:
                System.out.println("Invalid item type.");
                return;
        }
        library.addItem(item);
        System.out.println("Item added successfully.");
    }

    private void removeItem() {
        System.out.print("Enter item ID to remove: ");
        String itemId = scanner.nextLine();
        library.removeItem(itemId);
        System.out.println("Item removed successfully.");
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

    private void viewTransactionHistory() {
        // View transaction history implementation (not shown)
    }
}

