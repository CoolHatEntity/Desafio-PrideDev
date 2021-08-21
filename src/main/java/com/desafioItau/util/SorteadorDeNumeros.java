package com.desafioItau.util;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class SorteadorDeNumeros {
    protected static Set<Integer> sorteiaNumeros(int upperBound, int lowerBound, int quantidade){
        Set<Integer> retornoNumeros = new LinkedHashSet<>();
        Random rand = new Random();
        if((upperBound > lowerBound) && (quantidade > 1) && (((upperBound - lowerBound) + 1) >= quantidade)){
            while (retornoNumeros.size() != quantidade) {
                retornoNumeros.add(rand.nextInt((upperBound - lowerBound) + 1) + lowerBound);
            }
        }else{
            System.out.println("Entrada Inválida");
            return null;
        }
        return retornoNumeros;
    }
}
