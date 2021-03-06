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
import util.Validacao;

/**
 * Interface para as classes @see Aviao.java e @see RepositorioAvioes.java
 * 
 * @author Eduardo
 */
public class AvioesUI {
 
    private RepositorioAvioes lista;
    private Validacao valida;
    
    /**
     * Método construtor da classe
     * 
     * @param lista RepositorioAvioes
     */
    public AvioesUI(RepositorioAvioes lista){
        this.lista = lista;
    }
    
    /**
     * Método utilizado para interagir com o usuário
     */
    public void executar(){
        int opcao = 0;
        do {
        System.out.println(AvioesMenu.getOpcoes());
            try{
                opcao = Console.scanInt("Digite sua opção:");
            }catch(InputMismatchException e){
                /*  caso a entrada nao seja um int, forca uma opcao invalida
                    para refazer a leitura */
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
    
    /**
     * Método que adiciona um objeto avião ao repositório
     */
    public void cadastrarAviao(){
        String nome;
        Validacao valida = new Validacao();
        do{
            nome = Console.scanString("Nome: ");
        }while(!valida.validaNome(nome));
        // --TODO-- validacao
        if(lista.existeAviao(nome)){
            System.out.println("Aviao " + nome + " já cadastrado!");
        }else{
            int n_assentos;
            do{
                n_assentos = Console.scanInt("Numero de assentos: ");
            }while(n_assentos < 1);
            lista.addAviao(new Aviao(nome, n_assentos));
            System.out.println("Aviao " + nome + " cadastrado com sucesso!");
        }
        
    }
    
    /**
     * Exibe os aviões já cadastrados
     */
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
