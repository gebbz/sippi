package modelo;

//

import java.util.ArrayList;

//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Proyecto2010_Requerimientos-iuga
//  @ File Name : Localidad.java
//  @ Date : 10/06/2010
//  @ Author : 
//
//

public class Localidad {
    private int id;
    private String nombre;
    private ArrayList<Barrio> barrios;

    public Localidad() {
    }

    public void crear() {

    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public void mostrarLocalidad() {

    }

    public ArrayList<Barrio> getBarrios() {
        return this.barrios;
    }

    public void setBarrios(ArrayList<Barrio> barrios){
        this.barrios = barrios;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void buscarLocalidad() {

    }

    public void getLocalidad() {

    }

    public void mostrarNombresBarrios() {

    }


    public void esLocalidad() {

    }
}
