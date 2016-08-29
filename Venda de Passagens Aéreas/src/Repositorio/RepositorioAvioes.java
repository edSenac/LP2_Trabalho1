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
}
