package com.example.usersservice.application.exceptionhandler;

public enum ExceptionResponseApplication {

    INVALID_MAIL("This email is not valid"),
    EMPTY_FIELDS("You must fill in all the fields"),
    INVALID_DOCUMENT("The document should only have numbers"),
    INVALID_PHONE("The cell structure is wrong"),
    WRONG_CELL_SIZE("The maximum size of the number is 13"),
    YOUNGER("The owner must be of legal age"),
    INVALID_OLD("Enter a realistic age");
    ;

    private String message;

    ExceptionResponseApplication(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
