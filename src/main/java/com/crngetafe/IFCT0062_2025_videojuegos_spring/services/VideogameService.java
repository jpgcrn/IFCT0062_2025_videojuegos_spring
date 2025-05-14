package com.crngetafe.IFCT0062_2025_videojuegos_spring.services;

import com.crngetafe.IFCT0062_2025_videojuegos_spring.model.Videogame;
import com.crngetafe.IFCT0062_2025_videojuegos_spring.repository.IVideogameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideogameService implements IVideogameService {
    @Autowired
    IVideogameRepository videogameRepository;

    @Override
    public List<Videogame> getAll() {
        return videogameRepository.findAll();
    }

    @Override
    public Videogame create(Videogame videogame) {
        return videogameRepository.save(videogame);
    }

    @Override
    public Videogame findById(int id) {
        return videogameRepository.findById(id).orElse(null);
    }

    @Override
    public Videogame update(Videogame videogame) {
        return videogameRepository.save(videogame);
    }

    @Override
    public void delete(int id) {
        videogameRepository.deleteById(id);
    }

    @Override
    public List<String> getAllPlatforms() {
        return videogameRepository.getPlatformNames();
    }

    @Override
    public List<Videogame> findByPlatform(String platform) {
        return videogameRepository.findByPlatform(platform);
    }
}
