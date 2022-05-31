package com.beta.coffee.betacoffee.message;

import com.twilio.Twilio;  
import com.twilio.rest.api.v2010.account.Message; 

 
public class TwilioMessageWhatsapp { 
    // Find your Account Sid and Token at twilio.com/console 
    public static final String ACCOUNT_SID = "AC2c1493e19b13a72e77505058ea361345"; 
    public static final String AUTH_TOKEN = "23e6a40d0bcef8feec9c4263b8942bed"; 
 
    public static Integer messageSend(String numberSend , String boddyText) { 
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber(numberSend), 
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),  
                boddyText)      
            .create(); 
 
        return message.getErrorCode();
    } 
}