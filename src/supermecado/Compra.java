/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermecado;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author zeus
 */
public class Compra {

    private int costoTotal=0;
    private ArrayList<DetalleCompra> detalleCompras = new ArrayList<>();
    private Cliente cliente;
    private Empleado empleado;
    private Date fecha;

    public Compra(int costoTotal, Cliente cliente) {
        this.costoTotal = costoTotal;
        this.cliente = cliente;
    }
    /**
     * Metodo para agregar Detalle de compra
     * @param detalle objeto tipo DetalleCompra
     */
    public void add(DetalleCompra detalle) {
        detalleCompras.add(detalle);
        this.costoTotal += detalle.CostoProducto();
    }
    
    public int puntosCompra(){
        int puntosCompra=0;
        if(costoTotal>=200000){
            puntosCompra= (int) Math.floor(costoTotal/10000.0);
        }
        this.cliente.incrementarPuntos(puntosCompra); //Correccion de asignacion de Puntos
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
    
    /**
     * 
     * @param detalle obejto detalle para buscar un producto en especifico
     * @return
     * @throws Exception Error al no encotrar el producto buscado
     */
    public DetalleCompra buscar(DetalleCompra detalle)throws Exception{
        DetalleCompra detalleFound=null;
        
        for(DetalleCompra detail : this.detalleCompras){
            if(detalle.equals(detail)){
                detalleFound = detail;
                break;
            }
        }
        
        if(detalleFound==null){
            throw new ObjectNotFoundException("Producto: +"+detalle.toString() +" no encontrado");
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
