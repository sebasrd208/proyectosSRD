package SpringBoot.service;

import SpringBoot.domain.Productos;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

import java.io.IOException;
import java.util.List;


//@Primary
@Service//("jsonRecursosServicio")
@ConditionalOnProperty(name="servidor.productos", havingValue="alya")
public class ProductosServiceJSONImpl implements ProductoService{

    @Override
    public List<Productos> ObtenProductos() {
        List<Productos> productos;
        try{
            productos=new ObjectMapper()
                    .readValue(this.getClass().getResourceAsStream("/productos.json"),
                    new TypeReference<List<Productos>>() {});
            return productos;
        }catch(IOException s){
            throw new RuntimeException(s);
        }
    }
}
