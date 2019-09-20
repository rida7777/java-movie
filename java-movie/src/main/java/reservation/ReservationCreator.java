package main.java.reservation;

import main.java.domain.Movie;
import main.java.domain.PlaySchedule;
import main.java.view.InputView;
import main.java.view.OutputView;

public class ReservationCreator {

	static Movie inputMovie(int movieId) {
		return OutputView.printPlaySchedule(movieId);
	}

	static PlaySchedule inputSchedule(MovieReservation reservations, Movie selectedMovie) {
		PlaySchedule schedule;
		do {
			schedule = InputView.inputPlaySchedule(selectedMovie);
		} while(!reservations.checkVaildSchedule(schedule));
		return schedule; 
	}

	static int inputReserveNum(PlaySchedule schedule) {
		return InputView.inputReservationPeople(schedule);
	}
}
