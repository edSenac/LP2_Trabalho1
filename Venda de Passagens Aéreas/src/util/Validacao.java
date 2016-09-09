/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Eduardo
 */
public class Validacao {
    
    public boolean validaNome(String nome){
        boolean valido = nome.trim().matches("/^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$/");
        return valido;
    }
    
    public boolean validaRg(String rg){
        boolean valido = rg.trim().matches("[0-9]{10}");
        return valido;
    }
    
    
}
