/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermecado;

import java.util.ArrayList;
import java.util.Date;

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
        this.costoTotal += puntosCompra;
        return puntosCompra;
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

}
