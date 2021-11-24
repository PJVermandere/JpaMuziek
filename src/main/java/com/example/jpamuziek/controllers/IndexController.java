package com.example.jpamuziek.controllers;

import net.bytebuddy.matcher.StringMatcher;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public ModelAndView indexController(){
        var MVC = new ModelAndView("index");
        return MVC;
    }
}
