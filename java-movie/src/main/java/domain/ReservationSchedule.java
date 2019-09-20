package main.java.domain;

import java.time.LocalDateTime;
import static main.java.utils.DateTimeUtils.format;

public class ReservationSchedule extends PlaySchedule {
	 
   public ReservationSchedule(LocalDateTime startDateTime, int capacity) {
		super(startDateTime, capacity);
	}

   
   @Override
   public String toString() {
       return "���۽ð� : " + format(super.getStartDateTime()) + "\n�����ο� : " + super.getCapacity()+ "\n";
   }


}
