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
import java.util.InputMismatchException;

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
            try{
                opcao = Console.scanInt("Digite sua opção:");
            }catch(InputMismatchException e){
                // forca opcao invalida para refazer a leitura
                opcao = -1;
            }
            switch (opcao) {
                case VendasMenu.OP_CADASTRAR:
                    cadastrarVenda(voos, clientes);
                    break;
                case VendasMenu.OP_LISTAR:
                    mostrarVendas();
                    break;
                case VendasMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != VendasMenu.OP_VOLTAR);
    }

    /**
     * Cadastra uma venda a partir de um voo e um cliente, validando pelo numero
     * de assentos disponíveis no avião
     * @param voos
     * @param clientes 
     */
    public boolean cadastrarVenda(RepositorioVoos voos, RepositorioClientes clientes){
        
        ClientesUI clientesUI = new ClientesUI(clientes);
        clientesUI.mostrarClientes();
        String rg;
        do{
            rg = Console.scanString("RG: ");
        }while(!clientes.clienteExiste(rg));
        
        Cliente cliente = clientes.getCliente(rg);
        
        VoosUI voosUI = new VoosUI(voos);
        voosUI.mostrarVoos();
        int codigo;
        do{
            codigo = Console.scanInt("Codigo do Voo: ");
        }while(!voos.vooExiste(codigo));
        
        
        Voo voo = voos.getVoo(codigo);
        
        int assentosDisponiveis = voo.getAviao().getN_assentos();
        if(assentosDisponiveis > 0){ // fazer verificaçã na venda
            // não considera que um avião tem mais de um voo
            voo.getAviao().setN_assentos(assentosDisponiveis -1);
            // voo deve ter um parametro com o numero de assentos livres/ocupados
            lista.addVenda(new Venda(cliente, voo, new Date()));
            System.out.println("Venda cadastrada com sucesso!");
            return true;
        }else{
            System.out.println("Não há mais lugares disponíveis nesse vôo!");
            return false;
        }
    }
    
    public void mostrarVendas(){
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-20s", "|NOME CLIENTE") + "\t"
                + String.format("%-20s", "|ORIGEM VOO") + "\t"
                + String.format("%-20s", "|DESTINO VOO") + "\t"
                + String.format("%-20s", "|DATA-HORA COMPRA"));
        for (Venda venda : lista.getListaVendas()) {
            Voo voo = venda.getVoo();
            Cliente cliente = venda.getCliente();
            try{
                System.out.println(String.format("%-20s", cliente.getNome()) + "\t"
                + String.format("%-20s", "|" + voo.getOrigem()) + "\t"
                + String.format("%-20s", "|" + voo.getDestino()) + "\t"
                + String.format("%-20s", "|" + venda.getHorario_compra()) + "\t");
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
         
        }
    }
}
