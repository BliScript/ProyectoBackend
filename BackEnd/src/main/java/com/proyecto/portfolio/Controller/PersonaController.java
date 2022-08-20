package com.proyecto.portfolio.Controller;

import com.proyecto.portfolio.Entity.Persona;
import com.proyecto.portfolio.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @Autowired IPersonaService interPersona;
    
    
    
    @GetMapping ("/Personas/traer")
    public List<Persona> getPersonas() {
        
        return interPersona.getPersona();
    }
    
    @PostMapping ("/Personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        interPersona.savePersona(persona);
        //si se creó correctamente devuelve un string
        return "La persona ha sido creada correctamente";
    }
    
    @DeleteMapping ("/Personas/borrar/{id}") 
    public String deletePersona (@PathVariable Long id) {
    
            interPersona.deletePersona(id);
            //devuelve un string si la eliminación fue exitosa
            return "La persona fue eliminada correctamente"; 
    }
    
    // editar info x id
    @PutMapping ("/Personas/editar/{id}")
    public Persona editPersona (@PathVariable Long id, 
                                                  @RequestParam ("nombre") String nuevoNombre,
                                                  @RequestParam ("apellido") String nuevoApellido) {
    //buscar la persona
    Persona persona = interPersona.findPersona(id);
    
    persona.setApellido(nuevoApellido);
    persona.setNombre(nuevoNombre);
    
    interPersona.savePersona(persona);
    //retorna la nueva persona
        return persona;
    }
    
}
