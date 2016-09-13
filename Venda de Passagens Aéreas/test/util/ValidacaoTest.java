/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eduardo
 */
public class ValidacaoTest {
    
    public ValidacaoTest() {
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
     * Test of validaNome method, of class Validacao.
     */
    @Test
    public void testValidaNome() {
        System.out.println("validaNome");
        String nome = "";
        Validacao instance = new Validacao();
        boolean expResult = false;
        boolean result = instance.validaNome(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaRg method, of class Validacao.
     */
    @Test
    public void testValidaRg() {
        System.out.println("validaRg");
        String rg = "";
        Validacao instance = new Validacao();
        boolean expResult = false;
        boolean result = instance.validaRg(rg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
