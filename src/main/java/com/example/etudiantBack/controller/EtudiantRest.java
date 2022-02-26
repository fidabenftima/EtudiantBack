package com.example.etudiantBack.controller;

import com.example.etudiantBack.model.Etudiant;
import com.example.etudiantBack.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*",allowedHeaders = "*")



public class EtudiantRest {
    @Autowired
    EtudiantService agent;

    @GetMapping("/etudiants")
    public List<Etudiant> list_etudiant(){
        return agent.list_etudiant();
    }
    @PostMapping("/etudiants")
    public  String add_etudiant(@RequestBody Etudiant etudiant){
        agent.saveorupdate(etudiant);
        return "etudiant added with success";
    }
}
