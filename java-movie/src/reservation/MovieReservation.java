package reservation;

import java.util.ArrayList;

import main.java.domain.*;


public class MovieReservation {
	private ArrayList<ReservationMovie> reservations = new ArrayList<>();
	
	// 상영목록에 없는 영화를 선택한 경우 예외처리 
	public static int checkExistList(int movieId) {
		if(!MovieRepository.contain(movieId)) {
			throw new IllegalArgumentException();
		}
		return movieId;
	}
	
	// 선택된 영화의 스케줄이 있는지
	public static PlaySchedule checkExistSchedule(Movie selectedMovie, int ScheduleId) {
		return selectedMovie.checkVaildSchedule(ScheduleId);
	}

	public boolean checkVaildSchedule(PlaySchedule schedule) {
		return reservations.stream()
				.allMatch(reservation -> reservation.checkTime(schedule));
	}

}
