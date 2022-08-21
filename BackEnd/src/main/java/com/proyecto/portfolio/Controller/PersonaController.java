package com.proyecto.portfolio.Controller;

import com.proyecto.portfolio.Entity.Persona;
import com.proyecto.portfolio.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// p/ problema CORS policy
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
   // inyeccion de dependencias
    @Autowired 
     private IPersonaService interPersona;
    
    
    
    @GetMapping ("/personas/traer")
    public List<Persona> getPersonas() {
        
        return interPersona.getPersona();
    }
    
    @PostMapping ("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        interPersona.savePersona(persona);
        //si se creó correctamente devuelve un string
        return "La persona ha sido creada correctamente";
    }
    
    @DeleteMapping ("/personas/borrar/{id}") 
    public String deletePersona (@PathVariable Long id) {
    
            interPersona.deletePersona(id);
            //devuelve un string si la eliminación fue exitosa
            return "La persona fue eliminada correctamente"; 
    }
    
    // editar info x id
    @PutMapping ("/personas/editar/{id}")
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
    
    //mi info
    @GetMapping("/personas/traer/info")
    public Persona findPersona() {
    return interPersona.findPersona ((long)1);
    }
}

