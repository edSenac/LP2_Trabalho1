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
import java.util.InputMismatchException;
import util.Console;
import util.Validacao;

/**
 *
 * @author Eduardo
 */
public class RelatoriosUI {
    private RepositorioAvioes avioes;
    private RepositorioClientes clientes;
    private RepositorioVendas vendas;
    private RepositorioVoos voos;
    private Validacao valida = new Validacao();
    
    /*
    
        passar métodos de busca para o repositório
    
    */
    
    
    public void executar(){
        int opcao = 0;
        do {
         System.out.println(RelatoriosMenu.getOpcoes());
            try{
                opcao = Console.scanInt("Digite sua opção:");
            }catch(InputMismatchException e){
                // forca opcao invalida para refazer a leitura
                opcao = -1;
            }
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
    // para cada venda, se o cliente tem o rg == rg, mostra venda
        ClientesUI clientesUI = new ClientesUI(clientes);
        clientesUI.mostrarClientes();
        String rg;
        do{
           rg = Console.scanString("RG: ");
        }while(!valida.validaRg(rg));
        
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
        String rg;
        do{
            rg = Console.scanString("RG: ");
        }while(!valida.validaRg(rg));
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
    // para cada voo, se a origem == origem, mostra voo 
        String origem;
        do{
            origem = Console.scanString("Origem do Voo: ");
        }while(!valida.validaNome(origem));
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-20s", "VOOS:\n"));
        System.out.println(String.format("%-20s", "CODIGO") + "\t"
                + String.format("%-20s", "|AVIAO") + "\t"
                + String.format("%-20s", "|ORIGEM") + "\t"
                + String.format("%-20s", "|DESTINO") + "\t"
                + String.format("%-20s", "|HORARIO"));
        boolean encontrouVoos = false;
        for (Voo voo : voos.getListaVoos()){
            if(voo.getOrigem().equals(origem)){
                encontrouVoos = true;
                System.out.println(String.format("%-20s", voo.getCodigo()) + "\t"
                + String.format("%-20s", "|" + voo.getAviao().getNome()) + "\t"
                + String.format("%-20s", "|" + voo.getOrigem()) + "\t"
                + String.format("%-20s", "|" + voo.getDestino()) + "\t"
                + String.format("%-20s", "|" + voo.getHorario()));
            }
        }
        if(!encontrouVoos){
            System.out.println(String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----"));
        }
        
    }
    
    public void porDestino(){
    //  para cada voo, se o destino == destino, mostra voo    
        String destino;
        do{
            destino = Console.scanString("Destino do Voo: ");
        }while(!valida.validaNome(destino));
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-20s", "VOOS:\n"));
        System.out.println(String.format("%-20s", "CODIGO") + "\t"
                + String.format("%-20s", "|AVIAO") + "\t"
                + String.format("%-20s", "|ORIGEM") + "\t"
                + String.format("%-20s", "|DESTINO") + "\t"
                + String.format("%-20s", "|HORARIO"));
        boolean encontrouVoos = false;
        for (Voo voo : voos.getListaVoos()){
            if(voo.getDestino().equals(destino)){
                encontrouVoos = true;
                System.out.println(String.format("%-20s", voo.getCodigo()) + "\t"
                + String.format("%-20s", "|" + voo.getAviao().getNome()) + "\t"
                + String.format("%-20s", "|" + voo.getOrigem()) + "\t"
                + String.format("%-20s", "|" + voo.getDestino()) + "\t"
                + String.format("%-20s", "|" + voo.getHorario()));
            }
        }
        if(!encontrouVoos){
            System.out.println(String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----"));
        }
    }
        
}
