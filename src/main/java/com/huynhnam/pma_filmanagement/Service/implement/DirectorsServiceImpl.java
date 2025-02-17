package com.huynhnam.pma_filmanagement.Service.implement;

import com.huynhnam.pma_filmanagement.dao.DirectorsDAO;
import com.huynhnam.pma_filmanagement.entity.Directors;
import com.huynhnam.pma_filmanagement.Service.DirectorsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorsServiceImpl implements DirectorsService {

    @Autowired
    private DirectorsDAO directorsDAO;

    @Override
    public List<Directors> getAllDirectors() {
        return directorsDAO.findAll();
    }

    @Override
    public Optional<Directors> getDirectorById(Integer id) {
        return directorsDAO.findById(id);
    }

    @Override
    public Directors saveDirector(Directors director) {
        return directorsDAO.save(director);
    }

    @Override
    public Directors updateDirector(Integer id, Directors director) {
        Optional<Directors> existingDirector = directorsDAO.findById(id);
        if (existingDirector.isPresent()) {
            Directors updatedDirector = existingDirector.get();
            updatedDirector.setDirectorName(director.getDirectorName());
            return directorsDAO.save(updatedDirector);
        } else {
            throw new RuntimeException("Director with ID " + id + " not found!");
        }
    }

    @Override
    public void deleteDirector(Integer id) {
        if (directorsDAO.existsById(id)) {
            directorsDAO.deleteById(id);
        } else {
            throw new RuntimeException("Director with ID " + id + " not found!");
        }
    }
}
