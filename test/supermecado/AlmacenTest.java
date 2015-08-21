/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermecado;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Polker
 */
public class AlmacenTest {
    
    public AlmacenTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class Almacen.
     */
    @Test
    public void testAdd_Producto() throws Exception {
        System.out.println("add");
        Producto producto = null;
        Almacen instance = null;
        instance.add(producto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Almacen.
     */
    @Test
    public void testAdd_Empleado() throws Exception {
        System.out.println("add");
        Empleado empleado = null;
        Almacen instance = null;
        instance.add(empleado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Almacen.
     */
    @Test
    public void testAdd_Cliente() throws Exception {
        System.out.println("add");
        Cliente cliente = null;
        Almacen instance = null;
        instance.add(cliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Almacen.
     */
    @Test
    public void testAdd_Compra() throws Exception {
        System.out.println("add");
        Compra compra = null;
        Almacen instance = null;
        instance.add(compra);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarEmpleado method, of class Almacen.
     */
    @Test
    public void testBuscarEmpleado_long() throws Exception {
        System.out.println("BuscarEmpleado");
        long id = 0L;
        Almacen instance = null;
        Empleado expResult = null;
        Empleado result = instance.BuscarEmpleado(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarEmpleado method, of class Almacen.
     */
    @Test
    public void testBuscarEmpleado_String() throws Exception {
        System.out.println("BuscarEmpleado");
        String login = "";
        Almacen instance = null;
        Empleado expResult = null;
        Empleado result = instance.BuscarEmpleado(login);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarCliente method, of class Almacen.
     */
    @Test
    public void testBuscarCliente() throws Exception {
        System.out.println("BuscarCliente");
        long id = 0L;
        Almacen instance = null;
        Cliente expResult = null;
        Cliente result = instance.BuscarCliente(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarProducto method, of class Almacen.
     */
    @Test
    public void testBuscarProducto() throws Exception {
        System.out.println("BuscarProducto");
        String code = "";
        Almacen instance = null;
        Producto expResult = null;
        Producto result = instance.BuscarProducto(code);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarCompra method, of class Almacen.
     */
    @Test
    public void testBuscarCompra() throws Exception {
        System.out.println("BuscarCompra");
        Cliente client = null;
        Date fecha = null;
        Almacen instance = null;
        Compra expResult = null;
        Compra result = instance.BuscarCompra(client, fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Almacen.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Almacen instance = null;
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNIT method, of class Almacen.
     */
    @Test
    public void testGetNIT() {
        System.out.println("getNIT");
        Almacen instance = null;
        String expResult = "";
        String result = instance.getNIT();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
