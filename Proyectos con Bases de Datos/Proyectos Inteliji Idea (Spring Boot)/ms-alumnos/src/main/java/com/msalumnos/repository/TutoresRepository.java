package com.msalumnos.repository;
import com.msalumnos.entity.Tutores;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface TutoresRepository extends JpaRepository<Tutores, Integer>{

}
