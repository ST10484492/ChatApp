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

    private String userName;
    private String passWord;
    private String firstName;
    private String lastName;
    private String phoneNumber;
     //check username
    public boolean checkUsername(String userName){
        return userName.contains("_")&& userName.length()<=5;
    }
    
    //check password
    public boolean checkPassword(String passWord){
        
        String pattern = "(?=.*[A-Z])"//atleast one uppercasee
                       + "(?=.*\\d)" //atleast one number
                       + "(?=.*[^a-z0-9])"//atleast one special character
                       + ".{8,}";//atleast 8 characters long
        
        return passWord.matches(pattern); //this will return on main class
    }
    
    //check phone number
    public boolean checkPhoneNumber(String phoneNumber){
        String pattern = "^(\\+27[0-9]){9}|0[0-9]{8}";//user should enter +27 and 9number
        
        return phoneNumber.matches(pattern);
    }

    //register user
    public boolean registerUser(String userName, String passWord, String phoneNumber, String firstName, String lastName){
     if(checkUsername(userName) && checkPhoneNumber(phoneNumber)){
         System.out.println("Invalid username.");
            return false;
        }
     
     if(checkPassword(passWord)){
         System.out.println("Invalid password.");
         return false;
     }
     
     if(checkPhoneNumber(phoneNumber)){
         System.out.println("Phone number is not correctly formatted");
         return false;
     }
     
     //storing the details
     this.userName = userName;
     this.passWord = passWord;
     this.firstName = firstName;
     this.lastName = lastName;
     this.phoneNumber = phoneNumber;
     
        System.out.println("User successfully registered");
        return true;
    }
    
    public boolean loginUser(String userName, String passWord){
        return this.userName != null &&
                this.userName.equals(userName) && 
                this.passWord.equals(passWord);
}
    
    //return login message
    public String returnLoginStatus(boolean loginSuccess){
        if(loginSuccess){
            return "Welcome " + firstName + "," + lastName + " it is great to see you again.";
        }else{
            return "Username or password incorrect, please try again";
        }
    }
}