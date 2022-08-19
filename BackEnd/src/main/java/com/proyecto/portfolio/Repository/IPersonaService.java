
package com.proyecto.portfolio.Repository;

import com.proyecto.portfolio.Entity.Persona;
import java.util.List;



public interface IPersonaService {
    
    //metodo para traer todas las personas
    public List<Persona> getPersona();
    
    //metodo para dar de alta una persona
    public void savePersona (Persona perso);
    
    //metodo para borrar una persona
    public void deletePersona (Long id);
    
    //metodo para encontrar una persona
    public Persona findPersona (Long id);
    
    
    
}
