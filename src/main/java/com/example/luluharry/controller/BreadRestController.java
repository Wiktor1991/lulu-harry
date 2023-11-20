package com.example.luluharry.controller;

import com.example.luluharry.domain.Bread;
import com.example.luluharry.services.BreadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BreadRestController {

    private final BreadService breadService;

    public BreadRestController(BreadService breadService) {
        this.breadService = breadService;
    }

    @GetMapping("/welcome")
    public String welcome(){

        return "Welcome to harryApp";
    }

    @GetMapping("/all")
    public List<Bread> getAllArticle(){
        return breadService.getAllArticle();
    }
}
