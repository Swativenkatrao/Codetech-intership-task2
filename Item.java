package com.codetech.task33.main;

public abstract class Item {
    private String id;
    private String title;
    private String author;
    private String category;
    private boolean checkedOut;

    public Item(String id, String title, String author, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.checkedOut = false;
    }

    

	public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (Category: " + category + ")";
    }
}

