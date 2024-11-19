package SpringBoot.controles;

import org.springframework.web.bind.annotation.*;

@RestController
public class NumPrimos{
    @GetMapping("/primos/{n}")
    public String NP(@PathVariable String n){
        long e=Integer.parseInt(n);
        System.out.println("Solicitud ejecutada");
        if(e%2==0){
            return "El número "+e+" NO es un primo";
        }else{
            for(long i=3;i<=e;i=+2){
                if(e%i==0){
                    //return "El número "+e+" NO es un primo";
                }
            }
            return "El número "+e+" es un primo";
        }
    }
}
