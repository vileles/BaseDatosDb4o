package basedatosdb4o;

import java.io.Serializable;

public class Jefe implements Serializable {
    private String nombre;
    private int edad;
    private int anosEmpresa;
    private Hijo hijo;

    public Jefe(String nombre, int anosEmpresa, int edad, Hijo hijo) {
        this.nombre = nombre;
        this.edad = edad;
        this.anosEmpresa = anosEmpresa;
        this.hijo = hijo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAnosEmpresa() {
        return anosEmpresa;
    }

    public void setAnosEmpresa(int anosEmpresa) {
        this.anosEmpresa = anosEmpresa;
    }

    public Hijo getHijo() {
        return hijo;
    }

    public void setHijo(Hijo hijo) {
        this.hijo = hijo;
    }

    @Override
    public String toString() {
        return "Jefe{" + "nombre=" + nombre + ", edad=" + edad + ", anosEmpresa=" + anosEmpresa + '}';
    }
    
}
