/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.Aviao;
import interfaces.AviaoDAO;

/**
 *
 * @author 631620220
 */
public class AviaoDAODB implements AviaoDAO{

    @Override
    public boolean salvar(Aviao aviao){
        return false;
    }
    
    @Override
    public boolean atualizar(Aviao aviao){
        return false;
    }
    
    @Override
    public boolean deletar(Aviao aviao){
        return false;
    }
    
    @Override
    public void listar(){
        
    }
    
    @Override
    public Aviao consultar(int id){
        return null;
    }
    
}
