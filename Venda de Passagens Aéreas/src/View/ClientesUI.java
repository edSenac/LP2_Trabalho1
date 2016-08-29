/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Cliente;
import Repositorio.RepositorioClientes;
import util.Console;
import Menu.ClientesMenu;

/**
 *
 * @author Eduardo
 */
public class ClientesUI {
    
    private RepositorioClientes lista;
    
    public ClientesUI(RepositorioClientes lista){
        this.lista = lista;
    }
    
    public void executar() {
        int opcao = 0;
        do {
            System.out.println(ClientesMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case ClientesMenu.OP_CADASTRAR:
                    cadastrarCliente();
                    break;
                case ClientesMenu.OP_LISTAR:
                    mostrarClientes();
                    break;
                case ClientesMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != ClientesMenu.OP_VOLTAR);        
    }
    
    private void cadastrarCliente() {
        String rg = Console.scanString("RG: ");
        if (lista.clienteExiste(rg)) {
            System.out.println("RG já existente no cadastro");
        } else {
            String nome = Console.scanString("Nome: ");
            String telefone = Console.scanString("Telefone: ");
            lista.addCliente(new Cliente(nome, rg, telefone));
            System.out.println("Cliente " + nome + " cadastrado com sucesso!");
        }
    }


public void mostrarClientes() {
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "RG") + "\t"
                + String.format("%-20s", "|NOME") + "\t"
                + String.format("%-20s", "|TELEFONE"));
        for (Cliente cliente : lista.getListaClientes()) {
            System.out.println(String.format("%-10s", cliente.getRg()) + "\t"
                    + String.format("%-20s", "|" + cliente.getNome()) + "\t"
                    + String.format("%-20s", "|" + cliente.getTelefone()) + "\t");
        }

    }
}
