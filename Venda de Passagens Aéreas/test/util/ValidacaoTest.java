/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eduardo
 */
public class ValidacaoTest {
    
    private String nomeValido;
    private String nomeInvalido;
    
    private String rgValido;
    private String rgInvalido;
    
    public ValidacaoTest() {
        nomeValido = "nome";
        nomeInvalido = "1";
        
        rgValido = "1234567890";
        rgInvalido = "aaa";
    }

    /**
     * Test of validaNome method, of class Validacao.
     */
    @Test
    public void testValidaNomeValido() {
        System.out.println("validaNome");
        Validacao instance = new Validacao();

        boolean result = instance.validaNome(nomeValido);
        assertEquals(true, result);
    }
    
    @Test
    public void testValidaNomeInvalido() {
        System.out.println("validaNome");
        Validacao instance = new Validacao();

        boolean result = instance.validaNome(nomeInvalido);
        assertEquals(false, result);
    }

    /**
     * Test of validaRg method, of class Validacao.
     */
    @Test
    public void testValidaRgValido() {
        System.out.println("validaRg");
        Validacao instance = new Validacao();

        boolean result = instance.validaRg(rgValido);
        assertEquals(true, result);
    }
    
    @Test
    public void testValidaRgInvalido() {
        System.out.println("validaRg");
        Validacao instance = new Validacao();

        boolean result = instance.validaRg(rgInvalido);
        assertEquals(false, result);
    }
    
}
