package com.example.etudiantBack.service;

import com.example.etudiantBack.model.Etudiant;
import com.example.etudiantBack.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EtudiantServiceImp implements EtudiantService{
    @Autowired
    EtudiantRepository agent;

    @Override
    public Etudiant saveorupdate(Etudiant e) {

        return  agent.save(e);
    }


    @Override
    public List<Etudiant> list_etudiant() {
        return agent.findAll();
    }

    @Override
    public Optional<Etudiant> find_etudiant(long id) {
        return agent.findById(id);
    }

    @Override
    public void delete_etudiant(long id) {
        agent.deleteById(id);

    }

}
