package com.proyecto.portfolio.Interface;

import com.proyecto.portfolio.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //metodo para traer todas las personas
    public List<Persona> getPersona ();
    
    //metodo para guardar una persona
    public void savePersona (Persona persona);
    
    //metodo para borrar una persona x id
    public void deletePersona (Long id);
    
    //metodo para encontrar una persona x id
    public Persona findPersona (Long id);
}
