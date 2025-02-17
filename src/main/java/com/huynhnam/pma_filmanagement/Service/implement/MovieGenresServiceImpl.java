package com.huynhnam.pma_filmanagement.Service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huynhnam.pma_filmanagement.dao.Movie_genresDAO;
import com.huynhnam.pma_filmanagement.entity.MovieGenres;
import com.huynhnam.pma_filmanagement.entity.MovieGenresId;
import com.huynhnam.pma_filmanagement.Service.Movie_genresService;

import java.util.List;
import java.util.Optional;

@Service
public class MovieGenresServiceImpl implements Movie_genresService {

    @Autowired
    private Movie_genresDAO movieGenresDAO;

    @Override
    public List<MovieGenres> getAllMovieGenres() {
        return movieGenresDAO.findAll();
    }

    @Override
    public Optional<MovieGenres> getMovieGenreById(MovieGenresId id) {
        return movieGenresDAO.findById(id);
    }

    @Override
    public MovieGenres saveMovieGenre(MovieGenres movieGenre) {
        return movieGenresDAO.save(movieGenre);
    }

    @Override
    public void deleteMovieGenre(MovieGenresId id) {
        movieGenresDAO.deleteById(id);
    }
}
