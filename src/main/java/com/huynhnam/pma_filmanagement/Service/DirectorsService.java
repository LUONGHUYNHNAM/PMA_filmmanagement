package com.huynhnam.pma_filmanagement.Service;


import com.huynhnam.pma_filmanagement.entity.Directors;

import java.util.List;
import java.util.Optional;

public interface DirectorsService {
    List<Directors> getAllDirectors();
    Optional<Directors> getDirectorById(Integer id);
    Directors saveDirector(Directors director);
    Directors updateDirector(Integer id, Directors director);
    void deleteDirector(Integer id);
}
