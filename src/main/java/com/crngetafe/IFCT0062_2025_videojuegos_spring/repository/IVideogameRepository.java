package com.crngetafe.IFCT0062_2025_videojuegos_spring.repository;

import com.crngetafe.IFCT0062_2025_videojuegos_spring.model.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVideogameRepository extends JpaRepository<Videogame, Integer> {
    @Query("SELECT DISTINCT vg.platform FROM Videogame vg")
    List<String> getPlatformNames();
    // Lo anterior con JPA Query Methods podría ser así (según ChatGPT, no está probado):
    // List<String> findDistinctPlatformBy();

    List<Videogame> findByPlatform(String platform);
}

