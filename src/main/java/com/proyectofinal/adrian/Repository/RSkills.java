
package com.proyectofinal.adrian.Repository;

import com.proyectofinal.adrian.Entity.skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RSkills extends JpaRepository<skills, Integer> {
    Optional<skills> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
    
}
