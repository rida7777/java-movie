package main.java.view;

import java.util.List;

import main.java.domain.Movie;
import main.java.domain.MovieRepository;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
    	System.out.println("## 상영 영화 목록");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

	public static Movie printPlaySchedule(int movieId) {
		Movie selectedMovie = MovieRepository.getPlaySchedule(movieId);
		System.out.println(selectedMovie);
		return selectedMovie;
	}
}