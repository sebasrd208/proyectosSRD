package com.entity;

import javax.persistence.*;

@Entity //Indica que estamos trabajando con una entidad de una BD
@Table(name= "CLIENTES")
public class Clientes{
	
	@Id //Especifica que es una llave primaria en una BD
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator= "cid_auto")
	@SequenceGenerator(name="cid_auto", sequenceName="CLIENTE_SEC")
	@Column(name= "ID_CLIENTE", columnDefinition= "NUMBER")
	private int ID_Cliente;
	@Column(name= "NOMBRE", columnDefinition= "NVARCHAR2(30)")
	private String nombre;
	@Column(name= "DIRECCION", columnDefinition="NVARCHAR2(50)")
	private String direccion;
	@Column(name= "INE", columnDefinition= "NVARCHAR2(50)")
	private String ine;
	@Column(name= "TELEFONO", columnDefinition= "NVARCHAR2(12)")
	private String telefono;
	
	public Clientes(){}
	
	public Clientes(int id_cliente){
		super();
		this.ID_Cliente = id_cliente;
	}

	public int getID_Cliente(){
		return ID_Cliente;
	}

	public void setID_Cliente(int iD_Cliente){
		this.ID_Cliente=iD_Cliente;
	}

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre){
		this.nombre=nombre;
	}

	public String getDireccion(){
		return direccion;
	}

	public void setDireccion(String direccion){
		this.direccion=direccion;
	}

	public String getIne(){
		return ine;
	}

	public void setIne(String ine){
		this.ine=ine;
	}

	public String getTelefono(){
		return telefono;
	}

	public void setTelefono(String telefono){
		this.telefono=telefono;
	}

	@Override
	public String toString(){
		return "Clientes [IDCliente: "+ID_Cliente+", nombre: "+nombre+", direccion: "+direccion+", ine: "+ine+
				", telefono: "+telefono+"]";
	}
}
