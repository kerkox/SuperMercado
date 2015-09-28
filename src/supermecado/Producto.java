
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
public class Producto implements Serializable{
    
    @Id
    String codigo;
    @Column(nullable = false, length = 100)
    String nombre;
    @Column(nullable = false) 
    int costoUnitario;

    public Producto() {
    }

    public Producto(String codigo, String nombre, int costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.costoUnitario = costoUnitario;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    public void setCostoUnitario(int costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCostoUnitario() {
        return costoUnitario;
    }

  

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

   

    

    @Override
    public String toString() {
        return "codigo = " + codigo + ", nombre = " + nombre;
    }
    
    
    
    
    
}
