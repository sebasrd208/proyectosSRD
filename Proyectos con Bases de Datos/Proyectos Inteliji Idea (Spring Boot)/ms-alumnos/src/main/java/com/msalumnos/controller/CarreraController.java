package com.msalumnos.controller;
import java.util.*;
import com.msalumnos.logic.*;
import com.msalumnos.entity.*;
import com.msalumnos.request.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("carreras")
public class CarreraController{
    @Autowired
    CarreraLogic carLogic;
    Carreras carrera;

    @GetMapping("mostrar")
    //http://localhost:8090/carreras/mostrar
    public ResponseEntity<List<Carreras>> mostrar(){
        List<Carreras> lista=carLogic.mostrar();
        return new ResponseEntity<List<Carreras>>(lista, HttpStatus.OK);
    }

    @PostMapping("registrar")
    //http://localhost:8090/carreras/registrar
    public ResponseEntity<Carreras> registrar(@RequestBody CarreraRequest registro){
        carrera=carLogic.registrar(registro);
        return new ResponseEntity<Carreras>(carrera, HttpStatus.OK);
    }

    @PutMapping("editar")
    //http://localhost:8090/carreras/editar
    public ResponseEntity<Carreras> editar(@RequestBody CarreraRequest edicion){
        carrera=carLogic.editar(edicion);
        return new ResponseEntity<Carreras>(carrera, HttpStatus.OK);
    }

    @GetMapping("buscar/{ID}")
    //http://localhost:8090/carreras/buscar/
    public ResponseEntity<Carreras> buscar(@PathVariable int ID){
        carrera=carLogic.buscar(ID);

        return new ResponseEntity<Carreras>(carrera, HttpStatus.OK);
    }

    @DeleteMapping("eliminar/{ID}")
    public ResponseEntity<String> eliminar(@PathVariable int ID){
        String car=carLogic.eliminar(ID);

        return new ResponseEntity<String>(car, HttpStatus.OK);
    }
}
