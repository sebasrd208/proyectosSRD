package com.entity;
import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name="PRESTAMOS")
public class Prestamos{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cid_auto")
    @SequenceGenerator(name="cid_auto", sequenceName="PRESTAMOS_SEQ")
    @Column(name="ID_PRESTAMOS", columnDefinition="NUMBER")
    private int id_prestamo;
    @Column(name="ID_LIBRO", columnDefinition="NUMBER")
    private int id_libro;
    @Column(name="ID_SOCIO", columnDefinition="NUMBER")
    private int id_socio;
    @Column(name="FEC_PRESTAMO", columnDefinition="DATE")
    private Date fec_prestamo;
    @Column(name="FEC_DEVOLUCION", columnDefinition="DATE")
    private Date fec_devolucion;

    public Prestamos(){

    }

    public Prestamos(int id_prestamo, int id_libro, int id_socio, Date fec_prestamo, Date fec_devolucion){
        super();
        this.id_prestamo=id_prestamo;
        this.id_libro=id_libro;
        this.id_socio=id_socio;
        this.fec_prestamo=fec_prestamo;
        this.fec_devolucion=fec_devolucion;
    }

    public int getId_prestamo(){
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo){
        this.id_prestamo=id_prestamo;
    }

    public int getId_libro(){
        return id_libro;
    }

    public void setId_libro(int id_libro){
        this.id_libro=id_libro;
    }

    public int getId_socio(){
        return id_socio;
    }

    public void setId_socio(int id_socio){
        this.id_socio=id_socio;
    }

    public Date getFec_prestamo(){
        return fec_prestamo;
    }

    public void setFec_prestamo(Date fec_prestamo){
        this.fec_prestamo=fec_prestamo;
    }

    public Date getFec_devolucion(){
        return fec_devolucion;
    }

    public void setFec_devolucion(Date fec_devolucion){
        this.fec_devolucion=fec_devolucion;
    }

    @Override
    public String toString(){
        return "Prestamos{"+
                "id_prestamo: "+id_prestamo+"\n"+
                ", id_libro: "+id_libro+"\n"+
                ", id_socio: "+id_socio+"\n"+
                ", fec_prestamo: "+fec_prestamo+"\n"+
                ", fec_devolucion: "+fec_devolucion+"\n"+
                "}";
    }
}
