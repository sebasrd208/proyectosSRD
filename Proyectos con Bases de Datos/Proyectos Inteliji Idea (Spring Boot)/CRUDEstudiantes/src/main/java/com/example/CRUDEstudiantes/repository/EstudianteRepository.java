package com.example.CRUDEstudiantes.repository;

import org.springframework.data.jpa.repository.*;
import com.example.CRUDEstudiantes.entity.*;
import org.springframework.stereotype.*;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiantes ,Integer>{

}
