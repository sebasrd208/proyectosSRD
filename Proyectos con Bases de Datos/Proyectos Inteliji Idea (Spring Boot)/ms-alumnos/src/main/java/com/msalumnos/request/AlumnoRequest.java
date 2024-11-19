package com.msalumnos.request;
import java.time.*;

public class AlumnoRequest{
	private int ID_Alumno;
	private String nombre;
	private LocalDateTime fechaNac;
	private String grado;
	private String genero;
	private String ciudad;
	private int status;
	
	public AlumnoRequest(){
		
	}

	public AlumnoRequest(int ID_Alumno, String nombre, LocalDateTime fechaNac, String grado, String genero,
			String ciudad, int status) {
		super();
		this.ID_Alumno=ID_Alumno;
		this.nombre=nombre;
		this.fechaNac=fechaNac;
		this.grado=grado;
		this.genero=genero;
		this.ciudad=ciudad;
		this.status=status;
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

	public LocalDateTime getfechaNac(){
		return fechaNac;
	}

	public void setfechaNac(LocalDateTime fechaNac){
		this.fechaNac=fechaNac;
	}

	public String getGrado(){
		return grado;
	}

	public void setGrado(String grado){
		this.grado=grado;
	}

	public String getGenero(){
		return genero;
	}

	public void setGenero(String genero){
		this.genero=genero;
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

	@Override
	public String toString(){
		return "AlumnoRequest [ID_Alumno: "+ID_Alumno+" nombre:"+nombre+", Fecha de Nacimiento: "+fechaNac+", grado: "
				+grado+", genero: "+genero+", ciudad: "+ciudad+", status:"+status+"]";
	}
}
