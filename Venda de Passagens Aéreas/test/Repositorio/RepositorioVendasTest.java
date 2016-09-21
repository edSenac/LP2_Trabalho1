/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Model.Cliente;
import Model.Venda;
import Model.Voo;
import java.util.List;
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
public class RepositorioVendasTest {
    
    public RepositorioVendasTest() {
    }
    
    /**
     * Test of cadastraVenda method, of class RepositorioVendas.
     */
    @Test
    public void testCadastraVenda() {
        System.out.println("cadastraVenda");
        int codigo = 0;
        Cliente cliente = null;
        Voo voo = null;
        RepositorioVendas instance = new RepositorioVendas();
        boolean expResult = false;
        boolean result = instance.cadastraVenda(codigo, cliente, voo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
