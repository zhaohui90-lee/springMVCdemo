package com.melody.util.annotations.demo2;

import java.util.List;

/**
 * @Author: melody
 * @Date: 2020-05-22
 */
public class PasswordUtils {
    @UseCase(id = 47,description = "password must contain at least one numeric")
    public boolean validatePassword(String password){
        return password.matches("\\w*\\d\\w*");
    }
    @UseCase(id = 48)
    public String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }
    @UseCase(id = 49,description = "New password can't equal previously used ones")
    public boolean checkForNewPassword(
        List<String> prevPasswords,String password){
        return !prevPasswords.contains(password);
    }
}
