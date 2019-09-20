package main.java.reservation;

import main.java.domain.Movie;
import main.java.domain.MovieRepository;
import main.java.domain.PlaySchedule;
import main.java.view.InputView;

public class ReservationMain {
	public static MovieReservation reservationRun(MovieReservation reservations) {
		int reservePeopleNum;
		int movieId = InputView.inputMovieId();
	
		Movie selectedMovie = ReservationCreator.inputMovie(movieId);
		PlaySchedule schedule = ReservationCreator.inputSchedule(reservations, selectedMovie);
		reservePeopleNum = ReservationCreator.inputReserveNum(schedule);
		
		reservations.insertReservation(selectedMovie, schedule, reservePeopleNum);
		MovieRepository.reduceCapacity(selectedMovie, schedule, reservePeopleNum);
		return reservations;
	}
}
