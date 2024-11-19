package SpringBoot.controles;

import org.springframework.web.bind.annotation.*;

@RestController
public class Pares{
    @GetMapping("/pares/{v}")
    public String P(@PathVariable String v){
        System.out.println("¡Solicitud ejecutada!");
        int s=Integer.parseInt(v);
        if(s%2==0){
            return "El número "+s+" es par";
        }else{
            return "El número "+s+" es impar";
        }
    }
}
