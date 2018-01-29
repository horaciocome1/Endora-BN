/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversoes;

import operacoes.Expoente;

/**
 * class que recebe um numero binario
 * @author horaciocome1
 */
public class Binario {
    
    //metodo que recebe um vector binario e retorna um numero decimal e este metodo eh a base dos demais metodos
    public static int Decimal (int[] vet, int x){
        int num, soma;
        soma=0;
        for (int i=0; i<vet.length; i++){
            if (vet[i]==1){
                num = Expoente.Binario(x);
                soma = soma + num;
            }
            x--;
        }
        return soma;
    }
    
    //metodo que recebe um vetor binario e retorna uma string octal
    public static String Octal (int[] vet, int x){
        //mandamos para decimal.octal o resultado de binario.decimal
        return Decimal.Octal(Binario.Decimal(vet, x));
    }
    
    //metodo que recebe um vetor binario e retorna uma string hexadecimal
    public static String Hexadecimal (int[] vet, int x) {
        //mandamos para decimal.hexadecima o resultado de binario.decimal
        return Decimal.Hexadecimal(Binario.Decimal(vet, x));
    }
    
}
