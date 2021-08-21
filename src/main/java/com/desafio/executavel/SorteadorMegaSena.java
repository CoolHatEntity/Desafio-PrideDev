package com.desafio.executavel;

import com.desafio.util.SorteadorDeEntradas;
import com.desafio.util.SorteadorDeNumeros;
import com.desafio.util.fileManager.EntradaDeValores;

import java.util.*;

public class SorteadorMegaSena  extends SorteadorDeNumeros {
    public static void gerenciadorSorteios(){
        int quantidadeJogos = 0;
        int quantidadeNumeros = 0;
        List<Set<Integer>> resultado = new ArrayList<>();
        Scanner scan =  new Scanner(System.in);
        System.out.println("|===========================================================|");
        while(quantidadeJogos <= 0){
            System.out.print("|====| Insira quantos jogos deseja fazer:"); quantidadeJogos = scan.nextInt();
        }

        scan.nextLine();

        int op = -1;
        System.out.println("|===========================================================|");
        System.out.println("|=========| Deseja utilizar números já existentes? |========|");
        System.out.println("|===========================================================|");
        System.out.println("|====| [0] - Sortear tudo aleatoriamente |==================|");
        System.out.println("|====| [1] - Inserir números pelo console |=================|");
        System.out.println("|====| [2] - Ler números de um arquivo |====================|");
        System.out.println("|===========================================================|");
        while (op != 2 && op != 1 && op != 0){
            System.out.print("|====| Insira sua opção:"); op = scan.nextInt();
        }
        Set<Integer> valorEntrada = new HashSet<>();
        switch (op){
            case 1:
                valorEntrada = EntradaDeValores.entradaConsole();
                break;
            case 2:
                valorEntrada = EntradaDeValores.entradaArquivo();
                if(valorEntrada == null){
                    System.out.println("|====| Nenhum valor foi lido do arquivo");
                    System.out.println("|====| Valores aleatórios serão usados");
                    op = 0;
                }
                break;
        }
        System.out.println("|==============================================================|");
        System.out.println("|=========| Selecionar quantos números sortear (6-15) |========|");
        System.out.println("|==============================================================|");
        for(int i = 0; i < quantidadeJogos; i++){
            while(quantidadeNumeros < 6 || quantidadeNumeros > 15){
                System.out.print("|====| Insira quantos números deseja sortear(0 = Sair):"); quantidadeNumeros = scan.nextInt();
                if(quantidadeNumeros == 0){
                    i = quantidadeJogos;
                    break;
                }
                if(quantidadeNumeros < 6 || quantidadeNumeros > 15){
                    System.out.println("|====| Entrada inválida");
                }else{
                    if (op == 0) {
                        resultado.add(sorteadorDeNumero(quantidadeNumeros));
                    } else {
                        resultado.add(SorteadorDeEntradas.sortearEntradas(valorEntrada, quantidadeNumeros));
                    }
                }
            }

            quantidadeNumeros = 0;
        }
        if(resultado.size() < 1){
            System.out.println("|====| Nenhum jogo foi gerado");
        }else {
            for (Set<Integer> integers : resultado) {
                System.out.println(integers);
            }
        }
    }



    private static Set<Integer> sorteadorDeNumero(int quantidade){
        return sorteiaNumeros(60, 1, quantidade);
    }
}
