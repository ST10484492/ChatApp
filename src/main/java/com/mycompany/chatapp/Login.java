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
        String pattern = "^(\\+27|0)[6-8][0-9]{8}";//user should enter +27 and 9number
        
        return phoneNumber.matches(pattern);
    }
    
    //has stored all the users input
    public static boolean loginUser(String storedUser, String storedPass, String loginUser, String loginPass){
        return loginUser.equals(storedUser) && loginPass.equals(storedPass);
    }
    
    
    public String registerUser(String userName, String password, String phoneNumber, String firstName, String lastName){
        
        
        if(checkUsername(userName) && checkPhoneNumber(phoneNumber)){
            
            UserDetails details = new UserDetails(firstName, lastName, userName, password, phoneNumber);
            return "Successfully registered:)";
        }else{
            
        }
    }
}
