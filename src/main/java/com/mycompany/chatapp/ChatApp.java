/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class ChatApp {

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        
        //declaring
        String firstName;
        String lastName;
        String userName;
        String passWord;
        String phoneNumber;
        String loginUser;
        String loginPass;
    
        //object for login class
        Login login = new Login();
        
        //user input
        System.out.println("Enter your first name: ");
        firstName = input.nextLine();
        
        System.out.println("Enter your last name: ");
        lastName = input.nextLine();
        
        System.out.println("Enter username: ");
        userName = input.nextLine();
        
        System.out.println("Enter password: ");
        passWord = input.nextLine();
        
        System.out.println("Enter your phone number: ");
        phoneNumber = input.nextLine();
        
        //if-else username is valid
        if(login.checkUsername(userName)){
            System.out.println("Username successfully captured.");
        }else{
            System.out.println("Username is not correctly formatted; "
                    + "please ensure that your username containes an underscore "
                    + "and is no more than five characters in length.");
        }
        
        //if-else password is valid
        if(login.checkPassword(passWord)){
            System.out.println("Password successfully captured.");
        }else{
            System.out.println("Password is not correctly formatted; "
                    + "please ensure that the password contains at least eight character, "
                    + "a capital letter, a number, and a special character");
        }
        
        //if-else phonenumber is valid
        if(login.checkPhoneNumber(phoneNumber)){
            System.out.println("Cell phone number is successfully captured.");           
        }else{
            System.out.println("Cell phone number incorrectly formatted or "
                    + "does not contain international code");
        }
        
        login.registerUser(userName, passWord, phoneNumber, userName, userName);
        
        //Login class method??
        System.out.println("======LOGIN======");
        System.out.println("Enter your username: ");
        loginUser = input.nextLine();
        
        System.out.println("Enter your password: ");
        loginPass = input.nextLine();
        
        boolean success = login.loginUser(loginUser, loginPass);
        
        //display message
        System.out.println(login.returnLoginStatus(success));
    }
}
