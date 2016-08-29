package Menu;

public class MainMenu {

    public static final int OP_CLIENTES = 1;
    public static final int OP_AVIOES = 2;
    public static final int OP_VOOS = 3;
    public static final int OP_VENDAS = 4;
    public static final int OP_SAIR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Menu Clientes\n"
                + "2- Menu Aviões\n"
                + "3- Menu Vôos\n"
                + "4- Menu Vendas\n"
                + "0- Sair da Aplicação"
                + "\n--------------------------------------");
    }
}
