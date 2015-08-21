/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermecado;

/**
 *
 * @author zeus
 */
public class Cliente {
    
    
    private long identificacion;
    private String nombres;
    private String Apellidos;
    private int puntos=0;

    public Cliente(long identificacion, String nombres, String Apellidos) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.Apellidos = Apellidos;
    }
    
    public void incrementarPuntos(int puntos){
        this.puntos += puntos;
        
    }
    
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public int getPuntos() {
        return puntos;
    }

     @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.identificacion != other.identificacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nombre: "+ nombres + ", Apellidos=" + Apellidos;
    }
    
    
    
    
    
    
}
