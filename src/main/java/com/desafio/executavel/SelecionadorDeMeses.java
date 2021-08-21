package com.desafio.executavel;

import java.util.Scanner;

public class SelecionadorDeMeses {
    public static void selecionadorDeMeses(){
        String[] meses = {"Janeiro", "Fevereiro", "Março",
                "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro",
                "Outubro", "Novembro", "Dezembro"};
        Scanner scan = new Scanner(System.in);

        System.out.println("|===========================================================|");
        System.out.println("|====| Utilize de [1-12] para selecionar um mês |===========|");
        System.out.println("|===========================================================|");
        System.out.print("|==> Insira o mês:"); int input = scan.nextInt();
        switch (input){
            case 1:
                System.out.println("|====| Mês inserido =>" + meses[input - 1]);
                break;
            case 2:
                System.out.println("|====| Mês inserido =>" + meses[input - 1]);
                break;
            case 3:
                System.out.println("|====| Mês inserido =>" + meses[input - 1]);
                break;
            case 4:
                System.out.println("|====| Mês inserido =>" + meses[input - 1]);
                break;
            case 5:
                System.out.println("|====| Mês inserido =>" + meses[input - 1]);
                break;
            case 6:
                System.out.println("|====| Mês inserido =>" + meses[input - 1]);
                break;
            case 7:
                System.out.println("|====| Mês inserido =>" + meses[input - 1]);
                break;
            case 8:
                System.out.println("|====| Mês inserido =>" + meses[input - 1]);
                break;
            case 9:
                System.out.println("|====| Mês inserido =>" + meses[input - 1]);
                break;
            case 10:
                System.out.println("|====| Mês inserido =>" + meses[input - 1]);
                break;
            case 11:
                System.out.println("|====| Mês inserido =>" + meses[input - 1]);
                break;
            case 12:
                System.out.println("|====| Mês inserido =>" + meses[input - 1]);
                break;
            default:
                System.out.println("|====| Entrada inválida");
                break;
        }
    }
}
