package main.java;
import java.util.List;

import main.java.domain.Movie;
import main.java.domain.MovieRepository;
import main.java.domain.PlaySchedule;
import main.java.view.InputView;
import main.java.view.OutputView;
import reservation.MovieReservation;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        MovieReservation reservations = new MovieReservation();
        PlaySchedule schedule;
        
        OutputView.printMovies(movies);
        int movieId = InputView.inputMovieId();

        Movie selectedMovie = OutputView.printPlaySchedule(movieId);
        do {
        	schedule = InputView.inputPlaySchedule(selectedMovie);
        } while(!reservations.checkVaildSchedule(schedule));
    }
}