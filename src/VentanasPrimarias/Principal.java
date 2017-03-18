package VentanasPrimarias;

import ConfElectronica.Ventana;
import VentanasSegundarias.PMasaMasa;
import VentanasSegundarias.PMasavolumen;
import VentanasSegundarias.PVolumenVolumen;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Principal implements ActionListener {

    public class Imagen extends javax.swing.JPanel {

        public Imagen() {
            this.setSize(800, 500); //se selecciona el tamaño del panel
        }

        //Se crea un método cuyo parámetro debe ser un objeto Graphics
        public void paint(Graphics grafico) {
            Dimension height = getSize();
            //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
            ImageIcon Img = new ImageIcon(getClass().getResource("/Complements/otro.jpg"));

            //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
            grafico.drawImage(Img.getImage(), 0, 0, 800, 500, null);

            setOpaque(false);
            super.paintComponent(grafico);
        }
    }

    public class Imagen2 extends javax.swing.JPanel {

        public Imagen2() {
            this.setSize(200, 200); //se selecciona el tamaño del panel
        }

        //Se crea un método cuyo parámetro debe ser un objeto Graphics
        public void paint(Graphics grafico) {
            Dimension height = getSize();
            //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
            ImageIcon Img = new ImageIcon(getClass().getResource("/Complements/2.jpg"));

            //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
            grafico.drawImage(Img.getImage(), 0, 0, 200, 200, null);

            setOpaque(false);
            super.paintComponent(grafico);
        }
    }

    JFrame ventana;
    JButton pmm, mv, vv, M, m, n, close;
    JPanel interno, pimagen;

    public void crearbotones() {
        pmm = new JButton();
        pmm.setText("%m/m");
        pmm.setBounds(50, 350, 90, 30);
        pmm.setBackground(Color.LIGHT_GRAY);
        pmm.addActionListener(this);

        mv = new JButton();
        mv.setText("%m/v");
        mv.setBounds(170, 350, 90, 30);
        mv.setBackground(Color.LIGHT_GRAY);
        mv.addActionListener(this);

        vv = new JButton();
        vv.setText("%v/v");
        vv.setBounds(290, 350, 90, 30);
        vv.setBackground(Color.LIGHT_GRAY);
        vv.addActionListener(this);

        M = new JButton();
        M.setText("Configuraciòn Electrònica");
        M.setBounds(410, 350, 250, 30);
        M.setBackground(Color.LIGHT_GRAY);
        M.addActionListener(this);

        m = new JButton();
        m.setText("m");
        m.setBounds(530, 350, 90, 30);
        m.setBackground(Color.LIGHT_GRAY);
        m.addActionListener(this);

        n = new JButton();
        n.setText("n");
        n.setBounds(650, 350, 90, 30);
        n.setBackground(Color.LIGHT_GRAY);
        n.addActionListener(this);

        close = new JButton();
        close.setText("Close");
        close.setBounds(700, 440, 90, 30);
        close.setBackground(Color.RED);
        close.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == close) {
            ventana.dispose();
        }
        if (e.getSource() == pmm) {
            PMasaMasa pmm = new PMasaMasa();
        }
        if (e.getSource() == mv) {
            PMasavolumen pmv = new PMasavolumen();
        }
        if (e.getSource() == vv) {
            PVolumenVolumen pvv = new PVolumenVolumen();
        }
        if( e.getSource()== M){
            Ventana ven= new Ventana();
            ven.setVisible(true);
        }
    }

    public void crearpaneles() {
        interno = new JPanel();
        interno.setBounds(10, 10, 780, 250);
        interno.setBackground(Color.LIGHT_GRAY);
        interno.setLayout(null);

        pimagen = new JPanel();
        pimagen.setBounds(315, 25, 200, 200);
        pimagen.setBackground(Color.red);
        pimagen.setLayout(null);
        interno.add(pimagen);
    }

    public void crearventana() {
        ventana = new JFrame();
        ventana.setTitle("CHE-PRO");
        ventana.setSize(800, 500);

        ventana.add(pmm);
        ventana.add(M);
        ventana.add(mv);
        ventana.add(vv);
//        ventana.add(m);
//        ventana.add(n);
        ventana.add(interno);
        ventana.add(close);

        ventana.setLayout(null);

        ventana.setVisible(true);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
    }

    public void imagenesdefondo() {
        Imagen img = new Imagen();
        ventana.add(img);
        ventana.repaint();
    }

    public void imagenotrofondo() {
        Imagen2 img2 = new Imagen2();
        pimagen.add(img2);
        pimagen.repaint();
    }

    public Principal() {
        crearbotones();
        crearpaneles();
        crearventana();
        imagenesdefondo();
        imagenotrofondo();
    }

    public static void main(String[] args) {
        Principal prin = new Principal();
    }

}
