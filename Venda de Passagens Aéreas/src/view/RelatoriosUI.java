/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Aviao;
import model.Cliente;
import model.Venda;
import model.Voo;
import dao.*;
import menu.RelatoriosMenu;
import java.util.InputMismatchException;
import util.Console;
import util.Validacao;

/**
 *
 * @author Eduardo
 */
public class RelatoriosUI {
    private AviaoDAODB avioes;
    private ClienteDAODB clientes;
    private VendaDAODB vendas;
    private VooDAODB voos;
    private RelatorioDAODB lista = new RelatorioDAODB();
    private Validacao valida = new Validacao();
    private String relatorio;
    
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
    
    public void porCliente(){
    // para cada venda, se o cliente tem o rg == rg, mostra venda
        ClientesUI clientesUI = new ClientesUI();
        clientesUI.mostrarClientes();
        int id;
        do{
           id = Console.scanInt("ID: ");
        }while(clientes.procurarPorId(id) == null);
        relatorio = lista.porCliente(id);
        //print cabecalho
        System.out.println("-----------------------------\n");
            System.out.println(String.format("%-20s", "NOME") + "\t"
                + String.format("%-20s", "|ID VOO") + "\t"
                + String.format("%-20s", "|ID VENDA") + "\t"
                + String.format("%-20s", "|HORARIO VENDA")
            );
        if(relatorio.isEmpty()){
            System.out.println(String.format("%-20s", "-----") +"\t"
                + String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----"));
        }else{
            System.out.println(relatorio);
        }
        
    }
    
    public void porPassageiro(){
    // para cada venda, se o cliente tem o rg == rg, mostra voo
        ClientesUI clientesUI = new ClientesUI();
        clientesUI.mostrarClientes();
        int id;
        do{
            id = Console.scanInt("ID: ");
        }while(clientes.procurarPorId(id) == null);
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-20s", "VOOS:\n"));
        System.out.println(String.format("%-20s", "CODIGO") + "\t"
                + String.format("%-20s", "|AVIAO") + "\t"
                + String.format("%-20s", "|ORIGEM") + "\t"
                + String.format("%-20s", "|DESTINO") + "\t"
                + String.format("%-20s", "|HORARIO"));
       relatorio = lista.porPassageiro(id);
        if(relatorio.isEmpty()){
            System.out.println(String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----"));
        }else{
            System.out.println(relatorio);
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
        relatorio = lista.porOrigem(origem);
        if(relatorio.isEmpty()){
            System.out.println(String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----"));
        }else{
            System.out.println(relatorio);
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
        
        relatorio = lista.porDestino(destino);
        
        if(relatorio.isEmpty()){
            System.out.println(String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----") + "\t"
                + String.format("%-20s", "-----"));
        }else{
            System.out.println(relatorio);
        }
    }
        
}
