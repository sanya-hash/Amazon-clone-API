package com.clone.amazon.config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Configuration
public class MyConfig {
  	
	public String generateAuthToken(String id) {
        // Assuming you have a secret key defined
        String secretKey = "amaz_clone";
        // Assuming you have a user ID field
        return Jwts.builder()
                   .setSubject(String.valueOf(id))
                   .setIssuedAt(new Date())
                   .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day
                   .signWith(SignatureAlgorithm.HS512, secretKey)
                   .compact();
        
    }

//    public boolean isPasswordMatched(String password) {
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        return passwordEncoder.matches(password, this.password);
//    }

	public Map<String, Object> createPasswordResetToken() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[32];
        random.nextBytes(bytes);
        String resetToken = Base64.getEncoder().encodeToString(bytes);
        String passwordResetToken = null;
        Date passwordResetExpires = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(resetToken.getBytes());
            passwordResetToken = Base64.getEncoder().encodeToString(hashBytes);
            passwordResetExpires = new Date(System.currentTimeMillis() + 600000); // 10 minutes
            // Save this information to the database
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        Map<String, Object> resetInfo = new HashMap<>();
        resetInfo.put("passwordResetToken", passwordResetToken);
        resetInfo.put("passwordResetExpires", passwordResetExpires);
        return resetInfo;
    }

}
