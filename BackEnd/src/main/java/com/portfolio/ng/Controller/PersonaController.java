package com.portfolio.ng.Controller;

import com.portfolio.ng.Entity.Persona;
import com.portfolio.ng.Interface.IPersonaService;
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
@CrossOrigin(origins = "http://localhost:4200")

public class PersonaController {
   @Autowired IPersonaService ipersonaService;
   
   @GetMapping("personas/traer")
   public List<Persona> getPersona(){
       return ipersonaService.getPersona();
   }
   
   @PostMapping("/personas/crear")
   public String createPersona(@RequestBody Persona persona){
       ipersonaService.savePersona(persona);
       return "La persona fue creada de manera correcta";
   } 
   
   @DeleteMapping("/personas/borrar/(id)")
   public String deletePersona(@PathVariable Long id){
       ipersonaService.deletePersona(id);
       return "La persona fue eliminada de manera correcta";
   }
   
   @PutMapping("/personas/editar/(id)")
   public Persona editPersona(@PathVariable Long id,
                              @RequestParam("nombre")String nuevoNombre,
                              @RequestParam("apellido")String nuevoApellido,
                              @RequestParam("img") String nuevoImg) {
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        ipersonaService.savePersona(persona);
        return persona;
                              
  }
   
   @GetMapping("/personas/traer/perfil")
   public Persona findPersona(){
       return ipersonaService.findPersona ((long)1);
  
}
   }
