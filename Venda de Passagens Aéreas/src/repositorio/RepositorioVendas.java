/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import model.Venda;
import model.Voo;
import model.Cliente;
import java.util.ArrayList;
import java.util.Date;
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
    
    public boolean cadastraVenda(Cliente cliente, Voo voo){
        int lugares = voo.getLugares();
        if(lugares > 0){
            this.addVenda(new Venda(cliente, voo, new Date()));
            voo.setLugares(lugares -1);
            System.out.println("Venda cadastrada com sucesso!");
            return true;
        }
        else{
            System.out.println("Não há mais lugares disponíveis nesse vôo!");
            return false;
        }
    }
    /* adicionar método para verificar consistência do numero de assentos
        se não tem mais voos não vende.
    */
    
}
