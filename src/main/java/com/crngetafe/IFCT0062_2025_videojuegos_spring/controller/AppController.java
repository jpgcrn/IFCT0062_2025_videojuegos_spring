package com.crngetafe.IFCT0062_2025_videojuegos_spring.controller;

import com.crngetafe.IFCT0062_2025_videojuegos_spring.model.Genre;
import com.crngetafe.IFCT0062_2025_videojuegos_spring.model.Videogame;
import com.crngetafe.IFCT0062_2025_videojuegos_spring.services.IGenreService;
import com.crngetafe.IFCT0062_2025_videojuegos_spring.services.IVideogameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AppController {
    private final IVideogameService videogameService;
    private final IGenreService genreService;

    public AppController(IVideogameService videogameService,
                         IGenreService genreService) {
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

    @GetMapping("/search")
    public String searchVideogame(Model model, @RequestParam(required = false) String platform) {
        List<Videogame> videogameList;
        if (platform == null) {
            videogameList = videogameService.getAll();
        }
        else {
            videogameList = videogameService.findByPlatform(platform);
        }
        List<String> allPlatforms = videogameService.getAllPlatforms();

        model.addAttribute("platforms", allPlatforms);
        model.addAttribute("games", videogameList);

        return "searchByPlatform";
    }
}
