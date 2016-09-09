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

    public void cadastrarVenda(RepositorioVoos voos, RepositorioClientes clientes){
        // --TODO-- RESTRINGIR PELO NUMERO DE ASSENTOS NO VOO
        ClientesUI clientesUI = new ClientesUI(clientes);
        clientesUI.mostrarClientes();
        String rg = Console.scanString("RG: ");
        // --TODO-- validacao
        Cliente cliente = clientes.getCliente(rg);
        // --TODO-- verificar se cliente existe
        
        VoosUI voosUI = new VoosUI(voos);
        voosUI.mostrarVoos();
        int codigo = Console.scanInt("Codigo do Voo: ");
        // --TODO-- validacao
        Voo voo = voos.getVoo(codigo);
        // --TODO-- verificar se voo existe e se ha lugar
        
        Date horario_compra = new Date();
        lista.addVenda(new Venda(cliente, voo, horario_compra));
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
            System.out.println(String.format("%-20s", cliente.getNome()) + "\t"
                + String.format("%-20s", "|" + voo.getOrigem()) + "\t"
                + String.format("%-20s", "|" + voo.getDestino()) + "\t"
                + String.format("%-20s", "|" + venda.getHorario_compra()) + "\t");
        }
    }
}
