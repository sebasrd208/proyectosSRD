package com.msalumnos.exception;
import org.springframework.http.*;
import java.time.*;
import java.util.*;

public class ApiErrores {
    private String mensaje;
    private List<String> detalles;
    private HttpStatus status;
    private LocalDateTime timestamp;

    public ApiErrores(String mensaje, List<String> detalles,
                      HttpStatus status, LocalDateTime timestamp) {
        super();
        this.mensaje=mensaje;
        this.detalles=detalles;
        this.status=status;
        this.timestamp=timestamp;
    }

    public String getMensaje(){
        return mensaje;
    }

    public void setMensaje(String mensaje){
        this.mensaje=mensaje;
    }

    public List<String> getDetalles(){
        return detalles;
    }

    public void setDetalles(List<String> detalles){
        this.detalles=detalles;
    }

    public HttpStatus getStatus(){
        return status;
    }

    public void setStatus(HttpStatus status){
        this.status=status;
    }

    public LocalDateTime getTimestamp(){
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp){
        this.timestamp=timestamp;
    }

    @Override
    public String toString(){
        return "ApiErrores{"
                +"mensaje='"+mensaje
                +", detalles="+detalles
                +", status="+status
                +", timestamp="+timestamp+"}";
    }

}