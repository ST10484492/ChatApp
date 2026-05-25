/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

/**
 *
 * @author Student
 */
class Login {
    
    //conditions for username
    public static boolean checkUsername(String userName){
        return userName.contains("_")&& userName.length()<=5;
    }
    
    //conditions for password
    public static boolean checkPassword(String passWord){
        
        String pattern = "(?=.*[A-Z])"//atleast one uppercasee
                       + "(?=.*\\d)" //atleast one number
                       + "(?=.*[^a-z0-9])"//atleast one special character
                       + ".{8,}";//atleast 8 characters long
        
        return passWord.matches(pattern); //this will return on main class
    }
    
    //conditions for phone number
    public static boolean checkPhoneNumber(String phoneNumber){
        String pattern = "^(\\+27)"
                       + "[0-9]"//9 digits after +27
                       + "{9}";//user should enter +27 and 9numbers
        
        return phoneNumber.matches(pattern);
    }
    
    //has stored all the users input
    public static boolean loginUser(String storedUser, String storedPass, String loginUser, String loginPass){
        return loginUser.equals(storedUser) && loginPass.equals(storedPass);
    }
    
    
    }