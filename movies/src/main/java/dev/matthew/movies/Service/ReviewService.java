package dev.matthew.movies.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import dev.matthew.movies.Model.Movie;
import dev.matthew.movies.Model.Review;
import dev.matthew.movies.Repo.ReviewRepository;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewRepository repo;

    @Autowired
    private MongoTemplate mongoTemplate;
    
    public Review createReview(String reviewBody, String imdbId){
        Review review = 
        repo.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        return review;
    }

    public List<Review> allReviews(){
        return repo.findAll();
    }
}
