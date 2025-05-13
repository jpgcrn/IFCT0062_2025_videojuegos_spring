package com.crngetafe.IFCT0062_2025_videojuegos_spring.controller;

import com.crngetafe.IFCT0062_2025_videojuegos_spring.model.Genre;
import com.crngetafe.IFCT0062_2025_videojuegos_spring.model.Videogame;
import com.crngetafe.IFCT0062_2025_videojuegos_spring.services.GenreService;
import com.crngetafe.IFCT0062_2025_videojuegos_spring.services.VideogameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
    private final VideogameService videogameService;
    private final GenreService genreService;

    public AppController(VideogameService videogameService,
                         GenreService genreService) {
        this.videogameService = videogameService;
        this.genreService = genreService;
    }

    @GetMapping("/")
    public String showMain(Model model) {
        List<Videogame> videogames = this.videogameService.getAll();
        model.addAttribute("games", videogames);
        return "index";
    }

    @GetMapping("/create-videogame")
    public String initCreateVideogame(Model model) {
        List<Genre> genres = this.genreService.getAll();

        model.addAttribute("game", new Videogame());
        model.addAttribute("genre", new Genre());
        model.addAttribute("genres", genres);

        return "create_videogame";
    }

    @PostMapping("/videogames")
    public String createVideogame(@ModelAttribute Videogame newVideogame) {
        this.videogameService.create(newVideogame);
        return "redirect:/?message=Juego creado";
    }

    @GetMapping("/delete-videogame")
    public String deleteVideogame(@RequestParam Integer id) {
        this.videogameService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit-videogame/{id}")
    public ModelAndView editVideogame(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("/update");
        Videogame currentVideogame = videogameService.findById(id);
        List<Genre> genres = this.genreService.getAll();

        mav.addObject("game", currentVideogame);
        mav.addObject("genres", genres);

        return mav;
    }

    @PostMapping("/edit-videogame/{id}")
    public String editVideogame(@ModelAttribute Videogame updatedVideogame) {
        this.videogameService.update(updatedVideogame);
        return "redirect:/";
    }
}
