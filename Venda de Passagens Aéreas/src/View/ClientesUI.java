/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Cliente;
import Repositorio.RepositorioClientes;
import util.Console;
import util.Validacao;
import Menu.ClientesMenu;
import java.util.InputMismatchException;

/**
 *
 * @author Eduardo
 */
public class ClientesUI {
    
    private RepositorioClientes lista;
    private Validacao valida;
    
    public ClientesUI(RepositorioClientes lista){
        this.lista = lista;
    }
    
    public void executar() {
        
        /*debug
            valida.validaNome("joao");
        */
        
        int opcao = 0;
        do {
            System.out.println(ClientesMenu.getOpcoes());
            try{
                opcao = Console.scanInt("Digite sua opção:");
            }catch(InputMismatchException e){
                // forca opcao invalida para refazer a leitura
                opcao = -1;
            }
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
    
    public void cadastrarCliente() {
        String rg;
        rg = Console.scanString("RG (11 dígitos): ");
        if (lista.clienteExiste(rg)) {
            System.out.println("RG já existente no cadastro");
        } else {
            String nome;
            //do{
                nome = Console.scanString("Nome: ");
            //}while(!valida.validaNome(nome));
            String telefone = Console.scanString("Telefone: ");
            // --TODO-- validacao
            lista.addCliente(new Cliente(nome, rg, telefone));
            System.out.println("Cliente " + nome + " cadastrado com sucesso!");
        }
    }


    public void mostrarClientes() {
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-20s", "RG") + "\t"
                + String.format("%-20s", "|NOME") + "\t"
                + String.format("%-20s", "|TELEFONE"));
        for (Cliente cliente : lista.getListaClientes()) {
            System.out.println(String.format("%-20s", cliente.getRg()) + "\t"
                    + String.format("%-20s", "|" + cliente.getNome()) + "\t"
                    + String.format("%-20s", "|" + cliente.getTelefone()) + "\t");
        }

    }
}
