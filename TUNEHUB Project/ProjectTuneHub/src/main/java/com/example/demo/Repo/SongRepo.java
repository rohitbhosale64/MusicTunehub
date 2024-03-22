package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Song;

public interface SongRepo extends JpaRepository<Song, Integer> {

	public Song findByName(String name);

}
