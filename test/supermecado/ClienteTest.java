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
public class ClienteTest {
    
    public ClienteTest() {
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
     * Test of incrementarPuntos method, of class Cliente.
     */
    @Test
    public void testIncrementarPuntos() {
        System.out.println("incrementarPuntos");
        int puntos = 0;
        Cliente instance = null;
        instance.incrementarPuntos(puntos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPuntos method, of class Cliente.
     */
    @Test
    public void testSetPuntos() {
        System.out.println("setPuntos");
        int puntos = 0;
        Cliente instance = null;
        instance.setPuntos(puntos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdentificacion method, of class Cliente.
     */
    @Test
    public void testGetIdentificacion() {
        System.out.println("getIdentificacion");
        Cliente instance = null;
        long expResult = 0L;
        long result = instance.getIdentificacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombres method, of class Cliente.
     */
    @Test
    public void testGetNombres() {
        System.out.println("getNombres");
        Cliente instance = null;
        String expResult = "";
        String result = instance.getNombres();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApellidos method, of class Cliente.
     */
    @Test
    public void testGetApellidos() {
        System.out.println("getApellidos");
        Cliente instance = null;
        String expResult = "";
        String result = instance.getApellidos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPuntos method, of class Cliente.
     */
    @Test
    public void testGetPuntos() {
        System.out.println("getPuntos");
        Cliente instance = null;
        int expResult = 0;
        int result = instance.getPuntos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Cliente.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Cliente instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Cliente.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Cliente instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
