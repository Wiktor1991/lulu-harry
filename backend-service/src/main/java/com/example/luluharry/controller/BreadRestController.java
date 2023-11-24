package com.example.luluharry.controller;

import com.example.luluharry.domain.Bread;
import com.example.luluharry.services.BreadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@Slf4j
public class BreadRestController {

    private final BreadService breadService;

    public BreadRestController(BreadService breadService) {
        this.breadService = breadService;
    }



    @GetMapping("/all")
    public List<Bread> getAllArticle(){
        log.error("Request from frontend has just arrived !");
        return breadService.getAllArticle();
    }

    @PostMapping("/update")
    public ResponseEntity<Bread> orderUpdate(@RequestBody Bread bread){
        log.error("Trying to save new data from frontend" +bread.toString());

        return ResponseEntity.status(200)
                .body(breadService.addBread(bread));
    }
}
