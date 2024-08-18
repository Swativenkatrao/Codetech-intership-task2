package com.codetech.task33.main;

import java.util.Scanner;

public abstract class User {
    protected Scanner scanner;
    protected Library library;

    public User(Scanner scanner, Library library) {
        this.scanner = scanner;
        this.library = library;
    }

    public abstract void performTasks();
}

