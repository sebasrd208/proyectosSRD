package SpringBoot.controles;
import SpringBoot.domain.Clientes;
import jakarta.servlet.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.*;
import java.util.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private List<Clientes> clientes=new ArrayList<>(Arrays.asList(
            new Clientes(123, "Jesús Ortíz", "JesusFuerzaRegida", "SDK24991"),
            new Clientes(456, "Edwin Cazárez", "EdwinCazGrupoFirme", "BANDA306"),
            new Clientes(789, "Alán Ramirez", "AlanBandaMS", "SRD23452"),
            new Clientes(234, "Fidel Castro", "FidelMarcaRegistrada", "SRC3727")
    ));

    //@GetMapping("clientes")
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Clientes>> getClientes(){

        return ResponseEntity.ok(clientes);

    }

    //@GetMapping("/clientes/{usuario}")
    @RequestMapping(value="/{usuario}", method=RequestMethod.GET)
    public ResponseEntity<?> getCliente(@PathVariable String usuario){
        for(Clientes c: clientes){
            if(c.getUsuario().equalsIgnoreCase(usuario)){
                return ResponseEntity.ok(c);
                //return c;
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado "+usuario);
    }

    /*@GetMapping("/clientes/{ID}")
    public Clientes getCliente(@PathVariable int ID){
        for(Clientes c: clientes){
            if(c.getUsuario().equals(ID)){
                return c;
            }
        }
        return null;
    }*/

     //@PostMapping("/clientes")
    @RequestMapping(method=RequestMethod.POST)
     public ResponseEntity<?> postCliente(@RequestBody Clientes usuario){
        clientes.add(usuario);

        URI mikari= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{usuario}")
                .buildAndExpand(usuario.getUsuario()).toUri();

        //return ResponseEntity.created(mikari).build();
        return ResponseEntity.created(mikari).body(usuario);
        //return ResponseEntity.status(HttpStatus.CREATED).body("Cliente creado exitosamente: "+usuario.getUsuario());
     }


     //@PutMapping
     @RequestMapping(method=RequestMethod.PUT)
     public ResponseEntity<?> modificacion(@RequestBody Clientes costumer){
         for(Clientes s: clientes){
            if(s.getID()==costumer.getID()){
                s.setNombre(costumer.getNombre());
                s.setUsuario(costumer.getUsuario());
                s.setContrasena(costumer.getContrasena());

                return ResponseEntity.ok("Cliente Modificado Exitosamente: "+costumer.getID());
            }
         }
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado: "+costumer.getID());
     }

     //@DeleteMapping("/clientes/{ID}")
     @RequestMapping(value="/{ID}", method=RequestMethod.DELETE)
     public ResponseEntity<?> delete(@PathVariable int ID){
         for(Clientes s: clientes){
             if(s.getID()==ID){
                 clientes.remove(s);

                 return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cliente eliminado exitosamente: "+s.getID());
                 //return s;
             }
         }
         return null;
     }

     //@PatchMapping("/clientes")
     @RequestMapping(method=RequestMethod.PATCH)
     public Clientes modiParcial(Clientes costumers){
         for(Clientes s: clientes){
             if(s.getID()==costumers.getID()){
                 if(costumers.getNombre()!=null){
                    s.setNombre(costumers.getNombre());
                 }
                 if(costumers.getUsuario()!=null){
                    s.setUsuario(costumers.getUsuario());
                 }
                 if(costumers.getContrasena()!=null){
                    s.setContrasena(costumers.getContrasena());
                 }

                 return s;
             }
         }
         return null;
     }
}
