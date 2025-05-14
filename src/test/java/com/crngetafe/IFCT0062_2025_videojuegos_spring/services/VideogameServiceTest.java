package com.crngetafe.IFCT0062_2025_videojuegos_spring.services;

import com.crngetafe.IFCT0062_2025_videojuegos_spring.model.Genre;
import com.crngetafe.IFCT0062_2025_videojuegos_spring.model.Videogame;
import com.crngetafe.IFCT0062_2025_videojuegos_spring.repository.IGenreRepository;
import com.crngetafe.IFCT0062_2025_videojuegos_spring.repository.IVideogameRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class VideogameServiceTest {
    @Autowired
    VideogameService videogameService;

    @Autowired
    IGenreRepository genreRepository;

    @Autowired
    IVideogameRepository videogameRepository;

    //@Test
    public void createVideogame() {
        Genre genre = new Genre(
                "Género borrar",
                "Descripción borrar"
        );
        genre = genreRepository.save(genre);
        Videogame vg1 = new Videogame(
                "Borrar",
                "Plataforma",
                true,
                100,
                true,
                genre
        );
        vg1 = videogameService.create(vg1);
        assertNotNull(vg1);
        videogameRepository.delete(vg1);
        genreRepository.delete(genre);
    }

    //@Test
    public void getPlatformNames() {
        List<String> platformNames = videogameService.getAllPlatforms();
        platformNames.forEach(System.out::println);
        assert true;
    }

    @Test
    public void getGamesByPlatform() {
        List<Videogame> vgs = videogameService.findByPlatform("Nintendo Switch");
        vgs.forEach(System.err::println);
        assert true;
    }
}
