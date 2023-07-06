package edu.videojuego.pojo;

public class Personaje {
    
    private int id;
    private String nombre;
    private int edad;
    private String clase;
    private String pickrate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getPickrate() {
        return pickrate;
    }

    public void setPickrate(String pickrate) {
        this.pickrate = pickrate;
    }

    @Override
    public String toString() {
        return "Personaje [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", clase=" + clase + ", pickrate="
                + pickrate + "]";
    }

    

}
