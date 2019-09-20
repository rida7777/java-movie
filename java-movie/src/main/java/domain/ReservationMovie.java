package main.java.domain;

import main.java.utils.DateTimeUtils;

public class ReservationMovie extends Movie {
    private final ReservationSchedule schedule;

	public ReservationMovie(int id, String name, int price, ReservationSchedule schedule) {
		super(id, name, price);
		this.schedule = schedule;
	}

	// 한시간 안에 시작하는 영화는 예매 못하게 하도록
    public boolean checkTime(PlaySchedule schedule) {
    	return DateTimeUtils.isOneHourWithinRange(this.schedule.getStartDateTime(), 
    			schedule.getStartDateTime());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(schedule);
        return "예약영화 : " + super.getId() + " - " + super.getName() + ", " + super.getPrice() + "원" + "\n"
                + sb.toString();
    }
   
}
