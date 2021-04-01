package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.pojo.User;
import com.example.demo.utility.EncryptionUtil;
import com.example.demo.utility.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class AccountService {

    private static final String CHAR_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPERCASE = CHAR_LOWERCASE.toUpperCase();
    private static final String DIGIT = "0123456789";
    private static final String OTHER_PUNCTUATION = "!@#&()–[{}]:;',?/*";
    private static final String OTHER_SYMBOL = "~$^+=<>";
    private static final String OTHER_SPECIAL = OTHER_PUNCTUATION + OTHER_SYMBOL;
    private static final int PASSWORD_LENGTH = 8;

    private static final String PASSWORD_ALLOW =
            CHAR_LOWERCASE + CHAR_UPPERCASE + DIGIT + OTHER_SPECIAL;

    private static SecureRandom random = new SecureRandom();

    /**
     * Method to combine all random string
     * and generate a strong password with
     * lower case and upper case letter, number
     * and special characters
     *
     * @return return password
     */
    public static String generateStrongPassword() {

        StringBuilder result = new StringBuilder(PASSWORD_LENGTH);

        // at least 2 chars (lowercase)
        String strLowerCase = generateRandomString(CHAR_LOWERCASE, 2);
        result.append(strLowerCase);

        // at least 2 chars (uppercase)
        String strUppercaseCase = generateRandomString(CHAR_UPPERCASE, 2);
        result.append(strUppercaseCase);

        // at least 2 digits
        String strDigit = generateRandomString(DIGIT, 2);
        result.append(strDigit);

        // at least 2 special characters (punctuation + symbols)
        String strSpecialChar = generateRandomString(OTHER_SPECIAL, 2);
        result.append(strSpecialChar);


        String password = result.toString();

        return password;
    }
    /**
     * Method to generate a random string with
     * lower case and upper case letter, number
     * and special characters
     *
     * @param input different cases of characters
     * @param size number of characters (at least 2 char)
     * @return result string for different cases
     */
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

    /**
     * Method to determine user group(admin or student)
     * and verify if correct user credential is entered
     *
     * @param username
     * @param password
     * @param loginType (admin or student)
     * @return user object is credential is entered correctly
     */
    public User login(String username, String password,String loginType){
        User user = new User();


        if(loginType.equals(RoleType.Admin.name())){
            user = userDAO.findByUserNameAndUserTypeAndIsDeletedFalse(username,RoleType.Admin.toInt());

        }else if(loginType.equals(RoleType.Customer.name())){
            user = userDAO.findByUserNameAndUserTypeAndIsDeletedFalse(username,RoleType.Customer.toInt());

        }
        if (user == null){
            return null;
        }
        String encryptedPwd = EncryptionUtil.encryptPassword(password);

        if (user.getPassword().equals(encryptedPwd)){
            return user;
        }

        return null;
    }

    public boolean resetpwd(String oldpwd, String newpwd){
        return false;
    }

    /**
     * Method to save user information
     *
     * @param user
     * @return object to userDAO
     */
    public User save(User user) {
        return userDAO.save(user);
    }

    /**
     * Method to find all users
     *
     * @return list of all users
     */
    public List<User> listAll() {
        return userDAO.findAll(Sort.by(Sort.Direction.DESC, "userID"));
    }

    /**
     * Method to check if user exist
     *
     * @param userName
     * @param emailAddress
     * @param contactNUmber
     * @param icNumber
     * @return specific user
     */
    public User getByUserNameOrEmailAddressOrContactNumberOrIcNumber(String userName, String emailAddress, String contactNUmber, String icNumber){
        return  userDAO.findByUserNameOrEmailAddressOrContactNumberOrIcNumberAndIsDeletedFalse(userName, emailAddress, contactNUmber, icNumber);
    }

    /**
     * Method to check if user already exist
     * If not, add to database
     *
     * @param user
     * @return true if added to databse or false if not added to database
     */
    public boolean add(User user){
        Date createdDate = new Date();

        User isUserExisted = getByUserNameOrEmailAddressOrContactNumberOrIcNumber(user.getUserName(), user.getEmailAddress(), user.getContactNumber(), user.getIcNumber());
        if (isUserExisted == null) {

            User userModel = new User();
            userModel.setUserName(user.getUserName());
            userModel.setContactNumber(user.getContactNumber());
            userModel.setDisplayName(user.getDisplayName());
            userModel.setBirthDate(user.getBirthDate());
            userModel.setContactNumber(user.getContactNumber());
            userModel.setEmailAddress(user.getEmailAddress());
            userModel.setGender(user.getGender());
            userModel.setPassword(EncryptionUtil.encryptPassword(user.getPassword()));
            userModel.setUserType(user.getUserType());
            userModel.setIcNumber(user.getIcNumber());
            userModel.setCreatedBy(0);
            //userModel.setCreatedDate(createdDate);
            userModel.setVetID(user.getVetID());
            userDAO.save(userModel);
            return true;
        }


        else return false;
    }

    /**
     * Method to get user by its username
     *
     * @param name
     * @return user
     */
    public User getByUserName(String name) {
        return userDAO.findByUserNameAndIsDeletedFalse(name);
    }

    /**
     * Method to get user by its userID
     *
     * @param userid
     * @return user
     */
    public User getByUserID(Integer userid) {
        return userDAO.findByUserIDAndIsDeletedFalse(userid);
    }

}

