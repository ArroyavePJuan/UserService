package com.example.usersservice.application.exceptionhandler;

import com.example.usersservice.application.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisorApplication {
    private static final String MESSAGE = "Message";

    @ExceptionHandler(InvalidEmail.class)
    public ResponseEntity<Map<String, String>> invalidEmail(
            InvalidEmail invalidEmail) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponseApplication.INVALID_MAIL.getMessage()));
    }
    @ExceptionHandler(DocumentWithLetters.class)
    public ResponseEntity<Map<String, String>> documentWithLetters(
            DocumentWithLetters documentWithLetters) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponseApplication.INVALID_DOCUMENT.getMessage()));
    }
    @ExceptionHandler(CellVeryLong.class)
    public ResponseEntity<Map<String, String>> cellVeryLong(
            CellVeryLong cellVeryLong) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponseApplication.WRONG_CELL_SIZE.getMessage()));
    }
    @ExceptionHandler(InvalidCell.class)
    public ResponseEntity<Map<String, String>> invalidCell(
            InvalidCell invalidCell) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponseApplication.INVALID_PHONE.getMessage()));
    }
    @ExceptionHandler(EmptyFields.class)
    public ResponseEntity<Map<String, String>> emptyFields(
            EmptyFields emptyFields) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponseApplication.EMPTY_FIELDS.getMessage()));
    }
    @ExceptionHandler(Younger.class)
    public ResponseEntity<Map<String, String>> younger(
            Younger younger) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponseApplication.YOUNGER.getMessage()));
    }
    @ExceptionHandler(InvalidAge.class)
    public ResponseEntity<Map<String, String>> invalidAge(
            InvalidAge invalidAge) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponseApplication.INVALID_OLD.getMessage()));
    }

}
