package com.ssafy.java;

public class MovieMgr {
	private static Movie[] movies = new Movie[100];
	private int index=0;
	
	public void add(Movie m) {
		movies[index]=m;
		index++;
	}
	public Movie[] search() {
		return movies;
	}
	public Movie[] search(String title) {
		int count=0;
		for(int i=0;i<index;i++) {
			if(movies[i].getTitle().contains(title)) {
				count++;
			}
		}
		Movie[] m=new Movie[count];
		count=0;
		for(int i=0;i<index;i++) {
			if(movies[i].getTitle().contains(title)) {
				m[count++]=movies[i];
			}
		}
		return m;
	}
	public Movie[] searchDirector(String name) {
		int count=0;
		for(int i=0;i<index;i++) {
			if(movies[i].getDirector().equals(name)) {
				count++;
			}
		}
		Movie[] m=new Movie[count];
		count=0;
		for(int i=0;i<index;i++) {
			if(movies[i].getDirector().equals(name)) {
				m[count++]=movies[i];
			}
		}
		return m;
	}
	public Movie[] searchGenre(String genre) {
		int count=0;
		for(int i=0;i<index;i++) {
			if(movies[i].getGenre().equals(genre)) {
				count++;
			}
		}
		Movie[] m=new Movie[count];
		count=0;
		for(int i=0;i<index;i++) {
			if(movies[i].getGenre().equals(genre)) {
				m[count++]=movies[i];
			}
		}
		return m;
	}
	public void delete(String title){
		int tmpIndex=-1;
		for(int i=0;i<index-1;i++) {
			if(movies[i].getTitle().equals(title)) {
				tmpIndex=i;
				break;
			}
		}
		if(tmpIndex>=0) {
			for(int i=tmpIndex;i<index-1;i++) {
				movies[i]=movies[i+1];
			}
			index--;
		}
	}
	public int size() {
		return index;
	}
}
