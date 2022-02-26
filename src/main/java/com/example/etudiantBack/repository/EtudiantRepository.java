package com.example.etudiantBack.repository;

import com.example.etudiantBack.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RepositoryRestResource

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    public Etudiant findByfirstname(String  firstname);
}
