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
                    new ClientesUI().executar();
                    break;
                case MainMenu.OP_AVIOES:
                    new AvioesUI().executar();
                    break;
                case MainMenu.OP_VOOS:
                    new VoosUI().executar();
                    break;
                case MainMenu.OP_VENDAS:
                    new VendasUI().executar();
                    break;
                case MainMenu.OP_RELATORIOS:
                    new RelatoriosUI().executar();
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
