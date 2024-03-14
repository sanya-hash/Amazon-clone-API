package com.clone.amazon.service;

import java.util.List;

import com.clone.amazon.collections.Rating;

public interface RatingService {
	
	List<Rating> saveRatings(List<Rating> ratings);
	Rating save(Rating rating);

}
