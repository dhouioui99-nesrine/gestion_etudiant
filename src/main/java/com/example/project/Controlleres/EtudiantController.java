package com.example.project.Controlleres;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import com.example.project.Entities.Etudiant;
import com.example.project.Repositories.EtudiantRepository;
import com.example.project.Service.EtudiantService;


import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController

@RequestMapping("/etudiant")
@CrossOrigin(origins = "*")
public class EtudiantController {

    private EtudiantService etudiantService;

    private EtudiantRepository etudiantRepository;

    public EtudiantController(EtudiantService etudiantService, EtudiantRepository etudiantRepository) {
        this.etudiantService = etudiantService;
        this.etudiantRepository = etudiantRepository;
    }

    

    @PostMapping("/add")
    public ResponseEntity<Etudiant> ajouterEtudiant( @RequestBody Etudiant etudiant) {
        Etudiant ajouterEtudiant = etudiantService.ajouterEtudiant(etudiant);
        return new ResponseEntity<>(ajouterEtudiant, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @DeleteMapping("{id}")
    public void deleteEtudiant(@PathVariable long id){
        etudiantRepository.deleteById(id);
    }

   
    @PutMapping("path/{id}")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant , @PathVariable long id){
        Etudiant etudiant2 = etudiantRepository.findById(id).orElse(null);
        etudiant2.setAge(etudiant.getAge());
        etudiant2.setDepartement(etudiant.getDepartement());
        etudiant2.setEmail(etudiant.getEmail());
        etudiant2.setNom(etudiant.getNom());
        etudiant2.setPrenom(etudiant.getPrenom());
        etudiant2.setNote(etudiant.getNote());
        return etudiantRepository.save(etudiant2);
    }

}