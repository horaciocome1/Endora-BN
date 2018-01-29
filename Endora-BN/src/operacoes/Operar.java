/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operacoes;

/**
 * calcula adicao,subtracao, multiplicacao, divisao
 * os metodos devolvem strings que futuramente podem ser convertidas em inteiro se forem diferentes de erro!
 * @author horaciocome1
 */
public class Operar {
    
    public String adiciona (int x, int y) {
        String resultado;
        resultado = String.valueOf(x+y);
        return resultado;
    }
    
    public String subtrai (int x, int y) {
        String resultado;
        if (x>y)
            resultado = String.valueOf(x-y);
        else
            resultado = "ERRO!";
        return resultado;
    }
    
    public String Multiplica (int x, int y) {
        String resultado;
        resultado = String.valueOf(x*y);
        return resultado;
    }
    
    public String Divide (int x, int y) {
        String resultado;
        if (y==0)
            resultado = "ERRO!";
        else {
            try {
                x = x/y;
                resultado = String.valueOf(x/y);
            } catch (Exception e) {
                resultado = "ERRO!";
            }
        }
        return resultado;
    }
    
}
