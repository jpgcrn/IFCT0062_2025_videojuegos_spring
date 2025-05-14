package com.crngetafe.IFCT0062_2025_videojuegos_spring.services;

import com.crngetafe.IFCT0062_2025_videojuegos_spring.model.Genre;
import com.crngetafe.IFCT0062_2025_videojuegos_spring.repository.IGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService implements IGenreService {
    @Autowired
    IGenreRepository genreRepository;

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }
}
