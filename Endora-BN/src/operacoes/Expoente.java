/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operacoes;

/**
 * metodo que calcula o expoente na bases numericas binario, octal, hexadecimal
 * @author horaciocome1
 */
public class Expoente {
    
    public static int Binario(int exp){
        int resultado=1;
        if (exp == 0){
            resultado = 1;
        }else{
            for(int i=1; i<exp; i++){
                resultado = resultado * 2;
            }
        }
        return resultado;
    }
    
    public static int Octal(int exp){
        int resultado=1;
        if (exp == 0){
            resultado = 1;
        }else{
            for(int i=1; i<exp; i++){
                resultado = resultado * 8;
            }
        }
        return resultado;
    }
    
    public static int Hexadecimal(int exp){
        int resultado=1;
        if (exp == 0){
            resultado = 1;
        }else{
            for(int i=1; i<exp; i++){
                resultado = resultado * 16;
            }
        }
        return resultado;
    }
    
}
