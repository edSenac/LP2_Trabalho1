package View;

import util.Console;
import Menu.MainMenu;
import Repositorio.RepositorioAvioes;
import Repositorio.RepositorioClientes;
import Repositorio.RepositorioVendas;
import Repositorio.RepositorioVoos;
import java.util.InputMismatchException;

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
