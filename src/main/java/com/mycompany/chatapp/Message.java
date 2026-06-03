/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Student
 */
class Message {
   private String messageID;
   private int messageNumber;
   private String recipient;
   private String message;
   private String messageHash;
   
   //total message counter
   private static int totalMessages = 0;
   
   //constructor
   public Message(int messageNumber, String recipient, String message){
       
       this.messageNumber = messageNumber;
       this.recipient = recipient;
       this.message = message;
       
       generateMessageID();
       createMessageHash();
       
       totalMessages++;       
   }
   
   //random 10-digit ID
   private void generateMessageID(){
       
       Random random = new Random();
       long number = 1000000000L + (long)(random.nextDouble()*9000000000L);
       
       messageID = String.valueOf(number);      
   }
   
   //checking messageID length
   public boolean checkMessageID(){
       return messageID.length() == 10;
   }
   
   //checking recipient number
   public boolean checkRecipientCell(){
       return recipient.startsWith("+27") && recipient.length()==12;
   }
   
   //creating amessage hash
   public String createMessageHash(){
       String[] words = message.split(" ");
       
       String firstWord = words[0];
       
       String lastWord = words[words.length - 1];
       
       messageHash = messageID.substring(0,2) + ": " + messageNumber + ": " + firstWord + lastWord;
       
       messageHash = messageHash.toUpperCase();
       
       return messageHash;
   }
   
   public String sentMessage(){
       
       if(message.length()>250){
           return "Please enter a message of less than 250 characters.";
       }else{
           return "Message successfully sent";
       }
   }
   
   //printing message details
   public String printMessage(){
       
       return "Message ID: " + messageID + "\nMessage Hash: " + messageHash + "\nRecipient: " + recipient + "\nMessage: " + message;
   }
   
   //return the totla messages
   public static int returnTotalMessages(){
       return totalMessages;
   }
   
   public void storeMessage(){
       
       try{
           
           //creating a FileWriter object
           FileWriter writer = new FileWriter("messages.json", true);
           
           //message details stored in JSON format
           writer.write("\n");
           writer.write("\"MessagesID\":\"" + messageID + "\",\n");
           writer.write("\"MessagesHash\":\"" + messageHash + "\",\n");
           writer.write("\"Recipient\":\"" + recipient + "\",\n");
           writer.write("\"Message\":\"" + message + "\"\n");
           
           System.out.println("Message Successfully stored");
       }
       //handles the file errors
       catch(IOException e){
           System.out.println("Error storing message");
       }
   }
   
   //getters
   public String getMessage(){
       return message;      
   }
   
   public String getRecipient(){
       return recipient;
   }
   
   public String getMessageHash(){
       return messageHash;
   }
   
   public String getMessageID(){
       return messageID;
   }
   
}
