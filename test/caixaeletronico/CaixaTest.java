/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixaeletronico;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author Douglas
 */
public class CaixaTest {
    
    public CaixaTest() {
    }
    
    /**
     * Teste do método sacar da classe caixa com um valor
     * múltiplo de dez. É esperado que o saque ocorra normalmente,
     * e o método retorne uma lista com as notas sacadas.
     */
    @Test
    public void testSacarMultiploDeDez() {
        System.out.println("sacar múltiplo de dez");
        int valor = 80;
        Caixa instance = new Caixa();
        List<Integer> expResult = Arrays.asList(50, 20, 10);
        List<Integer> result = instance.sacar(valor);
        assertThat(result, is(expResult));
    }
    
    /**
     * Teste do método sacar da classe caixa com um valor
     * que não é múltiplo de dez. É esperado que o saque não ocorra,
     * e que a exceção CashException seja lançada
     */
    @Test(expected = Caixa.CashException.class)
    public void testSacarNaoMultiploDeDez(){
        System.out.println("sacar não múltiplo de dez");
        Caixa instance = new Caixa();
        instance.sacar(19);
    }
    
    /**
     * Teste do método sacar da classe caixa com um valor negativo.
     * É esperado que o saque não ocorra, e que a exceção 
     * IllegalArgumentException seja lançada
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSacarNegativo(){
        System.out.println("sacar negativo");
        Caixa instance = new Caixa();
        instance.sacar(-30);
    }
    
}
