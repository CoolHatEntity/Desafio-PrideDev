package com.desafio.util.fileManager;

import java.util.*;

public class EntradaDeValores {

    //Responsável por lidar com a lógica por trás da entrada de dados pelo usuário
    public static Set<Integer> entradaConsole(){
        int entrada = 1;
        Scanner s = new Scanner(System.in);
        int quantidade = 0;
        Set<Integer> entradas = new HashSet<>();
        System.out.println("|============================================================|");
        System.out.println("|==| Insira as entradas desejadas, ou \"0\" para finalizar |==|");
        System.out.println("|==| Valores repetidos serão desconsiderados              |==|");
        while (entrada != 0){
            System.out.print("|==| Insira a entrada:"); entrada = s.nextInt();
            if(entrada > 5 && entrada <= 15){
                entradas.add(entrada);
            }else{
                System.out.println("|==| Entrada inválida");
            }
        }
        System.out.println("|============================================================|");
        entradas.remove(0);
        s.nextLine();
        String op = "";
        System.out.println("|============================================================|");
        System.out.println("|==| Deseja salvar as entradas em um arquivo?(S/N)        |==|");
        while (!op.equals("N")){
            System.out.print("|==| Insira sua opção(S/N):"); op = s.nextLine();
            if(op.equals("S")){
                System.out.print("|==| Insira o nome do arquivo:"); FileManager.fileWriter(s.nextLine(), entradas);
                op = "N";
            }else if(!op.equals("N") && !op.equals("")){
                System.out.println("|==| Opção Inválida!");
            }
        }
        return entradas;
    }
    public static Set<Integer> entradaArquivo(){
        String fileName = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("|=================================================================|");
        System.out.println("|==| Insira o nome do arquivo para continuar (\"Sair\" para sair) |==|");
        while(!FileManager.fileChecker(fileName)){
            System.out.print("|==| Nome do arquivo:"); fileName = scan.nextLine();
            if(fileName.equals("Sair")){
                break;
            }
        }
        if(!fileName.equals("Sair")){
            return FileManager.fileReader(fileName);
        }else{
            return null;
        }
    }
}
