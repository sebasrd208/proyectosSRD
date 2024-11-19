package com.general;
import java.util.*;

public interface Metodos{
	public String registrar(Object ob);
	public String editar(Object ob);
	public String eliminar(int id);
	public Object buscar(int id);
	public List mostrar();
}