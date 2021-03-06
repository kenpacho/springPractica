package net.carlosPracticas.app.model;


import javax.persistence.*;

@Entity
@Table(name = "Perfiles")
public class Perfil {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cuenta;
    private String perfil;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", cuenta='" + cuenta + '\'' +
                ", perfil='" + perfil + '\'' +
                '}';
    }
}
