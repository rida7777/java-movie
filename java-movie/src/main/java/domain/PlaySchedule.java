package main.java.domain;

import static main.java.utils.DateTimeUtils.format;

import java.time.LocalDateTime;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }
    
    public LocalDateTime getStartDateTime() {
    	return startDateTime;
    }

    @Override
    public String toString() {
        return "���۽ð�: " + format(startDateTime) + " ���డ���ο�: " + capacity + "\n";
    }
}