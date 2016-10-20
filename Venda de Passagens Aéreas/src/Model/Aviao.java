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
    
    private int id;
    private String nome;
    private int assentos;

    /**
     * Método construtor da classe
     * 
     * @param nome String
     * @param assentos int
     */
    public Aviao(int id, String nome, int assentos) {
        this.id = id;
        this.nome = nome;
        this.assentos = assentos;
    }
    
    public Aviao(String nome, int assentos){
        this.nome = nome;
        this.assentos = assentos;
    }
    
    public void setId(int codigo){
        this.id = id;
    }
    
    /**
     * Getter
     * @return int codigo do avião
     */
    public int getId(){
        return this.id;
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
    public int getAssentos() {
        return assentos;
    }

    public void setAssentos(int assentos) {
        this.assentos = assentos;
    }
    
}
