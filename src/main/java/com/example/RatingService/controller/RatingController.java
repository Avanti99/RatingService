package com.example.RatingService.controller;

import com.example.RatingService.model.Rating;
import com.example.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        return ResponseEntity.ok(ratingService.getAllRatings());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(ratingService.getAllRatingsByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingsByHotelId(@PathVariable Integer hotelId) {
        return ResponseEntity.ok(ratingService.getAllRatingsByHotelId(hotelId));
    }

    @PutMapping("/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable Integer ratingId, @RequestBody Rating rating) {
        return ResponseEntity.ok(ratingService.update(ratingId, rating));
    }

    @DeleteMapping("/{ratingId}")
    public void deleteRating(@PathVariable Integer ratingId) {
        ratingService.deleteRating(ratingId);
    }
}
