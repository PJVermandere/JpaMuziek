package com.example.jpamuziek.controllers;

import com.example.jpamuziek.services.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
