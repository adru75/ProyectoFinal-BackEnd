
package com.proyectofinal.adrian.Controller;

import com.proyectofinal.adrian.Entity.skills;
import com.proyectofinal.adrian.Security.Controller.Mensaje;
import com.proyectofinal.adrian.Security.Dto.dtoSkills;
import com.proyectofinal.adrian.Service.SSkills;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/skills")

public class CSkills {

    @Autowired
    SSkills skills;
    
     // LISTAR ################
    @GetMapping("/lista")
    public ResponseEntity<List<skills>> list(){
        List<skills> list = skills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<skills> getById(@PathVariable("id") int id){
        if(!skills.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        skills sKills = skills.getOne(id).get();
        return new ResponseEntity(sKills, HttpStatus.OK);
    }
    
    // BORRAR #####################
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!skills.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe ID"), HttpStatus.BAD_REQUEST);
        }
        skills.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }
        
    // CREAR ##############
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskills) {

        if(StringUtils.isBlank(dtoskills.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(skills.existsByNombre(dtoskills.getNombre()))
            return new ResponseEntity(new Mensaje("La skill ya existe"), HttpStatus.BAD_REQUEST);

        skills sKills = new skills(dtoskills.getNombre(), dtoskills.getPorcentaje());
        skills.save(sKills);
        
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    
    }
    
    // ACTUALIZAR ###############
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskills) {
        if(!skills.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(skills.existsByNombre(dtoskills.getNombre()) && skills.getByNombre(dtoskills.getNombre()).get().getId() != id)    
            return new ResponseEntity(new Mensaje("Skill ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoskills.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        skills sKills = skills.getOne(id).get();
        sKills.setNombre(dtoskills.getNombre());
        sKills.setPorcentaje((dtoskills.getPorcentaje()));
        
        skills.save(sKills);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }
    
    
}
