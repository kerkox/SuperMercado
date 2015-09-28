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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author zeus
 */
@Entity

public class DetalleCompra implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private long id;
    
    @Column
    int cantidadProductos;
    @OneToOne
    private Producto producto;

    public DetalleCompra() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    
    
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

    public Producto getProducto() {
        return producto;
    }
    
    public void IncrementarCantidad(int cant){
        this.cantidadProductos +=cant;
    }
    
    public void DecrementarCantidad(int cant){
        this.cantidadProductos -=cant;
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
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        return true;
    }

    

 
    

 
    
    
    
    
    
    
}
