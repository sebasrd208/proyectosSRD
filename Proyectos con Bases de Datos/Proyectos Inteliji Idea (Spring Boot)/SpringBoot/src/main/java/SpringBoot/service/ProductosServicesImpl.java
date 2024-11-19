package SpringBoot.service;

import SpringBoot.domain.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.*;
import java.util.*;

@Service//("listRecursosServicio")
@ConditionalOnProperty(name="servidor.productos", havingValue="yuki")
public class ProductosServicesImpl implements ProductoService{
    List<Productos> lista=new ArrayList<>(Arrays.asList(
            new Productos(1, "Yadegal", 40.5, 3),
            new Productos(2, "Debequin-C", 22.5, 6),
            new Productos(3, "Butilhioscina", 25.0, 9),
            new Productos(4, "Loperamida", 22.5, 12)
    ));

    /*public List<Productos> getMisProductos() {
        return lista;
    }*/




    @Override
    public List<Productos> ObtenProductos(){
        return lista;
    }
}
