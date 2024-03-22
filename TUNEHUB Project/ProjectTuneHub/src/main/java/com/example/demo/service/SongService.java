package com.example.demo.service;

import java.util.List;

import com.example.demo.Entity.Song;

public interface SongService {

	public String addSong(Song song);

	public boolean songExists(String name);

	public List<Song> fetchAllSongs();

	public void updateSong(Song s);

	//public List<Song> accesSong();

	


}
