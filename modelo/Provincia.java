package modelo;

//

import java.util.ArrayList;
import java.util.List;

//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Proyecto2010_Requerimientos-iuga
//  @ File Name : Provincia.java
//  @ Date : 10/06/2010
//  @ Author : 
//
//




public class Provincia {
    private int id;
    private String nombre;
    private List localidades;

    public Provincia() {

        localidades = new ArrayList<Localidad>();
    }

    public void crear() {

    }
    
    public void addLocalidad(Localidad l)
    {
        localidades.add(l);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public List<Localidad> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<Localidad> localidades){
        this.localidades = localidades;
    }

    public void mostrarProvincia() {

    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void mostrarLocalidades() {

    }

    public void buscarProvincia() {

    }

    public void getProvincia() {

    }

    public void mostrarNombresLocalidades() {

    }

    public void esProvincia() {

    }
}
