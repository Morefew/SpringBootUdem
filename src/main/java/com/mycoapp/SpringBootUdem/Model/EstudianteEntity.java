package com.mycoapp.SpringBootUdem.Model;

public class EstudianteEntity {

    public Long cedula;
    public String nombre;
    public String apellido;

    public EstudianteEntity(Long cedula, String nombre, String apellido, String escuela) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.escuela = escuela;
    }

    public EstudianteEntity(){

    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
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

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String escuela;
}
