package dev.matthew.movies.Service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.matthew.movies.Model.Movie;
import dev.matthew.movies.Repo.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepo;
    public List<Movie> allMovies(){
        return movieRepo.findAll();
    };


    public Optional<Movie> getAMovieById(ObjectId id){
        return movieRepo.findById(id);
    }

    public Optional<Movie> getAMovieByImdbId(String imdbId){
        return movieRepo.findMovieByImdbId(imdbId);
    }
}
