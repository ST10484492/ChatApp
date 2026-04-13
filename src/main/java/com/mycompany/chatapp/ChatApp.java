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
        
        Login Login = new Login();
        //user input
        System.out.println("Enter first name: ");
        firstName = input.nextLine();
        
        System.out.println("Enter last name: ");
        lastName = input.nextLine();
        
        System.out.println("Enter username: ");
        userName = input.nextLine();
        
        System.out.println("Enter password: ");
        passWord = input.nextLine();
        
        System.out.println("Enter your phone number: ");
        phoneNumber = input.nextLine();
        
        //if-else username is valid
        if(Login.checkUsername(userName)){
            System.out.println("Username successfully captured.");
        }else{
            System.out.println("Username is not correctly formatted; "
                    + "please ensure that your username containes an underscore "
                    + "and is no more than five characters in length.");
        }
        
        //if-else password is valid
        if(Login.checkPassword(passWord)){
            System.out.println("Password successfully captured.");
        }else{
            System.out.println("Password is not correctly formatted; "
                    + "please ensure that the password contains at least eight character, "
                    + "a capital letter, a number, and a special character");
        }
        
        //if-else phonenumber is valid
        if(Login.checkPhoneNumber(phoneNumber)){
            System.out.println("Cell phone number is successfully captured.");           
        }else{
            System.out.println("Cell phone number incorrectly formatted or "
                    + "does not contain international code");
        }
        
        //Login class method??
        System.out.println("======LOGIN======");
        System.out.println("Enter your username: ");
        loginUser = input.nextLine();
        
        System.out.println("Enter your password: ");
        loginPass = input.nextLine();
        
        if(Login.loginUser(userName, passWord, loginUser, loginPass)){
            System.out.println("Welcome " + firstName + " " + lastName + ", Great To See You Again");
        }else{
            System.out.println("Username is incorect, please try again");
        }
    }
}
