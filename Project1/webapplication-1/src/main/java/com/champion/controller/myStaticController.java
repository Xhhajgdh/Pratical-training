package com.champion.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class myStaticController {

    @GetMapping("/index")
    public String getData(Model model) {

        return "/index.html";
    }

}
