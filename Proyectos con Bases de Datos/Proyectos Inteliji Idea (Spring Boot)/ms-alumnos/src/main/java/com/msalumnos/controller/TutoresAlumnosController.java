package com.msalumnos.controller;
import java.util.*;
import com.msalumnos.logic.*;
import com.msalumnos.entity.*;
import com.msalumnos.request.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("tutores-alumnos")
public class TutoresAlumnosController{

    @Autowired
    TutoresAlumnosLogic tutorLogic;

    TutoresAlumnos tutor;

    @GetMapping("mostrar")
    //http://localhost:8090/tutores-alumnos/mostrar
    public ResponseEntity<List<TutoresAlumnos>> mostrar(){
        List<TutoresAlumnos> lista=tutorLogic.mostrar();
        return new ResponseEntity<List<TutoresAlumnos>>(lista, HttpStatus.OK);
    }

    @PostMapping("registrar")
    //http://localhost:8090/tutores-alumnos/registrar
    public ResponseEntity<TutoresAlumnos> registrar(@RequestBody TutoresAlumnosRequest registro){
        tutor=tutorLogic.registrar(registro);
        return new ResponseEntity<TutoresAlumnos>(tutor, HttpStatus.OK);
    }

    @PutMapping("editar")
    //http://localhost:8090/tutores-alumnos/editar
    public ResponseEntity<TutoresAlumnos> editar(@RequestBody TutoresAlumnosRequest edicion){
        tutor=tutorLogic.editar(edicion);
        return new ResponseEntity<TutoresAlumnos>(tutor, HttpStatus.OK);
    }

    @GetMapping("buscar/{ID}")
    //http://localhost:8090/tutores-alumnos/buscar/
    public ResponseEntity<TutoresAlumnos> buscar(@PathVariable int ID){
        tutor=tutorLogic.buscar(ID);

        return new ResponseEntity<TutoresAlumnos>(tutor, HttpStatus.OK);
    }

    @DeleteMapping("eliminar/{ID}")
    public ResponseEntity<String> eliminar(@PathVariable int ID){
        String tutores=tutorLogic.eliminar(ID);

        return new ResponseEntity<String>(tutores, HttpStatus.OK);
    }
}
