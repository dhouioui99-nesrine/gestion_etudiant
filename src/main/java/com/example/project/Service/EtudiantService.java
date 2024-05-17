package com.example.project.Service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.project.Entities.Etudiant;
import com.example.project.Repositories.EtudiantRepository;



@Service
public class EtudiantService {
  
    private EtudiantRepository etudiantRepository;

    @Autowired
    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    public Etudiant ajouterEtudiant(Etudiant etudiant) {
     

        return etudiantRepository.save(etudiant);
    }

    public void validateEtudiant(Etudiant etudiant) {
        if (StringUtils.isBlank(etudiant.getNom()) ||
            StringUtils.isBlank(etudiant.getPrenom()) ||
            StringUtils.isBlank(etudiant.getEmail()) ||
            StringUtils.isBlank(etudiant.getDepartement()) ||
            StringUtils.isBlank(etudiant.getAge()) ||
            StringUtils.isBlank(etudiant.getNote())) {
                throw new IllegalArgumentException("Tous les champs de l'étudiant sont obligatoires.");
        }
    }
}
