/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Aviao;
import Model.Cliente;
import Model.Venda;
import Model.Voo;
import Repositorio.RepositorioAvioes;
import Repositorio.RepositorioClientes;
import Repositorio.RepositorioVendas;
import Repositorio.RepositorioVoos;
import Menu.RelatoriosMenu;
import util.Console;

/**
 *
 * @author Eduardo
 */
public class RelatoriosUI {
    private RepositorioAvioes avioes;
    private RepositorioClientes clientes;
    private RepositorioVendas vendas;
    private RepositorioVoos voos;
    
    public void executar(){
        int opcao = 0;
        do {
         System.out.println(RelatoriosMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            // --TODO-- validacao
            switch (opcao) {
                case RelatoriosMenu.REL_CLIENTE:
                    porCliente();
                    break;
                case RelatoriosMenu.REL_PASSAGEIRO:
                    porPassageiro();
                    break;
                case RelatoriosMenu.REL_ORIGEM:
                    porOrigem();
                    break;
                case RelatoriosMenu.REL_DESTINO:
                    porDestino();
                    break;
                case RelatoriosMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != RelatoriosMenu.OP_VOLTAR);
    }    

    public RelatoriosUI(RepositorioAvioes avioes, RepositorioClientes clientes, RepositorioVendas vendas, RepositorioVoos voos) {
        this.avioes = avioes;
        this.clientes = clientes;
        this.vendas = vendas;
        this.voos = voos;
    }
    
    public void porCliente(){
    // --TODO-- para cada venda, se o cliente tem o rg == rg, mostra venda
        ClientesUI clientesUI = new ClientesUI(clientes);
        clientesUI.mostrarClientes();
        String rg = Console.scanString("RG: ");
        // --TODO-- validacao
        
        //print cabecalho
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-20s", "VENDAS:\n"));
        System.out.println(String.format("%-20s", "CODIGO VOO") + "\t"
                + String.format("%-20s", "|HORARIO VENDA"));
        boolean encontrouVendas = false;
        for (Venda venda : vendas.getListaVendas()){
            if(venda.getCliente().getRg().equals(rg)){
                encontrouVendas = true;
                System.out.println(String.format("%-20s", venda.getVoo().getCodigo()) + "\t"
                + String.format("%-20s", "|" + venda.getHorario_compra()));
            }
        }
        if(!encontrouVendas){
            System.out.println(String.format("%-20s", "-----") +"\t"
                + String.format("%-20s", "-----"));
        }
        
    }
    
    public void porPassageiro(){
    // para cada venda, se o cliente tem o rg == rg, mostra voo
        ClientesUI clientesUI = new ClientesUI(clientes);
        clientesUI.mostrarClientes();
        String rg = Console.scanString("RG: ");
        // --TODO-- validacao
        // --TODO-- validacao
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-20s", "VOOS:\n"));
        System.out.println(String.format("%-20s", "CODIGO") + "\t"
                + String.format("%-20s", "|AVIAO") + "\t"
                + String.format("%-20s", "|ORIGEM") + "\t"
                + String.format("%-20s", "|DESTINO") + "\t"
                + String.format("%-20s", "|HORARIO"));
        boolean encontrouVendas = false;
        for (Venda venda : vendas.getListaVendas()){
            if(venda.getCliente().getRg().equals(rg)){
                encontrouVendas = true;
                Voo voo = venda.getVoo();
                Aviao aviao = voo.getAviao();
                System.out.println(String.format("%-20s", voo.getCodigo()) + "\t"
                + String.format("%-20s", "|" + aviao.getNome()) + "\t"
                + String.format("%-20s", "|" + voo.getOrigem()) + "\t"
                + String.format("%-20s", "|" + voo.getDestino()) + "\t"
                + String.format("%-20s", "|" + voo.getHorario()));
            }
        }
        if(!encontrouVendas){
            System.out.println(String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----"));
        }
    }
    
    public void porOrigem(){
    // --TODO-- para cada voo, se a origem == origem, mostra voo    
        
    }
    
    public void porDestino(){
    // --TODO-- para cada voo, se o destino == destino, mostra voo    
        
    }
        
}
