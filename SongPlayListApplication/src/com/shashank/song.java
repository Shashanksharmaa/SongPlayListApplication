package com.shashank;

public class song {
	String title; //name of the song
	double duration; //duration of the song
	
	public song(String name, double duration) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.duration = duration;
	}
	public song() {
		//constructure
	}
	
	public double getDuration() {
		return duration;
	}
	public String getTitle() {
		return title;
	}
	@Override
	//return the property of the class
	//return whatever we have in this class
	public String toString() {
		return "song{" + 
	               "title='" + title + '\'' + 
	               ", duration" + duration + 
	               '}';
	}

	
}
