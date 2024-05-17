package com.example.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.Entities.Etudiant;

@Repository
public interface EtudiantRepository extends  JpaRepository <Etudiant , Long> {

}
