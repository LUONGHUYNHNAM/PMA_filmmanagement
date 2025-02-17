package com.huynhnam.pma_filmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movie_casts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieCasts {

    @EmbeddedId
    private MovieCastsId id;

    @ManyToOne
    @MapsId("movieId") 
    @JoinColumn(name = "movie_id", nullable = false)
    private Movies movie;

    @ManyToOne
    @MapsId("castId") 
    @JoinColumn(name = "cast_id", nullable = false)
    private CastMembers castMember;
}
