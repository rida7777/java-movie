package main.java;
import java.util.List;

import main.java.domain.Movie;
import main.java.domain.MovieRepository;
import main.java.view.InputView;
import main.java.view.OutputView;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();

        // TODO 구현 진행
    }
}