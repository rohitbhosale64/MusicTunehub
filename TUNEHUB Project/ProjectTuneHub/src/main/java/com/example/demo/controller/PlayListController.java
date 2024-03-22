package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.PlayList;
import com.example.demo.Entity.Song;
import com.example.demo.service.PlayListService;
import com.example.demo.service.SongService;

@Controller
public class PlayListController {
	@Autowired
	SongService songService;
	@Autowired
	PlayListService playlistservice;
	
	@GetMapping("/createplaylists")
	public String createPlaylists( Model model)
	{
		List<Song> songList=songService.fetchAllSongs();
		model.addAttribute("songs",songList);
		return "createplaylists";
	}
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute PlayList  playlist)
	
	{
		playlistservice.addplaylist(playlist);
		List<Song> songList=playlist.getSongs();
		for(Song s:songList)
		{
			s.getPlaylists().add(playlist);
			songService.updateSong(s);
			
		}
		
		return "adminHome";
		
	}
	@GetMapping("/viewplaylists")
	public String viewplaylists(Model model)
	{
	List<PlayList> allplaylist=	playlistservice.fetchAllPlaylists();
	model.addAttribute("allplaylist", allplaylist);
	
		return "displayplaylist";
	}
	

}
