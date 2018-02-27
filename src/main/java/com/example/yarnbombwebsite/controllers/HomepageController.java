package com.example.yarnbombwebsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("views")

public class HomepageController {

    @RequestMapping(value = "")
    public String index (Model model){
        model.addAttribute("title", "RiverBend YarnBombers");
        model.addAttribute("intro","We help make yarn art happen in the RiverBend area");
        model.addAttribute("signup", "Don't have an account? Create one here to contribute " +
                "to our blog and get email updates on upcoming events.");
        return "views/index";
    }
    @RequestMapping(value = "biography")
    public String displayBiographyPage(Model model) {
        model.addAttribute("title", "About Our Members");
        return "views/biography";
    }


}
