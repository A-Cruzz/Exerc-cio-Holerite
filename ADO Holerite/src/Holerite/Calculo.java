package Holerite;

import java.util.Scanner;
import Proventos.Proventos;
import Descontos.Descontos;
import Funcionario.Funcionario;
import CalculosADHOC.ValidadorCPF;

public class Calculo {

    Funcionario Funcionario[];

    public static void Calculos() {

//  Loop para manter o programa em funcionamento, at� que seja desejado o seu encerramento.
        int programa = 1;
        while (programa == 1) {
            int loopg;
            Scanner read = new Scanner(System.in);

            System.out.println("\n--------------------------------------------\n");
            System.out.println("\n--------------------------------------------\n");
            System.out.println("\tCadastro de funcion�rio(s)\n");

//  Bloco da inclus�o da quantidade de funcion�rios
            System.out.println("--------------------------------------------\n");
            System.out.println("Informe a quantidade de funcion�rios");
            System.out.printf("Quantidade de Funcion�rios: ");
            int QtdFuncionarios = read.nextInt();
            Funcionario Funcionario[] = new Funcionario[QtdFuncionarios];
            System.out.println("\n--------------------------------------------\n");
            for (int i = 0; i < Funcionario.length; i++) {

                Funcionario[i] = new Funcionario();

//  Recebe o nome do funcion�rio.
                System.out.println("\n--------------------------------------------");
                System.out.println("\t\tNome\t\t");
                System.out.println("--------------------------------------------\n");
                System.out.println("Informe o nome do funcion�rio");
                System.out.printf("Nome do Funcion�rio: ");
                Funcionario[i].Nome = read.next();
                String Sobrenome = read.nextLine();
                String NomeCompleto = Funcionario[i].Nome + " " + Sobrenome;
                System.out.println("\n--------------------------------------------\n");
//  Recebe o CPF e valida se o CPF � v�lido ou n�o.
                int saida = 1;
                while (saida == 1) {

                    System.out.println("\n--------------------------------------------");
                    System.out.println("\t\tCPF\t\t");
                    System.out.println("--------------------------------------------\n");

                    System.out.println("Informe o cpf do funcion�rio (sem separa��es)");
                    System.out.printf("CPF do Funcion�rio: ");
                    Funcionario[i].CPF = read.nextLong();

                    ValidadorCPF.ValidadorCPF(Funcionario[i].CPF);
                    if (ValidadorCPF.Validador == 0) {
                        System.out.println("CPF Inv�lido!, insira um CPF v�lido.\n");
                        System.out.println("--------------------------------------------");
                    } else {
                        System.out.println("CPF V�lido. \n");
                        saida = 0;
                        System.out.println("--------------------------------------------\n");
                    }
                }

//  Op��o da inclus�o de dependentes para o funcion�rio.
                System.out.println("\n--------------------------------------------");
                System.out.println("\t\tDependentes\t\t");
                System.out.println("--------------------------------------------\n");

                System.out.println("O funcion�rio possui dependentes? \n1.Sim \n2.N�o");
                System.out.printf("Digite sua escolha: ");
                loopg = read.nextInt();
                int Dependentes = 0;
                if (loopg == 1) {

                    System.out.println("\n--------------------------------------------");
                    System.out.println("\nInforma a quantidade de dependentes do funcion�rio (somente n�meors).");
                    System.out.printf("Quantidade de dependentes: ");
                    Dependentes = read.nextInt();

                    System.out.printf("\nTotal de dependentes: %d \n", Dependentes);
                } else {
                    System.out.println("\nFuncion�rio sem dependentes, prosseguindo para a pr�xima op��o.");
                }

//  Op��o obrigat�ria para o informe do sal�rio do funcion�rio.
                System.out.println("\n--------------------------------------------");
                System.out.println("\t\tSal�rio");
                System.out.println("--------------------------------------------\n");
                System.out.println("Informe o sal�rio do funcion�rio");
                System.out.printf("Salario: R$ ");
                Funcionario[i].Salario = read.nextDouble();

//  Op��o obrigat�ria para sele��o da jornada de horas do funcion�rio, necess�rio para os c�lculos realizados no c�digo.
                System.out.println("\n--------------------------------------------\n");
                System.out.println("\n--------------------------------------------");
                System.out.println("\t   Jornada de horas");
                saida = 1;
                while (saida == 1) {
                    System.out.println("--------------------------------------------\n");
                    System.out.println("Selecione a jornada de horas para o funcion�rio: \n1. 220 horas \n2. 200 horas\n3. 180 horas");
                    System.out.printf("Digite sua escolha: ");
                    int horas = read.nextInt();
                    switch (horas) {
                        case 1 -> {
                            Funcionario[i].Jhora = 220;
                            saida = 0;
                        }
                        case 2 -> {
                            Funcionario[i].Jhora = 200;
                            saida = 0;
                        }
                        case 3 -> {
                            Funcionario[i].Jhora = 180;
                            saida = 0;
                        }
                        default ->
                            System.out.println("Op��o inv�lida.");
                    }

                }
                System.out.println("\n--------------------------------------------\n");

//  Op��o para o calculo de horas extras.
                System.out.println("\n--------------------------------------------");
                System.out.println("\t\tHoras Extras");
                System.out.println("--------------------------------------------\n");

// Previnindo que a vari�vel seja lida com o valor da consulta ant�rior em caso de uma nova consulta.
                Proventos.HoraExtra = 0;

                System.out.println("O funcion�rio possu� horas extras? \n1.Sim \n2.N�o");
                System.out.printf("Digite sua escolha: ");
                loopg = read.nextInt();
                if (loopg == 1) {

                    System.out.println("\nInforma a quantidade de horas extras realizadas no m�s (somente n�meros).");
                    System.out.printf("Quantidade de horas extras: ");

                    double QtdHE = read.nextDouble();
                    Proventos.HoraExtra(Funcionario[i].Salario, Funcionario[i].Jhora, QtdHE);
                    System.out.printf("\nTotal de HE: R$%.2f \n", Proventos.HoraExtra);

                } else {
                    System.out.println("Funcion�rio sem Horas Extras, prosseguindo para a pr�xima op��o.");
                }
                System.out.println("\n--------------------------------------------\n");

//  Op��o para o calculo do adicional noturno.
                System.out.println("\n--------------------------------------------");
                System.out.println("\t\tAdicional Noturno");
                System.out.println("--------------------------------------------\n");

// Previnindo que a vari�vel seja lida com o valor da consulta ant�rior em caso de uma nova consulta.
                Proventos.AdicionalNot = 0;
                    
                System.out.println("O funcion�rio possu� Adicional Noturno? \n1.Sim \n2.N�o");
                System.out.printf("Digite sua escolha: ");
                loopg = read.nextInt();
                if (loopg == 1) {

                    System.out.println("\nInforma a quantidade de horas noturnas trabalhadas no m�s (somente n�meros).");
                    System.out.printf("Quantidade de horas para o adicional noturno: ");

                    double QtdAdcNot = read.nextDouble();
                    Proventos.AdicionalNot(Funcionario[i].Salario, Funcionario[i].Jhora, QtdAdcNot);
                    System.out.printf("\nTotal de Adicional Noturno: R$%.2f \n", Proventos.AdicionalNot);

                } else {
                    System.out.println("\nFuncion�rio sem Adicional Noturno, prosseguindo para a pr�xima op��o.");
                }
                System.out.println("\n--------------------------------------------\n");

//  Op��o para o c�lculo de periculosidade
                System.out.println("\n--------------------------------------------");
                System.out.println("\t\tAdicional Periculosidade");
                System.out.println("--------------------------------------------\n");
                
// Previnindo que a vari�vel seja lida com o valor da consulta ant�rior em caso de uma nova consulta.
               Proventos.AdicionalPer = 0;

                System.out.println("O funcion�rio possu� Adicional de Periculosidade? \n1.Sim \n2.N�o");
                System.out.printf("Digite sua escolha: ");
                loopg = read.nextInt();
                if (loopg == 1) {
                    Proventos.AdicionalPer(Funcionario[i].Salario);
                    System.out.printf("\nTotal de Adicional de Periculosidade: R$%.2f\n", Proventos.AdicionalPer);

                } else {
                    System.out.println("\nFuncion�rio sem Adicional de Periculosidade, prosseguindo para a pr�xima op��o.");
                }
                System.out.println("\n--------------------------------------------\n");

//  Op��o para o c�lculo do adicional de insalubridade
                System.out.println("\n--------------------------------------------");
                System.out.println("\t\tAdicional Insalubridade");
                System.out.println("--------------------------------------------\n");
                
// Previnindo que a vari�vel seja lida com o valor da consulta ant�rior em caso de uma nova consulta.
                Proventos.AdicionalIns = 0;
                
                System.out.println("O funcion�rio possu� Adicional de Insalubridade?");
                System.out.println("1.Sim \n2.N�o");
                System.out.printf("Digite sua escolha: ");
                loopg = read.nextInt();

                double piso = 0;
                double pctInsalubridade = 0;

                if (loopg == 1) {
                    saida = 1;
                    while (saida == 1) {
                        int p;

                        System.out.println("--------------------------------------------\n");
                        System.out.println("\nInforme o piso Salarial para o c�lculo da insalubridade: \n1.Sal�rio M�nimo (R$1.412,00). \n2.Outro valor.");
                        System.out.printf("Selecione a op��o de piso salarial: ");
                        p = read.nextInt();
                        switch (p) {
                            case 1 -> {
                                piso = 1412;
                                saida = 0;
                            }
                            case 2 -> {
                                System.out.println("\nDigite o valor do piso salarial:");
                                System.out.printf("Piso Salarial: R$");
                                piso = read.nextDouble();
                                saida = 0;
                            }
                            default ->
                                System.out.println("\nOp��o Inv�lida, selecione uma das op��es dispon�veis!");
                        }
                    }
                    saida = 1;
                    while (saida == 1) {
                        int p;
                        System.out.println("\n--------------------------------------------");
                        System.out.println("Informe a porcentagem de insalubridade: \n1.(10%). \n2.(20%). \n3.(40%).");
                        System.out.printf("Selecione a porcentagem: ");
                        p = read.nextInt();
                        switch (p) {
                            case 1 -> {
                                pctInsalubridade = 0.1;
                                saida = 0;
                            }
                            case 2 -> {
                                pctInsalubridade = 0.2;
                                saida = 0;
                            }
                            case 3 -> {
                                pctInsalubridade = 0.4;
                                saida = 0;
                            }
                            default ->
                                System.out.println("\nOp��o inv�lida! Selecione uma das op��es dispon�vels!");
                        }
                    }
                    Proventos.AdicionalIns(piso, pctInsalubridade);
                    System.out.printf("\nTotal de Adicional de Insalubridade: R$%.2f\n", Proventos.AdicionalIns);
                } else {
                    System.out.println("\nFuncion�rio sem Adicional de Insalubridade, prosseguindo para a pr�xima op��o.");
                }
                System.out.println("\n--------------------------------------------\n");

//  Bloco da inser��o de b�nus alheios.
                System.out.println("\n--------------------------------------------");
                System.out.println("\t\tB�nus");
                System.out.println("--------------------------------------------\n");
                 
// Previnindo que a vari�vel seja lida com o valor da consulta ant�rior em caso de uma nova consulta.
                Proventos.Bonificacoes = 0;

                System.out.println("Existe alguma bonifica��o para o funcion�rio?");
                System.out.println("1.Sim \n2.N�o");
                System.out.printf("Digite sua escolha: ");
                loopg = read.nextInt();
                double bonus;
                if (loopg == 1) {

                    System.out.println("\nInforme a quantidade TOTAL de b�nus a serem adicionados (somente n�meros)");
                    System.out.printf("B�nus: R$");
                    bonus = read.nextDouble();
                    Proventos.Bonuificacao(bonus);

                    System.out.printf("\nTotal de bonifica��es par ao funcion�rio: R$%.2f\n", Proventos.Bonificacoes);
                } else {
                    System.out.println("\nFuncion�rio sem bonifica��e.");
                }
                System.out.println("\n--------------------------------------------\n");
                System.out.println("\n--------------------------------------------");
                System.out.println("\t\tBenef�cios (VT)\t\t");
                System.out.println("--------------------------------------------\n");

//  Descontos
//  Calculo do sal�rio tribut�vel.
                Funcionario[i].SalarioTributavel = Funcionario[i].Salario + Proventos.HoraExtra + Proventos.AdicionalNot + Proventos.AdicionalPer + Proventos.AdicionalIns;

//  Calculos independentes da escolha do funcion�rio.
                Descontos.INSS(Funcionario[i].SalarioTributavel);
                Descontos.IRRF(Funcionario[i].SalarioTributavel, Dependentes);
                Funcionario[i].TicketAR = Descontos.DescontoTicketAR();
                Funcionario[i].Amedico = Descontos.AssistMedicMen();
                Funcionario[i].Aodontologica = Descontos.AssistOdontMen();

//  Calculo do VT, sendo opcional ou n�o, devido a necessidade de saber o valor de cargas di�rias utilizadas.
                System.out.println("O funcion�rio � optante pelo Vale Transporte? \n1.Sim \n2.N�o");
                System.out.printf("Digite sua escolha: ");
                loopg = read.nextInt();
                Funcionario[i].VT = 0;
                int vtdia = 0;
                double VTCal = vtdia * 5.80;
                if (loopg == 1) {
                    System.out.println("\nO valor do fixo do VT � de R$5,80, independente do meio de transporte.\nInforme a quantidade de vales utilizado di�riamente (ida e volta, apenas em n�meros)");
                    System.out.printf("Vales ulitizados (dia): ");
                    vtdia = read.nextInt();
                    Descontos.DescontoVT(Funcionario[i].Salario, vtdia);
                } else {
                    System.out.println("\nFuncion�rio n�o optante pelo Vale Transporte.\n");
                }
                Funcionario[i].VT = VTCal;
                System.out.println("\n--------------------------------------------\n");

                System.out.println("\n--------------------------------------------");
                System.out.println("\t\tConv�nios\t\t");
                System.out.println("--------------------------------------------\n");
//  Verifica��o da utiliza��o do servi�o de cooparticipa��o m�dica e odontol�gica do funcion�rio.
                System.out.println("Houve a utiliza��o de alguns dos servi��es de assist�ncia oferecidos? \n1.Assist�ncia M�dica \n2.Assist�ncia Odontol�gica \n3.Ambas Assist�nias \n4.Nenhuma utiliza��o.");
                System.out.printf("Digite sua escolha: ");
                double DespMed = 0;
                double DespOdont = 0;
                loopg = read.nextInt();
                saida = 1;
                while (saida == 1) {
                    switch (loopg) {
                        case 1 -> {
                            System.out.println("\nInforme o valor total gasto com despesas m�dicas: ");
                            DespMed = read.nextDouble();
                            Descontos.AssistMedicCoop(DespMed);
                            saida = 0;
                        }
                        case 2 -> {
                            System.out.println("\nInforme o valor total gasto com despesas odontol�gicas: ");
                            DespOdont = read.nextDouble();
                            Descontos.AssistOdontCoop(DespOdont);
                            saida = 0;
                        }
                        case 3 -> {
                            System.out.println("\nInforme primeiro o valor total gasto com despesas m�dicas e posteriormente o valor total das despesas odontol�gicas.");
                            System.out.printf("Despesas m�dicas: ");
                            DespMed = read.nextDouble();
                            Descontos.AssistMedicCoop(DespMed);
                            System.out.printf("\nDespesas odontol�gicas: ");
                            DespOdont = read.nextDouble();
                            Descontos.AssistOdontCoop(DespOdont);
                            saida = 0;
                        }
                        case 4 -> {
                            System.out.println("\nNenhum desconto com assist�ncias a ser computado.\n");
                            saida = 0;
                        }
                        default ->
                            System.out.println("\nOp��o inv�lida, selecione uma das op��es listadas.\n");
                    }
                }

                double TotalMed = DespMed + Funcionario[i].Amedico;
                double TotalOdont = DespOdont + Funcionario[i].Aodontologica;

                System.out.println("--------------------------------------------");

//  Verifica��o se o funcion�rio � optante pela contribui��o sindical
                System.out.println("\n--------------------------------------------");
                System.out.println("\tContribui��o Sindical\t\t");
                System.out.println("--------------------------------------------\n");
                System.out.println("\nO funcion�rio � optante pela contribui��o sindical? \n1.Sim \n2.N�o");
                System.out.printf("Digite sua escolha: ");
                loopg = read.nextInt();
                if (loopg == 1) {
                    Descontos.Sindicato();
                } else {
                    System.out.println("\nFuncion�rio n�o optante pela contribui��o.\n");
                }
                System.out.println("\n--------------------------------------------");

//  Visualiza��o do Holerite do funcion�rio.
                double TotalProventos = Funcionario[i].Salario + Proventos.HoraExtra + Proventos.AdicionalNot + Proventos.AdicionalPer + Proventos.AdicionalIns + Proventos.Bonificacoes;
                double TotalDescontos = Descontos.INSS + Descontos.IRRF + Descontos.DescontoVT + Descontos.DescontoTicketAR + Descontos.AssistMedicMen + Descontos.AssistMedicCoop + Descontos.AssistOdontMen + Descontos.AssistOdontCoop + Descontos.Sindicato;
                double Liquido = TotalProventos - TotalDescontos;

                String loopa = "1";
                if (loopa == "1") {
                    System.out.println("\n----------------------------------------------------------------------------------------");
                    System.out.printf("\t\t\t\tHOLERITE %s\n ", Funcionario[i].Nome);
                    System.out.println("----------------------------------------------------------------------------------------\n");
                    System.out.printf("Nome: %s\nCPF: %d \t\t\t\t\tDependentes: %d\n\n", NomeCompleto, Funcionario[i].CPF, Dependentes);
                    System.out.println("Proventos \t\t\t\t\t\tDescontos\n");
                    System.out.printf("Salario: \tR$ %.2f \t\t\t\tINSS: \t\tR$ %.2f \n", Funcionario[i].Salario, Descontos.INSS);
                    System.out.printf("H.E: \t\tR$ %.2f \t\t\t\tIRRF: \t\tR$ %.2f\n", Proventos.HoraExtra, Descontos.IRRF);
                    System.out.printf("Adc. Not: \tR$ %.2f \t\t\t\tVT: \t\tR$ %.2f \n", Proventos.AdicionalNot, Descontos.DescontoVT);
                    System.out.printf("Adc. Per: \tR$ %.2f \t\t\t\tTicketAR: \tR$ %.2f\n", Proventos.AdicionalPer, Descontos.DescontoTicketAR);
                    System.out.printf("Adc. Ins \tR$ %.2f \t\t\t\tAssist. Med.\tR$ %.2f\n", Proventos.AdicionalIns, TotalMed);
                    System.out.printf("Bonus: \t\tR$ %.2f \t\t\t\tAssist. Odont.\tR$ %.2f\n", Proventos.Bonificacoes, TotalOdont);
                    System.out.printf("\t\t\t\t\t\t\tSindicato: \tR$ %.2f\n\n", Descontos.Sindicato);
                    System.out.printf("Total de Proventos: R$ %.2f \t\t\t\tTotal de Descontos: R$ %.2f\n", TotalProventos, TotalDescontos);
                    System.out.printf("Salario Liquido: R$ %.2f\n", Liquido);
                    System.out.println("\n----------------------------------------------------------------------------------------");

                    System.out.println("\nInsira qualquer valor qualquer tecla para continuar.");
                    loopa = read.next();
                }
            }
            System.out.println("\n--------------------------------------------");
            System.out.println("\t\tFim do Cadastro\t\t");
            System.out.println("--------------------------------------------\n");

            System.out.println("Deseja voltar ao painel do Holerite? \n1.Sim \n2.Cadastrar novos funcio�rios.");
            System.out.printf("Digite sua escolha: ");
            loopg = read.nextInt();
            if (loopg == 1) {
                System.out.println("\nVoltando para o Holerite.\n");
                System.out.println("--------------------------------------------\n");

                programa = 0;
            } else {
                System.out.println("\nVoltando para o cadastro de funcion�rios.");
            }
        }
    }
}
