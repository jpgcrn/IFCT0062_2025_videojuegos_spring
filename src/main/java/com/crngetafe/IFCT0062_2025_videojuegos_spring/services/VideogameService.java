package com.crngetafe.IFCT0062_2025_videojuegos_spring.services;

import com.crngetafe.IFCT0062_2025_videojuegos_spring.model.Videogame;
import com.crngetafe.IFCT0062_2025_videojuegos_spring.repository.IVideogameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideogameService {
    @Autowired
    IVideogameRepository videogameRepository;

    public List<Videogame> getAll() {
        return videogameRepository.findAll();
    }

    public Videogame create(Videogame videogame) {
        return videogameRepository.save(videogame);
    }
}
