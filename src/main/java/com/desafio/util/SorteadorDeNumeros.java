package com.desafio.util;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class SorteadorDeNumeros {
    protected static Set<Integer> sorteiaNumeros(int upperBound, int lowerBound, int quantidade){
        Set<Integer> retornoNumeros = new LinkedHashSet<>();
        Random rand = new Random();
        //Realiza o sorteio se três condições forem verdadeiras
        //1 - O valor superior precisa ser maior que o inferior
        //2 - A quantidade precisa ser maior, ou igual á 1
        //3 - A quantidade de números precisa estar contida no delimitador definido pelos valores inferiores e superiores
        if((upperBound > lowerBound) && (quantidade >= 1) && (((upperBound - lowerBound) + 1) >= quantidade)){
            while (retornoNumeros.size() != quantidade) {
                retornoNumeros.add(rand.nextInt((upperBound - lowerBound) + 1) + lowerBound);
            }
        }else{
            System.out.println("|====| Entrada Inválida");
            return null;
        }
        return retornoNumeros;
    }
}
