package main.java.domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private static final char NEW_LINE = '\n';

    private final int id;
    private final String name;
    private final int price;

    private List<PlaySchedule> playSchedules = new ArrayList<>();

    public Movie(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    } 
    
    // private 필드 값을 얻어가게 하기 위해서 getter 세팅
    public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	void addPlaySchedule(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }
	
	//존재하는 영화인지 검증 : movie class에 들어 있는 영화 id와 사용자가 입력한 movieId가 일치하는지 확인
    boolean contains(int movieId) {
    	return this.id == movieId;
    }

    //선택된 영화의 스케줄이 있는지 확인
	public PlaySchedule checkVaildSchedule(int scheduleId) {
		try {
			//get : 스케줄번호에서-1한 "인덱스" 위치에 있는 값 리턴
			return playSchedules.get(scheduleId - 1); 
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalArgumentException();
		}
	}
	
	void reduceCapacity(PlaySchedule schedule, int reservePeopleNum) {
		if(playSchedules.get(playSchedules.indexOf(schedule)).reduce(reservePeopleNum)) {
			playSchedules.remove(playSchedules.indexOf(schedule));
		}
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlaySchedule playSchedule : playSchedules) {
            sb.append(playSchedule);
        }
        return id + " - " + name + ", " + price + "원" + NEW_LINE
                + sb.toString();
    }
}