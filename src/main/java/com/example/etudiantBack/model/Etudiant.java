package com.example.etudiantBack.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="etudiants")

public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private  String lastname;
    public Etudiant(String firstname, String lastname){
        this.firstname= firstname;
        this.lastname= lastname;
    }
    public Etudiant(){

    }
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id=id;
    }
    public String getFirstname(){
        return firstname;
    }
    public void setFirstname(String firstname){
        this.firstname=firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public void setLastname(String  lastname){
        this.lastname=lastname;
    }
}
