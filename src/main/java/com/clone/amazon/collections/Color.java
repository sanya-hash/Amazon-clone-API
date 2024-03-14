package com.clone.amazon.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.clone.amazon.utils.IDgenerator;
import com.clone.amazon.utils.LocalDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;

@Data
@Document(collection = "color")
public class Color {

    @Id
    private String id;

    private String title;
    
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdAt;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updatedAt;
    
    
    public Color() {
        this.id= IDgenerator.generateUniqueId();
        createdAt = LocalDateTime.now(); 
        updatedAt = LocalDateTime.now(); 
    }
    
}
