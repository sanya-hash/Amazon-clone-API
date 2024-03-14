package com.clone.amazon.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.clone.amazon.collections.User;

@Service
public class JavaSmtpGmailSenderService {

	
	@Autowired
    private JavaMailSender emailSender;

    public void sendResetPasswordEmail(String email,User user, String token){
    	  String resetUrl = "http://localhost:5173/reset/" + token; 
          String emailContent = "Please click the following link to reset your password: " + resetUrl;
    	    
    	    SimpleMailMessage message = new SimpleMailMessage();
    	    message.setFrom("sanyak2345@gmail.com");
    	    message.setTo(email);
    	    message.setSubject("Password Reset Request!");
    	    message.setText(emailContent);

    	    emailSender.send(message);

    }
}
