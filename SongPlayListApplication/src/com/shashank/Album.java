package com.shashank;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	private String name; //name of album
	private String artist; //name of artist
	//Array List for the song
	private ArrayList<song> songs;
	
	public Album(String name, String artist) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<song>();
	}
	//Create empty constructor
	//it is always a good practice to have an empty constructor
	public Album() {
		
	}
	
	//return true if song is added successfully
	//return false if not
	
	//find song for use in addsong
	public boolean addSong(String title,double duration) {
		if(findSong(title) == null) {
			//means that it does not exists within our album
			//so we need to add the song in the album
			songs.add(new song(title, duration));
			System.out.println(title + "Successfully added to the list");
			return true;
			
		}else {
			System.out.println("Song with name" + title + "already exists in the album");
			return false;
		}
	}
	private song findSong(String title) {
		//iterate through the loop to check 
		//weather the song named title exists or not
		// for this we are going to use enhanced for loop
		for(song checkedSong : songs) {
			//if whatever title is passed inside this method it will check for equility for title in album
			//means we a song in the song album
			if(checkedSong.getTitle().equals(title)) return checkedSong;	
		}
		//if not exist then null
		return null;
	}
	//now we a functionality to add a song in the playList
	//and that song must exists in the playList(arrayList) that exists in the album
	//trackNumber for each song
    //Maintaining a linkedList for previous and next Track in the playList
	public boolean addToPlaylist(int trackNumber, LinkedList<song> PlayList) {
		
		//As we know index start from 0
		//but trackNumber from 1
		//We need to take care of that 
		int index = trackNumber - 1;
		if(index > 0 && index <= this.songs.size()) {
			PlayList.add(this.songs.get(index));
			return true;
		}
		System.out.println("This album doesn't have the song with trackNumber " + trackNumber);
		return false;
	}
	public boolean addToPlaylist(String title, LinkedList<song> PlayList) {
		for(song checkedSong : this.songs) {
			if(checkedSong.getTitle().equals(title)) {
				PlayList.add(checkedSong);
				return true;
			}
		}
		System.out.println(title + " there is no such song in the album");
		return false;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
