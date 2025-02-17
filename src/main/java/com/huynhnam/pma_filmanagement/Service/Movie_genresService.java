package com.huynhnam.pma_filmanagement.Service;
import com.huynhnam.pma_filmanagement.entity.MovieGenres;
import com.huynhnam.pma_filmanagement.entity.MovieGenresId;

import java.util.List;
import java.util.Optional;

public interface Movie_genresService {
	 
		    List<MovieGenres> getAllMovieGenres();
		    Optional<MovieGenres> getMovieGenreById(MovieGenresId id);
		    MovieGenres saveMovieGenre(MovieGenres movieGenre);
		    void deleteMovieGenre(MovieGenresId id);
}
