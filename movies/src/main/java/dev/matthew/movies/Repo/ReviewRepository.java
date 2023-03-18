package dev.matthew.movies.Repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.matthew.movies.Model.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId>{
    
}
