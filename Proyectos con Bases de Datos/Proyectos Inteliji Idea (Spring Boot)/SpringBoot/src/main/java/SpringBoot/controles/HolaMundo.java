package SpringBoot.controles;

import org.springframework.web.bind.annotation.*;

@RestController
public class HolaMundo{

    @GetMapping("/hola")
    public String Saludos(){
        return "¡Que onda!";

    }
}

