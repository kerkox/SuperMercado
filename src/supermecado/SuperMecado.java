
package supermecado;

import GUI.Ventana;

/**
 *
 * @author Polker
 */
public class SuperMecado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //Datos Base
        try{
        Almacen max = new Almacen("SuperMercado MERCAMAX", "800.456.123-1");
        
        Empleado worker = new Empleado(12345, "Fabio", "Mendez", "Fer", "F123");
        Producto item = new Producto("001", "RAM 4GB", 90000);
        DetalleCompra detalle = new DetalleCompra(4,item);
        Cliente customer = new Cliente(123456789, "Pol", "KER");
        
        max.add(worker);
        max.add(customer);
        max.add(item);
        
        
        
        Ventana w = new Ventana(max);
        w.setVisible(true);
        }catch(ObjectNotFoundException notFound){
            notFound.printStackTrace();                    
        }catch(Exception error){
            error.printStackTrace();
        }
        
       
       
    }
    
}
