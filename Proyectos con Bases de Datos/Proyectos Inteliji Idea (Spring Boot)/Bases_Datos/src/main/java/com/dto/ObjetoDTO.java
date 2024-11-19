package com.dto;

public class ObjetoDTO{
	private int matricula;
	private String alumno, 
	carrera, grado, materia;
	
	public ObjetoDTO(){
		
	}

	public ObjetoDTO(int matricula, String alumno, String carrera, String grado, String materia) {
		super();
		this.matricula=matricula;
		this.alumno=alumno;
		this.carrera=carrera;
		this.grado=grado;
		this.materia=materia;
	}

	public int getMatricula(){
		return matricula;
	}

	public void setMatricula(int matricula){
		this.matricula=matricula;
	}

	public String getAlumno(){
		return alumno;
	}

	public void setAlumno(String alumno){
		this.alumno=alumno;
	}

	public String getCarrera(){
		return carrera;
	}

	public void setCarrera(String carrera){
		this.carrera=carrera;
	}

	public String getGrado(){
		return grado;
	}

	public void setGrado(String grado){
		this.grado=grado;
	}

	public String getMateria(){
		return materia;
	}

	public void setMateria(String materia){
		this.materia=materia;
	}

	@Override
	public String toString(){
		return "ObjetoDTO [matricula="+matricula+", alumno="+alumno+", carrera="+carrera+", grado="+grado+
			", materia="+materia+"]";
	}	
	
	
}
