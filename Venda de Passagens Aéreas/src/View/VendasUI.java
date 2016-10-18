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
    
    private ClienteDAODB clientes;
    private VooDAODB voos;
    private VendaDAODB lista;
    
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
    public boolean cadastrarVenda(){
        
        ClientesUI clientesUI = new ClientesUI();
        clientesUI.mostrarClientes();
        String rg;
        do{
            rg = Console.scanString("RG: ");
        }while(clientes.procurarPorRg(rg) == null);
        
        Cliente cliente = clientes.procurarPorRg(rg);
        
        VoosUI voosUI = new VoosUI();
        voosUI.mostrarVoos();
        int codigo;
        do{
            codigo = Console.scanInt("Codigo do Voo: ");
        }while(voos.procurarPorId(codigo) == null);
        
        Voo voo = voos.procurarPorId(codigo);
        
        return lista.cadastraVenda(cliente, voo);
        
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
}
