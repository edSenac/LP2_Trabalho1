/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import model.Aviao;
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
    
        public boolean existeAviaoId(int id){
        for (Aviao aviao : avioes) {
            if (aviao.getId() == id) {
                return true;
            }
        }
        return false;
    }
    
    public Aviao getAviao(int id){
        for (Aviao aviao : this.getListaAvioes()) {
            if(id == aviao.getId()){
                return aviao;
            }
        }
        return null;
    }
}
