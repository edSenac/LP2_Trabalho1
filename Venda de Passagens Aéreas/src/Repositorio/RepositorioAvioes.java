/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Model.Aviao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class RepositorioAvioes {

    private List<Aviao> avioes;
    
    public RepositorioAvioes(){
        avioes = new ArrayList<Aviao>();
    }
    
    public boolean addAviao (Aviao aviao) {
        return (avioes.add(aviao));
    }
    
    public List<Aviao> getListaAvioes () {
        return avioes;
    }
    
    public boolean existeAviao(String nome){
        for (Aviao aviao : avioes) {
            if (aviao.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }
    
        public boolean existeAviaoCod(int codigo){
        for (Aviao aviao : avioes) {
            if (aviao.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }
    
    public Aviao getAviao(int codigo){
        for (Aviao aviao : this.getListaAvioes()) {
            if(codigo == aviao.getCodigo()){
                return aviao;
            }
        }
        return null;
    }
}
