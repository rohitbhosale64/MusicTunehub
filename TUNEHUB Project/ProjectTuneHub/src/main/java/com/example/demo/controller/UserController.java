package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Song;
import com.example.demo.Entity.User;
import com.example.demo.service.SongService;
import com.example.demo.serviceImpl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserServiceImpl serviceImpl;
	@Autowired
	SongService songService;
	
	@PostMapping("/register")
	public String addUser( @ModelAttribute User user)
	{
		
		//email taken from the registeration from
		String email=user.getEmail();
		//checking if email as entered in registersation form is present int the DB
		boolean status=serviceImpl.emailExists(email);
		if(status==false)
		{
		serviceImpl.addUser(user);
		System.out.println("User is added");
		}
		else {
			System.out.println("User allready Exist");
		}
		return "login";
		

	}
	@PostMapping("/validate")
	public String validate( @RequestParam("email") String email,@RequestParam("password") String password,HttpSession session,Model model)
	{
		if(serviceImpl.validateUser(email,password)==true)
		{
			String role=serviceImpl.getRole(email);
			session.setAttribute("email", email);
			if(role.equals("Admin"))
			{
				return "adminHome";
			}else {
				User user=serviceImpl.getUser(email);
				boolean userstatus=user.isIspremium();
				List<Song> fetchAllSongs=songService.fetchAllSongs();
				model.addAttribute("songs",fetchAllSongs);
				model.addAttribute("ispremium",userstatus);
				return "customerHome";
			}
			
		}
		else
		{
		return "login";
		}
		
		
		 
	}
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "login";
	}
	
	
}
