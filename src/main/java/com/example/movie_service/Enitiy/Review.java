package com.example.movie_service.Enitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;
    private Integer rating;
    private String status;
    private String comment;
    private String inTrash ;
    @Column(updatable = false)
    private Date createdOn= new Date();
    private Date lastmodifiedOn = new Date();



}
