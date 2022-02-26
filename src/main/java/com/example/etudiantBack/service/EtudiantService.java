package com.example.etudiantBack.service;

import com.example.etudiantBack.model.Etudiant;

import java.util.List;
import java.util.Optional;

public interface EtudiantService {

    public Etudiant saveorupdate(Etudiant e);
    public List<Etudiant> list_etudiant();
    public Optional<Etudiant> find_etudiant(long id);
    public void delete_etudiant(long id);
}
