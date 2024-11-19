package SpringBoot.controles;

import org.springframework.web.bind.annotation.*;

@RestController
public class Nombres{

    @GetMapping("/letras/{n}")
    public String Palabras(@PathVariable String n){
        String resultado=n.replaceAll("[aeiouAEIOU]", "*");
        System.out.println("Solicitud ejecutada");
        return "Resultado "+resultado;
    }
}
