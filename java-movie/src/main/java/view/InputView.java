package main.java.view;

import java.util.Scanner;

import reservation.MovieReservation;

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
}