/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Model.Cliente;
import Model.Venda;
import Model.Voo;
import Model.Aviao;
import java.util.List;
import java.util.Date;
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
    Cliente cliente = null;
    Aviao aviao1 = new Aviao("aviao", 1);
    Aviao aviao2 = new Aviao("aviao", 0);        
    Voo voo1 = new Voo("POA", "BSB", new Date(), aviao1);
    Voo voo2 = new Voo("BSB", "POA", new Date(), aviao2);
    RepositorioVendas instance = new RepositorioVendas();
    
    public RepositorioVendasTest() {

    }
    
    /**
     * Test of cadastraVenda method, of class RepositorioVendas.
     */
    @Test
    public void testCadastraVendaTrue() {
        System.out.println("cadastraVenda true");
        boolean expResult = true;
        boolean result = instance.cadastraVenda(cliente, voo1);
        assertEquals(expResult, result);
    }
    @Test
    public void testCadastraVendaFalse(){
        System.out.println("cadastraVenda false");
        boolean expResult = false;
        boolean result = instance.cadastraVenda(cliente, voo2);
        assertEquals(expResult, result);
    }
    
}
