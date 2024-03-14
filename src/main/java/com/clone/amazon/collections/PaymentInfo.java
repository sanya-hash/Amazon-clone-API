package com.clone.amazon.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.clone.amazon.utils.IDgenerator;

@Data
@Document(collection = "payment_info")
public class PaymentInfo {

    @Id
    private String id;

    private String razorPayOrderId;

    private String razorPayPaymentId;

    private String paidWith;
    
    public PaymentInfo() {
        this.id = IDgenerator.generateUniqueId();
    }
}
