package net.carlosPracticas.app.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Horarios")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date fecha;
    private String hora;
    private String sala;
    private double precio;

    //@Transient
    @ManyToOne
    @JoinColumn(name="idPelicula")
    private Pelicula pelicula;


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
        return pelicula;
    }

    public void setPelicuala(Pelicula pelicuala) {
        this.pelicula = pelicuala;
    }


    @Override
    public String toString() {
        return "Horario{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", hora='" + hora + '\'' +
                ", sala='" + sala + '\'' +
                ", precio=" + precio +
                ", pelicula=" + pelicula +
                '}';
    }
}
