package com.codetech.task33.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private List<Item> items = new ArrayList<>();
    private Map<String, Transaction> transactions = new HashMap<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(String itemId) {
        items.removeIf(item -> item.getId().equals(itemId));
    }

    public Item searchItemById(String itemId) {
        for (Item item : items) {
            if (item.getId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }

    public List<Item> searchItems(String title, String author, String category) {
        List<Item> results = new ArrayList<>();
        for (Item item : items) {
            if ((title == null || item.getTitle().contains(title)) &&
                (author == null || item.getAuthor().contains(author)) &&
                (category == null || item.getCategory().equals(category))) {
                results.add(item);
            }
        }
        return results;
    }

    public void checkoutItem(String itemId, String userId) {
        Item item = searchItemById(itemId);
        if (item != null && !item.isCheckedOut()) {
            item.setCheckedOut(true);
            transactions.put(itemId, new Transaction(itemId, userId, "CHECKOUT"));
        }
    }

    public void returnItem(String itemId, String userId) {
        Item item = searchItemById(itemId);
        if (item != null && item.isCheckedOut()) {
            item.setCheckedOut(false);
            transactions.put(itemId, new Transaction(itemId, userId, "RETURN"));
        }
    }

    public void loadItems() {
        // Load items from file (implementation not shown)
    }

    public void saveItems() {
        // Save items to file (implementation not shown)
    }

    public double calculateFines(String itemId) {
        // Calculate overdue fines based on transaction data (implementation not shown)
        return 0.0;
    }
}

