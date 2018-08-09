/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixaeletronico;

import java.util.ArrayList;

/**
 * Classe para implementação de um caixa eletrônico
 * @author Douglas
 */
public class Caixa {
    
    /**
     * Valores das notas disponíveis no caixa eletrônico
     */
    private final int[] NOTAS = {100, 50, 20, 10};
    
    /**
     * Método que retorna as notas a serem sacados pelo cliente
     * @param valor o valor a ser sacado pelo cliente
     * @return uma lista com as notas sacadas pelo cliente
     * @throws IllegalArgumentException se o valor for negativo
     * @throws CashException se o valor não for múltiplo de dez
     */
    public ArrayList<Integer> sacar(int valor){
        ArrayList<Integer> devolucao = new ArrayList<>();
        if(valor <= 0)
            throw new IllegalArgumentException("Valor inválido");
        if(valor % 10 == 0){
            while(valor > 0){
                for(int i: NOTAS){
                    int aux = valor / i;
                    while(aux >= 1){
                        devolucao.add(i);
                        valor -= i;
                        aux = valor / i;
                    }
                }
            }
        }
        else
            throw new CashException("Não é possível sacar o valor solicitado");
        return devolucao;
    }
    
    public static class CashException extends RuntimeException{
        
        public CashException(String msg){
            super(msg);
        }
        
        public CashException(){
            super();
        }
    }
}
