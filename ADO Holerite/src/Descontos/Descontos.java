package Descontos;

public class Descontos {

    public static double INSS;
    public static double IRRF;
    public static double DescontoVT;
    public static double DescontoTicketAR;
    public static double AssistMedicMen;
    public static double AssistMedicCoop;
    public static double AssistOdontMen;
    public static double AssistOdontCoop;
    public static double Sindicato;
    
    
    
    public static double INSS(double SalTrib){
        
        if (SalTrib < 1412) {
            INSS = 0;
            
        } else if (SalTrib > 1412 && SalTrib <= 2666.68){
            INSS  = (SalTrib * 0.09) - 21.18;
           
        } else if (SalTrib > 2666.68 && SalTrib <= 4000.03){
            INSS  = (SalTrib * 0.12) - 101.18;
            
        } else if (SalTrib > 4000.03 && SalTrib <= 7786.02){
            INSS  = (SalTrib * 0.14) - 181.18;
    
        } else {        
            INSS = 908.86;
        }
        
        return INSS;
    }
    
    public static double IRRF(double SalTrib, double Depend){
        
        double irrfs,irrfc;
        double dep = Depend * 189.59;      
        double inss = INSS;
           
        double b1 = SalTrib - inss - dep;
        double b2 = SalTrib - 528;
        double birrf;
        if (b1 > b2){
            birrf = b2;
        } else {
            birrf = b1;
        }
        
        if (birrf <= 2259.20){
            IRRF = 0;
            
        } else if (birrf > 2259.20 && birrf <= 2826.65){ 
            IRRF = (birrf * 0.075) - 169.44;
        
        } else if (birrf > 2826.65 && birrf <= 3751.05){
            IRRF = (birrf * 0.15) - 381.44;          
            
        } else if (birrf > 3751.05 && birrf <= 4664.68){
            IRRF = (birrf * 0.225) -  662.77;
            
        } else {
            IRRF = (birrf * 0.275) -  896;
        }
        
        return IRRF;
    }
    
    public static double DescontoVT(double Salario, int vtdia){
        
        double TotalVT = (vtdia * 5.80) * 22;
        double SalDesc = Salario * 0.06;
        if  (TotalVT > SalDesc){
            DescontoVT = SalDesc;
        } else {
            DescontoVT = TotalVT;
        }
        
        return DescontoVT;
    }
    
    public static double DescontoTicketAR(){
        DescontoTicketAR = 825.75 * 0.2;
        
        return DescontoTicketAR;
    }
    
    public static double AssistMedicMen(){
        
        AssistMedicMen = 74.99;
        
        return AssistMedicMen;
    }
    
    public static double AssistMedicCoop(double Custo){
 
        AssistMedicCoop = Custo * 0.3;
        
        return AssistMedicCoop; 
    }

    public static double AssistOdontMen(){
        
        AssistOdontMen = 49.99;
        
        return AssistOdontMen;
    }
    
    public static double AssistOdontCoop(double Custo){
 
        AssistOdontCoop = Custo * 0.285;
        
        return AssistOdontCoop; 
    }
    
    public static double Sindicato(){
        
        Sindicato = 22.61;
        
        return Sindicato;
    }
    
}
