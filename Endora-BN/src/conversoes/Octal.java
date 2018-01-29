/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversoes;

import operacoes.Expoente;

/**
 * metodo que recebe um numero octal
 * @author horaciocome1
 */
public class Octal {
    
    //metodo que recebe um vetor octal e retorna um numero decimal
    public static int Decimal (int[] vet, int x){
        int num, soma;
        soma=0;
        for (int i=0; i<vet.length; i++){
            if (vet[i]>=1 && vet[i]<=7){
                num = Expoente.Octal(x);
                num = num * vet[i];
                soma = soma + num;
            }else{
                System.out.print("HG"+vet[i]);
            }
            x--;
        }
        return soma;
    }
    
    //metodo que recebe um vetor octal e retorna uma string binaria
    public static String Binario (int[] vet, int x) {
        return Decimal.Binario(Octal.Decimal(vet, x));
    }
    
    //metodo que recebe um vetor octal e retorna uma string hexadecimal
    public static String Hexadecimal (int[] vet, int x) {
        return Decimal.Hexadecimal(Octal.Decimal(vet, x));
    }
    
}
