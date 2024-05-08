
package View;

import java.util.Scanner;
import Holerite.Holerite;
import Holerite.Testing;

public class View {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);
        int saida = 1;
        
        while (saida == 1) {
            System.out.println("--------------------------------------------");
            System.out.println("\t\tMenu Inicial \t\t");
            System.out.println("--------------------------------------------");
            System.out.println("\n1.Iniciar \n2.Sair"); 
            System.out.printf("Digite sua escolha: ");
            saida = read.nextInt();
            System.out.println("\n--------------------------------------------\n");  
            switch (saida) {
                case 1 -> Holerite.Holerite();
                case 2 -> System.out.println("---------Finalizando o Programa-------------");
            }
        }
    }
}
