package Holerite;

import java.util.Scanner;
import Proventos.Proventos;
import Descontos.Descontos;
import Funcionario.Funcionario;
import CalculosADHOC.ValidadorCPF;

public class Calculo {

    Funcionario Funcionario[];

    public static void Calculos() {

//  Loop para manter o programa em funcionamento, até que seja desejado o seu encerramento.
        int programa = 1;
        while (programa == 1) {
            int loopg;
            Scanner read = new Scanner(System.in);

            System.out.println("\n--------------------------------------------\n");
            System.out.println("\n--------------------------------------------\n");
            System.out.println("\tCadastro de funcionário(s)\n");

//  Bloco da inclusão da quantidade de funcionários
            System.out.println("--------------------------------------------\n");
            System.out.println("Informe a quantidade de funcionários");
            System.out.printf("Quantidade de Funcionários: ");
            int QtdFuncionarios = read.nextInt();
            Funcionario Funcionario[] = new Funcionario[QtdFuncionarios];
            System.out.println("\n--------------------------------------------\n");
            for (int i = 0; i < Funcionario.length; i++) {

                Funcionario[i] = new Funcionario();

//  Recebe o nome do funcionário.
                System.out.println("\n--------------------------------------------");
                System.out.println("\t\tNome\t\t");
                System.out.println("--------------------------------------------\n");
                System.out.println("Informe o nome do funcionário");
                System.out.printf("Nome do Funcionário: ");
                Funcionario[i].Nome = read.next();
                String Sobrenome = read.nextLine();
                String NomeCompleto = Funcionario[i].Nome + " " + Sobrenome;
                System.out.println("\n--------------------------------------------\n");
//  Recebe o CPF e valida se o CPF é válido ou não.
                int saida = 1;
                while (saida == 1) {

                    System.out.println("\n--------------------------------------------");
                    System.out.println("\t\tCPF\t\t");
                    System.out.println("--------------------------------------------\n");

                    System.out.println("Informe o cpf do funcionário (sem separações)");
                    System.out.printf("CPF do Funcionário: ");
                    Funcionario[i].CPF = read.nextLong();

                    ValidadorCPF.ValidadorCPF(Funcionario[i].CPF);
                    if (ValidadorCPF.Validador == 0) {
                        System.out.println("CPF Inválido!, insira um CPF válido.\n");
                        System.out.println("--------------------------------------------");
                    } else {
                        System.out.println("CPF Válido. \n");
                        saida = 0;
                        System.out.println("--------------------------------------------\n");
                    }
                }

//  Opção da inclusão de dependentes para o funcionário.
                System.out.println("\n--------------------------------------------");
                System.out.println("\t\tDependentes\t\t");
                System.out.println("--------------------------------------------\n");

                System.out.println("O funcionário possui dependentes? \n1.Sim \n2.Não");
                System.out.printf("Digite sua escolha: ");
                loopg = read.nextInt();
                int Dependentes = 0;
                if (loopg == 1) {

                    System.out.println("\n--------------------------------------------");
                    System.out.println("\nInforma a quantidade de dependentes do funcionário (somente númeors).");
                    System.out.printf("Quantidade de dependentes: ");
                    Dependentes = read.nextInt();

                    System.out.printf("\nTotal de dependentes: %d \n", Dependentes);
                } else {
                    System.out.println("\nFuncionário sem dependentes, prosseguindo para a próxima opção.");
                }

//  Opção obrigatória para o informe do salário do funcionário.
                System.out.println("\n--------------------------------------------");
                System.out.println("\t\tSalário");
                System.out.println("--------------------------------------------\n");
                System.out.println("Informe o salário do funcionário");
                System.out.printf("Salario: R$ ");
                Funcionario[i].Salario = read.nextDouble();

//  Opção obrigatória para seleção da jornada de horas do funcionário, necessário para os cálculos realizados no código.
                System.out.println("\n--------------------------------------------\n");
                System.out.println("\n--------------------------------------------");
                System.out.println("\t   Jornada de horas");
                saida = 1;
                while (saida == 1) {
                    System.out.println("--------------------------------------------\n");
                    System.out.println("Selecione a jornada de horas para o funcionário: \n1. 220 horas \n2. 200 horas\n3. 180 horas");
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
                            System.out.println("Opção inválida.");
                    }

                }
                System.out.println("\n--------------------------------------------\n");

//  Opção para o calculo de horas extras.
                System.out.println("\n--------------------------------------------");
                System.out.println("\t\tHoras Extras");
                System.out.println("--------------------------------------------\n");

// Previnindo que a variável seja lida com o valor da consulta antérior em caso de uma nova consulta.
                Proventos.HoraExtra = 0;

                System.out.println("O funcionário possuí horas extras? \n1.Sim \n2.Não");
                System.out.printf("Digite sua escolha: ");
                loopg = read.nextInt();
                if (loopg == 1) {

                    System.out.println("\nInforma a quantidade de horas extras realizadas no mês (somente números).");
                    System.out.printf("Quantidade de horas extras: ");

                    double QtdHE = read.nextDouble();
                    Proventos.HoraExtra(Funcionario[i].Salario, Funcionario[i].Jhora, QtdHE);
                    System.out.printf("\nTotal de HE: R$%.2f \n", Proventos.HoraExtra);

                } else {
                    System.out.println("Funcionário sem Horas Extras, prosseguindo para a próxima opção.");
                }
                System.out.println("\n--------------------------------------------\n");

//  Opção para o calculo do adicional noturno.
                System.out.println("\n--------------------------------------------");
                System.out.println("\t\tAdicional Noturno");
                System.out.println("--------------------------------------------\n");

// Previnindo que a variável seja lida com o valor da consulta antérior em caso de uma nova consulta.
                Proventos.AdicionalNot = 0;
                    
                System.out.println("O funcionário possuí Adicional Noturno? \n1.Sim \n2.Não");
                System.out.printf("Digite sua escolha: ");
                loopg = read.nextInt();
                if (loopg == 1) {

                    System.out.println("\nInforma a quantidade de horas noturnas trabalhadas no mês (somente números).");
                    System.out.printf("Quantidade de horas para o adicional noturno: ");

                    double QtdAdcNot = read.nextDouble();
                    Proventos.AdicionalNot(Funcionario[i].Salario, Funcionario[i].Jhora, QtdAdcNot);
                    System.out.printf("\nTotal de Adicional Noturno: R$%.2f \n", Proventos.AdicionalNot);

                } else {
                    System.out.println("\nFuncionário sem Adicional Noturno, prosseguindo para a próxima opção.");
                }
                System.out.println("\n--------------------------------------------\n");

//  Opção para o cálculo de periculosidade
                System.out.println("\n--------------------------------------------");
                System.out.println("\t\tAdicional Periculosidade");
                System.out.println("--------------------------------------------\n");
                
// Previnindo que a variável seja lida com o valor da consulta antérior em caso de uma nova consulta.
               Proventos.AdicionalPer = 0;

                System.out.println("O funcionário possuí Adicional de Periculosidade? \n1.Sim \n2.Não");
                System.out.printf("Digite sua escolha: ");
                loopg = read.nextInt();
                if (loopg == 1) {
                    Proventos.AdicionalPer(Funcionario[i].Salario);
                    System.out.printf("\nTotal de Adicional de Periculosidade: R$%.2f\n", Proventos.AdicionalPer);

                } else {
                    System.out.println("\nFuncionário sem Adicional de Periculosidade, prosseguindo para a próxima opção.");
                }
                System.out.println("\n--------------------------------------------\n");

//  Opção para o cálculo do adicional de insalubridade
                System.out.println("\n--------------------------------------------");
                System.out.println("\t\tAdicional Insalubridade");
                System.out.println("--------------------------------------------\n");
                
// Previnindo que a variável seja lida com o valor da consulta antérior em caso de uma nova consulta.
                Proventos.AdicionalIns = 0;
                
                System.out.println("O funcionário possuí Adicional de Insalubridade?");
                System.out.println("1.Sim \n2.Não");
                System.out.printf("Digite sua escolha: ");
                loopg = read.nextInt();

                double piso = 0;
                double pctInsalubridade = 0;

                if (loopg == 1) {
                    saida = 1;
                    while (saida == 1) {
                        int p;

                        System.out.println("--------------------------------------------\n");
                        System.out.println("\nInforme o piso Salarial para o cálculo da insalubridade: \n1.Salário Mínimo (R$1.412,00). \n2.Outro valor.");
                        System.out.printf("Selecione a opção de piso salarial: ");
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
                                System.out.println("\nOpção Inválida, selecione uma das opções disponíveis!");
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
                                System.out.println("\nOpção inválida! Selecione uma das opções disponívels!");
                        }
                    }
                    Proventos.AdicionalIns(piso, pctInsalubridade);
                    System.out.printf("\nTotal de Adicional de Insalubridade: R$%.2f\n", Proventos.AdicionalIns);
                } else {
                    System.out.println("\nFuncionário sem Adicional de Insalubridade, prosseguindo para a próxima opção.");
                }
                System.out.println("\n--------------------------------------------\n");

//  Bloco da inserção de bônus alheios.
                System.out.println("\n--------------------------------------------");
                System.out.println("\t\tBônus");
                System.out.println("--------------------------------------------\n");
                 
// Previnindo que a variável seja lida com o valor da consulta antérior em caso de uma nova consulta.
                Proventos.Bonificacoes = 0;

                System.out.println("Existe alguma bonificação para o funcionário?");
                System.out.println("1.Sim \n2.Não");
                System.out.printf("Digite sua escolha: ");
                loopg = read.nextInt();
                double bonus;
                if (loopg == 1) {

                    System.out.println("\nInforme a quantidade TOTAL de bônus a serem adicionados (somente números)");
                    System.out.printf("Bônus: R$");
                    bonus = read.nextDouble();
                    Proventos.Bonuificacao(bonus);

                    System.out.printf("\nTotal de bonificações par ao funcionário: R$%.2f\n", Proventos.Bonificacoes);
                } else {
                    System.out.println("\nFuncionário sem bonificaçõe.");
                }
                System.out.println("\n--------------------------------------------\n");
                System.out.println("\n--------------------------------------------");
                System.out.println("\t\tBenefícios (VT)\t\t");
                System.out.println("--------------------------------------------\n");

//  Descontos
//  Calculo do salário tributável.
                Funcionario[i].SalarioTributavel = Funcionario[i].Salario + Proventos.HoraExtra + Proventos.AdicionalNot + Proventos.AdicionalPer + Proventos.AdicionalIns;

//  Calculos independentes da escolha do funcionário.
                Descontos.INSS(Funcionario[i].SalarioTributavel);
                Descontos.IRRF(Funcionario[i].SalarioTributavel, Dependentes);
                Funcionario[i].TicketAR = Descontos.DescontoTicketAR();
                Funcionario[i].Amedico = Descontos.AssistMedicMen();
                Funcionario[i].Aodontologica = Descontos.AssistOdontMen();

//  Calculo do VT, sendo opcional ou não, devido a necessidade de saber o valor de cargas diárias utilizadas.
                System.out.println("O funcionário é optante pelo Vale Transporte? \n1.Sim \n2.Não");
                System.out.printf("Digite sua escolha: ");
                loopg = read.nextInt();
                Funcionario[i].VT = 0;
                int vtdia = 0;
                double VTCal = vtdia * 5.80;
                if (loopg == 1) {
                    System.out.println("\nO valor do fixo do VT é de R$5,80, independente do meio de transporte.\nInforme a quantidade de vales utilizado diáriamente (ida e volta, apenas em números)");
                    System.out.printf("Vales ulitizados (dia): ");
                    vtdia = read.nextInt();
                    Descontos.DescontoVT(Funcionario[i].Salario, vtdia);
                } else {
                    System.out.println("\nFuncionário não optante pelo Vale Transporte.\n");
                }
                Funcionario[i].VT = VTCal;
                System.out.println("\n--------------------------------------------\n");

                System.out.println("\n--------------------------------------------");
                System.out.println("\t\tConvênios\t\t");
                System.out.println("--------------------------------------------\n");
//  Verificação da utilização do serviço de cooparticipação médica e odontológica do funcionário.
                System.out.println("Houve a utilização de alguns dos servições de assistência oferecidos? \n1.Assistência Médica \n2.Assistência Odontológica \n3.Ambas Assistênias \n4.Nenhuma utilização.");
                System.out.printf("Digite sua escolha: ");
                double DespMed = 0;
                double DespOdont = 0;
                loopg = read.nextInt();
                saida = 1;
                while (saida == 1) {
                    switch (loopg) {
                        case 1 -> {
                            System.out.println("\nInforme o valor total gasto com despesas médicas: ");
                            DespMed = read.nextDouble();
                            Descontos.AssistMedicCoop(DespMed);
                            saida = 0;
                        }
                        case 2 -> {
                            System.out.println("\nInforme o valor total gasto com despesas odontológicas: ");
                            DespOdont = read.nextDouble();
                            Descontos.AssistOdontCoop(DespOdont);
                            saida = 0;
                        }
                        case 3 -> {
                            System.out.println("\nInforme primeiro o valor total gasto com despesas médicas e posteriormente o valor total das despesas odontológicas.");
                            System.out.printf("Despesas médicas: ");
                            DespMed = read.nextDouble();
                            Descontos.AssistMedicCoop(DespMed);
                            System.out.printf("\nDespesas odontológicas: ");
                            DespOdont = read.nextDouble();
                            Descontos.AssistOdontCoop(DespOdont);
                            saida = 0;
                        }
                        case 4 -> {
                            System.out.println("\nNenhum desconto com assistências a ser computado.\n");
                            saida = 0;
                        }
                        default ->
                            System.out.println("\nOpção inválida, selecione uma das opções listadas.\n");
                    }
                }

                double TotalMed = DespMed + Funcionario[i].Amedico;
                double TotalOdont = DespOdont + Funcionario[i].Aodontologica;

                System.out.println("--------------------------------------------");

//  Verificação se o funcionário é optante pela contribuição sindical
                System.out.println("\n--------------------------------------------");
                System.out.println("\tContribuição Sindical\t\t");
                System.out.println("--------------------------------------------\n");
                System.out.println("\nO funcionário é optante pela contribuição sindical? \n1.Sim \n2.Não");
                System.out.printf("Digite sua escolha: ");
                loopg = read.nextInt();
                if (loopg == 1) {
                    Descontos.Sindicato();
                } else {
                    System.out.println("\nFuncionário não optante pela contribuição.\n");
                }
                System.out.println("\n--------------------------------------------");

//  Visualização do Holerite do funcionário.
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

            System.out.println("Deseja voltar ao painel do Holerite? \n1.Sim \n2.Cadastrar novos funcioários.");
            System.out.printf("Digite sua escolha: ");
            loopg = read.nextInt();
            if (loopg == 1) {
                System.out.println("\nVoltando para o Holerite.\n");
                System.out.println("--------------------------------------------\n");

                programa = 0;
            } else {
                System.out.println("\nVoltando para o cadastro de funcionários.");
            }
        }
    }
}
