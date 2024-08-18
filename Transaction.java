package com.codetech.task33.main;

public class Transaction {
    private String itemId;
    private String userId;
    private String type; // CHECKOUT or RETURN

    public Transaction(String itemId, String userId, String type) {
        this.itemId = itemId;
        this.userId = userId;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction [Item ID: " + itemId + ", User ID: " + userId + ", Type: " + type + "]";
    }
}

