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
    private int codigo;
    private String nome;
    private int n_assentos;

    public Aviao(String nome, int n_assentos) {
        this.nome = nome;
        this.n_assentos = n_assentos;
        this.codigo = getCODIGO();
    }
    
    private static int getCODIGO() {
        return CODIGO++;
    }
    
    public int getCodigo(){
        return this.codigo;
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
