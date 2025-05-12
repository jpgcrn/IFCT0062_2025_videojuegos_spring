package com.crngetafe.IFCT0062_2025_videojuegos_spring.repository;

import com.crngetafe.IFCT0062_2025_videojuegos_spring.model.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVideogameRepository extends JpaRepository<Videogame, Integer> {
}
