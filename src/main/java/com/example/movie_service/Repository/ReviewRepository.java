package com.example.movie_service.Repository;

import com.example.movie_service.Enitiy.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {

}
