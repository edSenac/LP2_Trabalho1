/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Venda;
import Model.Voo;
import Model.Cliente;
import Repositorio.RepositorioVendas;
import Repositorio.RepositorioVoos;
import Repositorio.RepositorioClientes;
import util.Console;
import Menu.VendasMenu;
import java.util.Date;

/**
 *
 * @author Eduardo
 */
public class VendasUI {
 
    private RepositorioVendas lista;
    
    public VendasUI(RepositorioVendas lista){
        this.lista = lista;
    }
    
    public void executar(RepositorioVoos voos, RepositorioClientes clientes){
        int opcao = 0;
        do {
         System.out.println(VendasMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case VendasMenu.OP_CADASTRAR:
                    //cadastrarVenda(voos, clientes);
                    break;
                case VendasMenu.OP_LISTAR:
                    //mostrarVendas();
                    break;
                case VendasMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != VendasMenu.OP_VOLTAR);
    }

    public void cadastrarVenda(RepositorioVoos voos, RepositorioClientes clientes){
        // --TODO-- RESTRINGIR PELO NUMERO DE ASSENTOS NO VOO
        
        String rg = Console.scanString("RG: ");
        Cliente cliente = clientes.getCliente(rg);
        int codigo = Console.scanInt("Codigo do Voo: ");
        Voo voo = voos.getVoo(codigo);
        Date horario_compra = new Date();
        
        // IF numero de assentos < 0 vende, se nao ignora
        
        lista.addVenda(new Venda(cliente, voo, horario_compra));
    }
    
    public void mostrarVendas(){
        // --TODO--  AJUSTAR PARA VENDAS EM VEZ DE AVIAO
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "CODIGO") + "\t"
                + String.format("%-20s", "|NOME") + "\t"
                + String.format("%-20s", "|NUMERO DE ASSENTOS"));
        for (Aviao aviao : lista.getListaAvioes()) {
            System.out.println(String.format("%-10s", aviao.getCODIGO()) + "\t"
                + String.format("%-20s", "|" + aviao.getNome()) + "\t"
                + String.format("%-20s", "|" + aviao.getN_assentos()) + "\t");
        }
    }
}
