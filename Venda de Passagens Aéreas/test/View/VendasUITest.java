/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Repositorio.RepositorioClientes;
import Repositorio.RepositorioVoos;
import Repositorio.RepositorioVendas;
import Model.Cliente;
import Model.Voo;
import Model.Aviao;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 631620220
 */
public class VendasUITest {
    
    private RepositorioClientes listaClientes = new RepositorioClientes();
    private RepositorioVoos listaVoos1 = new RepositorioVoos();
    private RepositorioVoos listaVoos2 = new RepositorioVoos();
    private RepositorioVoos listaVoos3 = new RepositorioVoos();
        
    
    private Cliente cliente1 = new Cliente("0123456789", "ClienteTeste", "99999999");
    
    private RepositorioVendas listaVendas;
    
    private Aviao aviao1 = new Aviao("Aviao", 1);
    private Aviao aviao2 = new Aviao("OutroAviao", 0);
    private Aviao aviao3 = new Aviao("MaisUmAviao", -1);
    
    private Voo voo1 = new Voo("POA", "SP", new Date(), aviao1);
    private Voo voo2 = new Voo("POA", "BSB", new Date(), aviao2);
    private Voo voo3 = new Voo("POA", "AKL", new Date(), aviao3);
    
    public VendasUITest() {
        listaClientes.addCliente(cliente1);
        
        listaVoos1.addVoo(voo1);
        listaVoos2.addVoo(voo2);
        listaVoos3.addVoo(voo3);
        
    }

    /**
     * Test of cadastrarVenda method, of class VendasUI.
     * @param voos
     * @param clientes
     */
    @Test
    public void testCadastrarVenda() {

        VendasUI instance = new VendasUI(listaVendas);
        boolean cadastrarVenda1 = instance.cadastrarVenda(listaVoos1, listaClientes);
        boolean cadastrarVenda2 = instance.cadastrarVenda(listaVoos2, listaClientes);
        boolean cadastrarVenda3 = instance.cadastrarVenda(listaVoos3, listaClientes);
        
        System.out.println("Avião com 1 assento:");
        assertTrue(cadastrarVenda1);
        System.out.println("Avião com 0 assentos");
        assertFalse(cadastrarVenda2);
        System.out.println("Avião com -1 assentos");
        assertFalse(cadastrarVenda3);

    }

}
