package com.clone.amazon.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.clone.amazon.utils.IDgenerator;

import java.util.Date;

@Data
@Document(collection = "coupons")
public class Coupon {

    @Id
    private String id;

    private String name;

    private Date expiry;

    private double discount;
    
    public Coupon() {
        this.id = IDgenerator.generateUniqueId();
    }
}
