/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversoes;

import operacoes.Expoente;

/**
 * metodo que recebe um numero hexadecimal
 * @author horaciocome1
 */
public class Hexadecimal {
    
    //metodo que recebe um vetor hexadecimal e retorna um numero decimal
    public static int Decimal (int[] vet, int x){
        int num, soma=0;
        for (int i=0; i<vet.length; i++){
            if (vet[i]>=1 && vet[i]<=15){
                num = Expoente.Hexadecimal(x);
                num = num * vet[i];
                soma = soma + num;
            }
            x--;
        }
        return soma;
    }
    
    //metodo que recebe um vetor hexadecimal e retorna uma string binaria
    public static String Binario (int[] vet, int x) {
        return Decimal.Binario(Hexadecimal.Decimal(vet, x));
    }
    
    //metodo que recebe um vetor hexadecimal e retorna uma string octal
    public static String Octal (int[] vet, int x) {
        return Decimal.Octal(Hexadecimal.Decimal(vet, x));
    }    
}
