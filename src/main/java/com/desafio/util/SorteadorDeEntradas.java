package com.desafio.util;

import java.util.*;

public class SorteadorDeEntradas {
    public static Set<Integer> sortearEntradas(Set<Integer> entradas, int quantidade){
        Set<Integer> saida = new HashSet<>();
        Random rand = new Random();
        int index;

        //Se utiliza ‘List’ ao invés de ‘Set’ para poder ter acesso ao comando ‘get()’, sendo ele útil para poder sortear a partir do elemento selecionado
        List<Integer> temp = new ArrayList<>(entradas);

        for(int i  = 0; i < temp.size(); i++){
            if(temp.get(i) < 1 || temp.get(i) > 60){
                temp.remove(i);
            }
        }

        //Verifica se o ‘Set’ com as entradas é grande o suficiente para ter os números sorteados a partir dele
        //Caso não seja, ele irá tentar completar o ‘Set’ com valores aleatórios
        if(temp.size() < quantidade){
            //Sorteia a partir dos valores de entrada
            while((saida.size() != (quantidade - temp.size() ))){
                index = rand.nextInt(temp.size());
                saida.add(temp.get(index));
            }
            while (saida.size() != quantidade){
                //Sorteia valores individuais, garantindo que eles não sejam repetidos
                //Completando assim o ‘Set’ de retorno
                saida.addAll(SorteadorDeNumeros.sorteiaNumeros(60, 1, 1));
            }
        }else{
            //Sorteia valores aleatorios a partir da entrada
            while ((saida.size() != quantidade)) {
                index = rand.nextInt(temp.size());
                saida.add(temp.get(index));
            }
        }

        return saida;
    }
}
