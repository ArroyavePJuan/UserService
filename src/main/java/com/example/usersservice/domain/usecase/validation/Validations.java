package com.example.usersservice.domain.usecase.validation;

import com.example.usersservice.domain.model.User;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {

    private Validations() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean emptyFields(User user){
        return user.getBirthdate()==null || empty(user.getEmail())
                || empty(user.getPassword())
                || empty(user.getUserLastName()) || empty(user.getName())
                || user.getDocumentNumber()==null || empty(user.getPhone()) || empty(user.getDocumentNumber());

    }
    private static boolean empty(String string){
        return string == null || string.isEmpty() || string.isBlank();
    }
    public static boolean younger(LocalDate birthday){
        LocalDate now = LocalDate.now();
        Period period = Period.between(birthday,now);
        return period.getYears()<18;
    }
    public static boolean correctAge(LocalDate birthday){
        LocalDate now = LocalDate.now();
        Period period = Period.between(birthday,now);
        return period.getYears()>100 || period.getYears()<0;
    }
    public static boolean cellSize(String cell){
        return cell.length()>13;
    }
    private static final String PHONE_REGEX = "^\\+?\\d{1,12}$";
    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);
    public static boolean cellStructure(String cell){
        Matcher matcher = PHONE_PATTERN.matcher(cell);
        return !matcher.matches();
    }
    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    public static boolean emailStructure(String email){
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return !matcher.matches();
    }
    public static boolean validateDocument(String document){
        return !document.matches("\\d+");
    }

}
