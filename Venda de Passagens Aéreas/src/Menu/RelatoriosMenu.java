/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

/**
 *
 * @author Eduardo
 */
public class RelatoriosMenu {
    
    public static final int REL_CLIENTE = 1;
    public static final int REL_PASSAGEIRO = 2;
    public static final int REL_ORIGEM = 3;
    public static final int REL_DESTINO = 4;
    public static final int OP_VOLTAR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- por Cliente\n"
                + "2- por Passageiro\n"
                + "3- Voos por Origem\n"
                + "4- Voos por Destino\n"
                + "0- Voltar"
                + "\n--------------------------------------");
    }   
      
}
