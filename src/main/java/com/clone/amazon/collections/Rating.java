package com.clone.amazon.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.clone.amazon.utils.IDgenerator;

@Data
@Document(collection = "ratings")
public class Rating {
    
    @Id
    private String id;

    private Double star;

    private String comment;

    private String title;
    
    private String postedBy;
    
    public Rating() {
        this.id = IDgenerator.generateUniqueId();
    }
}
