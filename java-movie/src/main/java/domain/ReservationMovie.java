package main.java.domain;

import main.java.utils.DateTimeUtils;

public class ReservationMovie {
    private final int id;
    private final String name;
    private final int price;
    private final ReservationSchedule schedule;

	public ReservationMovie(int id, String name, int price, ReservationSchedule schedule) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.schedule = schedule;
	}

	// �ѽð� �ȿ� �����ϴ� ��ȭ�� ���� ���ϰ� �ϵ���
    public boolean checkTime(PlaySchedule schedule) {
    	return DateTimeUtils.isOneHourWithinRange(this.schedule.getStartDateTime(), 
    			schedule.getStartDateTime());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(schedule);
        return "���࿵ȭ : " + id + " - " + name + ", " + price + "��" + "\n"
                + sb.toString();
    }
   
}
