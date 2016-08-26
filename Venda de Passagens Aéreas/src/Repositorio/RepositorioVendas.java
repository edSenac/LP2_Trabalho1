/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Model.Venda;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class RepositorioVendas {
    
    private List<Venda> vendas;
    
    public RepositorioVendas() {
        vendas = new ArrayList<Venda>();
    }

    public boolean addVenda(Venda venda) {
        return (vendas.add(venda));
    }

    public List<Venda> getListaVendas() {
        return vendas;
    }
    
}
