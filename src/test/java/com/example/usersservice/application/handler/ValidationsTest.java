package com.example.usersservice.application.handler;

import com.example.usersservice.domain.model.User;
import com.example.usersservice.domain.usecase.validation.Validations;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ValidationsTest {

    @Test
    void testEmptyFieldsWithEmptyUserRequest() {
        User user = new User();
        assertTrue(Validations.emptyFields(user));
    }
    @ParameterizedTest
    @CsvSource({
            "2005-02-18, mail, password, lastName, name, document, 11111, false",
            ", mail, password, lastName, name, document, 11111, true",
            "2005-02-18, , password, lastName, name, document, 11111, true",
            "2005-02-18, mail, , lastName, name, document, 11111, true",
            "2005-02-18, mail, password, , name, document, 11111, true",
            "2005-02-18, mail, password, lastName, , document, 11111, true",
            "2005-02-18, mail, password, lastName, name, , 11111, true",
            "2005-02-18, mail, password, lastName, name, document, , true"
    })
    void testEmptyFields(LocalDate birtdate, String mail, String pasword, String lastName, String name, String document, String phone, boolean result){
        User user = new User();
        user.setBirthdate(birtdate);
        user.setEmail(mail);
        user.setPassword(pasword);
        user.setUserLastName(lastName);
        user.setName(name);
        user.setDocumentNumber(document);
        user.setPhone(phone);

        assertEquals(result, Validations.emptyFields(user));
    }
    @ParameterizedTest
    @CsvSource({
        "1990, 1, 1, false",
        "2005, 02, 18, false",
        "2005, 9, 1, false",
        "2005, 9, 2, true",
        "2010, 1, 1, true",
        "2027, 10, 3, true",
    })
    void testYearsOld(int year, int month, int day, boolean result){
        LocalDate birthday = LocalDate.of(year, month, day);
        assertEquals(result, Validations.younger(birthday));
    }

    @ParameterizedTest
    @CsvSource({
            "1990, 1, 1, false",
            "1200, 1, 1, true"
    })
    void testCorrectAge(int year, int month, int day, boolean result) {
        LocalDate birthday = LocalDate.of(year, month, day);
        assertEquals(result, Validations.correctAge(birthday));

    }

    @ParameterizedTest
    @CsvSource({
            "132512313, false",
            "13251231123123123, true"
    })
    void testCellSize(String phone, boolean result) {
        assertEquals(result ,Validations.cellSize(phone));
    }

    @ParameterizedTest
    @CsvSource({
            "+1234567890,false",
            "+123f123313vsdfs,true",
            "+ñaoñao,true"
    })
    void testCellStructure(String phone, boolean result) {
        assertEquals(result, Validations.cellStructure(phone));
    }
    @ParameterizedTest
    @CsvSource({
            "test@example.com,false",
            "invalid@a,true",
            "invalid,true",
    })
    void testEmailStructureWithValidEmail(String mail, boolean result) {
        assertEquals(result,Validations.emailStructure(mail));
    }
    @ParameterizedTest
    @CsvSource({
            "1111as111, true",
            "111111, false"
    })
    void testDocumentNumbersWithLetters(String phone, boolean result){ assertEquals(result,Validations.validateDocument(phone));}
}