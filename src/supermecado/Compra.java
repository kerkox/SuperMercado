/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermecado;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author zeus
 */
@Entity
public class Compra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private long id;
    
    @Column
    private int costoTotal = 0;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha = new Date();
    
    @OneToOne
    private Cliente cliente;
    @OneToOne
    private Empleado empleado;
    
    @OneToMany
    private ArrayList<DetalleCompra> detalleCompras = new ArrayList<>();

    public Compra() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCostoTotal(int costoTotal) {
        this.costoTotal = costoTotal;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setDetalleCompras(ArrayList<DetalleCompra> detalleCompras) {
        this.detalleCompras = detalleCompras;
    }

    public long getId() {
        return id;
    }
    
    

    public Compra(Cliente cliente, Empleado vendedor) {

        this.cliente = cliente;
        this.empleado = vendedor;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Metodo para agregar Detalle de compra
     *
     * @param detalle objeto tipo DetalleCompra
     */
    public void add(DetalleCompra detalle) {
        int pos = 0;
        if (this.detalleCompras.contains(detalle)) {

            pos = detalleCompras.indexOf(detalle);
            this.costoTotal -= detalleCompras.get(pos).CostoProducto(); //Se resta el coto del producto que hay
            detalleCompras.get(pos).IncrementarCantidad(detalle.cantidadProductos);
            this.costoTotal += detalleCompras.get(pos).CostoProducto(); //se ajusta al nuevo costo por el cambio de cantidad   
        } else {

            detalleCompras.add(detalle);
            this.costoTotal += detalle.CostoProducto();
        }
    }

    public void remove(DetalleCompra detalle) throws Exception {
        int pos = 0, cantidad = 0;
        if (this.detalleCompras.contains(detalle)) {
            pos = detalleCompras.indexOf(detalle);
            if (this.detalleCompras.size() == 1) {
                this.detalleCompras = new ArrayList<>();
                this.costoTotal = 0;
            } else {
                //aqui se evalua la cantidad de productos a retirar
                cantidad = detalleCompras.get(pos).cantidadProductos;
                if (cantidad > detalle.cantidadProductos) {
                    this.costoTotal -= detalleCompras.get(pos).CostoProducto(); //Se resta el coto del producto que hay
                    detalleCompras.get(pos).DecrementarCantidad(detalle.cantidadProductos);
                    this.costoTotal += detalleCompras.get(pos).CostoProducto(); //se ajusta al nuevo costo por el cambio de cantidad 
                } else if (cantidad == detalle.cantidadProductos) {
                    //aqui se remueve el objeto por completo
                    DetalleCompra detalleCompra = detalleCompras.get(pos);
                    this.detalleCompras.remove(pos);
                    this.costoTotal -= detalleCompra.CostoProducto(); //Se resta el coto del producto que hay
                } else {
                    throw new Exception("Cantidad a devolver invalida");
                }
            }
        } else {
            throw new ObjectNotFoundException("El prodcuto a retirar no se encuentra en la compra");

        }

    }

    public int puntosCompra() {
        int puntosCompra = 0;
        if (costoTotal >= 200000) {
            puntosCompra = (int) Math.floor(costoTotal / 10000.0);
        }
//          Linea eliminada porque los puntos se asignan cuando se registra la venta
        return puntosCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getCostoTotal() {
        return costoTotal;
    }

    public ArrayList<DetalleCompra> getDetalleCompras() {
        return detalleCompras;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     *
     * @param detalle obejto detalle para buscar un producto en especifico
     * @return
     * @throws Exception Error al no encotrar el producto buscado
     */
    public DetalleCompra buscar(DetalleCompra detalle) throws Exception {
        DetalleCompra detalleFound = null;

        for (DetalleCompra detail : this.detalleCompras) {
            if (detalle.equals(detail)) {
                detalleFound = detail;
                break;
            }
        }

        if (detalleFound == null) {
            throw new ObjectNotFoundException("Producto: +" + detalle.toString() + " no encontrado");
        }

        return detalleFound;

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Compra other = (Compra) obj;
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

}
