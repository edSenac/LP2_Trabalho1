/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Classe para validação de dados de entrada
 * @author Eduardo
 */
public class Validacao {
    
    Pattern pattern;
    Matcher matcher;
    
    /**
     * Valida uma string de nome, para garantir que não é vazia
     * nem contem números, através de uma expressão regular
     * @param nome
     * @return true se entrada é válida, se não, false
     */
    public boolean validaNome(String nome){
        if(nome.isEmpty()){
            System.out.println("Entrada inválida");
            return false;
        }
        pattern = Pattern.compile("[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$");
        matcher = pattern.matcher(nome);
        boolean result = matcher.matches();
        if(!result){
            System.out.println("Entrada inválida");
        }
        return result;
    }
    
    /**
     * Valida uma string numérica de 10 dígitos contendo um RG
     * @param rg
     * @return true se entrada é válida, se não, false
     */
    public boolean validaRg(String rg){
        if(rg.isEmpty()){
            System.out.println("RG inválido");
            return false;
        }
        pattern = Pattern.compile("[0-9]{10}");
        matcher = pattern.matcher(rg);
        boolean result = matcher.matches();
        if(!result){
            System.out.println("RG inválido");
        }
        return result;
    }
    
        /**
     * Valida uma string numérica de 8 a 12 dígitos contendo um RG
     * @param telefone
     * @return true se entrada é válida, se não, false
     */
    public boolean validaTelefone(String telefone){
        if(telefone.isEmpty()){
            System.out.println("Telefone inválido");
            return false;
        }
        pattern = Pattern.compile("[0-9]{8,12}");
        matcher = pattern.matcher(telefone);
        boolean result = matcher.matches();
        if(!result){
            System.out.println("Telefone inválido");
        }
        return result;
    }
    
    
}
