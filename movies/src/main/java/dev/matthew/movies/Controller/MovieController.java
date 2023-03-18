package dev.matthew.movies.Controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.matthew.movies.Model.Movie;
import dev.matthew.movies.Service.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin("http://localhost:3000")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<List<Movie>> allMovies(){
        return new ResponseEntity<List<Movie>>(service.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> findMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(service.getAMovieByImdbId(imdbId), HttpStatus.OK);
    }
    
}
