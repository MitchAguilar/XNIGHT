package Process;

import VentanasSegundarias.PMasaMasa;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MasaVoluemen {

    double masadelsoluto, volumen, cla;

    public MasaVoluemen(double masadelsoluto, double masadeladisolucion, double cla) {
        this.masadelsoluto = masadelsoluto;
        this.volumen = masadeladisolucion;
        this.cla = cla;
    }

    public MasaVoluemen() {
        this.masadelsoluto = 0;
        this.volumen = 0;
        this.cla = 0;
    }

    public void calcular() throws IOException {

        //enviar los datos convertidos al archivo texto
        File archivo2 = new File("src/BaseDeDatos/MasaVolumen/soluto.txt");
        BufferedReader leer2 = new BufferedReader(new FileReader(archivo2));
        String resultado = "";
        for (int i = 0; i <= 1; i++) {
            resultado = leer2.readLine();
        }
        masadelsoluto = Double.parseDouble(resultado);
        System.out.println(masadelsoluto + "    lekndlknklfndlkfndlfk");
        File archivo3 = new File("src/BaseDeDatos/MasaVolumen/volumen.txt");
        BufferedReader leer3 = new BufferedReader(new FileReader(archivo3));
        String resultado3 = "";
        for (int i = 0; i <= 1; i++) {
            resultado3 = leer3.readLine();
        }
        volumen = Double.parseDouble(resultado3);
        System.out.println(volumen + "   sdnlskdnlksskdnlk");
        //calculo del valor 
        this.cla = ((masadelsoluto / volumen) * 100);
        System.out.println("este es el resultado:   " + cla + " gr/ml");
        JOptionPane.showMessageDialog(null, "Hola, Tu Resultado Es: " + cla + " gr/lt");

        //enviar el resultado a unarchivo de texto
        File archivo = new File("src/BaseDeDatos/MasaVolumen/MasaVolumen.txt");
        FileWriter text = new FileWriter(archivo);
        PrintWriter escribir = new PrintWriter(text);

        escribir.println();
        escribir.append("" + cla);
        escribir.close();
    }

    public void crearprueba(String soluto) {
        try {
            //enviar el resultado a un archivo de texto
            File archivo = new File("src/BaseDeDatos/MasaVolumen/soluto.txt");
            FileWriter text = new FileWriter(archivo);
            PrintWriter escribir = new PrintWriter(text);

            escribir.println();
            escribir.append("" + soluto);
            escribir.close();
        } catch (IOException ex) {
            Logger.getLogger(PMasaMasa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void creardisolucion(String diso) {
        try {
            //enviar el resultado a unarchivo de texto
            File archivo = new File("src/BaseDeDatos/MasaVolumen/volumen.txt");
            FileWriter text = new FileWriter(archivo);
            PrintWriter escribir = new PrintWriter(text);

            escribir.println();
            escribir.append("" + diso);
            escribir.close();
        } catch (IOException ex) {
            Logger.getLogger(PMasaMasa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public double devolver1() throws FileNotFoundException, IOException {
        //enviar los datos convertidos al archivo texto
        File archivo2 = new File("src/BaseDeDatos/MasaVolumen/soluto.txt");
        BufferedReader leer2 = new BufferedReader(new FileReader(archivo2));
        String resultado = "";
        for (int i = 0; i <= 1; i++) {
            resultado = leer2.readLine();
        }
        masadelsoluto = Double.parseDouble(resultado);
        System.out.println(masadelsoluto + "    lekndlknklfndlkfndlfk");

        return masadelsoluto;
    }

    public double devolver2() throws FileNotFoundException, IOException {
        File archivo3 = new File("src/BaseDeDatos/MasaVolumen/volumen.txt");
        BufferedReader leer3 = new BufferedReader(new FileReader(archivo3));
        String resultado3 = "";
        for (int i = 0; i <= 1; i++) {
            resultado3 = leer3.readLine();
        }
        volumen = Double.parseDouble(resultado3);
        return volumen;
    }
}
