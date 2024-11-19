package com.msalumnos.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import com.msalumnos.entity.*;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	
}
