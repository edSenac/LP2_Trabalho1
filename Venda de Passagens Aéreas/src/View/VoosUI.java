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
import util.Validacao;
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
    private Validacao valida = new Validacao();
    
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
        String origem;
        String destino;
        String horarioStr;
        
        do{
            origem = Console.scanString("Origem: ");
        }while(!valida.validaNome(origem));
        
        do{
            destino = Console.scanString("Destino: ");    
        }while(!valida.validaNome(origem));
        horarioStr = Console.scanString("Horario (dd/mm/yyyy hh:mm): ");
        
        Date horario = null;
        try {
            horario = DateUtil.stringToDateHour(horarioStr);
        } catch (ParseException ex) {
            System.out.println("Data ou hora no formato inválido!");
            return;
        }
        
        AvioesUI avioesUI = new AvioesUI(avioes);
        avioesUI.mostrarAvioes();
        int codAviao;
        do{
            codAviao = Console.scanInt("Codigo do aviao: ");
            // --TODO-- validacao
        }while(!avioes.existeAviaoCod(codAviao));
        
        Aviao aviao = avioes.getAviao(codAviao);

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
                + String.format("%-30s", "|HORARIO") + "\t"
                + String.format("%-20s", "|LUGARES DISPONIVEIS"));
        for (Voo voo : lista.getListaVoos()) {
            Aviao aviao = voo.getAviao();
            System.out.println(String.format("%-20s", voo.getCodigo()) + "\t"
                + String.format("%-20s", "|" + aviao.getNome()) + "\t"
                + String.format("%-20s", "|" + voo.getOrigem()) + "\t"
                + String.format("%-20s", "|" + voo.getDestino()) + "\t"
                + String.format("%-30s", "|" + voo.getHorario()) + "\t"
                + String.format("%-20s", "|" + voo.getLugares()));
        }
    } 
}
