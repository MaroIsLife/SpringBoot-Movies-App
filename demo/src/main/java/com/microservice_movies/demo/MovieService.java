package com.microservice_movies.demo;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService {


    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> getAllMovies()
    {
        return movieRepository.findAll();
    }

    public Movie getMovie(ObjectId id)
    {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie getMovieTitle(String id)
    {
        return movieRepository.findMovieByTitle(id).orElse(null);
    }

    public Movie getMovieImdbId(String id)
    {
        return movieRepository.findMovieByImdbId(id).orElse(null);
    }
}
