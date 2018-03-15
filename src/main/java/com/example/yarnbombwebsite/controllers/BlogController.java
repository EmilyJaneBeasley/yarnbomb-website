package com.example.yarnbombwebsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("")
public class BlogController {
    static ArrayList<String> posts = new ArrayList<>();
    @RequestMapping(value="addBlog", method = RequestMethod.GET)
    public String displayAddBlogForm(Model model){

        model.addAttribute("posts", posts);
        model.addAttribute("title", "Blog Posts");
        return "blog/addBlog";
    }
    @RequestMapping(value="addBlog", method = RequestMethod.POST)
    public String processAddBlogForm(@RequestParam String addPost){
        posts.add(addPost);
        return "blog/addBlog";
    }


}
