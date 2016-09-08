/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Model.Voo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class RepositorioVoos {
    
    private List<Voo> voos;

    public RepositorioVoos() {
        voos = new ArrayList<Voo>();
    }
    
    public boolean addVoo(Voo voo){
        return (voos.add(voo));
    }
    
    public List<Voo> getListaVoos(){
        return voos;
    }

    public Voo getVoo(int codigo){
        for (Voo voo : this.getListaVoos()) {
            if(codigo == voo.getCodigo()){
                return voo;
            }
        }
        return null;
    }
}
