package main.java.reservation;

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

	boolean checkVaildSchedule(PlaySchedule schedule) {
		if (!reservations.stream()
				.allMatch(reservation -> reservation.checkTime(schedule))) {
			System.out.println("1시간 이내의 영화는 예매 불가능합니다.");
			return false;
		}
		return true;
	}

	public void printResult() {
		for (ReservationMovie rservationMovie : reservations) {
			System.out.println("## 예약 정보\n" + rservationMovie);
		}
	}

	void insertReservation(Movie selectedMovie, PlaySchedule schedule, int reservePeopleNum) {
		reservations.add(new ReservationMovie(selectedMovie.getId(), selectedMovie.getName(), selectedMovie.getPrice(),
                new ReservationSchedule(schedule.getStartDateTime(), reservePeopleNum)));
	}

}
