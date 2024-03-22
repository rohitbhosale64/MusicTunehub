package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Song;
import com.example.demo.Repo.SongRepo;
import com.example.demo.service.SongService;


@Service
public class SongServiceImpl implements SongService {

	@Autowired
	SongRepo songRepo;
	@Override
	public 	String addSong(Song song)
	{
		songRepo.save(song);
		return "added succesfully";
	}

	@Override
	public boolean songExists(String name)
	{
		Song song=songRepo.findByName(name);
		if(song==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public List<Song> fetchAllSongs()
	{
		List<Song> songs=songRepo.findAll();
		
		return songs;
	}

	@Override
	public void updateSong(Song s) {
		songRepo.save(s);
	}
	
//	public List<Song> accesSong()
//	{
//		List<Song> ss=songRepo.findAll();
//		return ss;
//	}


}
