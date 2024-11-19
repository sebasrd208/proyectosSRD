package com.msalumnos.controller;
import java.util.*;
import com.msalumnos.logic.*;
import com.msalumnos.entity.*;
import com.msalumnos.request.*;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("alumnos")
public class AlumnoController{
    @Autowired
    AlumnoLogic alumno;
    Alumno estudiante;

    @GetMapping("mostrar")
    //http://localhost:8090/alumnos/mostrar
    public ResponseEntity<List<Alumno>> mostrar(){
        List<Alumno> lista=alumno.mostrar();
        return new ResponseEntity<List<Alumno>>(lista, HttpStatus.OK);
    }

    @PostMapping("registrar")
    //http://localhost:8090/alumnos/registrar
    public ResponseEntity<Alumno> registrar(@RequestBody AlumnoRequest registro){
        estudiante=alumno.registrar(registro);
        return new ResponseEntity<Alumno>(estudiante, HttpStatus.OK);
    }

    @PutMapping("editar")
    //http://localhost:8090/alumnos/editar
    public ResponseEntity<Alumno> editar(@RequestBody AlumnoRequest edicion){
        estudiante=alumno.editar(edicion);
        return new ResponseEntity<Alumno>(estudiante, HttpStatus.OK);
    }

    @GetMapping("buscar/{ID}")
    //http://localhost:8090/alumnos/buscar/
    public ResponseEntity<Alumno> buscar(@PathVariable int ID){
        estudiante=alumno.buscar(ID);

        return new ResponseEntity<Alumno>(estudiante, HttpStatus.OK);
    }

    @DeleteMapping("eliminar/{ID}")
    public ResponseEntity<String> eliminar(@PathVariable int ID){
        String estudiante=alumno.eliminar(ID);

        return new ResponseEntity<String>(estudiante, HttpStatus.OK);
    }

    @PatchMapping("inactivar/{ID}")
    //http://localhost:8090/alumnos/inactivar/
    public ResponseEntity<String> inactivar(@PathVariable int ID){
        String estudiante=alumno.inactivar(ID);

        return new ResponseEntity<String>(estudiante, HttpStatus.OK);
    }
}
