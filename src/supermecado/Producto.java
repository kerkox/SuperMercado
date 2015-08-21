
package supermecado;

import java.util.Objects;

/**
 *
 * @author zeus
 */
public class Producto {
    
    String codigo;
    String nombre;
    int costoUnitario;

    public Producto(String codigo, String nombre, int costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.costoUnitario = costoUnitario;
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
    public int hashCode() {
        int hash = 7;
        return hash;
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
