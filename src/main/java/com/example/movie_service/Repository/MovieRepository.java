package com.example.movie_service.Repository;

import com.example.movie_service.Enitiy.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    Movie findByTitle(String movieTitle);
}
