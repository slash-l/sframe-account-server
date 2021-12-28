package com.sframe.app.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("")
    public String index(Model model) {
//        model.addAttribute("title", "Demo");
//        model.addAttribute("msg", "Welcome to the docker container!");
        return "index";
    }
}
