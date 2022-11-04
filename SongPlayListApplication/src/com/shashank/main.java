package com.shashank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class main {
	
	private static ArrayList<Album> albums = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Album album = new Album("KkAlbum","KK");
		
		album.addSong("phir mohabbat",3.5);
		album.addSong("mere bina",4.5);
		album.addSong("tum hi ho",5.5);
		album.addSong("teri jhuki nazar",6.5);
		albums.add(album);
		
		album = new Album("Ealbum", "Eminem");
		
		album.addSong("rapgod", 5);
		album.addSong("mockingbird", 6.5);
		album.addSong("When i'm gone", 5.5);
		album.addSong("lose yourself", 4);
		albums.add(album);
		//we have to add this album into ArrayList that we have made for insidal property of object
		
		//Create linkedList for PlayList
		
		 LinkedList<song> playList_1 = new LinkedList<>();
		 
		 //add elements inside this
		 
		 albums.get(0).addToPlaylist("phir mohabbat", playList_1);   
		 albums.get(0).addToPlaylist("mere bina", playList_1); // get 0 means album 1
		 albums.get(1).addToPlaylist("rap god", playList_1); //get 1 means album 2
		 albums.get(1).addToPlaylist("mockingbird", playList_1);
		
		play(playList_1);
	}
	private static void play(LinkedList<song> playList) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<song> listIterator = playList.listIterator();
		if(playList.size() == 0) {
			System.out.println("this playlist have no song");
		}else {
			System.out.println("Now Playing" + listIterator.next().toString());
			printMenu();
		}
		while(!quit) {
			int action = sc.nextInt();
			sc.nextLine();
			
			switch(action) {
			case 0:
				System.out.println("PlayList complete");
				quit = true;
				break;
			case 1:
				if(!forward) {
					if(listIterator.hasNext()) {
						//if next song exist then we have to shift our listiterator to next
						listIterator.next();
					}
					forward = true;
				}
				if(listIterator.hasNext()) {
					System.out.println("Now Playing " + listIterator.next().toString());
				}else {
					System.out.println("No song available : Reached to end of the list");
					forward = false;
				}
				break;
			case 2:
				if(forward) {
					if(listIterator.hasPrevious()) {
						listIterator.previous();
					}
					forward = false;
				}
				if(listIterator.hasPrevious()) {
					System.out.println("Now Playing " + listIterator.previous().toString());
					
				}else {
					System.out.println("We are at first song");
					forward = false;
				}
				break;
			case 3:
				if(forward) {
					if(listIterator.hasPrevious()) {
						System.out.println("Now Playing " + listIterator.previous().toString());
						forward = false;
					}else {
						System.out.println("We are at the start of the list");
					}
				}else {
					if(listIterator.hasNext()) {
						System.out.println("Now Playing " + listIterator.next().toString());
						forward = true;
					}else {
						System.out.println("We have reached to the end of the list");
					}
				}
				break;
			case 4:
				printList(playList);
				break;
			case 5:
				printMenu();
				break;
			case 6:
				if(playList.size() > 0) {
					//then we delete the song from the playlist
					listIterator.remove();
					if(listIterator.hasNext()) {
						System.out.println("Now Playing " + listIterator.next().toString());
//						forward = true;
					}else {
						if(listIterator.hasPrevious()) {
							System.out.println("Now Playing " + listIterator.previous().toString());
						}
					}
				}
			}
		}
		
	}
	private static void printMenu() {
		System.out.println("Available Options\n press"); // we have available options below this;
		System.out.println("0 - to quit\n"
				+ "1 - to play next song\n"
				+ "2 - to play previous song\n"
				+ "3 - to replay the current song\n"
				+ "4 - List of all songs\n"
				+ "5 - print all available options\n"
				+ "6 - to delete current song");
	}
	private static void printList(LinkedList<song> playList) {
		//it iterates throughout the playlist
		//so we need iterator for this
		Iterator<song> iterator = playList.iterator();
		System.out.println("****************");
		while(iterator.hasNext()) {
			System.out.println(iterator.next()); //prints all songs available in the playlist
		}
		System.out.println("****************");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
