package com.crngetafe.IFCT0062_2025_videojuegos_spring.repository;

import com.crngetafe.IFCT0062_2025_videojuegos_spring.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenreRepository extends JpaRepository<Genre, Integer> {
}
