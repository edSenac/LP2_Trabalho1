/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Voo;
import Model.Aviao;
import util.Console;
import util.DateUtil;
import util.Validacao;
import Menu.VoosMenu;
import java.util.Date;
import java.text.ParseException;
import java.util.InputMismatchException;
import dao.AviaoDAODB;
import dao.VooDAODB;

/**
 *
 * @author Eduardo
 */
public class VoosUI {
    
    private VooDAODB lista;
    private AviaoDAODB avioes;
    private Validacao valida = new Validacao();
    
    public void executar(){
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
                    cadastrarVoo();
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
    
    public void cadastrarVoo(){
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
        
        AvioesUI avioesUI = new AvioesUI();
        avioesUI.mostrarAvioes();
        int codAviao;
        do{
            codAviao = Console.scanInt("Codigo do aviao: ");
        }while(avioes.procurarPorId(codAviao) == null);
        
        Aviao aviao = avioes.procurarPorId(codAviao);

        if(horario != null){
            lista.salvar(new Voo(origem, destino, horario, aviao, aviao.getN_assentos()));
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
        for (Voo voo : lista.listar()) {
            Aviao aviao = voo.getAviao();
            System.out.println(String.format("%-20s", voo.getId()) + "\t"
                + String.format("%-20s", "|" + aviao.getNome()) + "\t"
                + String.format("%-20s", "|" + voo.getOrigem()) + "\t"
                + String.format("%-20s", "|" + voo.getDestino()) + "\t"
                + String.format("%-30s", "|" + voo.getHorario()) + "\t"
                + String.format("%-20s", "|" + voo.getLugares()));
        }
    } 
}
