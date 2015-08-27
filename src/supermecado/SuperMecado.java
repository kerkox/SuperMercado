
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
        
        Empleado[] worker = {new Empleado(12345, "Fabio", "Mendez", "Fer", "F123"),
                             new Empleado(123, "Esperanza", "Gomez", "Esgo", "gomez123")};
        Producto[] item = { new Producto("001", "RAM 4GB", 90000), 
                            new Producto("002", "RAM 8GB", 180000),
                            new Producto("003", "SDD 256GB", 320000),
                            new Producto("004", "HUB USB", 10000)};
//        DetalleCompra detalle = new DetalleCompra(4,item);
        Cliente[] customer ={ new Cliente(123456789, "Pol", "KER"),
                              new Cliente(12345, "Carlos", "Lara")};
        
        
        for(int x=0; x<worker.length;x++){
            max.add(worker[x]);
        }
            
        for(int x=0; x<customer.length;x++){
            max.add(customer[x]);
        }
        
        for(int x=0; x<item.length;x++){
            max.add(item[x]);
        }
        
        
        
        
        
        Ventana w = new Ventana(max);
        w.setVisible(true);
        
        
        
        }catch(ObjectNotFoundException notFound){
            notFound.printStackTrace();                    
        }catch(Exception error){
            error.printStackTrace();
        }
        
       
       
    }
    
}
