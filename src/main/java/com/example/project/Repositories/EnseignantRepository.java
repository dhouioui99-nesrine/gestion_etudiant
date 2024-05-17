
package com.example.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.Entities.Enseignant;


@Repository
public interface EnseignantRepository extends  JpaRepository <Enseignant , Long> {

}
