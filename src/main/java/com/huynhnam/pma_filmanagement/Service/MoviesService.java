package com.huynhnam.pma_filmanagement.Service;

import com.huynhnam.pma_filmanagement.entity.Movies;
import java.util.List;
import java.util.Optional;

public interface MoviesService {
    List<Movies> getAllMovies();
    Optional<Movies> getMovieById(Integer movieId);
    Movies saveMovie(Movies movie);
    void deleteMovie(Integer movieId);
}
