package com.example.RatingService.service.impl;

import com.example.RatingService.dao.RatingDao;
import com.example.RatingService.model.Rating;
import com.example.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingDao ratingDao;

    @Override
    public Rating createRating(Rating rating) {
        return ratingDao.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingDao.findAll();
    }

    @Override
    public List<Rating> getAllRatingsByUserId(Integer userId) {
        return ratingDao.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllRatingsByHotelId(Integer hotelId) {
        return ratingDao.findByHotelId(hotelId);
    }

    @Override
    public void deleteRating(Integer ratingId) {
        ratingDao.deleteById(ratingId);
    }

    @Override
    public Rating update(Integer ratingId, Rating rating) {
        Optional<Rating> updatedRating = ratingDao.findById(ratingId);
        if(updatedRating.isPresent()) {
            Rating existingRating = updatedRating.get();
            existingRating.setUserId(rating.getUserId());
            existingRating.setHotelId(rating.getHotelId());
            existingRating.setRating(rating.getRating());
            existingRating.setFeedback(rating.getFeedback());
            return ratingDao.save(existingRating);
        } else {
            throw new RuntimeException("User with given id is not found on server !! : " + ratingId);
        }
    }
}
