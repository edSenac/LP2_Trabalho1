/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Venda;
import Model.Voo;
import Model.Cliente;
import dao.ClienteDAODB;
import dao.VooDAODB;
import dao.VendaDAODB;
import util.Console;
import Menu.VendasMenu;
import java.util.Date;
import java.util.InputMismatchException;

/**
 *
 * @author Eduardo
 */
public class VendasUI {
    
    private ClienteDAODB clientes = new ClienteDAODB();
    private VooDAODB voos = new VooDAODB();
    private VendaDAODB lista = new VendaDAODB();
    
    public void executar(){
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
                    cadastrarVenda();
                    break;
                case VendasMenu.OP_LISTAR:
                    mostrarVendas();
                    break;
                case VendasMenu.OP_REMOVER:
                    removerVenda();
                case VendasMenu.OP_ATUALIZAR:
                    atualizarVenda();
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
     */
    public void cadastrarVenda(){
        
        ClientesUI clientesUI = new ClientesUI();
        clientesUI.mostrarClientes();
        int id;
        do{
            id = Console.scanInt("ID: ");
        }while(clientes.procurarPorId(id) == null);
        
        Cliente cliente = clientes.procurarPorId(id);
        
        VoosUI voosUI = new VoosUI();
        voosUI.mostrarVoos();
        int codigo;
        do{
            codigo = Console.scanInt("Codigo do Voo: ");
        }while(voos.procurarPorId(codigo) == null);
        
        Voo voo = voos.procurarPorId(codigo);
        
        lista.cadastraVenda(cliente, voo);
        
    }
    
    public void mostrarVendas(){
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-20s", "|NOME CLIENTE") + "\t"
                + String.format("%-20s", "|ORIGEM VOO") + "\t"
                + String.format("%-20s", "|DESTINO VOO") + "\t"
                + String.format("%-20s", "|DATA-HORA COMPRA"));
        for (Venda venda : lista.listar()) {
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

    private void removerVenda() {
        this.mostrarVendas();
        int id = Console.scanInt("Digite o id da venda que quer remover: ");
        Venda venda = lista.procurarPorId(id);
        if(venda != null) {
            lista.deletar(venda);
            System.out.println("Voo removido com sucesso.");
        } else {
            System.out.println("Voo não encontrado.");
        }    
    }

    private void atualizarVenda() {
        this.mostrarVendas();
        int id = Console.scanInt("Digite o id da venda que quer atualizar: ");
        Venda venda = lista.procurarPorId(id);
        
        ClientesUI clientesUI = new ClientesUI();
        clientesUI.mostrarClientes();
        int id_cliente;
        do{
            id_cliente = Console.scanInt("ID: ");
        }while(clientes.procurarPorId(id_cliente) == null);
        
        Cliente cliente = clientes.procurarPorId(id);
        
        VoosUI voosUI = new VoosUI();
        voosUI.mostrarVoos();
        int id_voo;
        do{
            id_voo = Console.scanInt("ID: ");
        }while(voos.procurarPorId(id_voo) == null);
        
        Voo voo = voos.procurarPorId(id_voo);
        
        lista.atualizar(new Venda(id, cliente, voo, venda.getHorario_compra()));
    }
}
