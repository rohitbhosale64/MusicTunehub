package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.PlayList;

public interface PlayListRepo extends JpaRepository<PlayList, Integer> {

	
}
