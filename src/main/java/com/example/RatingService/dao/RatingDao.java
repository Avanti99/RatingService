package com.example.RatingService.dao;

import com.example.RatingService.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingDao extends JpaRepository<Rating, Integer> {
    List<Rating> findByUserId(Integer userId);

    List<Rating> findByHotelId(Integer hotelId);
}
