package com.showtimehub.booking.repository;

import com.showtimehub.booking.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryMovieRepository implements StaticMovieRepository {
    private List<Movie> movies = new ArrayList<>();

    @Override
    public List<Movie> findAll() {
        return new ArrayList<>(movies);
    }

    @Override
    public List<Movie> findByTitle(String title) {
        return movies.stream()
                .filter(movie -> movie.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    @Override
    public void save(Movie movie) {
        movies.add(movie);
    }

	@Override
	public List<Movie> findByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}
}