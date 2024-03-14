package com.clone.amazon.model;

import lombok.Data;

@Data
public class RatingRequest {
	
	private Double star;

    private String comment;

    private String title;
    
    private String prodId;

}
