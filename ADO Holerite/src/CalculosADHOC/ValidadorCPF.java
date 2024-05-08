package CalculosADHOC;

public class ValidadorCPF {

    public static int Validador;
    
    public static int ValidadorCPF(long cpf) {
        
        String raw = Long.toString(cpf);
        String c1 = raw.substring(0, 1);
        String c2 = raw.substring(1, 2);         
        String c3 = raw.substring(2, 3);
        String c4 = raw.substring(3, 4);
        String c5 = raw.substring(4, 5);
        String c6 = raw.substring(5, 6);
        String c7 = raw.substring(6, 7);
        String c8 = raw.substring(7, 8);
        String c9 = raw.substring(8, 9);
        String c10 = raw.substring(9, 10);
        String c11 = raw.substring(10, 11);

        int v1 = Integer.parseInt(c1);
        int v2 = Integer.parseInt(c2);
        int v3 = Integer.parseInt(c3);
        int v4 = Integer.parseInt(c4);
        int v5 = Integer.parseInt(c5);
        int v6 = Integer.parseInt(c6);
        int v7 = Integer.parseInt(c7);
        int v8 = Integer.parseInt(c8);
        int v9 = Integer.parseInt(c9);
        int v10 = Integer.parseInt(c10);
        int v11 = Integer.parseInt(c11);

        int Stage1 = (v1 * 10) + (v2 * 9) + (v3 * 8) + (v4 * 7) + (v5 * 6) + (v6 * 5) + (v7 * 4) + (v8 * 3) + (v9 * 2);
        int Stage2 = Stage1 % 11;

        if (Stage2 <= 1) {
            Stage2 = 0;            
        } else {
            Stage2 = Stage2 - 11;
            if (Stage2 < 0){
                Stage2 = Stage2 * (-1);
            }
        }

        int Stage3 = (v1 * 11) + (v2 * 10) + (v3 * 9) + (v4 * 8) + (v5 * 7) + (v6 * 6) + (v7 * 5) + (v8 * 4) + (v9 * 3) + (v10 * 2);
        int Stage4 = Stage3 % 11;

        if (Stage4 > 1) {
           Stage4 = Stage4 - 11;
           if (Stage4 < 0){
                Stage4 = Stage4 * (-1);
            }
        } else {
            Stage4 = 0;
        }

        if (v10 == Stage2 && v11 == Stage4) {
            Validador = 1;
        } else {
            Validador = 0;
        }

        return Validador;
    }
}
