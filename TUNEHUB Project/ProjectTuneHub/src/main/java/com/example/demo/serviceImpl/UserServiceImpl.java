package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repo.UserRepo;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepo userRepo;


	public String addUser(User user) {
		userRepo.save(user);
		return "user added success fully";
	}


	//Logic to check the duplicate enters 
	public boolean emailExists(String email) {
		if(userRepo.findByEmail(email)!=null) {
			return true;
		}
		else {
			return false;
		}
	}


	public boolean validateUser(String email, String password) {
		
		User user=userRepo.findByEmail(email);
		String pwd=user.getPassword();
		if(password.equals(pwd))
		{
			return true;
		}
		else
		{
			return false;
		}
		
//		if(userRepo.findByEmail(email).equals(password))
//		{
//			return true;
//		}
//		else {
//		return false;
//		}
		 
		//another method
		//
	}


	public String getRole(String email) {
		User user=userRepo.findByEmail(email);
		return user.getRole();
	}


	@Override
	public User getUser(String email) {
		
		return userRepo.findByEmail(email);
	}


	@Override
	public void updateUser(User user) {
		userRepo.save(user);
	}


	


}
