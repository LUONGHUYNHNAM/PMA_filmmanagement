package com.huynhnam.pma_filmanagement.Service.implement;

import com.huynhnam.pma_filmanagement.dao.GenresDAO;
import com.huynhnam.pma_filmanagement.entity.Genres;
import com.huynhnam.pma_filmanagement.Service.GenresService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenresServiceImpl implements GenresService {

    @Autowired
    private GenresDAO genresDAO;

    @Override
    public List<Genres> getAllGenres() {
        return genresDAO.findAll();
    }

    @Override
    public Optional<Genres> getGenreById(Integer id) {
        return genresDAO.findById(id);
    }

    @Override
    public Genres saveGenre(Genres genre) {
        return genresDAO.save(genre);
    }

    @Override
    public Genres updateGenre(Integer id, Genres genre) {
        Optional<Genres> existingGenre = genresDAO.findById(id);
        if (existingGenre.isPresent()) {
            Genres updatedGenre = existingGenre.get();
            updatedGenre.setGenreName(genre.getGenreName());
            return genresDAO.save(updatedGenre);
        } else {
            throw new RuntimeException("Genre with ID " + id + " not found!");
        }
    }

    @Override
    public void deleteGenre(Integer id) {
        if (genresDAO.existsById(id)) {
            genresDAO.deleteById(id);
        } else {
            throw new RuntimeException("Genre with ID " + id + " not found!");
        }
    }
}
