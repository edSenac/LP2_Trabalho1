/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Aviao;
import util.Console;
import menu.AvioesMenu;
import java.util.InputMismatchException;
import util.Validacao;
import dao.AviaoDAODB;
import dao.VooDAODB;

/**
 * Interface para as classes @see Aviao.java e @see RepositorioAvioes.java
 * 
 * @author Eduardo
 */
public class AvioesUI {
 
    private AviaoDAODB lista = new AviaoDAODB();
    private VooDAODB voos = new VooDAODB();
    
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
                case AvioesMenu.OP_REMOVER:
                    removerAviao();
                    break;
                case AvioesMenu.OP_ATUALIZAR:
                    atualizarAviao();
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
        if(!lista.procurarPorNome(nome).isEmpty()){
            System.out.println("Aviao " + nome + " já cadastrado!");
        }else{
            int n_assentos;
            do{
                n_assentos = Console.scanInt("Numero de assentos: ");
            }while(n_assentos < 1);
            lista.salvar(new Aviao(nome, n_assentos));
            System.out.println("Aviao " + nome + " cadastrado com sucesso!");
        }
        
    }
    
    /**
     * Exibe os aviões já cadastrados
     */
    public void mostrarAvioes(){
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-20s", "ID") + "\t"
                + String.format("%-20s", "|NOME") + "\t"
                + String.format("%-20s", "|NUMERO DE ASSENTOS"));
        for (Aviao aviao : lista.listar()) {
            System.out.println(String.format("%-20s", aviao.getId()) + "\t"
                + String.format("%-20s", "|" + aviao.getNome()) + "\t"
                + String.format("%-20s", "|" + aviao.getAssentos()) + "\t");
        }
    }

    private void removerAviao() {
        System.out.println("Essa operação implica na remoção dos voos e vendas do aviao.");
        String continua = "n";
        do{
            continua = Console.scanString("Deseja prosseguir? (S/N): ").toLowerCase();
        }while(continua.equals("s") || continua.equals("n"));
        if(continua.equals("s")){
            this.mostrarAvioes();
            int id = Console.scanInt("Digite o id do avião que quer remover: ");
            Aviao aviao = lista.procurarPorId(id);
            if(aviao != null) {
                lista.deletar(aviao);
                System.out.println("Avião removido com sucesso.");
                voos.deletarPorAviao(id);
            } else {
                System.out.println("Avião não encontrado.");
            }
        }else{
            System.out.println("Abortando operação...");
        }
    }

    public void atualizarAviao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
