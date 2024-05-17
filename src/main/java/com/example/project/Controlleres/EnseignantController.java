package com.example.project.Controlleres;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.project.Entities.Enseignant;
import com.example.project.Repositories.EnseignantRepository;
import com.example.project.Service.EnseignantService;

@RestController

@RequestMapping("/enseignant")
@CrossOrigin(origins = "*")
public class EnseignantController {
    
    private EnseignantService  enseignantService;

    private EnseignantRepository enseignantRepository;

    

    

    public EnseignantController(EnseignantService enseignantService, EnseignantRepository enseignantRepository) {
        this.enseignantService = enseignantService;
        this.enseignantRepository = enseignantRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<Enseignant> ajouterEnseignant( @RequestBody Enseignant enseignant) {
        Enseignant ajouterEnseignant = enseignantService.ajouterEnseignant(enseignant);
        return new ResponseEntity<>(ajouterEnseignant, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }

    @DeleteMapping("{id}")
    public void deleteEnseignant(@PathVariable long id){
        enseignantRepository.deleteById(id);
    }

   
    @PutMapping("path/{id}")
    public Enseignant updateEnseignant(@RequestBody Enseignant Enseignant , @PathVariable long id){
        Enseignant enseignant2 = enseignantRepository.findById(id).orElse(null);
        
        enseignant2.setDepartement(Enseignant.getDepartement());
        enseignant2.setEmail(Enseignant.getEmail());
        enseignant2.setNom(Enseignant.getNom());
        enseignant2.setPrenom(Enseignant.getPrenom());
    
        return enseignantRepository.save(enseignant2);
    }

}
