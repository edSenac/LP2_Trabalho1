/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Eduardo
 */
public class Aviao {
    
    private static int CODIGO = 1;
    private String nome;
    private int n_assentos;

    public Aviao() {
    }
    
    public static int getCODIGO() {
        return CODIGO;
    }

    public static void setCODIGO(int CODIGO) {
        Aviao.CODIGO = CODIGO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getN_assentos() {
        return n_assentos;
    }

    public void setN_assentos(int n_assentos) {
        this.n_assentos = n_assentos;
    }
    
    
    
    
}
