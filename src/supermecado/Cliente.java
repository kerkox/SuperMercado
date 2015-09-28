/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermecado;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author zeus
 */

@Entity
public class Cliente implements Serializable{
    
    
    @Id
    private long identificacion;
    @Column(nullable = false, length = 100)
    private String nombres;
    @Column(nullable = false, length = 100)
    private String Apellidos;
    @Column
    private int puntos=0;

    public Cliente() {
    }

    public Cliente(long identificacion, String nombres, String Apellidos) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.Apellidos = Apellidos;
    }

    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String Apellidos) {
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
