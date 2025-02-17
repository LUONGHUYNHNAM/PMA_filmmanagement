package com.huynhnam.pma_filmanagement.controller;

import com.huynhnam.pma_filmanagement.entity.Movies;
import com.huynhnam.pma_filmanagement.Service.DirectorsService;
import com.huynhnam.pma_filmanagement.Service.MoviesService;
import com.huynhnam.pma_filmanagement.entity.Directors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin/movie")
public class AdminMoviesController {

    @Autowired
    private MoviesService moviesService;

    @Autowired
    private DirectorsService directorsService;

    @GetMapping
    public String listMovies(Model model) {
        model.addAttribute("movies", moviesService.getAllMovies());
        return "/admin/movie";
    }

    @GetMapping("/create")
    public String createMovieForm(Model model) {
        model.addAttribute("movie", new Movies());
        model.addAttribute("directors", directorsService.getAllDirectors());
        return "/admin/movie-form";
    }

    @PostMapping("/save")
    public String saveMovie(@ModelAttribute Movies movie) {
        moviesService.saveMovie(movie);
        return "redirect:/admin/movie";
    }

    @GetMapping("/edit/{id}")
    public String editMovie(@PathVariable Integer id, Model model) {
        Optional<Movies> movie = moviesService.getMovieById(id);
        if (movie.isPresent()) {
            model.addAttribute("movie", movie.get());
            model.addAttribute("directors", directorsService.getAllDirectors());
            return "/admin/movie-form";
        } else {
            return "redirect:/admin/movie";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Integer id) {
        moviesService.deleteMovie(id);
        return "redirect:/admin/movie";
    }
}
