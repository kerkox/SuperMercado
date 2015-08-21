/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermecado;

import java.util.Objects;

/**
 *
 * @author zeus
 */
public class DetalleCompra {
    
    int cantidadProductos;
    private Producto producto;

    public DetalleCompra(int cantidadProductos, Producto producto) {
        this.cantidadProductos = cantidadProductos;
        this.producto = producto;
    }

    public int CostoProducto(){
         return this.cantidadProductos * this.producto.costoUnitario;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DetalleCompra other = (DetalleCompra) obj;
        if (this.cantidadProductos != other.cantidadProductos) {
            return false;
        }
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        return true;
    }

 
    

 
    
    
    
    
    
    
}
