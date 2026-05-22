/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */

import java.util.Random;

public class Message {

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
   public String checkRecipientCell(){
       
       if(recipient.matches("^\\+27[0-9]{9}$")){
           return "Cell phone number successfully captured.";
       }else{
           return "Cell phone number incorrectly formatted.";
       }
   }
   
   //creating amessage hash
   public String createMessageHash(){
       String[] words = message.split(" ");
       
       String firstWord = words[0];
       String lastWord = words[words.length - 1];
       
       messageHash = messageID.substring(0,2) + ":" + messageNumber + ":" + firstWord + lastWord;
       
       messageHash = messageHash.toUpperCase();
       
       return messageHash;
   }
   
   //printing message details
   public String printMessage(){
       
       return "Message ID: " + messageID + "\nMessage Hash: " + messageHash + "\nRecipient: " + recipient + "\nMessage: " + message;
   }
   
   //return the totla messages
   public static int returnTotalMessages(){
       return totalMessages;
   }
   
   //storing message placeholder
   public void storeMessage(){
       System.out.println("Message successfully stored.");
   }
    
}
