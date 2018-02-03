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
        return "views/index";
    }


}
