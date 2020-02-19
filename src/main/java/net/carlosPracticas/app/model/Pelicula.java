package net.carlosPracticas.app.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "Peliculas")
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment MyQSL
	private int id;
	private String titulo;
	private int duracion;
	private String clasificacion;
	private String genero;
	private String imagen = "cinema.png"; // imagen por default	
	private Date fechaEstreno;	
	private String estatus="Activa";

	//@Transient // ignorar este atributo durante la persistencia.
	@OneToOne
	@JoinColumn(name="idDetalle")
	private Detalle detalle;

	@OneToMany(mappedBy = "pelicula", fetch = FetchType.EAGER)
	private List<Horario> horarios;

	public Pelicula(){

	}
	
	public int getId() {
		return id;
	}

	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Date getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	@Override
	public String toString() {
		return "Pelicula{" +
				"id=" + id +
				", titulo='" + titulo + '\'' +
				", duracion=" + duracion +
				", clasificacion='" + clasificacion + '\'' +
				", genero='" + genero + '\'' +
				", imagen='" + imagen + '\'' +
				", fechaEstreno=" + fechaEstreno +
				", estatus='" + estatus + '\'' +
				", detalle=" + detalle +
				", horarios=" + horarios +
				'}';
	}
}
