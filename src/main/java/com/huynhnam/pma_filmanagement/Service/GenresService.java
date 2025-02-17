package com.huynhnam.pma_filmanagement.Service;



import com.huynhnam.pma_filmanagement.entity.Genres;

import java.util.List;
import java.util.Optional;

public interface GenresService {
    List<Genres> getAllGenres();
    Optional<Genres> getGenreById(Integer id);
    Genres saveGenre(Genres genre);
    Genres updateGenre(Integer id, Genres genre);
    void deleteGenre(Integer id);
}
