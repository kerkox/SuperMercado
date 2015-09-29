/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermecado;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author zeus
 */
@Entity
public class Empleado implements Serializable {
    
    @Id
    long identificacion;
    @Column(nullable =  false, length = 100)
    String nombres;
    @Column(nullable =  false, length = 100)
    String apellidos;
    @Column(nullable =  false, length = 20)
    String login;
    @Column(nullable =  false, length = 20)
    String password;

    public Empleado() {
    }

    public Empleado(long identificacion, String nombres, String apellidos, String login, String password) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.login = login;
        this.password = password;
    }

    
    
    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    
    
    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    
    public long getIdentificacion() {
        return identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getLogin() {
        return login;
    }

   
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if ((this.identificacion != other.identificacion)&&(!Objects.equals(this.login, other.login))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "nombres=" + nombres + ", apellidos=" + apellidos ;
    }
    
    

   
    
    
    
    
}
