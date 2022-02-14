package com.example.movie_service.Service;

import com.example.movie_service.Enitiy.Movie;
import com.example.movie_service.Enitiy.Review;
import com.example.movie_service.Repository.MovieRepository;
import com.example.movie_service.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MovieServiceImpl  implements  MovieService{

    private  final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;


    @Override
    public Movie createMovie(Movie movie) {
        movie.setInTrash("FALSE");
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getMovies() {

        List<Movie> notintrash = new ArrayList<>();
        List<Movie> allmovies = movieRepository.findAll();
        if (allmovies ==null)
            return null;
        for(Movie movie: allmovies){
            if (movie.getInTrash().equals("FALSE")==true)
            notintrash.add(movie);
        }
        return notintrash;
    }

    @Override
    public Movie getMovie(String movieTitle) {
        Movie db_movie= movieRepository.findByTitle(movieTitle);
        if((db_movie !=null)&&(db_movie.getInTrash().equals("TRUE")!=true)){
            return  db_movie;

        }
        return null;
    }

    @Override
    public Movie updateMovie(Movie movie,String movieTitle) {

        Movie db_movie= movieRepository.findByTitle(movieTitle);
        if((db_movie !=null)&&(db_movie.getInTrash().equals("TRUE")!=true)){
            if(movie.getDescription()!=null)
                db_movie.setDescription(movie.getDescription());

            if(movie.getSeries()!=null)
                db_movie.setSeries(movie.getDescription());
            db_movie.setLastmodeifiedOn(new Date());
            log.info("date saved "+db_movie.getLastmodeifiedOn());
            return movieRepository.save(db_movie);
        }
        return null;
    }

    @Override
    public Movie deleteMovie(String movieTitle) {

        Movie db_movie= movieRepository.findByTitle(movieTitle);
        if((db_movie !=null)&&(db_movie.getInTrash().equals("TRUE")!=true)){
            db_movie.setInTrash("TRUE");
            return  movieRepository.save(db_movie);
        }
        return null;
    }

    @Override
    public Movie addReview(String movieTitle, Review review) {
        review.setInTrash("FALSE");
        Movie movietoreview= movieRepository.findByTitle(movieTitle);
        if((movietoreview!=null)&& (movietoreview.getInTrash().equals("FALSE")==true)) {
            Review savedreview = reviewRepository.save(review);
            log.info("saved review"+savedreview);
            movietoreview.getReviews().add(savedreview);
            return movietoreview;
        }
        return  null;
    }

    @Override
    public Review deleteReview(Long reviewId) {
        return reviewRepository.getById(reviewId);
    }


}
