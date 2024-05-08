package Proventos;

public class Proventos {

    public static double HoraExtra;
    public static double AdicionalNot;
    public static double AdicionalPer;
    public static double AdicionalIns;
    public static double Bonificacoes;

    public static double HoraExtra(double Salario, double Jhora, double QtdHE) {
        double SalarioHora = Salario / Jhora;
        HoraExtra = (SalarioHora * 1.5) * QtdHE;

        return HoraExtra;
    }

    public static double AdicionalNot(double Salario, double Jhora, double HrNot) {
        double SalarioHora = Salario / Jhora;
        AdicionalNot = (SalarioHora * 1.2) * HrNot;

        return AdicionalNot;
    }

    public static double AdicionalPer(double Salario) {
        AdicionalPer = Salario * 0.3;
        
        return AdicionalPer;
    }

    public static double AdicionalIns(double piso, double pct) {
        AdicionalIns =  piso * pct;

        return AdicionalIns;
    }

    public static double Bonuificacao(double bonusacumulado) {
        Bonificacoes = bonusacumulado;

        return Bonificacoes;
    }
}
