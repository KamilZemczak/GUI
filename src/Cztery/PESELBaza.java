package Cztery;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PESELBaza {
    
    private static ArrayList<PESEL> peselBaza = new ArrayList<>();
    
    public static void addPESEL(PESEL pesel) {
        peselBaza.clear();
        czytajPlik();
        peselBaza.add(pesel);
        piszPlik();
    }
    
    private static void czytajPlik() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\PESEL.txt"));
            String pesel;
            
            while ((pesel = br.readLine()) != null) {
                peselBaza.add(new PESEL(pesel));
            }
            br.close(); 
        } catch (IOException ex) {
        }
    }
    
    private static void piszPlik() {
        try {
            FileWriter fileWriter = new FileWriter(new File(System.getProperty("user.dir") + "\\PESEL.txt"));
            PrintWriter printWriter = new PrintWriter(fileWriter);
            String lineSeparator = System.getProperty("line.separator");
            
            for(PESEL pesel:peselBaza)
                printWriter.write(pesel.toString() + lineSeparator);
            
            printWriter.close();
        } catch(IOException e) {
        }    
    }
}
