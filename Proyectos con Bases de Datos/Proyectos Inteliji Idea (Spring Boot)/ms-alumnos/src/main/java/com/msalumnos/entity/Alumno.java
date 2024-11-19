package com.msalumnos.entity;
import java.io.*;
import java.time.*;
import javax.persistence.*;

@Entity
@Table(name="ESTUDIANTES")
public class Alumno implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aid_auto")
	@SequenceGenerator(name="aid_auto", sequenceName="ESTUDIANTES_SEQ", allocationSize=1)
	@Column(name="ID_ALUMNO", columnDefinition="NUMBER")
	private int ID_Alumno;
	@Column(name="NOMBRE", columnDefinition="NVARCHAR(50)")
	private String nombre;
	@Column(name="FEC_NACIMIENTO", columnDefinition="DATE")
	private LocalDateTime fechaNac;
	@Column(name="GENERO", columnDefinition="NVARCHAR(20)")
	private String genero;
	@Column(name="GRADO", columnDefinition="NVARCHAR(30)")
	private String grado;
	@Column(name="CIUDAD", columnDefinition="NVARCHAR(50)")
	private String ciudad;
	@Column(name="ESTADO", columnDefinition="NUMBER")
	private int status;

	public Alumno(){
		
	}
	
	public Alumno(int IDAlumno){
		super();
		this.ID_Alumno=IDAlumno;
	}

	public int getID_Alumno(){
		return ID_Alumno;
	}

	public void setID_Alumno(int ID_Alumno){
		this.ID_Alumno=ID_Alumno;
	}

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre){
		this.nombre=nombre;
	}

	public LocalDateTime getFechaNac(){
		return fechaNac;
	}

	public void setFechaNac(LocalDateTime fechaNac){
		this.fechaNac=fechaNac;
	}

	public String getGenero(){
		return genero;
	}

	public void setGenero(String genero){
		this.genero=genero;
	}

	public String getGrado(){
		return grado;
	}

	public void setGrado(String grado){
		this.grado=grado;
	}

	public String getCiudad(){
		return ciudad;
	}

	public void setCiudad(String ciudad){
		this.ciudad=ciudad;
	}

	public int getStatus(){
		return status;
	}

	public void setStatus(int status){
		this.status=status;
	}

	public static long getSerialversionuid(){
		return serialVersionUID;
	}
}