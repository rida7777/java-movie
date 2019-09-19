package reservation;

import java.util.ArrayList;

import main.java.domain.*;


public class MovieReservation {
	private ArrayList<ReservationMovie> reservations = new ArrayList<>();
	
	// �󿵸�Ͽ� ���� ��ȭ�� ������ ��� ����ó�� 
	public static int checkExistList(int movieId) {
		if(!MovieRepository.contain(movieId)) {
			throw new IllegalArgumentException();
		}
		return movieId;
	}
	
	// ���õ� ��ȭ�� �������� �ִ���
	public static PlaySchedule checkExistSchedule(Movie selectedMovie, int ScheduleId) {
		return selectedMovie.checkVaildSchedule(ScheduleId);
	}

	public boolean checkVaildSchedule(PlaySchedule schedule) {
		return reservations.stream()
				.allMatch(reservation -> reservation.checkTime(schedule));
	}

}
