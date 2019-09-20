package main.java.reservation;

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

	boolean checkVaildSchedule(PlaySchedule schedule) {
		if (!reservations.stream()
				.allMatch(reservation -> reservation.checkTime(schedule))) {
			System.out.println("���� ���� ��ϰ� �ѽð� �̻� ���̰� ���ϴ�.");
			return false;
		}
		return true;
	}

	public void printResult() {
		System.out.println("## ���� ����");
		for (ReservationMovie rservationMovie : reservations) {
			System.out.println(rservationMovie);
		}
	}

	void insertReservation(Movie selectedMovie, PlaySchedule schedule, int reservePeopleNum) {
		reservations.add(new ReservationMovie(selectedMovie.getId(), selectedMovie.getName(), selectedMovie.getPrice(),
                new ReservationSchedule(schedule.getStartDateTime(), reservePeopleNum)));
	}

	public int getPay() {
		int payment = 0;
		for (ReservationMovie reservationMovie : reservations) {
			payment += reservationMovie.getPrice() * reservationMovie.getCapacity();
		}
		return payment;
	}
}
