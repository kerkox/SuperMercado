/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermecado;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistence.ClienteJpaController;
import persistence.CompraJpaController;
import persistence.DetalleCompraJpaController;
import persistence.EmpleadoJpaController;
import persistence.ProductoJpaController;

/**
 *
 * @author zeus
 */
public class Almacen {

    private String nombre;
    private String NIT;
    private List<Producto> productos = new ArrayList<>();
    private List<Empleado> empleados = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Compra> compras = new ArrayList<>();
    public Empleado logueado;
    public boolean log = false;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuperMecadoPU");

    private EmpleadoJpaController empleadoJpa = new EmpleadoJpaController(emf);
    private ClienteJpaController clienteJpa = new ClienteJpaController(emf);
    private CompraJpaController compraJpa = new CompraJpaController(emf);
    private DetalleCompraJpaController detalleJpa = new DetalleCompraJpaController(emf);
    private ProductoJpaController productoJpa = new ProductoJpaController(emf);

    
    public Almacen(String nombre, String NIT) {
        this.nombre = nombre;
        this.NIT = NIT;
    }

    public void registrar(Compra compra){
        compraJpa.create(compra);
    }
    public boolean Logueo(String user, char[] pass) throws Exception {

        Empleado worker = empleadoJpa.findEmpleado(user);
        String checker = "", passOk = worker.getPassword();
        for (int x = 0; x < pass.length; x++) {
            checker += pass[x] + "";
        }

        if (passOk.equals(checker)) {
            log = true;
            this.logueado = worker;
        }

        return log;
    }

    public List<Compra> getCompras() {

        return compraJpa.findCompraEntities();
    }

/**
 * 
    
//*******************************    
    // Agregado de obejtos a las listas correspondientes
//    public void add(Producto producto) throws Exception {
//        if (productos.contains(producto)) {
//            throw new Exception("Ya esta registrado este producto: " + producto.toString());
//        }
//        productos.add(producto);
//
//    }
//
//    public void add(Empleado empleado) throws Exception {
//        if (empleados.contains(empleado)) {
//            throw new Exception("El empleado: " + empleado.toString() + " ya esta Registrado");
//        }
//        empleados.add(empleado);
//
//    }
//
//    public void add(Cliente cliente) throws Exception {
//        if (clientes.contains(cliente)) {
//            throw new Exception("El cliente: " + cliente.toString() + " Ya esta registrado");
//        }
//        clientes.add(cliente);
//
//    }
//
//    public void add(Compra compra) throws Exception {
//        if (compras.contains(compra)) {
//            throw new Exception("La compra ya esta registrada");
//        }
//        compras.add(compra);
//
//    }

    //Fin metodos de agregado
    //*******************************    
    
    */
    public List<Empleado> getEmpleados() {
        return empleadoJpa.findEmpleadoEntities();
    }

    //******************************
    // Metodos de Busqueda
    /**
     * Busca en la lista de empleado por numero de identificacion
     *
     * @param id del empleado a buscar
     * @return
     * @throws ObjectNotFoundException
     */
//    public Empleado BuscarEmpleado(long id) throws ObjectNotFoundException {
//
//        return new Empleado();
//
//    }

//    public Empleado BuscarEmpleado(String login) throws ObjectNotFoundException {
//        Empleado employee = null;
//        for (Empleado worker : empleados) {
//            if (worker.getLogin().equals(login)) {
//                employee = worker;
//            }
//        }
//        if (employee == null) {
//            throw new ObjectNotFoundException("login: " + login + " invalido");
//        }
//
//        return employee;
//
//    }

    /**
     * busca el cliente en la lista de clientes por identificacion
     *
     * @param id
     * @return el Cliente que encuentra
     * @throws ObjectNotFoundException
     */
    public Cliente BuscarCliente(long id) throws ObjectNotFoundException {
        return clienteJpa.findCliente(id);

    }

    /**
     * Busca un producto por su codigo
     *
     * @param code
     * @return
     * @throws ObjectNotFoundException
     */
    public Producto BuscarProducto(String code) throws ObjectNotFoundException {
        Producto item = null;
        item = productoJpa.findProducto(code);
//        for (Producto product : productos) {
//            if (product.getCodigo().equalsIgnoreCase(code)) {
//                item = product;
//            }
//        }
        if (item == null) {
            throw new ObjectNotFoundException("Producto con codigo: " + code + " no encontrado");
        }

        return item;

    }

    public Compra BuscarCompra(Cliente client, Date fecha) throws ObjectNotFoundException {
        Compra buy = null;
        for (Compra purchase : compras) {
            if (purchase.getCliente().equals(client) && (purchase.getFecha().equals(fecha))) {
                buy = purchase;
            }
        }
        if (buy == null) {
            throw new ObjectNotFoundException("Compra del cliente: " + client.toString() + " en la fecha: " + fecha.toString() + " no encontrado");
        }

        return buy;

    }

    //******************************
    public String getNombre() {
        return nombre;
    }

    public String getNIT() {
        return NIT;
    }

}
