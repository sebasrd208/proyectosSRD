package com.general;

import java.util.List;

public interface Metodos{
    public List mostrar();
    public Object buscar(int ID);
    public String registrar(Object ob);
    public String editar(Object ob);
    public String eliminar(int ID);

}
