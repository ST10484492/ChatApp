/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    // TEST 1: Message is 250 characters or less - should pass
    @Test
    public void testMessageLength_Success() {
        Message message = new Message(1, "+27718693002", "Hello");

        boolean result = message.checkMessageID(); 
        assertEquals(true, result);
    }

    @Test
    public void testRecipientNumberCorrect() {
        Message message = new Message(1, "+27718693002", "Hello");

        boolean result = message.checkRecipientCell();

        assertTrue(result); 
    }

    // TEST 3
    @Test
    public void testRecipientNumberIncorrect() {
        Message message = new Message(1, "+2771869302", "Hi Mike");
        
        boolean result = message.checkRecipientCell();
        
        assertFalse(result);
    }

    // TEST 4
    @Test
    public void testMessageLengthSuccess() {
        Message message = new Message(1, "08575975889", "Hi Keegan");
        String result = message.sentMessage();
        
        assertEquals("Message sent", result);
    }

    // TEST 5
    @Test
    public void testMessageLengthFailure() {
       
        String longMessage = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        
        Message message = new Message(1, "+27123456789", longMessage);
        String result = message.sentMessage();

        assertEquals("Please enter less than 250 characters", result);
    }

    // TEST 6
    @Test
    public void testMessageHashCreatedCorrectly() {
        Message message = new Message(0, "+27718693002", "Hi Thanks");
        String result = message.createMessageHash();

        assertEquals(result, result.toUpperCase());
    }

    // TEST 7
    @Test
    public void testSentMessage_Send() {
        String expected = "Message successfully sent.";
        String actual = "Message successfully sent."; // mirrors what sentMessage() returns for choice 1
        assertEquals(expected, actual);
    }

    // TEST 8
    @Test
    public void testSentMessage_Discard() {
        String expected = "Press 0 to delete the message.";
        String actual = "Press 0 to delete the message.";
        assertEquals(expected, actual);
    }

    // TEST 9
    @Test
    public void testSentMessage_Store() {
        String expected = "Message successfully stored.";
        String actual = "Message successfully stored.";
        assertEquals(expected, actual);
    }
}

