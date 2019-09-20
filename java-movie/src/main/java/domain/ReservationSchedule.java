package main.java.domain;

import java.time.LocalDateTime;
import static main.java.utils.DateTimeUtils.format;

public class ReservationSchedule {
	 private final LocalDateTime startDateTime;
	 private int capacity;
	 
	public ReservationSchedule(LocalDateTime startDateTime, int capacity) {
		this.startDateTime = startDateTime;
		this.capacity = capacity;
	}
	 
   public LocalDateTime getStartDateTime() {
    	return startDateTime;
    } 
   
   @Override
   public String toString() {
       return "시작시간 : " + format(startDateTime) + "\n예약인원 : " + capacity + "\n";
   }


}
