package net.carlosPracticas.app.model;
import java.util.Date;

public class Horario {

    private int id;
    private Date fecha;
    private String hora;
    private String sala;
    private double precio;
    private Pelicula pelicuala;


    public Horario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Pelicula getPelicuala() {
        return pelicuala;
    }

    public void setPelicuala(Pelicula pelicuala) {
        this.pelicuala = pelicuala;
    }


    @Override
    public String toString() {
        return "Horario{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", hora='" + hora + '\'' +
                ", sala='" + sala + '\'' +
                ", precio=" + precio +
                ", pelicuala=" + pelicuala +
                '}';
    }
}
