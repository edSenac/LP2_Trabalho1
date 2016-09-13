/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Eduardo
 */
public class Validacao {
    
    Pattern pattern;
    Matcher matcher;
    
    public boolean validaNome(String nome){
        if(nome.equals("")){
            return false;
        }
        pattern = Pattern.compile("[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$");
        matcher = pattern.matcher(nome);
        boolean result = matcher.matches();
        return result;
    }
    
    public boolean validaRg(String rg){
        if(rg.equals("")){
            return false;
        }
        pattern = Pattern.compile("[0-9]{10}");
        matcher = pattern.matcher(rg);
        return matcher.matches();
    }
    
    
}
