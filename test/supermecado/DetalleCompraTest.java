/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermecado;

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
public class DetalleCompraTest {
    
    public DetalleCompraTest() {
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
     * Test of CostoProducto method, of class DetalleCompra.
     */
    @Test
    public void testCostoProducto() {
        System.out.println("CostoProducto");
        DetalleCompra instance = null;
        int expResult = 0;
        int result = instance.CostoProducto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCantidadProductos method, of class DetalleCompra.
     */
    @Test
    public void testGetCantidadProductos() {
        System.out.println("getCantidadProductos");
        DetalleCompra instance = null;
        int expResult = 0;
        int result = instance.getCantidadProductos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class DetalleCompra.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        DetalleCompra instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
