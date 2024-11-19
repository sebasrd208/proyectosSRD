package com.msalumnos.repository;
import com.msalumnos.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface CarreraRepository extends JpaRepository<Carreras, Integer>{

}
