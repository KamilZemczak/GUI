package Cztery;

import javax.swing.JOptionPane;

public class PESEL {

    int[] pesel = new int[11];

    private PESEL(int[] PESEL) {
        pesel = PESEL.clone();
    }

    public PESEL(String PESEL) {
        pesel = pobierzPESELzStringa(PESEL);
    }

    public static void sprawdzPESEL(String PESEL) {
        if (poprawnaDlugosc(PESEL) && jestPoprawny(pobierzPESELzStringa(PESEL))) {
            wiadomoscSukces();
            PESEL psl = new PESEL(pobierzPESELzStringa(PESEL));
            PESELBaza.addPESEL(psl);
        } else {
            wiadomoscPorazka();
        }
    }

    private static boolean poprawnaDlugosc(String PESEL) {
        return (PESEL.length() == 11);
    }

    private static void wiadomoscSukces() {
        pokazWiadomosc("PESEL jest poprawny.");
    }

    private static void wiadomoscPorazka() {
        pokazWiadomosc("PESEL jest nieprawidłowy.");
    }

    private static void pokazWiadomosc(String wiadomosc) {
        JOptionPane.showMessageDialog(null, wiadomosc);
    }

    private static int[] pobierzPESELzStringa(String PESEL) {
        int[] psl = new int[11];

        for (int i = 0; i < 11; i++) {
            psl[i] = Integer.parseInt(PESEL.charAt(i) + "");
        }
        return psl;
    }

    private static boolean jestPoprawny(int[] PESEL) {
        int sum = 0;
        int[] szerokosc = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3, 1};

        for (int i = 0; i < 11; i++) {
            sum += szerokosc[i] * PESEL[i];
            sum %= 10;
        }
        return (sum == 0);
    }
    
    public String doStringa() {
        String psl = "";
        for (int i = 0; i < 11; i++) 
            psl += pesel[i] + "";
        return psl;
    }
}
