package com.huynhnam.pma_filmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Integer movieId;

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Directors director;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "age_rating", length = 5)
    private String ageRating;

    @Column(name = "runtime_min", nullable = false)
    private Integer runtimeMin;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    @Column(name = "release_date")
    private Date releaseDate;


    @Column(name = "trailer_link", nullable = false, length = 1000)
    private String trailerLink;

    @Column(name = "description", length = 2000)
    private String description;

    @Column(name = "banner_image", nullable = false, length = 1000)
    private String bannerImage;

    @Column(name = "poster_image", nullable = false, length = 1000)
    private String posterImage;

    @Column(name = "synopsis", length = 4000)
    private String synopsis;
}
