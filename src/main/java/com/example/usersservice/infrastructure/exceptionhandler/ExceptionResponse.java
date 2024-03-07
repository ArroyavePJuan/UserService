package com.example.usersservice.infrastructure.exceptionhandler;

public enum ExceptionResponse {
    EXISTING_EMAIL("This email is already registered"),
    EXISTING_DOCUMENT("This document is already registered"),
    NON_EXISTENT_ROLE("This role does not exist"),
    USER_NOT_FOUNT("No user found with this id")
    ;

    private String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}