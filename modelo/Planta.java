package modelo;

//

import java.util.ArrayList;
import java.util.List;

//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Proyecto2010_Requerimientos-iuga
//  @ File Name : Planta.java
//  @ Date : 14/06/2010
//  @ Author : 
//
//




public class Planta {

        private int id;
	private String razonSocial;
	private List telefonos;
	private Domicilio domicilio;
	private ContactoResponsable contacto;

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public ContactoResponsable getContacto() {
        return contacto;
    }

    public void setContacto(ContactoResponsable contacto) {
        this.contacto = contacto;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public List getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List telefono) {
        this.telefonos = telefono;
    }
}
