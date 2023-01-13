
package com.proyectofinal.adrian.Service;

import com.proyectofinal.adrian.Entity.skills;
import com.proyectofinal.adrian.Repository.RSkills;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SSkills {
    @Autowired
    RSkills rskill;
    
    public List<skills> list() {
        return rskill.findAll();
    }
    
    public Optional<skills> getOne(int id) {
        return rskill.findById(id);
    }
    
    public Optional<skills> getByNombre(String nombre) {
        return rskill.findByNombre(nombre);
    }
    
    public void save(skills skill) {
        rskill.save(skill);
    }
    
    public void delete(int id){
        rskill.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return rskill.existsById(id);
    }
    
    public boolean existsByNombre(String nombre) {
        return rskill.existsByNombre(nombre);
    }
    
    
}
