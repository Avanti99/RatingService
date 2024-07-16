package com.example.RatingService.service;

import com.example.RatingService.model.Rating;

import java.util.List;

public interface RatingService {
    Rating createRating(Rating rating);

    List<Rating> getAllRatings();

    List<Rating> getAllRatingsByUserId(Integer userId);

    List<Rating> getAllRatingsByHotelId(Integer hotelId);

    void deleteRating(Integer ratingId);

    Rating update(Integer ratingId, Rating rating);
}
