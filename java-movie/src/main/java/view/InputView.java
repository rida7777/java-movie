package main.java.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## ������ ��ȭ�� �����ϼ���.");
        return scanner.nextInt();
    }
}