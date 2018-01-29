/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversoes;

import javax.swing.JOptionPane;

/**
 * class que recebe um numero decimal
 * @author horaciocome1
 */
public class Decimal {
    
    //metodo que recebe um numero decimal e retorna uma string hexadecimal
    public static String Binario (int x){
        String y = "";
        int resto, i = 0, size = 100000;
        int vetor[] = new int [size];
        do{
            i++;
            resto = x % 2;
            x = x - resto;
            x = x / 2;
            if (i <= size){
                vetor [i] = resto;
             //   y = y + vetor[i];
            }    
        } while (x != 0);
        while (i>0){
            y = y + vetor[i];
            i--;
        }
        return y;
    }
    
    //metodo que recebe um numero decimal e retorna uma String octal
    public static String Octal (int x){
        String y = "";
        int resto, i = 0, size = 100000;
        int vetor[] = new int [size];
        do{
            i++;
            resto = x % 8;
            x = x - resto;
            x = x / 8;
            if (i <= size){
                vetor [i] = resto;
             //   y = y + vetor[i];
            } else {
                JOptionPane.showMessageDialog(null, "Demasiado"+i);
            }    
        } while (x != 0);
        while (i>0){
            y = y + vetor[i];
            i--;
        }
        return y;
    }
    
    //metodo que recebe um numero decimal e retorna uma String hexadecimal
    public static String Hexadecimal (int x){
        String y = "";
        int resto, i = 0, size = 100000;
        int vetor[] = new int [size];
        do{
            i++;
            resto = x % 16;
            x = x - resto;
            x = x / 16;
            if (i <= size){
                vetor [i] = resto;
             //   y = y + vetor[i];
            } else {
                JOptionPane.showMessageDialog(null, "Demasiado"+i);
            }    
        } while (x != 0);
        while (i>0){
            switch (vetor[i]){
                case 10: y = y + "A"; break;
                case 11: y = y + "B"; break;
                case 12: y = y + "C"; break;
                case 13: y = y + "D"; break;
                case 14: y = y + "E"; break;
                case 15: y = y + "F"; break;
                default: y = y + vetor[i];
            }
            i--;
        }
        return y;
    }
    
    
}
