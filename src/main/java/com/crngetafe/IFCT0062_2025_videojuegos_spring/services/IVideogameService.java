package com.crngetafe.IFCT0062_2025_videojuegos_spring.services;

import com.crngetafe.IFCT0062_2025_videojuegos_spring.model.Videogame;

import java.util.List;

public interface IVideogameService {
    List<Videogame> getAll();

    Videogame create(Videogame videogame);

    Videogame findById(int id);

    Videogame update(Videogame videogame);

    void delete(int id);

    List<String> getAllPlatforms();

    List<Videogame> findByPlatform(String platform);
}
