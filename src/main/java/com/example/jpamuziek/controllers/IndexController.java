package com.example.jpamuziek.controllers;

import com.example.jpamuziek.services.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {
    private final AlbumService service;

    public IndexController(AlbumService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView indexController(){
        var MVC = new ModelAndView("index", "albums", service.getAllAlbums());
        return MVC;
    }
    @GetMapping("/album/{id}")
    public ModelAndView albumInfo(@PathVariable long id){
        var MVC = new ModelAndView("albumInfo", "album", service.findAlbumById(id));
        return MVC;
    }
}
