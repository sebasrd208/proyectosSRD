package com.msalumnos.controller;
import java.util.*;
import com.msalumnos.logic.*;
import com.msalumnos.entity.*;
import com.msalumnos.request.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("tutores")
public class TutoresController{

    @Autowired
    TutoresLogic tutorLogic;

    Tutores tutor;

    @GetMapping("mostrar")
    //http://localhost:8090/tutores/mostrar
    public ResponseEntity<List<Tutores>> mostrar(){
        List<Tutores> lista=tutorLogic.mostrar();
        return new ResponseEntity<List<Tutores>>(lista, HttpStatus.OK);
    }

    @PostMapping("registrar")
    //http://localhost:8090/tutores/registrar
    public ResponseEntity<Tutores> registrar(@RequestBody TutoresRequest registro){
        tutor=tutorLogic.registrar(registro);
        return new ResponseEntity<Tutores>(tutor, HttpStatus.OK);
    }

    @PutMapping("editar")
    //http://localhost:8090/tutores/editar
    public ResponseEntity<Tutores> editar(@RequestBody TutoresRequest edicion){
        tutor=tutorLogic.editar(edicion);
        return new ResponseEntity<Tutores>(tutor, HttpStatus.OK);
    }

    @GetMapping("buscar/{ID}")
    //http://localhost:8090/tutores/buscar/
    public ResponseEntity<Tutores> buscar(@PathVariable int ID){
        tutor=tutorLogic.buscar(ID);

        return new ResponseEntity<Tutores>(tutor, HttpStatus.OK);
    }

    @DeleteMapping("eliminar/{ID}")
    public ResponseEntity<String> eliminar(@PathVariable int ID){
        String tutores=tutorLogic.eliminar(ID);

        return new ResponseEntity<String>(tutores, HttpStatus.OK);
    }
}
