// Punto 3 del taller
package trabajoa.p_punto3;

public class Nodo {
    
    private String nombre, direccion;
    private int cedula;
    Nodo Li, LD;

    public Nodo(String nombre, String direccion, int cedula, Nodo Li, Nodo LD) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cedula = cedula;
        this.Li = Li;
        this.LD = LD;
    }
    
    public Nodo() {
        this.nombre = "";
        this.direccion = "";
        this.cedula = 0;
        this.Li = null;
        this.LD = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public Nodo getLi() {
        return Li;
    }

    public void setLi(Nodo Li) {
        this.Li = Li;
    }

    public Nodo getLD() {
        return LD;
    }

    public void setLD(Nodo LD) {
        this.LD = LD;
    }
    
    
    
}
