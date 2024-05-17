package com.example.project.Service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Entities.Enseignant;

import com.example.project.Repositories.EnseignantRepository;



@Service
public class EnseignantService {
    

     private EnseignantRepository enseignantRepository;

    @Autowired
    public EnseignantService(EnseignantRepository enseignantRepository) {
        this.enseignantRepository = enseignantRepository;
    }

    public Enseignant ajouterEnseignant(Enseignant enseignant) {
     

        return enseignantRepository.save(enseignant);
    }

    public void validateEnseignant(Enseignant enseignant) {
        if (StringUtils.isBlank(enseignant.getNom()) ||
            StringUtils.isBlank(enseignant.getPrenom()) ||
            StringUtils.isBlank(enseignant.getEmail()) ||
            StringUtils.isBlank(enseignant.getDepartement())) 
             {
                throw new IllegalArgumentException("Tous les champs de l'étudiant sont obligatoires.");
        }
    }
}


