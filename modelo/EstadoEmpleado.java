package modelo;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Proyecto2010_Requerimientos-iuga
//  @ File Name : EstadoEmpleado.java
//  @ Date : 14/06/2010
//  @ Author : Iuga
//
//




public class EstadoEmpleado extends EstadoAbstracto
{

        public EstadoEmpleado()
        {
        
        }

        public EstadoEmpleado(String nom)
        {    
            super();
            super.setNombre(nom);
        }

	public boolean esActivo()
        {
            return false;
	}

        public boolean esBaja()
        {
            return false;
	}
        public boolean darBaja(Empleado tc)
        {
            tc.setHib_flag_estado("modelo.EstadoEmpleadoBaja");
            tc.setEstado(new EstadoEmpleadoBaja());
            return true;
        }

        public boolean darAlta(Empleado tc)
        {
            tc.setHib_flag_estado("modelo.EstadoEmpleadoActivo");
            tc.setEstado(new EstadoEmpleadoActivo());
            return true;
        }
}
