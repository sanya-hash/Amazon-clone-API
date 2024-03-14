package com.clone.amazon.collections;

import java.time.LocalDateTime;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.clone.amazon.utils.IDgenerator;
import com.clone.amazon.utils.LocalDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;

@Data
@Document(collection = "blogcategory")
public class BlogCategory {
    
    @Id
    private String id;

    private String title;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdAt;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updatedAt;
    
    public BlogCategory() {
        this.id = IDgenerator.generateUniqueId();
        createdAt = LocalDateTime.now(); 
        updatedAt = LocalDateTime.now(); 
    }

}
