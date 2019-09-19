package main.java.view;

import java.util.Scanner;

import reservation.MovieReservation;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
    	try {
	        System.out.println("## 예약할 영화 번호를 선택하세요.");
	        return MovieReservation.checkExistList(Integer.parseInt(scanner.nextLine().trim()));
    	} catch(IllegalArgumentException e) {
    		System.out.println("올바르지 않은 입력입니다.");
    		// 영화번호를 다시 입력하게 하기.
    		return inputMovieId();
    	}
    }
}