/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

/**
 *
 * @author Eduardo
 */
public class AvioesMenu {

    public static final int OP_CADASTRAR = 1;
    public static final int OP_LISTAR = 2;
    public static final int OP_REMOVER = 3;
    public static final int OP_ATUALIZAR = 4;
    public static final int OP_VOLTAR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Cadastrar Aviao\n"
                + "2- Listar Avioes\n"
                + "3- Remover Aviao\n"
                + "4- Atualizar Aviao\n"
                + "0- Voltar"
                + "\n--------------------------------------");
    }
    
}
