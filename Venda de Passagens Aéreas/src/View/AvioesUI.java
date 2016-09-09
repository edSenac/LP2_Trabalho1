/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Aviao;
import Repositorio.RepositorioAvioes;
import util.Console;
import Menu.AvioesMenu;
import java.util.InputMismatchException;

/**
 *
 * @author Eduardo
 */
public class AvioesUI {
 
    private RepositorioAvioes lista;
    
    public AvioesUI(RepositorioAvioes lista){
        this.lista = lista;
    }
    
    public void executar(){
        int opcao = 0;
        do {
        System.out.println(AvioesMenu.getOpcoes());
            try{
                opcao = Console.scanInt("Digite sua opção:");
            }catch(InputMismatchException e){
                // forca opcao invalida para refazer a leitura
                opcao = -1;
            }
            switch (opcao) {
                case AvioesMenu.OP_CADASTRAR:
                    cadastrarAviao();
                    break;
                case AvioesMenu.OP_LISTAR:
                    mostrarAvioes();
                    break;
                case AvioesMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != AvioesMenu.OP_VOLTAR);
    }
    
    public void cadastrarAviao(){
            String nome = Console.scanString("Nome: ");
            // --TODO-- validacao
            int n_assentos = Console.scanInt("Numero de assentos: ");
            // --TODO-- validacao
            lista.addAviao(new Aviao(nome, n_assentos));
            System.out.println("Aviao " + nome + " cadastrado com sucesso!");
    }
    
    public void mostrarAvioes(){
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-20s", "CODIGO") + "\t"
                + String.format("%-20s", "|NOME") + "\t"
                + String.format("%-20s", "|NUMERO DE ASSENTOS"));
        for (Aviao aviao : lista.getListaAvioes()) {
            System.out.println(String.format("%-20s", aviao.getCodigo()) + "\t"
                + String.format("%-20s", "|" + aviao.getNome()) + "\t"
                + String.format("%-20s", "|" + aviao.getN_assentos()) + "\t");
        }
    }
}
