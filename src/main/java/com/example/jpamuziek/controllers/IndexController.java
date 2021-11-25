package com.example.jpamuziek.controllers;

import com.example.jpamuziek.exceptions.AlbumNietGevondenException;
import com.example.jpamuziek.records.ScoreFormRecord;
import com.example.jpamuziek.services.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
        MVC.addObject(new ScoreFormRecord(0));
        return MVC;
    }
    @GetMapping("album/{id}/score")
    public ModelAndView scoreWijziging(@PathVariable long id ,@Valid ScoreFormRecord form, Errors errors, RedirectAttributes redirect){
        if (errors.hasErrors()) {
            return new ModelAndView("albumInfo", "album", service.findAlbumById(id));
        }
        try {
            service.wijzigScore(id, form.score());
            redirect.addAttribute("id", id);
            return new ModelAndView("redirect:/album/{id}");
        } catch (AlbumNietGevondenException ex) {
            return new ModelAndView("albumInfo");
        }
    }
}
