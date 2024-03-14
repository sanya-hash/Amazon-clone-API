package com.clone.amazon.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.clone.amazon.utils.IDgenerator;

import java.util.Date;

@Data
@Document(collection = "sessions")
public class Session {
    
    @Id
    private String id;

    @DBRef
    private User user;

    private boolean valid;

    private String userAgent;

    private Date createdAt;

    private Date updatedAt;
    
    public Session() {
        this.id = IDgenerator.generateUniqueId();
    }
}
