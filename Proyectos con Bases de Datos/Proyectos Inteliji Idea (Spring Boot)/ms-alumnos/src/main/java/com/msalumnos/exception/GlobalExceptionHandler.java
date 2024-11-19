package com.msalumnos.exception;
import org.springframework.http.*;
import org.springframework.http.converter.*;
import org.springframework.web.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;
import org.springframework.web.servlet.mvc.method.annotation.*;
import java.time.*;
import java.util.*;
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        String mensaje=ex.getMessage();
        List<String> detalles=new ArrayList<String>();
        detalles.add("Verbo HTTP no soportado. Verifique el verbo correcto de la petición");

        ApiErrores errores=new ApiErrores(mensaje, detalles, status, LocalDateTime.now());

        return ResponseEntity.status(status).body(errores);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String mensaje=ex.getMessage();
        List<String> detalles=new ArrayList<String>();
        detalles.add("Formato de texto no admitido. Verifique el uso de JSON");

        ApiErrores errores=new ApiErrores(mensaje, detalles, status, LocalDateTime.now());

        return ResponseEntity.status(status).body(errores);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String mensaje=ex.getMessage();
        List<String> detalles=new ArrayList<String>();
        detalles.add("Falta enviar información en el cuerpo/formulario");

        ApiErrores errores=new ApiErrores(mensaje, detalles, status, LocalDateTime.now());

        return ResponseEntity.status(status).body(errores);
    }

    @ExceptionHandler(NoSePuedeEditarException.class)
    public ResponseEntity<Object> handleNoSePuedeEditarException(NoSePuedeEditarException s){
        String mensaje=s.getMessage();
        List<String> detalles=new ArrayList<String>();
        detalles.add("No se puede editar un alumno con status 0");

        ApiErrores errores=new ApiErrores(mensaje, detalles, HttpStatus.BAD_REQUEST, LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
    }
}
