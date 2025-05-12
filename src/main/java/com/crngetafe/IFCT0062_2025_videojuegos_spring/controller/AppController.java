package com.crngetafe.IFCT0062_2025_videojuegos_spring.controller;

import com.crngetafe.IFCT0062_2025_videojuegos_spring.model.Videogame;
import com.crngetafe.IFCT0062_2025_videojuegos_spring.services.VideogameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {
    private final VideogameService videogameService;

    public AppController(VideogameService videogameService) {
        this.videogameService = videogameService;
    }

    @GetMapping("/")
    public String showMain(Model model) {
        List<Videogame> videogames = this.videogameService.getAll();
        model.addAttribute("games", videogames);
        return "index";
    }

    @GetMapping("/create-videogame")
    public String initCreateVideogame(Model model) {
        model.addAttribute("game", new Videogame());
        return "create_videogame";
    }

    @PostMapping("/videogames")
    public String createVideogame(@ModelAttribute Videogame newVideogame) {
        this.videogameService.create(newVideogame);
        return "index";
    }
}
