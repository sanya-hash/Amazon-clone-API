package com.clone.amazon.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.clone.amazon.utils.IDgenerator;

import java.util.Date;

@Data
@Document(collection = "enquiry")
public class Enquiry {

    @Id
    private String id;

    private String name;

    private String email;

    private String mobile;

    private String message;

    private Date createdAt;

    private Date updatedAt;
    
    public Enquiry() {
        this.id = IDgenerator.generateUniqueId();
    }
}
