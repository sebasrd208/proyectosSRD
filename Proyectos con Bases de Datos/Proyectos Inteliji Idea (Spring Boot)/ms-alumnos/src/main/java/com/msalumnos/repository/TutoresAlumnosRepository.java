package com.msalumnos.repository;

import com.msalumnos.entity.TutoresAlumnos;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface TutoresAlumnosRepository extends JpaRepository<TutoresAlumnos, Integer>{

}
