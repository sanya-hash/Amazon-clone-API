package com.clone.amazon.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.amazon.collections.Rating;
import com.clone.amazon.repositories.RatingRepository;
import com.clone.amazon.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public List<Rating> saveRatings(List<Rating> ratings) {
		return ratingRepository.saveAll(ratings);
	}

	@Override
	public Rating save(Rating rating) {
		return ratingRepository.save(rating);
	}

}
