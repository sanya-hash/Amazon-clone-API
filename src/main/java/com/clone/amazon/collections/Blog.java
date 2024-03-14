package com.clone.amazon.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.clone.amazon.utils.IDgenerator;
import com.clone.amazon.utils.LocalDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "blogs")
@Data
public class Blog {
    @Id
    private String id;

    private String title;

    private String description;

    @DBRef
    private BlogCategory category;

    private int numViews;

    private boolean isLiked;

    private boolean isDisliked;

    @DBRef
    private List<User> likes;

    @DBRef
    private List<User> dislikes;

    private String image;
    
    @DBRef
    private List<Image> images;

    @DBRef
    private User author;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdAt;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updatedAt;

    public Blog() {
        this.id = IDgenerator.generateUniqueId();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

}
