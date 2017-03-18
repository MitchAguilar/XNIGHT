package VentanasSegundarias;

import Process.MasaMasa;
import Process.MasaVoluemen;
import Process.VolumenVolumen;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PVolumenVolumen implements ActionListener, ChangeListener {

    public class Imagen extends javax.swing.JPanel {

        public Imagen() {
            this.setSize(ventana.getWidth(), ventana.getHeight()); //se selecciona el tamaño del panel
        }

        //Se crea un método cuyo parámetro debe ser un objeto Graphics
        public void paint(Graphics grafico) {
            Dimension height = getSize();
            //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
            ImageIcon Img = new ImageIcon(getClass().getResource("/Complements/otro.jpg"));

            //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
            grafico.drawImage(Img.getImage(), 0, 0, ventana.getWidth(), ventana.getHeight(), null);

            setOpaque(false);
            super.paintComponent(grafico);
        }
    }
    JFrame ventana;
    JTextField Soluto, Disolucion;
    JLabel text1, text2, saludo;
    JButton botoncerrar;
    JButton calcularporcenmm;
    ButtonGroup grupo1masa, grupomasa2;
    JRadioButton mililitros1, litros1, mililitros, litros;
    JTextArea area;

    public void Creartexfi() {
        Soluto = new JTextField();
        Soluto.setBounds(125, 80, 90, 30);
        Soluto.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                solonumeros(e);
            }
        });

        Disolucion = new JTextField();
        Disolucion.setBounds(150, 120, 90, 30);
        Disolucion.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                solonumeros2(e);
            }
        });
    }

    public void CrearLabels() {
        text1 = new JLabel();
        text1.setBounds(30, 80, 90, 20);
        text1.setText("V Soluto:");
        text1.setForeground(Color.BLACK);

        text2 = new JLabel();
        text2.setBounds(30, 120, 100, 20);
        text2.setText("V Disoluciòn: ");
        text2.setForeground(Color.BLACK);

        saludo = new JLabel();
        saludo.setText("Digita Tus Valores a Calcular.");
        saludo.setBounds(85, 20, 500, 30);
        saludo.setForeground(Color.BLACK);
        Font font = new Font("Dialog", Font.BOLD, 25);
        saludo.setFont(font);

    }

    public void CrearBoton() {
        botoncerrar = new JButton();
        botoncerrar.setBounds(500, 335, 90, 30);
        botoncerrar.setText("Close");
        botoncerrar.setBackground(Color.red);
        botoncerrar.addActionListener(this);

        calcularporcenmm = new JButton();
        calcularporcenmm.setBounds(130, 180, 120, 30);
        calcularporcenmm.setText("Calcular");
        calcularporcenmm.setBackground(Color.LIGHT_GRAY);
        calcularporcenmm.setForeground(Color.BLACK);
        calcularporcenmm.addActionListener(this);

    }

    public void CrearRadioButton() {
        grupo1masa = new ButtonGroup();

        mililitros1 = new JRadioButton("Mililitros");
        mililitros1.setBounds(250, 80, 105, 20);
        mililitros1.setLayout(null);
        //miligramos.addChangeListener(this);
        mililitros1.addActionListener(this);

        litros1 = new JRadioButton("Litros");
        litros1.setBounds(370, 80, 105, 20);
        litros1.setLayout(null);
        //gramos.addChangeListener(this);
        litros1.addActionListener(this);

//        kilogramos = new JRadioButton("Kilogramos");
//        kilogramos.setBounds(490, 80, 105, 20);
//        kilogramos.setLayout(null);
//        kilogramos.addChangeListener(this);
//        kilogramos.addActionListener(this);
        grupo1masa.add(litros1);
        grupo1masa.add(mililitros1);
//        grupo1masa.add(kilogramos);
        //segunda parte
        grupomasa2 = new ButtonGroup();

        mililitros = new JRadioButton("Mililitros");
        mililitros.setBounds(250, 120, 105, 20);
        mililitros.setLayout(null);
        //miligramos2.addChangeListener(this);
        mililitros.addActionListener(this);

        litros = new JRadioButton("Litros");
        litros.setBounds(370, 120, 105, 20);
        litros.setLayout(null);
        //gramos2.addChangeListener(this);
        litros.addActionListener(this);
//
//        kilogramos2 = new JRadioButton("Kilogramos");
//        kilogramos2.setBounds(490, 120, 105, 20);
//        kilogramos2.setLayout(null);
//        //kilogramos2.addChangeListener(this);
//        kilogramos2.addActionListener(this);

        grupomasa2.add(mililitros);
        grupomasa2.add(litros);
//        grupomasa2.add(kilogramos2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botoncerrar) {
            ventana.dispose();
        }
        if (e.getSource() == calcularporcenmm) {

            BufferedReader leer = null;
            try {
                try {
                    //introducir los datos al programa
                    VolumenVolumen masa = new VolumenVolumen();
                    masa.calcular();
                } catch (IOException ex) {
                    Logger.getLogger(PMasaMasa.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Verifique los valores ingresados, si es un decimal de modo ( . )\nde lo contrario verifique haber elegido una medida");
                }
                //recoger el resultado
                File archivo = new File("src/BaseDeDatos/VolumenVolumen/VolumenVolumen.txt");
                leer = new BufferedReader(new FileReader(archivo));
                String resultado = "";
                for (int i = 0; i <= 1; i++) {
                    resultado = leer.readLine();
                }
                //enviar al metodo paintmath
                System.out.println("este es el resuktado principal: " + resultado);
                paintmath(resultado);
                //prueba con los radiobutton

            } catch (FileNotFoundException ex) {
                Logger.getLogger(PMasaMasa.class
                        .getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Verifique los valores ingresados, si es un decimal de modo ( . )\nde lo contrario verifique haber elegido una medida");

            } catch (IOException ex) {
                Logger.getLogger(PMasaMasa.class
                        .getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Verifique los valores ingresados, si es un decimal de modo ( . )\nde lo contrario verifique haber elegido una medida");
            } finally {
                try {
                    leer.close();

                } catch (IOException ex) {
                    Logger.getLogger(PMasaMasa.class
                            .getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Verifique los valores ingresados, si es un decimal de modo ( . )\nde lo contrario verifique haber elegido una medida");
                }
            }

//            eliminar directorios
            File archivo = new File("src/BaseDeDatos/VolumenVolumen/VolumenVolumen.txt");
            archivo.delete();
            File archivo2 = new File("src/BaseDeDatos/VolumenVolumen/volumen.txt");
            archivo2.delete();
            File archivo3 = new File("src/BaseDeDatos/VolumenVolumen/vsoluto.txt");
            archivo3.delete();

            //reiniciar llos radios button
            grupo1masa.clearSelection();
            grupomasa2.clearSelection();

        }
        if (e.getSource() == mililitros1) {
            double cadena = Double.parseDouble(Soluto.getText());
            VolumenVolumen iii = new VolumenVolumen();
            iii.crearprueba("" + cadena);
        }
//        if (e.getSource() == kilogramos) {
//            double cadena = Double.parseDouble(Soluto.getText());
//            cadena = cadena * 1000;
//            MasaVoluemen iii = new MasaVoluemen();
//            iii.crearprueba("" + cadena);
//        }
        if (e.getSource() == litros1) {
            double cadena = Double.parseDouble(Soluto.getText());
            VolumenVolumen iii = new VolumenVolumen();
            cadena = cadena * 1000;
            iii.crearprueba("" + cadena);
        }
        if (e.getSource() == mililitros) {
            double cadena = Double.parseDouble(Disolucion.getText());
            VolumenVolumen iii = new VolumenVolumen();
            iii.creardisolucion("" + cadena);
        }
//        if (e.getSource() == kilogramos2) {
//            double cadena = Double.parseDouble(Disolucion.getText());
//            cadena = cadena * 1000;
//            MasaMasa iii = new MasaMasa();
//            iii.creardisolucion("" + cadena);
//        }
        if (e.getSource() == litros) {
            double cadena = Double.parseDouble(Disolucion.getText());
            VolumenVolumen iii = new VolumenVolumen();
            cadena = cadena * 1000;
            iii.creardisolucion("" + cadena);
        }

    }

    public void paintmath(String c) throws IOException {
        //paint math, in area.
        VolumenVolumen mas = new VolumenVolumen();

        area.setText("Formula: \n\n                   " + mas.devolver1() + " lt" + "\n %m/m :    _______________    *100" + " = " + c + " %\n                   " + mas.devolver2() + " lt" + "\n\n BY: Stefany and Mitch");
    }

    public void stateChanged(ChangeEvent arg0) {
        //no haber nada en el metodo
        if (litros1 == null) {

        }
    }

    public void crearareadetexto() {
        area = new JTextArea();
        area.setBounds(20, 250, 400, 120);
        area.setBackground(Color.LIGHT_GRAY);
        area.setForeground(Color.BLACK);
    }

    //metodo para restringir teclas
    private void solonumeros(KeyEvent e) {
//        char caracter = e.getKeyChar();
//        // Verificar si la tecla pulsada no es un digito
//        if (((caracter < '0') || (caracter > '9') ||(caracter <'.')) && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
//            e.consume();  // ignorar el evento de teclado
//        }
        char c = e.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)//bloquea todas las teclas menos los numeros y el punto
                && (c != '.')) {
            e.consume();
        }
        if (c == '.' && Soluto.getText().contains(".")) {//se trae las textfiel para uw solo tenga un punto
            e.consume();
        }
    }

    private void solonumeros2(KeyEvent e) {
//        char caracter = e.getKeyChar();
//        // Verificar si la tecla pulsada no es un digito
//        if (((caracter < '0') || (caracter > '9') ||(caracter <'.')) && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
//            e.consume();  // ignorar el evento de teclado
//        }
        char c = e.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)//bloquea todas las teclas menos los numeros y el punto
                && (c != '.')) {
            e.consume();
        }
        if (c == '.' && Disolucion.getText().contains(".")) {//se trae las textfiel para uw solo tenga un punto
            e.consume();
        }
    }

    public void crearventana() {
        ventana = new JFrame();
        ventana.setTitle("Porcentaje Volumen / Volumen");
        ventana.setSize(600, 400);

        ventana.add(Soluto);
        ventana.add(Disolucion);
        ventana.add(text1);
        ventana.add(text2);
        ventana.add(botoncerrar);
        ventana.add(calcularporcenmm);
        ventana.add(mililitros1);
        ventana.add(litros1);
        ventana.add(area);
//        ventana.add(kilogramos);
        ventana.add(mililitros);
        ventana.add(litros);
//        ventana.add(kilogramos2);
        ventana.add(saludo);

        ventana.setLayout(null);
        ventana.setVisible(true);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(ventana.DO_NOTHING_ON_CLOSE);
    }

    public void paint() {
        Imagen imp = new Imagen();
        ventana.add(imp);
        ventana.repaint();
    }

    public PVolumenVolumen() {
        Creartexfi();
        CrearBoton();
        CrearRadioButton();
        CrearLabels();
        crearareadetexto();
        crearventana();
        paint();

    }

    public static void main(String[] args) {
        PVolumenVolumen ma = new PVolumenVolumen();
    }

}
