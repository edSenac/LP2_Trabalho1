/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Voo;
import model.Aviao;
import util.Console;
import util.DateUtil;
import util.Validacao;
import menu.VoosMenu;
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
    
    private VooDAODB lista = new VooDAODB();
    private AviaoDAODB avioes = new AviaoDAODB();
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
                case VoosMenu.OP_REMOVER:
                    removerVoo();
                    break;
                case VoosMenu.OP_ATUALIZAR:
                    atualizarVoo();
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
        }while(!avioes.existeId(codAviao));
        
        Aviao aviao = avioes.procurarPorId(codAviao);

        if(horario != null){
            lista.salvar(new Voo(origem, destino, horario, aviao, aviao.getAssentos()));
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

    public void removerVoo() {
        System.out.println("Essa operação implica na remoção das vendas do voo.");
        String continua = "n";
        do{
            continua = Console.scanString("Deseja prosseguir? (S/N): ").toLowerCase();
        }while(continua.equals("s") || continua.equals("n"));
        if(continua.equals("s")){
            this.mostrarVoos();
            int id = Console.scanInt("Digite o id do voo que quer remover: ");
            Voo voo = lista.procurarPorId(id);
            if(voo != null) {
                lista.deletar(voo);
                System.out.println("Voo removido com sucesso.");
            } else {
                System.out.println("Voo não encontrado.");
            }
        }else{
            System.out.println("Abortando operação...");
        }
    }

    public void atualizarVoo() {
        String origem;
        String destino;
        String horarioStr;
        
        this.mostrarVoos();
        int id = Console.scanInt("Digite o id do voo que quer atualizar: ");
        Voo voo = lista.procurarPorId(id);
        if(voo != null) {
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
            }while(!avioes.existeId(codAviao));

            Aviao aviao = avioes.procurarPorId(codAviao);

            if(horario != null){
                lista.atualizar(new Voo(id, origem, destino, horario, aviao, aviao.getAssentos()));
                System.out.println("Voo atualizado com sucesso!");
            }
        } else {
            System.out.println("Voo não encontrado.");
        }
    }
     
}
