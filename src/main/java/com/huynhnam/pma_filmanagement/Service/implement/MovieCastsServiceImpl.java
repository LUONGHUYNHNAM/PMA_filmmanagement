package com.huynhnam.pma_filmanagement.Service.implement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huynhnam.pma_filmanagement.dao.MovieCastsDAO;
import com.huynhnam.pma_filmanagement.entity.MovieCasts;
import com.huynhnam.pma_filmanagement.entity.MovieCastsId;
import com.huynhnam.pma_filmanagement.Service.Movie_castsService;

import java.util.List;
import java.util.Optional;

@Service
public class MovieCastsServiceImpl implements Movie_castsService {

    @Autowired
    private MovieCastsDAO movieCastsDAO;

    @Override
    public List<MovieCasts> getAllMovieCasts() {
        return movieCastsDAO.findAll();
    }

    @Override
    public Optional<MovieCasts> getMovieCastById(MovieCastsId id) {
        return movieCastsDAO.findById(id);
    }

    @Override
    public MovieCasts saveMovieCast(MovieCasts movieCast) {
        return movieCastsDAO.save(movieCast);
    }

    @Override
    public void deleteMovieCast(MovieCastsId id) {
        movieCastsDAO.deleteById(id);
    }
}
