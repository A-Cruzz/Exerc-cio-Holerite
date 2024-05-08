package Holerite;

import Funcionario.Funcionario;
import Descontos.Descontos;
import Proventos.Proventos;

public class Testing {

    public static void teste() {
        
        Funcionario Funcionario[] = new Funcionario[1];
        Funcionario[0] = new Funcionario();
        int Dependentes = 0;
        double DespMed = 0;
        double DespOdont = 0;
        double TotalMed = DespMed + Funcionario[0].Amedico;
        double TotalOdont = DespOdont + Funcionario[0].Aodontologica;
        double TotalProventos = Proventos.HoraExtra + Proventos.AdicionalNot + Proventos.AdicionalPer + Proventos.AdicionalIns + Proventos.Bonificacoes;
        double TotalDescontos = Descontos.INSS + Descontos.IRRF + Descontos.DescontoVT + Descontos.DescontoTicketAR + Descontos.AssistMedicMen + Descontos.AssistMedicCoop + Descontos.AssistOdontMen + Descontos.AssistOdontCoop + Descontos.Sindicato;

        System.out.println("\n----------------------------------------------------------------------------------------");
        System.out.printf("\t\t\t\tHOLERITE %s\n ", Funcionario[0].Nome);
        System.out.println("----------------------------------------------------------------------------------------\n");
        System.out.printf("Nome: %s \t\t\tCPF: %d \t\t\tDependentes: %d\n\n",Funcionario[0].Nome, Funcionario[0].CPF, Dependentes);
        System.out.println("Proventos \t\t\t\t\t\tDescontos\n");
        System.out.printf("Salario: \tR$ %.2f \t\t\t\tINSS: \t\tR$ %.2f \n", Funcionario[0].Salario,Descontos.INSS);
        System.out.printf("H.E: \t\tR$ %.2f \t\t\t\tIRRF: \t\tR$ %.2f\n", Proventos.HoraExtra, Descontos.IRRF);
        System.out.printf("Adc. Not: \tR$ %.2f \t\t\t\tVT: \t\tR$ %.2f \n",Proventos.AdicionalNot, Descontos.DescontoVT);
        System.out.printf("Adc. Per: \tR$ %.2f \t\t\t\tTicketAR: \tR$ %.2f\n",Proventos.AdicionalPer, Descontos.DescontoTicketAR);
        System.out.printf("Adc. Ins \tR$ %.2f \t\t\t\tAssist. Med.\tR$ %.2f\n",Proventos.AdicionalPer, TotalMed);
        System.out.printf("Bonus: \t\tR$ %.2f \t\t\t\tAssist. Odont.\tR$ %.2f\n", Proventos.Bonificacoes, TotalOdont);
        System.out.printf("\t\t\t\t\t\t\tSindicato: \tR$ %.2f\n\n",Descontos.Sindicato);
        System.out.printf("Total de Proventos: R$ %.2f \t\t\t\tTotal de Descontos: R$ %.2f\n",TotalProventos, TotalDescontos);
        System.out.println("----------------------------------------------------------------------------------------");
        
    }

}
