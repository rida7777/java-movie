package main.java.domain;

import main.java.utils.DateTimeUtils;

public class ReservationMovie extends Movie {
    private final ReservationSchedule schedule;

	public ReservationMovie(int id, String name, int price, ReservationSchedule schedule) {
		super(id, name, price);
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
        return "���࿵ȭ : " + super.getId() + " - " + super.getName() + ", " + super.getPrice() + "��" + "\n"
                + sb.toString();
    }
   
}
