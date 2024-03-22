package com.example.demo.service;

import java.util.List;

import com.example.demo.Entity.PlayList;

public interface PlayListService {

	public String addplaylist(PlayList playlist);
	
	public List<PlayList> fetchAllPlaylists();

}
