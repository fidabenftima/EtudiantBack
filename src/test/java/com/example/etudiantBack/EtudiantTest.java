package com.example.etudiantBack;

import com.example.etudiantBack.model.Etudiant;
import com.example.etudiantBack.repository.EtudiantRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class EtudiantTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private EtudiantRepository repository;

    @Test
    @Rollback(false)
    @Order(1)
    public void testCreateEtudiant() {
        entityManager.persist(new Etudiant("fida", "benftima"));

        Etudiant etudiant = repository.findByfirstname("fida");

        assertThat(etudiant.getFirstname()).isEqualTo("fida");
    }
    @Test
    @Order(2)
    public void testFindProductByName() {
        Etudiant product = repository.findByfirstname("fida");
        assertThat(product.getFirstname().equals("fida"));
    }
    @Test
    @Order(3)
    public void testListEtudiants() {
        List<Etudiant> etudiants = (List<Etudiant>) repository.findAll();
        assertThat(etudiants).size().isGreaterThan(0);
    }
    @Test
    @Rollback(false)
    @Order(4)
    public void testUpdateEtudiant() {
        Etudiant etudiant = repository.findByfirstname("fida");
        etudiant.setLastname("benftima");

        repository.save(etudiant);

        Etudiant updatedEtudiant = repository.findByfirstname("fida");

        assertThat(updatedEtudiant.getLastname().equals("benftima"));
    }
    @Test
    @Rollback(false)
    @Order(5)
    public void testDeleteEtudiant() {
        Etudiant etudiant = repository.findByfirstname("fida");

        repository.deleteById(etudiant.getId());

        Etudiant deletedEtudiant = repository.findByfirstname("fida");

        assertThat(deletedEtudiant).isNull();

    }

}
