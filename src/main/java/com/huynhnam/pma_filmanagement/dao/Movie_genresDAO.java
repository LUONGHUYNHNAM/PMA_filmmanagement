package com.huynhnam.pma_filmanagement.dao;

import com.huynhnam.pma_filmanagement.entity.MovieGenres;
import com.huynhnam.pma_filmanagement.entity.MovieGenresId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Movie_genresDAO extends JpaRepository<MovieGenres, MovieGenresId> {
   
}
