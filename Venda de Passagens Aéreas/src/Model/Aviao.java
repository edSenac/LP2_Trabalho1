/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Classe de abstração de Avião
 * 
 * @author Eduardo
 */
public class Aviao {
    
    private static int CODIGO = 1;
    private int codigo;
    private String nome;
    private int n_assentos;

    /**
     * Método construtor da classe
     * 
     * @param nome String
     * @param n_assentos int
     */
    public Aviao(int codigo, String nome, int n_assentos) {
        this.nome = nome;
        this.n_assentos = n_assentos;
        this.codigo = codigo;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    /**
     * Getter
     * @return int codigo do avião
     */
    public int getCodigo(){
        return this.codigo;
    }
    
    /**
     * Getter
     * @return String nome do avião
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter
     * @param nome String
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter
     * @return int número de assentos do avião
     */
    public int getN_assentos() {
        return n_assentos;
    }

    public void setN_assentos(int n_assentos) {
        this.n_assentos = n_assentos;
    }
    
}
