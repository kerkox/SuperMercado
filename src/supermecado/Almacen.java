/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermecado;

import java.util.ArrayList;

/**
 *
 * @author zeus
 */
public class Almacen {

    private String nombre;
    private long NIT;
    private ArrayList<Producto> productos = new ArrayList<>();
    private ArrayList<Empleado> empleados = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Compra> compras = new ArrayList<>();

    public Almacen(String nombre, long NIT) {
        this.nombre = nombre;
        this.NIT = NIT;
    }

    
    //*******************************    
    // Agregado de obejtos a las listas correspondientes
    
    public void add(Producto producto) {
        productos.add(producto);

    }

    public void add(Empleado empleado) {
        empleados.add(empleado);

    }

    public void add(Cliente cliente) {
        clientes.add(cliente);

    }
    
    public void add(Compra compra) {
        compras.add(compra);

    }
    
    
    //*******************************    
    
    
    public String getNombre() {
        return nombre;
    }

    public long getNIT() {
        return NIT;
    }

}
