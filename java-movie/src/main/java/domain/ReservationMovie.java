package main.java.domain;

import main.java.utils.DateTimeUtils;

public class ReservationMovie {
    private final int id;
    private final String name;
    private final int price;
    private final PlaySchedule schedule;
    
	public ReservationMovie(int id, String name, int price, PlaySchedule schedule) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.schedule = schedule;
	}
    
	// 한시간 안에 시작하는 영화는 예매 못하게 하도록
    public boolean checkTime(PlaySchedule schedule) {
    	return DateTimeUtils.isOneHourWithinRange(this.schedule.getStartDateTime(), 
    			schedule.getStartDateTime());
    }
}
