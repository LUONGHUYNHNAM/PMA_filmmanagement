package com.huynhnam.pma_filmanagement.controller;

import com.huynhnam.pma_filmanagement.Service.Cast_membersService;
import com.huynhnam.pma_filmanagement.Service.Movie_castsService;
import com.huynhnam.pma_filmanagement.Service.MoviesService;
import com.huynhnam.pma_filmanagement.entity.CastMembers;
import com.huynhnam.pma_filmanagement.entity.MovieCasts;
import com.huynhnam.pma_filmanagement.entity.MovieCastsId;
import com.huynhnam.pma_filmanagement.entity.Movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/actor")
public class CastController {

    @Autowired
    private Cast_membersService cast_membersService;
    @Autowired
    private MoviesService moviesService;
 
    @Autowired
    private Movie_castsService movieCastsRepository;

    public void saveMovieCasts(Integer movieId, Integer castId) {
        MovieCasts movieCasts = new MovieCasts();
        MovieCastsId movieCastsId = new MovieCastsId();
        movieCastsId.setMovieId(movieId);
        movieCastsId.setCastId(castId);

        movieCasts.setId(movieCastsId);
        movieCasts.setMovie(moviesService.getMovieById(movieId).get());
        movieCasts.setCastMember(cast_membersService.getCastMemberById(castId).get());

        movieCastsRepository.saveMovieCast(movieCasts);
    }

    @GetMapping()
    public String showActorPage(Model model) {
        List<CastMembers> castMembersList = cast_membersService.getAllCastMembers();
      
        model.addAttribute("castMembers", castMembersList);
        return "/admin/actor";
    }


    @PostMapping("/save")
    public String saveCast(@ModelAttribute CastMembers castMember, @RequestParam List<Integer> movies) {

        cast_membersService.saveCastMember(castMember);
        for (Integer movieId : movies) {
            saveMovieCasts(movieId, castMember.getCastId());
        }
        return "redirect:/admin/actor"; 
    }
    @GetMapping("/add")
    public String createCast(Model model) {
        List<Movies> movies = moviesService.getAllMovies();
        model.addAttribute("castMember", new CastMembers());
        model.addAttribute("movies", movies);
        
        return "/admin/actor_edit";
    }


    
    @GetMapping("/edit/{id}")
    public String editCast(@PathVariable Integer id, Model model) {

        Optional<CastMembers> castMember = cast_membersService.getCastMemberById(id);
        
        if (castMember.isEmpty()) {
            return "redirect:/admin/actor"; 
        }
        List<Movies> movies = moviesService.getAllMovies();
        model.addAttribute("castMember", castMember.get()); 
        model.addAttribute("movies", movies);
        
        return "/admin/actor_edit"; 

    }

    @GetMapping("/delete/{id}")
    public String deleteCast(@PathVariable Integer id) {
        Optional<CastMembers> castMember = cast_membersService.getCastMemberById(id);
        if (castMember.isPresent()) {
            cast_membersService.deleteCastMember(id);
        }
        return "redirect:/admin/actor";
    }

}
