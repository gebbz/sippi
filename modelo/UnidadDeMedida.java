package modelo;

/**
 * Descripción:
 * @version 1.0
 * @author Iuga
 * @cambios
 * @todo
 */

public class UnidadDeMedida {

    private int id;
    private String nombre;
    private String abreviatura;
    
    // Esta unidad de medida {Unidad} tiene que SI O SI tener el ID:
    public static final int ID_UNIDAD_BASE = 1;
    public static final String UNIDAD_BASE_NOMBRE = "Unidad";
    public static final String UNIDAD_BASE_ABREVIATURA = "UN";

    public UnidadDeMedida() {
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
