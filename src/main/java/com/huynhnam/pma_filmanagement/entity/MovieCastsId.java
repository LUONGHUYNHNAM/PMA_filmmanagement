package com.huynhnam.pma_filmanagement.entity;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter


public class MovieCastsId implements Serializable {
    private Integer movieId;
    private Integer castId;

    public MovieCastsId() {}

    public MovieCastsId(Integer movieId, Integer castId) {
        this.movieId = movieId;
        this.castId = castId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieCastsId that = (MovieCastsId) o;
        return Objects.equals(movieId, that.movieId) && Objects.equals(castId, that.castId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, castId);
    }
}
