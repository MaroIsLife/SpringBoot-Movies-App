package com.microservice_movies.demo;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies()
    {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable ObjectId id)
    {
        return new ResponseEntity<>(movieService.getMovie(id), HttpStatus.OK);
    }

    @GetMapping("/title/{id}")
    public ResponseEntity<Movie> getMovieTitle(@PathVariable String id)
    {

        return new ResponseEntity<>(movieService.getMovieTitle(id), HttpStatus.OK);
    }

    @GetMapping("/imdb/{id}")
    public ResponseEntity<Movie> getMovieImdb(@PathVariable String id)
    {

        
        return new ResponseEntity<>(movieService.getMovieImdbId(id), HttpStatus.OK);
    }


}


