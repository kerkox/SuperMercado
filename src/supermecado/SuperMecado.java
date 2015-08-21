
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
        Almacen max = new Almacen("SuperMercado MERCAMAX", "800.456.123-1");
        
        
        
        Ventana w = new Ventana(max);
       w.setVisible(true);
       
    }
    
}
