package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import com.example.demo.utility.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.User;
import com.example.demo.dao.UserDAO;

@Service
public class AccountService {

    private static final String CHAR_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPERCASE = CHAR_LOWERCASE.toUpperCase();
    private static final String DIGIT = "0123456789";
    private static final String OTHER_PUNCTUATION = "!@#&()–[{}]:;',?/*";
    private static final String OTHER_SYMBOL = "~$^+=<>";
    private static final String OTHER_SPECIAL = OTHER_PUNCTUATION + OTHER_SYMBOL;
    private static final int PASSWORD_LENGTH = 20;

    private static final String PASSWORD_ALLOW =
            CHAR_LOWERCASE + CHAR_UPPERCASE + DIGIT + OTHER_SPECIAL;

    private static SecureRandom random = new SecureRandom();

    public static String generateStrongPassword() {

        StringBuilder result = new StringBuilder(PASSWORD_LENGTH);

        // at least 2 chars (lowercase)
        String strLowerCase = generateRandomString(CHAR_LOWERCASE, 2);
        System.out.format("%-20s: %s%n", "Chars (Lowercase)", strLowerCase);
        result.append(strLowerCase);

        // at least 2 chars (uppercase)
        String strUppercaseCase = generateRandomString(CHAR_UPPERCASE, 2);
        System.out.format("%-20s: %s%n", "Chars (Uppercase)", strUppercaseCase);
        result.append(strUppercaseCase);

        // at least 2 digits
        String strDigit = generateRandomString(DIGIT, 2);
        System.out.format("%-20s: %s%n", "Digits", strDigit);
        result.append(strDigit);

        // at least 2 special characters (punctuation + symbols)
        String strSpecialChar = generateRandomString(OTHER_SPECIAL, 2);
        System.out.format("%-20s: %s%n", "Special chars", strSpecialChar);
        result.append(strSpecialChar);

        // remaining, just random
        String strOther = generateRandomString(PASSWORD_ALLOW, PASSWORD_LENGTH - 8);
        System.out.format("%-20s: %s%n", "Others", strOther);
        result.append(strOther);

        String password = result.toString();
        // combine all
        System.out.format("%-20s: %s%n", "Password", password);
        // shuffle again
        System.out.format("%-20s: %s%n", "Final Password", shuffleString(password));
        System.out.format("%-20s: %s%n%n", "Password Length", password.length());

        return password;
    }

    private static String generateRandomString(String input, int size) {

        if (input == null || input.length() <= 0)
            throw new IllegalArgumentException("Invalid input.");
        if (size < 1) throw new IllegalArgumentException("Invalid size.");

        StringBuilder result = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            // produce a random order
            int index = random.nextInt(input.length());
            result.append(input.charAt(index));
        }
        return result.toString();
    }

    // for final password, make it more random
    public static String shuffleString(String input) {
        List<String> result = Arrays.asList(input.split(""));
        Collections.shuffle(result);
        // java 8
        return result.stream().collect(Collectors.joining());
    }


    @Autowired
    UserDAO userDAO;

    public User save(User user) {
        return userDAO.save(user);
    }

    public List<User> listAll() {
        return userDAO.findAll(Sort.by(Sort.Direction.DESC, "userID"));
    }

    public List<User> list() {
        return userDAO.findAllByIsDeletedFalse(Sort.by(Sort.Direction.DESC, "userID"));
    }

    public void add(User user){
        Date createdDate = new Date();

        User userModel = new User();
        userModel.setBirthDate(user.getBirthDate());
        userModel.setContactNumber(user.getContactNumber());
        userModel.setEmailAddress(user.getEmailAddress());
        userModel.setGender(user.getGender());
        userModel.setPassword(EncryptionUtil.encryptPassword(user.getPassword()));
        userModel.setUserType(user.getUserType());
        userModel.setIcNumber(user.getIcNumber());
        userModel.setCreatedBy(0);
        userModel.setCreatedDate(createdDate);
        
        userDAO.save(user);
    }

    public User getByUserName(String name) {
        return userDAO.findByUserNameAndIsDeletedFalse(name);
    }


}

