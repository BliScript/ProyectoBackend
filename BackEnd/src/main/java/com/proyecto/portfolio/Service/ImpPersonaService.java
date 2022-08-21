
package com.proyecto.portfolio.Service;

import com.proyecto.portfolio.Entity.Persona;
import com.proyecto.portfolio.Interface.IPersonaService;
import com.proyecto.portfolio.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService {
   
    @Autowired 
    public IPersonaRepository personaRepository;
    
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> listaPersonas = personaRepository.findAll();
        return listaPersonas; 
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
       Persona persona = personaRepository.findById(id) .orElse(null);
       return persona;
    }
    
}
