package com.huynhnam.pma_filmanagement.Service;



import com.huynhnam.pma_filmanagement.entity.MovieCasts;
import com.huynhnam.pma_filmanagement.entity.MovieCastsId;

import java.util.List;
import java.util.Optional;

public interface Movie_castsService {
    List<MovieCasts> getAllMovieCasts();
    Optional<MovieCasts> getMovieCastById(MovieCastsId id);
    MovieCasts saveMovieCast(MovieCasts movieCast);
    void deleteMovieCast(MovieCastsId id);
}
