package com.desafio;

import com.desafio.executavel.SelecionadorDeMeses;
import com.desafio.executavel.SorteadorMegaSena;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int op;
        printMenu();
        while(true){
            System.out.print("|====| Insira sua opçao:"); op = scan.nextInt();
            if(op == 0){
                SorteadorMegaSena.gerenciadorSorteios();
                System.out.println("|====| Saindo da mega sena");
                printMenu();
            }else if( op == 1){
                SelecionadorDeMeses.selecionadorDeMeses();
                System.out.println("|====| Saindo do selecionador de meses");
                printMenu();
            }else if(op == 2){
                break;
            }else{
                System.out.println("|====| Entrada inválida");
            }
        }
    }
    private static void printMenu(){
        System.out.println("|===========================================================|");
        System.out.println("|=========|    Qual \"Desafio\" deseja selecionar   |=========|");
        System.out.println("|===========================================================|");
        System.out.println("|====| [0] - Sortear números da mega sena |=================|");
        System.out.println("|====| [1] - Selecionar mês |===============================|");
        System.out.println("|====| [2] - Sair |=========================================|");
        System.out.println("|===========================================================|");
    }
}
