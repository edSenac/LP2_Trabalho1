package View;

import util.Console;
import Menu.MainMenu;
import Repositorio.*;
import java.util.InputMismatchException;

import Model.*;
import java.util.Date;
/**
 *
 * @author Eduardo
 */
public class MainUI {
    
    private RepositorioAvioes listaAvioes;
    private RepositorioClientes listaClientes;
    private RepositorioVendas listaVendas;
    private RepositorioVoos listaVoos;

    public MainUI() {
        
        listaAvioes = new RepositorioAvioes();
        listaClientes = new RepositorioClientes();
        listaVendas = new RepositorioVendas();
        listaVoos = new RepositorioVoos();
        
        inicializar();
    }

    private void inicializar(){
        Aviao aviao = new Aviao("aviao1",1);
        listaAvioes.addAviao(aviao);
        
        Cliente cliente = new Cliente("Cliente", "1234567890", "99999999");
        listaClientes.addCliente(cliente);
        
        Voo voo = new Voo("POA", "BSB", new Date(), aviao);
        listaVoos.addVoo(voo);
        
        Venda venda = new Venda(cliente, voo, new Date());
        listaVendas.addVenda(venda);
    }
    
    public void executar() {
        int opcao = 0;
        do {
            System.out.println(MainMenu.getOpcoes());
            try{
                opcao = Console.scanInt("Digite sua opção:");
            }catch(InputMismatchException e){
                // forca opcao invalida para refazer a leitura
                opcao = -1;
            }
            switch (opcao) {
                case MainMenu.OP_CLIENTES:
                    new ClientesUI(listaClientes).executar();
                    break;
                case MainMenu.OP_AVIOES:
                    new AvioesUI(listaAvioes).executar();
                    break;
                case MainMenu.OP_VOOS:
                    new VoosUI(listaVoos).executar(listaAvioes);
                    break;
                case MainMenu.OP_VENDAS:
                    new VendasUI(listaVendas).executar(listaVoos, listaClientes);
                    break;
                case MainMenu.OP_RELATORIOS:
                    new RelatoriosUI(listaAvioes, listaClientes, listaVendas, listaVoos).executar();
                    break;
                case MainMenu.OP_SAIR:
                    System.out.println("Aplicação finalizada!!!");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != MainMenu.OP_SAIR);
    }

}
