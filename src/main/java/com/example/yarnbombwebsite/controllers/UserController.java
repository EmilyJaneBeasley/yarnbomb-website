package com.example.yarnbombwebsite.controllers;


import com.example.yarnbombwebsite.models.User;
import com.example.yarnbombwebsite.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserDao userDao;



    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute(new User());
        return "/user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user, Errors errors, String verify) {

        if (errors.hasErrors()) {
            model.addAttribute(user);
            return "user/add";
        }

        if (user.getPassword() == null || verify == null) {
            user.setPassword("");
            model.addAttribute("passwordError", "Enter your password and verify it.");
            model.addAttribute(user);
            return "user/add";
        }

        if (!user.getPassword().equals(verify)) {
            user.setPassword("");
            model.addAttribute("passwordError", "Passwords don't match.");
            model.addAttribute(user);
            return "user/add";
        }
        else {
            userDao.save(user);
            model.addAttribute(user);
            return "user/index";

        }

    }

}