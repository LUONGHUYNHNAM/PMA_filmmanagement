package com.huynhnam.pma_filmanagement.Service.implement;



import com.huynhnam.pma_filmanagement.dao.MoviesDAO;
import com.huynhnam.pma_filmanagement.entity.Movies;
import com.huynhnam.pma_filmanagement.Service.MoviesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    private MoviesDAO moviesDAO;

    @Override
    public List<Movies> getAllMovies() {
        return moviesDAO.findAll();
    }

    @Override
    public Optional<Movies> getMovieById(Integer movieId) {
        return moviesDAO.findById(movieId);
    }

    @Override
    public Movies saveMovie(Movies movie) {
        return moviesDAO.save(movie);
    }

    @Override
    public void deleteMovie(Integer movieId) {
        moviesDAO.deleteById(movieId);
    }
}
