package com.huynhnam.pma_filmanagement.dao;

import com.huynhnam.pma_filmanagement.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MoviesDAO extends JpaRepository<Movies, Integer> {
}
