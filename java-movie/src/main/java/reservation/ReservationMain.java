package main.java.reservation;

import main.java.domain.Movie;
import main.java.domain.MovieRepository;
import main.java.domain.PlaySchedule;
import main.java.view.InputView;
import main.java.view.OutputView;

public class ReservationMain {
	public static MovieReservation reservationRun(MovieReservation reservations) {
		PlaySchedule schedule;
		int reservePeopleNum;
		int movieId = InputView.inputMovieId();
		Movie selectedMovie = OutputView.printPlaySchedule(movieId);
		do {
			schedule = InputView.inputPlaySchedule(selectedMovie);
		} while(!reservations.checkVaildSchedule(schedule));
		reservePeopleNum = InputView.inputReservationPeople(schedule);
		reservations.insertReservation(selectedMovie, schedule, reservePeopleNum);
		MovieRepository.reduceCapacity(selectedMovie, schedule, reservePeopleNum);
		return reservations;
		
		
	}

}
