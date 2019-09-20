package main.java.view;

import java.util.Scanner;

import main.java.domain.Movie;
import main.java.domain.PlaySchedule;
import main.java.reservation.MovieReservation;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
    	try {
	        System.out.println("## ������ ��ȭ ��ȣ�� �����ϼ���.");
	        return MovieReservation.checkExistList(Integer.parseInt(scanner.nextLine().trim()));
    	} catch(IllegalArgumentException e) {
    		System.out.println("�ùٸ��� ���� �Է��Դϴ�.");
    		// ��ȭ��ȣ�� �ٽ� �Է��ϰ� �ϱ�.
    		return inputMovieId();
    	}
    }

	public static PlaySchedule inputPlaySchedule(Movie selectedMovie) {
		try {
			System.out.println("## ������ �ð�ǥ�� �����ϼ���. (ù��° �� �ð��� 1��)");
			return MovieReservation.checkExistSchedule(selectedMovie, 
					Integer.parseInt(scanner.nextLine().trim()));
		} catch(IllegalArgumentException e) {
			System.out.println("�ùٸ��� ���� �Է��Դϴ�.");
			return inputPlaySchedule(selectedMovie);
		}
	}

	public static int inputReservationPeople(PlaySchedule schedule) {
		try {
			System.out.println("## ������ �ο��� �Է��ϼ���.");
			return schedule.checkValidReservation(Integer.parseInt(scanner.nextLine().trim()));
		} catch (IllegalArgumentException e) {
			System.out.println("�ùٸ��� ���� �Է��Դϴ�.");
			return inputReservationPeople(schedule);
		}
	}

	public static boolean inputContinueReservation() {
		try {
			System.out.println("## ������ �����ϰ� ������ �����Ϸ��� 1��, �߰� ������ �����Ϸ��� 2���� �Է��ϼ���.");
			return checkContinue(Integer.parseInt(scanner.nextLine().trim()));
		} catch (IllegalArgumentException e) {
			System.out.println("�ùٸ��� ���� �Է��Դϴ�.");
			return inputContinueReservation();
		}
	}

	private static boolean checkContinue(int userInput) {
		if(userInput == 1) {
			return false;
		}
		
		if(userInput == 2) {
			return true;
		}
		throw new IllegalArgumentException();
	}

    
    
}