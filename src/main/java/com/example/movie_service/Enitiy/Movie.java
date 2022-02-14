package com.example.movie_service.Enitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity @NoArgsConstructor @AllArgsConstructor@Data
public class Movie {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long movieId;
    private String series;
    private String title;
    private String  description;
    private String inTrash;
    @Column(updatable = false)
    private Date createdOn = new Date();
    private Date lastmodeifiedOn= new Date();
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Review> reviews = new ArrayList<>();

}
