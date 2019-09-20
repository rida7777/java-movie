package main.java;
import java.util.List;

import main.java.domain.Movie;
import main.java.domain.MovieRepository;
import main.java.domain.PlaySchedule;
import main.java.reservation.MovieReservation;
import main.java.reservation.ReservationMain;
import main.java.view.InputView;
import main.java.view.OutputView;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        MovieReservation reservations = new MovieReservation();
        
        do {
        	OutputView.printMovies(movies);
        	ReservationMain.reservationRun(reservations);
        	reservations.printResult();
        } while(InputView.inputContinueReservation());
    }
}