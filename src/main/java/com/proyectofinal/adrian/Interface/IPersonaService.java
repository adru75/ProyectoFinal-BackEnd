
package com.proyectofinal.adrian.Interface;

import com.proyectofinal.adrian.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //lista de personas
    public List<Persona> getPersona();
    
    //guardar un objeto tipo Persona
    public void savePersona(Persona persona);
    
    //eliminar obj x id
    public void deletePersona(Long id);
    
    //buscar por id
    public Persona findPersona(Long id);
}
