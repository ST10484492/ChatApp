/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;
import java.util.ArrayList;
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
        int option = 0;
        int numberOfMessages;
        String recipient;
        String messageText;
        int messageOption;
        int delete;
        
        Login Login = new Login();
        
        System.out.println("======REGISTER======");
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
            System.out.println("================================================");
            System.out.println("\nWelcome To QuickChat");
            System.out.println("================================================");
        }else{
            System.out.println("Username is incorect, please try again");
        }  
        
        //application runs till user quits
        while(option != 3){
            
            System.out.println("======MENU======");
            System.out.println("\nChoose an option: ");
            System.out.println("1) Send Messages");
            System.out.println("2) Show Recently sent messages");
            System.out.println("3) Quit");
            
            System.out.println("Option: ");
            option = input.nextInt();
            input.nextLine();
            
            //for the send messages option
            if(option == 1){
                
                System.out.println("How many messages would you like to send?");
                numberOfMessages = input.nextInt();
                input.nextLine();
                
                for(int i = 1; i<= numberOfMessages; i++){
                    
                    System.out.println("\nMESSAGE " + i);
                    
                    System.out.println("Recipient Number: ");
                    recipient = input.nextLine();
                    
                    System.out.println("Enter Message: ");
                    messageText = input.nextLine();
                    
                    //new class
                    Message message = new Message(i, recipient, messageText);
                    
                    System.out.println(message.checkRecipientCell());
                    
                    System.out.println(message.sentMessage());
                    
                    System.out.println("\nChoose an option: ");
                    System.out.println("1) Send Message");
                    System.out.println("2) Disregard Message");
                    System.out.println("3) Store Message");
                    messageOption = input.nextInt();
                    input.nextLine();
                    
                    //message option 1, if chosen
                    if(messageOption == 1){
                        System.out.println("Message successfully sent.");
                        
                        System.out.println(message.printMessage());
                        
                    }
                    //message option 2, delete message, if chosen
                    else if(messageOption == 2){
                        
                        System.out.println("Press 0 to delete message");
                        delete = input.nextInt();
                        input.nextLine();
                        
                        if(delete == 0){
                            System.out.println("Message deleted");
                        }
                    }
                    //message option 3, to store message, if chosen
                    else if(messageOption == 3){
                        message.storeMessage();
                    }  
                }
                
                System.out.println("\nTotal Messages Sent: " + Message.returnTotalMessages());    
            }
            
            else if(option == 2){
                System.out.println("Coming Soon.");
            }
            
            else if(option == 3){
                System.out.println("Goodbye");
            }
            
            else{
                System.out.println("Invalid Option");
            }
        }
    }
}
