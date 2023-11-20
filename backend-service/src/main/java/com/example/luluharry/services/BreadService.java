package com.example.luluharry.services;

import com.example.luluharry.domain.Bread;
import com.example.luluharry.repositories.BreadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreadService {
    private final BreadRepository breadRepository;

    public BreadService(BreadRepository breadRepository) {
        this.breadRepository = breadRepository;
    }


    public List<Bread> getAllArticle() {
        return breadRepository.findAll();
    }

    public Bread addBread(Bread bread) {
        return breadRepository.save(bread);
    }
}
