package com.huynhnam.pma_filmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movie_genres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieGenres {

    @EmbeddedId
    private MovieGenresId id;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id", nullable = false)
    private Movies movie;

    @ManyToOne
    @MapsId("genreId")
    @JoinColumn(name = "genre_id", nullable = false)
    private Genres genre;
}
