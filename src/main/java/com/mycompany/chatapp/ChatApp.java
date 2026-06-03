/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

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
        ArrayList<String>sentMessages = new ArrayList<>();
        ArrayList<String>disregardedMessages = new ArrayList<>();
        ArrayList<String>storedMessages = new ArrayList<>();
        ArrayList<String>messageHashes = new ArrayList<>();
        ArrayList<String>messageIDs = new ArrayList<>();
        ArrayList<String>recipients = new ArrayList<>();
        
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
        
        System.out.println("Enter your phone number (start with +27): ");
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
        
        
        //PART 2
        //Login
        System.out.println("======LOGIN======");
        System.out.println("Enter your username: ");
        loginUser = input.nextLine();
        
        System.out.println("Enter your password: ");
        loginPass = input.nextLine();
        
        if(Login.loginUser(userName, passWord, loginUser, loginPass)){
            System.out.print("================================================");
            System.out.println("\nWelcome To QuickChat");
            System.out.print("================================================");
        }else{
            System.out.println("Username is incorect, please try again");
        }  
        
        //application runs till user quits
        while(option != 3){
            
            System.out.println("\n======MENU======");
            System.out.println("Choose an option: ");
            System.out.println("1) Send Messages");
            System.out.println("2) Show Recently Sent Messages");
            System.out.println("3) Stored Messages");
            System.out.println("4) Quit");
            
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
                    
                    System.out.println("Recipient Number(start with +27): ");
                    recipient = input.nextLine();
                    
                    System.out.println("Enter Message: ");
                    messageText = input.nextLine();
                    
                    //new class
                    Message message = new Message(i, recipient, messageText);
                    
                    //recipients number checker??
                    if(message.checkRecipientCell()){
                        System.out.println("Cell phone correctly formatted");
                    } else{
                        System.out.println("Cell phone incorrectly formatted");
                    }
                    
                    System.out.println("\nChoose an option (what to do with message): ");
                    System.out.println("1) Send Message");
                    System.out.println("2) Disregard Message");
                    System.out.println("3) Store Message");
                    
                    messageOption = input.nextInt();
                    input.nextLine();
                    
                    //message option 1, if chosen
                    if(messageOption == 1){
                        
                        sentMessages.add(message.getMessage());
                        messageHashes.add(message.getMessageHash());
                        messageIDs.add(message.getMessageID());
                        recipients.add(message.getRecipient());
                        
                        //displays sent message
                        System.out.println(message.sentMessage());
                        
                        //prints message details
                        System.out.println(message.printMessage());
                        
                        //saves message to JSON file
                        message.storeMessage();
                        
                    }
                    //message option 2, delete message, if chosen
                    else if(messageOption == 2){
                        disregardedMessages.add(message.getMessage());
                        System.out.println("Message discarded");
                    }
                    //message option 3, to store message, if chosen
                    else if(messageOption == 3){
                        storedMessages.add(message.getMessage());
                        
                        messageHashes.add(message.getMessageHash());
                        messageIDs.add(message.getMessageID());
                        recipients.add(message.getRecipient());
                        message.storeMessage();
                    }  
                }
                
                System.out.println("\nTotal Messages Sent: " + Message.returnTotalMessages());    
            }
            
            else if(option == 2){
                if(sentMessages.isEmpty()){
                    
                    System.out.println("No messages sent yet");
                }
                else{
                    System.out.println("===RECENTLY SENT MESSAGES===");
                    
                    //loop through messages
                    for(int i = 0;i < sentMessages.size();i++){
                        System.out.println(sentMessages.get(i));
                    }
                } 
            }
            
            else if(option == 3){
                System.out.println("===STORED MESSAGES MENU===");
                System.out.println("1) Display sender and recipient");
                System.out.println("2) Display longest message");
                System.out.println("3) Search by Message ID");
                System.out.println("4) Search by recipient");
                System.out.println("5) Delete by message hash");
                System.out.println("6) Display report");
                System.out.println("Choice: ");
                int storedOption = input.nextInt();
                input.nextLine();
                
                //
                if(storedOption == 1){
                    for(int i = 0; i < recipients.size(); i++){
                        System.out.println("Sender: Developer");
                        System.out.println("Recipient: " + recipients.get(i));
                        System.out.println();
                    }
                }else if(storedOption == 2){
                    String longestMessage = "";
                    
                    for(String msg : sentMessages){
                        if(msg.length()> longestMessage.length()){
                            longestMessage = msg;
                        }
                    }
                    
                    System.out.println("LongestMessage: ");
                    System.out.println(longestMessage);
                }else if(storedOption == 3){
                    System.out.println("Enter Message ID: ");
                    String searchID = input.nextLine();
                    
                    boolean found = false;
                    for(int i = 0; i < messageIDs.size(); i++){
                        if(messageIDs.get(i).equals(searchID)){
                            System.out.println("Recipient: " + recipients.get(i));
                            System.out.println("Messages: " + sentMessages.get(i));
                            found = true;
                            
                        }
                    }
                    
                    if(!found){
                        System.out.println("Message ID not found");
                    }
                }else if(storedOption == 4){
                    System.out.println("Enter Recipients Number: ");
                    String searchRecipient = input.nextLine();
                    
                    boolean found = false;
                    
                    for(int i = 0; i < recipients.size(); i++){
                        if(recipients.get(i).equals(searchRecipient)){
                            System.out.println(sentMessages.get(i));
                            found = true;
                        }
                    }
                    
                    if(!found){
                        System.out.println("No Messages Found");
                    }
                }else if(storedOption == 5){
                    System.out.println("Enter Message Hash: ");
                    String hash = input.nextLine();
                    
                    boolean deleted = false;
                    
                    for(int i = 0; i < messageHashes.size(); i++){
                        if(messageHashes.get(i).equals(hash)){
                            System.out.println("Message: " + sentMessages.get(i) + " successfully deleted");
                            
                            sentMessages.remove(i);
                            recipients.remove(i);
                            messageHashes.remove(i);
                            messageIDs.remove(i);
                            deleted = true;
                        }
                    }
                    
                    if(!deleted){
                        System.out.println("Message Hash not found");
                    }
                }else if(storedOption == 6){
                    System.out.println("\n===MESSAGE REPORT===");
                    
                    for(int i = 0; i < sentMessages.size(); i++){
                        System.out.println("Message Hash: " + messageHashes.get(i));
                        System.out.println("Recipient: " + recipients.get(i));
                        System.out.println("Message: " + sentMessages.get(i));
                        System.out.println("------------------");
                    }
                }
            }
            
            else{
                System.out.println("Invalid Option, please choose 1, 2 or 3");
            }
        }
    }
}
