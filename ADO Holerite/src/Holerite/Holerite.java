package Holerite;

import java.util.Scanner;

public class Holerite {
    
    public static void Holerite(){
        
        int programa = 1;
        while (programa == 1){
            
            Scanner read = new Scanner(System.in);
            int escolha;
            
            System.out.println("--------------------------------------------");
            System.out.println("\t   Painel de Seleção \t\t");
            System.out.println("--------------------------------------------\n");
            System.out.println("1.Inclusão de Funcionário(s) \n2.Sair \n");
            System.out.printf("Digite sua escolha: ");
            escolha = read.nextInt();
            
            switch (escolha){
                case 1 -> Calculo.Calculos();
                case 2 ->{
                    System.out.println("\n--------------------------------------------\n");
                    System.out.println("------------Voltando ao menu----------------\n");
                    programa = 0;
                    break;
                }
            }
            
            
        }
        
    }
}
