package com.example.movie_service.Controller;

import com.example.movie_service.Enitiy.Movie;
import com.example.movie_service.Enitiy.Review;
import com.example.movie_service.Service.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MovieController {
    private final MovieServiceImpl movieService;

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>>getMovies(){

     return  ResponseEntity.ok().body(movieService.getMovies());
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/movies/").toUriString());
        return ResponseEntity.created(uri).body(movieService.createMovie(movie));
    }

    @DeleteMapping("/movies/{movieTitle}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable("movieTitle") String movieTitle){
      Movie moviesexist= movieService.deleteMovie(movieTitle);
      if (moviesexist ==null)
          return ResponseEntity.notFound().build();

      return ResponseEntity.ok().build();
    }

    @PutMapping("/movies/{movieTitle}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("movieTitle") String movieTitle,@RequestBody Movie movie){
        Movie moviesexist= movieService.updateMovie(movie,movieTitle);
        if (moviesexist ==null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().build();
    }


    @PostMapping ("/movies/reviews/{movieTitle}")
    public ResponseEntity<Movie> addReview(@RequestBody Review review, @PathVariable("movieTitle") String movieTitle){

        return ResponseEntity.ok().body(movieService.addReview(movieTitle,review));
    }
}
