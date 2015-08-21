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
public class CompraTest {
    
    public CompraTest() {
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
        DetalleCompra detalle = null;
        Compra instance = null;
        instance.add(detalle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of puntosCompra method, of class Compra.
     */
    @Test
    public void testPuntosCompra() {
        System.out.println("puntosCompra");
        Compra instance = null;
        int expResult = 0;
        int result = instance.puntosCompra();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCliente method, of class Compra.
     */
    @Test
    public void testGetCliente() {
        System.out.println("getCliente");
        Compra instance = null;
        Cliente expResult = null;
        Cliente result = instance.getCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class Compra.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        Compra instance = null;
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCostoTotal method, of class Compra.
     */
    @Test
    public void testGetCostoTotal() {
        System.out.println("getCostoTotal");
        Compra instance = null;
        int expResult = 0;
        int result = instance.getCostoTotal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class Compra.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        DetalleCompra detalle = null;
        Compra instance = null;
        DetalleCompra expResult = null;
        DetalleCompra result = instance.buscar(detalle);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Compra.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Compra instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
