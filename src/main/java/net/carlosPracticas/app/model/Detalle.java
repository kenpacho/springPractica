package net.carlosPracticas.app.model;

public class Detalle {
    private int iid;
    private String director;
    private String actores;
    private String sinopsis;
    private String trailer;


    public Detalle(){

    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }



    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    @Override
    public String toString() {
        return "Detalle{" +
                "iid=" + iid +
                ", director='" + director + '\'' +
                ", actores='" + actores + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", trailer='" + trailer + '\'' +
                '}';
    }
}
