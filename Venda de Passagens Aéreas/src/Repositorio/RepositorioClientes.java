/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Model.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class RepositorioClientes {
    
    private List<Cliente> clientes;
    
    public RepositorioClientes(){
        clientes = new ArrayList<Cliente>();
    }
    
    public boolean addCliente(Cliente cliente){
        return (clientes.add(cliente));
    }

    public List<Cliente> getListaClientes(){
        return clientes;
    }
    
    public boolean clienteExiste(String rg) {
        for (Cliente cliente : clientes) {
            if (cliente.getRg().equals(rg)) {
                return true;
            }
        }
        return false;
    }

    public Cliente getCliente(String rg) {
        for (Cliente cliente : clientes) {
            if (cliente.getRg().equals(rg)) {
                return cliente;
           }
        }
        return null;
    }
    
}
