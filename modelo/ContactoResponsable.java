package modelo;
import java.util.List;


//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Proyecto2010_Requerimientos-iuga
//  @ File Name : ContactoResponsable.java
//  @ Date : 14/06/2010
//  @ Author : Iuga
//
//

public class ContactoResponsable {
	private int id;
	private String nombre;
        private String apellido;
	private List<Telefono> telefonos;
        private String email;
        private RolContactoResponsable rol;
        private String cuil;

    public ContactoResponsable() {
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public RolContactoResponsable getRol() {
        return rol;
    }

    public void setRol(RolContactoResponsable rol) {
        this.rol = rol;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public void crear() {

    }

    public void mostrarContactoEmpresa() {

    }

    public void getContacto() {

    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return apellido + ", " + nombre;
    }
    
    
}
