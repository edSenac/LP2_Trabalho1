/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Cliente;
import util.Console;
import util.Validacao;
import menu.ClientesMenu;
import java.util.InputMismatchException;
import dao.ClienteDAODB;
import dao.VendaDAODB;

/**
 *
 * @author Eduardo
 */
public class ClientesUI {
    
    private ClienteDAODB lista = new ClienteDAODB();
    private VendaDAODB vendas = new VendaDAODB();
    private Validacao valida = new Validacao();
    
    public void executar() {
        
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
                case ClientesMenu.OP_REMOVER:
                    removerCliente();
                    break;
                case ClientesMenu.OP_ATUALIZAR:
                    atualizarCliente();
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
        do{
            rg = Console.scanString("RG: ");
        }while(!valida.validaRg(rg));
        if (lista.procurarPorRg(rg) != null) {
            System.out.println("RG já existente no cadastro");
        } else {
            String nome;
            do{
                nome = Console.scanString("Nome: ");
            }while(!valida.validaNome(nome));
            String telefone;
            do{
                telefone = Console.scanString("Telefone: ");
            }while(!valida.validaTelefone(telefone));
            // --TODO-- validacao
            lista.salvar(new Cliente(nome, rg, telefone));
            System.out.println("Cliente " + nome + " cadastrado com sucesso!");
        }
    }


    public void mostrarClientes() {
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-20s", "ID") + "\t"
                + String.format("%-20s", "RG") + "\t"
                + String.format("%-20s", "|NOME") + "\t"
                + String.format("%-20s", "|TELEFONE"));
        for (Cliente cliente : lista.listar()) {
            System.out.println(String.format("%-20s", cliente.getId()) + "\t"
                    + String.format("%-20s", cliente.getRg()) + "\t"
                    + String.format("%-20s", "|" + cliente.getNome()) + "\t"
                    + String.format("%-20s", "|" + cliente.getTelefone()) + "\t");
        }

    }
    
    public void removerCliente() {
        System.out.println("Essa operação implica na remoção das vendas do cliente.");
        String continua = "n";
        do{
            continua = Console.scanString("Deseja prosseguir? (S/N): ").toLowerCase();
        }while(continua.equals("s") || continua.equals("n"));
        if(continua.equals("s")){
            this.mostrarClientes();
            int id = Console.scanInt("Digite o id do cliente que quer remover: ");
            Cliente cliente = lista.procurarPorId(id);
            if(cliente != null) {
                lista.deletar(cliente);
                System.out.println("Cliente removido com sucesso.");
                vendas.deletarPorCliente(id);
            } else {
                System.out.println("Cliente não encontrado.");
            }
        }else{
            System.out.println("Abortando operação...");
        }
        
    }

    public void atualizarCliente() {
        String rg;
        this.mostrarClientes();
        int id = Console.scanInt("Digite o id do cliente que quer atualizar: ");
        Cliente cliente = lista.procurarPorId(id);
        if(cliente != null) {
            do{
                rg = Console.scanString("RG: ");
            }while(!valida.validaRg(rg));
            // se encontrar cliente com o mesmo rg e não for o mesmo que quer atualizar
            if ((lista.procurarPorRg(rg) != null)) {
                if(id != lista.procurarPorRg(rg).getId()){
                    System.out.println("RG já existente no cadastro");
                }
            } else {
                String nome;
                do{
                    nome = Console.scanString("Nome: ");
                }while(!valida.validaNome(nome));
                String telefone;
                do{
                    telefone = Console.scanString("Telefone: ");
                }while(!valida.validaTelefone(telefone));
                lista.atualizar(new Cliente(id, nome, rg, telefone));
                System.out.println("Cliente atualizado com sucesso.");
            }
        }else {
            System.out.println("Cliente não encontrado.");
        }
      
    }
}
