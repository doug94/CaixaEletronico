/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixaeletronico;

import caixaeletronico.Caixa.CashException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Douglas
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Caixa c = new Caixa();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Digite o valor a ser sacado: ");
            int valor = input.nextInt();
            try {
                ArrayList<Integer> notas = c.sacar(valor);
                System.out.print("O valor será sacado nas notas de ");
                for(int i = 0; i < notas.size() - 1; i++)
                    System.out.print(notas.get(i) + ", ");
                System.out.println("e " + notas.get(notas.size() - 1));
                break;
            } catch (CashException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
