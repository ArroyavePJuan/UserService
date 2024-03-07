package com.example.usersservice.infrastructure.exceptionhandler;

import com.example.usersservice.infrastructure.exception.DocumentAlreadyRegistered;
import com.example.usersservice.infrastructure.exception.RegisteredMail;
import com.example.usersservice.infrastructure.exception.RoleDoesNotExist;
import com.example.usersservice.infrastructure.exception.UserNotFount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {
    private static final String MESSAGE = "Message";

    @ExceptionHandler(RoleDoesNotExist.class)
    public ResponseEntity<Map<String, String>> roleDoesNotExist(
            RoleDoesNotExist roleDoesNotExist) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NON_EXISTENT_ROLE.getMessage()));
    }
    @ExceptionHandler(RegisteredMail.class)
    public ResponseEntity<Map<String, String>> registaredMail(
            RegisteredMail registaredMail) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.EXISTING_EMAIL.getMessage()));
    }
    @ExceptionHandler(DocumentAlreadyRegistered.class)
    public ResponseEntity<Map<String, String>> documentAlreadyRegistered(
            DocumentAlreadyRegistered documentAlreadyRegistered) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.EXISTING_DOCUMENT.getMessage()));
    }
    @ExceptionHandler(UserNotFount.class)
    public ResponseEntity<Map<String, String>> userNotFount(
            UserNotFount userNotFount) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.USER_NOT_FOUNT.getMessage()));
    }

}
