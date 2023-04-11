package com.microservice_movies.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/movies/reviews")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<String> createReview(@RequestBody Map<String, String> payload)
    {
        

        //Body Will be a JSON like this
        /*
            "reviewBody": "Nice movie",
            "imdbId": "tt192381"
         */
        Review review = reviewService.createReview(payload.get("reviewBody"),payload.get("imdbId"));

        if (review == null) {
            return new ResponseEntity<>("Movie Id not found " + payload.get("imdbId"), HttpStatus.NOT_FOUND);
        }
        else
           return new ResponseEntity<>(review.toString(), HttpStatus.CREATED);

    }

}
