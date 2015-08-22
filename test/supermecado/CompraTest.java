/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermecado;

import java.awt.BorderLayout;
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
public class CompraTest {
    
    private Producto item = new Producto("001", "RAM 4GB", 90000);
    private DetalleCompra detalle = new DetalleCompra(4,item);
    private Cliente customer = new Cliente(123456789, "Pol", "KER");
    private Compra instance = new Compra(customer);
    private Date fecha = new Date();
        
    public CompraTest() {
        instance.add(detalle);
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
     * Test of add method, of class Compra.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        try{
//        DetalleCompra detalle = null;
//        Compra instance = new Compra(customer);
        instance.add(detalle);
        }catch(Exception error){
        // TODO review the generated test code and remove the default call to fail.
            error.printStackTrace();
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of puntosCompra method, of class Compra.
     */
    @Test
    public void testPuntosCompra() {
        System.out.println("puntosCompra");
        try{
//        Compra instance = null;
        int expResult = 36;
        int result = instance.puntosCompra();
        assertEquals(expResult, result);
        }catch(Exception error){
        error.printStackTrace();
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getCliente method, of class Compra.
     */
    @Test
    public void testGetCliente() {
        System.out.println("getCliente");
        try{
        Cliente expResult = customer;
        Cliente result = instance.getCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        }catch(Exception error){
            error.printStackTrace();
            fail("The test case is a prototype.");
        }
        
    }

    /**
     * Test of getFecha method, of class Compra.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        try{
//        Compra instance = null;
        Date expResult = fecha;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
    }catch(Exception error){
            error.printStackTrace();
        fail("The test case is a prototype.");
    }
        
        
    }

    /**
     * Test of getCostoTotal method, of class Compra.
     */
    @Test
    public void testGetCostoTotal() {
        System.out.println("getCostoTotal");
        try{
//        Compra instance = null;
        int expResult = 360000;
        int result = instance.getCostoTotal();
        assertEquals(expResult, result);
        
        }catch(Exception error){
            error.printStackTrace();
            fail("The test case is a prototype.");    
        }
        
    }

    /**
     * Test of buscar method, of class Compra.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        try{
//        DetalleCompra detalle = null;
//        Compra instance = null;
        DetalleCompra expResult = detalle;
        DetalleCompra result = instance.buscar(detalle);
        assertEquals(expResult, result);
        }catch(Exception error){
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of equals method, of class Compra.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        try{
        Object obj = null;
//        Compra instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        }catch(Exception error){
        error.printStackTrace();                
        fail("The test case is a prototype.");
    }
        
        
    }
    
}
