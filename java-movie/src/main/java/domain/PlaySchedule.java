package main.java.domain;

import static main.java.utils.DateTimeUtils.format;

import java.time.LocalDateTime;

public class PlaySchedule {
	private static final int MIN_RESERVATION_NUM = 0;
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }
    
    public LocalDateTime getStartDateTime() {
    	return startDateTime;
    }
    
    
    public int checkValidReservation(int reservePeopleNum) {
    	if((this.capacity >= reservePeopleNum) &&
    			(reservePeopleNum > MIN_RESERVATION_NUM)) {
    		return reservePeopleNum;
    	}
    	throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return "시작시간 : " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }

	void reduce(int reservePeopleNum) {
		capacity -= reservePeopleNum;
	}
}