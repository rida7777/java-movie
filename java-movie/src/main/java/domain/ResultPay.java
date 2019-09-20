package main.java.domain;

public class ResultPay {
	private static final int CARD = 1;
	private static final int MONEY = 2;
	private static final double CARD_RATIO = 0.95;
	private static final double MONEY_RATIO = 0.98;
	private static final int MIN_POINT = 0;
	int payment;
	int point;
	int paymentMethod;
	
	public ResultPay(int payment, int point, int paymentMehod) {
		this.paymentMethod = paymentMehod;
		this.point = point;
		if (paymentMethod == CARD) {
			this.payment = (int) (payment * CARD_RATIO) - point ;
		}	
		if (paymentMethod == MONEY) {
			this.payment = (int) (payment * MONEY_RATIO) - point ;
		}
		if (this.payment < 0) {
			this.payment = 0;
		}
	}

	public static int checkPoint(int point) {
		if (point < MIN_POINT) {
			throw new IllegalArgumentException();
		}
		return point;
	}

	public static int checkPaymentMethod(int paymentMethod) {
		if (paymentMethod == CARD || paymentMethod == MONEY) {
			return paymentMethod;
		}
		throw new IllegalArgumentException();
	}

	public void printResult() {
		System.out.println("## ���Ű� �Ϸ�Ǿ����ϴ�.\n > ���� ���� �ݾ� : " + payment + "��");
		System.out.println("\n## ��ſ� ��ȭ �����Ǽ���.");
	}
}
