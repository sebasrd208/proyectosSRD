package com.entity;
import javax.persistence.*;

@Entity
@Table(name="LIBROS")
public class Libros{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cid_auto")
	@SequenceGenerator(name="cid_auto", sequenceName="LIBROS_SEQ")
	@Column(name="ID_LIBRO", columnDefinition="NUMBER")
	private int ID_Libro;
	@Column(name="TITULO", columnDefinition="NVARCHAR2(50)")
	private String titulo;
	@Column(name="ID_AUTOR", columnDefinition="NUMBER")
	private int ID_Autor;
	@Column(name="COPIAS", columnDefinition="NUMBER")
	private int copias;
	
	public Libros(){
		
	}

	public Libros(int ID_Libro){
		super();
		this.ID_Libro=ID_Libro;
	}

	public int getID_Libro(){
		return ID_Libro;
	}

	public void setID_Libro(int ID_Libro){
		this.ID_Libro=ID_Libro;
	}

	public String getTitulo(){
		return titulo;
	}

	public void setTitulo(String titulo){
		this.titulo=titulo;
	}

	public int getID_Autor(){
		return ID_Autor;
	}

	public void setID_Autor(int ID_Autor){
		this.ID_Autor=ID_Autor;
	}

	public int getCopias(){
		return copias;
	}

	public void setCopias(int copias){
		this.copias=copias;
	}

	@Override
	public String toString(){
		return "Libros{"+
				"ID_Libro: "+ID_Libro+"\n"+
				", titulo: "+titulo+"\n"+
				", ID_Autor: "+ID_Autor+"\n"+
				", copias: "+copias+"\n"+
				"}";
	}
}
