package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.PlayList;
import com.example.demo.Repo.PlayListRepo;
import com.example.demo.service.PlayListService;

@Service
public class PlayListServiceImpl implements PlayListService {

	@Autowired
	PlayListRepo playlistRepo;
	
	@Override
	public String addplaylist(PlayList playlist)
	{
		playlistRepo.save(playlist);
		return null;
	}

	

	@Override
	public List<PlayList> fetchAllPlaylists() {

		List<PlayList> allplaylist=playlistRepo.findAll();
		return allplaylist;
	}
	
	
}
