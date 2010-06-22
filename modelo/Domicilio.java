package modelo;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Proyecto2010_Requerimientos-iuga
//  @ File Name : Domicilio.java
//  @ Date : 14/06/2010
//  @ Author : 
//
//




public class Domicilio {
        private int id;
	private String calle;
	private int numero;
	private int piso;
	private String depto;
	private String codigoPostal;
	private Barrio barrio;
	public void crear() {
	
	}
        public Domicilio()
        {

        }
        public Domicilio(String calleD, int numeroD, int pisoD, String deptoD, String codigoPostalD, Barrio barrioD)
        {
            calle=calleD;
            numero=numeroD;
            piso=pisoD;
            depto=deptoD;
            codigoPostal=codigoPostalD;
            barrio=barrioD;
        }
	
	public void mostrarDomicilio() {
	
	}

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }
	
	
}
