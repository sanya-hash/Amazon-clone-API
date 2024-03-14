package com.clone.amazon.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.clone.amazon.utils.IDgenerator;
import com.clone.amazon.utils.LocalDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;

@Data
@Document(collection = "category")
public class ProdCategory {

    @Id
    private String id;

    private String title; //mjhe lgra h data glt dala hoga map ni kr parar

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdAt;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updatedAt;
    
    
    public ProdCategory() {
        this.id = IDgenerator.generateUniqueId();
        this.createdAt = LocalDateTime.now(); 
        this.updatedAt = LocalDateTime.now(); 
    }
    //age debug as chlaoge to bar bar restat krne ki zrurt ni pdegi after kuch chnage kre ok bcche
}
