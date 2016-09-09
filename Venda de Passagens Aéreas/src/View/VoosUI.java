/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Voo;
import Model.Aviao;
import Repositorio.RepositorioAvioes;
import Repositorio.RepositorioVoos;
import util.Console;
import util.DateUtil;
import Menu.VoosMenu;
import java.util.Date;
import java.text.ParseException;
import java.util.InputMismatchException;

/**
 *
 * @author Eduardo
 */
public class VoosUI {
    
    private RepositorioVoos lista;
    
    public VoosUI(RepositorioVoos lista){
        this.lista = lista;
    }
    
    public void executar(RepositorioAvioes avioes){
        int opcao = 0;
        do {
        System.out.println(VoosMenu.getOpcoes());
            try{
                opcao = Console.scanInt("Digite sua opção:");
            }catch(InputMismatchException e){
                // forca opcao invalida para refazer a leitura
                opcao = -1;
            }
            switch (opcao) {
                case VoosMenu.OP_CADASTRAR:
                    cadastrarVoo(avioes);
                    break;
                case VoosMenu.OP_LISTAR:
                    mostrarVoos();
                    break;
                case VoosMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != VoosMenu.OP_VOLTAR);
    }
    
    public void cadastrarVoo(RepositorioAvioes avioes){
            String origem = Console.scanString("Origem: ");
            // --TODO-- validacao
            String destino = Console.scanString("Destino: ");
            // --TODO-- validacao
            String horarioStr = Console.scanString("Horario (dd/mm/yyyy hh:mm): ");
            // --TODO-- validacao
            AvioesUI avioesUI = new AvioesUI(avioes);
            avioesUI.mostrarAvioes();
            int codAviao = Console.scanInt("Codigo do aviao: ");
            // --TODO-- validacao
            Aviao aviao = avioes.getAviao(codAviao);
            Date horario = null;
            try {
                horario = DateUtil.stringToDateHour(horarioStr);
            } catch (ParseException ex) {
                System.out.println("Data ou hora no formato inválido!");                
            }
            if(horario != null){
                lista.addVoo(new Voo(origem, destino, horario, aviao));
                System.out.println("Voo cadastrado com sucesso!");
            }
    }
    
    public void mostrarVoos(){
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-20s", "CODIGO") + "\t"
                + String.format("%-20s", "|AVIAO") + "\t"
                + String.format("%-20s", "|ORIGEM") + "\t"
                + String.format("%-20s", "|DESTINO") + "\t"
                + String.format("%-20s", "|HORARIO"));
        for (Voo voo : lista.getListaVoos()) {
            Aviao aviao = voo.getAviao();
            System.out.println(String.format("%-20s", voo.getCodigo()) + "\t"
                + String.format("%-20s", "|" + aviao.getNome()) + "\t"
                + String.format("%-20s", "|" + voo.getOrigem()) + "\t"
                + String.format("%-20s", "|" + voo.getDestino()) + "\t"
                    // --TODO-- formatar hora?
                + String.format("%-20s", "|" + voo.getHorario()) + "\t");
        }
    } 
}
