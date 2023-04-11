package com.microservice_movies.demo;

import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    public Review createReview(String reviewBody, String imdbId)
    {
            try
            {
                Review review = reviewRepository.insert(new Review(reviewBody));
                System.out.println(imdbId);
//                Query query = new Query(Criteria.where("imdbId").is(imdbId));
//                Update update = new Update().push("reviewIds", new Review(reviewBody));
//                mongoTemplate.updateFirst(query, update, Movie.class);

                mongoTemplate.update(Movie.class)
                        .matching(Criteria.where("imdbId").is(imdbId))
                        .apply(new Update().push("reviewIds").value(review))
                        .first();

                return review;
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                return null;
            }

    }
}
