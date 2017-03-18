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

public class VolumenVolumen {

    double volumendelsoluto, volumen, cla;

    public VolumenVolumen(double volumendelsoluto, double volumen, double cla) {
        this.volumendelsoluto = volumendelsoluto;
        this.volumen = volumen;
        this.cla = cla;
    }

    public VolumenVolumen() {
        this.volumendelsoluto = 1;
        this.volumen = 1;
        this.cla = 1;
    }

    public void calcular() throws IOException {

        //enviar los datos convertidos al archivo texto
        File archivo2 = new File("src/BaseDeDatos/VolumenVolumen/vsoluto.txt");
        BufferedReader leer2 = new BufferedReader(new FileReader(archivo2));
        String resultado = "";
        for (int i = 0; i <= 1; i++) {
            resultado = leer2.readLine();
        }
        volumendelsoluto = Double.parseDouble(resultado);
        System.out.println(volumendelsoluto + "    lekndlknklfndlkfndlfk");
        File archivo3 = new File("src/BaseDeDatos/VolumenVolumen/volumen.txt");
        BufferedReader leer3 = new BufferedReader(new FileReader(archivo3));
        String resultado3 = "";
        for (int i = 0; i <= 1; i++) {
            resultado3 = leer3.readLine();
        }
        volumen = Double.parseDouble(resultado3);
        System.out.println(volumen + "   sdnlskdnlksskdnlk");
        //calculo del valor 
        this.cla = ((volumendelsoluto / volumen) * 100);
        System.out.println("este es el resultado:   " + cla + " gr/ml");
        JOptionPane.showMessageDialog(null, "Hola, Tu Resultado Es: " + cla + " %");

        //enviar el resultado a unarchivo de texto
        File archivo = new File("src/BaseDeDatos/VolumenVolumen/VolumenVolumen.txt");
        FileWriter text = new FileWriter(archivo);
        PrintWriter escribir = new PrintWriter(text);

        escribir.println();
        escribir.append("" + cla);
        escribir.close();
    }

    public void crearprueba(String soluto) {
        try {
            //enviar el resultado a un archivo de texto
            File archivo = new File("src/BaseDeDatos/VolumenVolumen/vsoluto.txt");
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
            File archivo = new File("src/BaseDeDatos/VolumenVolumen/volumen.txt");
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
        File archivo2 = new File("src/BaseDeDatos/VolumenVolumen/vsoluto.txt");
        BufferedReader leer2 = new BufferedReader(new FileReader(archivo2));
        String resultado = "";
        for (int i = 0; i <= 1; i++) {
            resultado = leer2.readLine();
        }
        volumendelsoluto = Double.parseDouble(resultado);
        System.out.println(volumendelsoluto + "    lekndlknklfndlkfndlfk");

        return volumendelsoluto;
    }

    public double devolver2() throws FileNotFoundException, IOException {
        File archivo3 = new File("src/BaseDeDatos/VolumenVolumen/volumen.txt");
        BufferedReader leer3 = new BufferedReader(new FileReader(archivo3));
        String resultado3 = "";
        for (int i = 0; i <= 1; i++) {
            resultado3 = leer3.readLine();
        }
        volumen = Double.parseDouble(resultado3);
        return volumen;
    }
}
