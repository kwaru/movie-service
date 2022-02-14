package com.example.movie_service.Service;

import com.example.movie_service.Enitiy.Movie;
import com.example.movie_service.Enitiy.Review;

import java.util.List;

public interface MovieService {
    Movie createMovie(Movie movie);
    List<Movie> getMovies();
    Movie getMovie( String movieTitle);
    Movie updateMovie(Movie movie,String movieTitle);
    Movie deleteMovie(String movieTitle);
    Movie addReview(String movieTitle, Review review);
    Review deleteReview(Long reviewId);


}
