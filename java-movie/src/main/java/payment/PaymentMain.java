package main.java.payment;

import main.java.domain.ResultPay;
import main.java.reservation.MovieReservation;
import main.java.view.InputView;
import main.java.view.OutputView;

public class PaymentMain {

	public static void paymentrun(MovieReservation reservations) {
		OutputView.paymentStart();
		ResultPay resultPay;
		int point = InputView.inputPoint();
		int payment = reservations.getPay();
		int paymentMethod = InputView.selectPaymentMethod();
		
		resultPay = new ResultPay(payment, point, paymentMethod);
		resultPay.printResult();
	}
}
