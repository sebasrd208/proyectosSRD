package SpringBoot.controles;

import SpringBoot.domain.Productos;
import SpringBoot.service.ProductoService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/productos")
public class ProductosController{

    //ProductoService ririsa=new ProductosServicesImpl();
    @Autowired
    //@Qualifier("listRecursosServicio")
    private ProductoService ririsa;

    @GetMapping
    public ResponseEntity<?> getProductos(){
        List<Productos> mikari=ririsa.ObtenProductos();

        return ResponseEntity.ok(mikari);
    }
}
