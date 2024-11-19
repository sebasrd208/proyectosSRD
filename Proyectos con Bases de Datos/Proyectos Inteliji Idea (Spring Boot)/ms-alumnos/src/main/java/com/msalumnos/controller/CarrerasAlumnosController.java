package com.msalumnos.controller;
import java.util.*;
import com.msalumnos.logic.*;
import com.msalumnos.entity.*;
import com.msalumnos.request.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("carreras-alumnos")
public class CarrerasAlumnosController{

    @Autowired
    CarrerasAlumnosLogic carLogic;
    CarrerasAlumnos car;

    @GetMapping("mostrar")
    //http://localhost:8090/carreras-alumnos/mostrar
    public ResponseEntity<List<CarrerasAlumnos>> mostrar(){
        List<CarrerasAlumnos> lista=carLogic.mostrar();
        return new ResponseEntity<List<CarrerasAlumnos>>(lista, HttpStatus.OK);
    }

    @PostMapping("registrar")
    //http://localhost:8090/carreras-alumnos/registrar
    public ResponseEntity<CarrerasAlumnos> registrar(@RequestBody CarrerasAlumnosRequest registro){
        car=carLogic.registrar(registro);
        return new ResponseEntity<CarrerasAlumnos>(car, HttpStatus.OK);
    }

    @PutMapping("editar")
    //http://localhost:8090/carreras-alumnos/editar
    public ResponseEntity<CarrerasAlumnos> editar(@RequestBody CarrerasAlumnosRequest edicion){
        car=carLogic.editar(edicion);
        return new ResponseEntity<CarrerasAlumnos>(car, HttpStatus.OK);
    }

    @GetMapping("buscar/{ID}")
    //http://localhost:8090/carreras-alumnos/buscar/
    public ResponseEntity<CarrerasAlumnos> buscar(@PathVariable int ID){
        car=carLogic.buscar(ID);

        return new ResponseEntity<CarrerasAlumnos>(car, HttpStatus.OK);
    }

    @DeleteMapping("eliminar/{ID}")
    //http://localhost:8090/carreras-alumnos/eliminar/
    public ResponseEntity<String> eliminar(@PathVariable int ID){
        String car=carLogic.eliminar(ID);

        return new ResponseEntity<String>(car, HttpStatus.OK);
    }
}
