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
            opcao = Console.scanInt("Digite sua opção:");
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
    
    private void cadastrarAviao(){
            String nome = Console.scanString("Nome: ");
            int n_assentos = Console.scanInt("Numero de assentos: ");
            lista.addAviao(new Aviao(nome, n_assentos));
            System.out.println("Aviao " + nome + " cadastrado com sucesso!");
    }
    
    private void mostrarAvioes(){
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "CODIGO") + "\t"
                + String.format("%-20s", "|NOME") + "\t"
                + String.format("%-20s", "|NUMERO DE ASSENTOS"));
        for (Aviao aviao : lista.getListaAvioes()) {
            System.out.println(String.format("%-10s", aviao.getCODIGO()) + "\t"
                + String.format("%-20s", "|" + aviao.getNome()) + "\t"
                + String.format("%-20s", "|" + aviao.getN_assentos()) + "\t");
        }
    }
}
