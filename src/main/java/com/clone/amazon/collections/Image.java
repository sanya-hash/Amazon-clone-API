package com.clone.amazon.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.clone.amazon.utils.IDgenerator;

import lombok.Data;

@Data
@Document(collection = "images")
public class Image {
	
	@Id
	private String id;
	private String url;
	
	public Image() {
		this.id = IDgenerator.generateUniqueId();
	}

}
