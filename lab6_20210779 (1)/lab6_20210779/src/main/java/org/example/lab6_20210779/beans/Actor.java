package org.example.lab6_20210779.beans;

public class Actor {
    private int id;
    private String nombre;
    private String apellido;
    private int anioNacimiento;
    private boolean ganador;

    public int getIdActor() {
        return id;
    }

    public void setIdActor(int idActor) {
        this.id = idActor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public boolean isGanador() {
        return ganador;
    }
    public void setGanador(boolean ganador) {
        this.ganador = ganador;
    }
}