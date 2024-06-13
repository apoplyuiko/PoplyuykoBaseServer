package com.example.Poplyuiko_base_server.handling;

public class ToDoNotFoundException extends RuntimeException {
    public ToDoNotFoundException() {
        super("ToDo not found");
    }

    public ToDoNotFoundException(String message) {
        super(message);
    }

    public ToDoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
