package ConfElectronica;

import javax.swing.JOptionPane;
import java.io.*;
public class Motor {

	private int valores[] = {2, 2, 6, 2, 6, 2, 10, 6, 2, 10, 6, 2, 14, 10, 6, 2, 14, 10, 6};
	private String orbitas[] = {"1s", "2s", "2p", "3s", "3p", "4s", "3d", "4p", "5s", "4d", "5p", "6s", "4f", "5d", "6p", "7s", "5f", "6d", "7p"};
	private int suma, electrones, n, diferencia;
	private String resultado, elementos, na[];
	private boolean encontrado;
	private FileReader arc;
	private BufferedReader lector;

	public Motor() {
		suma = 0;
		n = 0;
		resultado = "";
	}

	public String Configurar(String elemento) {
		try {
			arc = new FileReader("src/ConfElectronica/DataBase/Dic.dic");
			lector = new BufferedReader(arc);
			elementos = lector.readLine();
			na = elementos.split("[%]+");
			for (int x = 0; x < na.length; x++) {
				if (na[x].equals(elemento)) {
					electrones = Integer.parseInt(na[x - 1]);
				}
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al leer diccionario");
		}
		if (electrones == 0) {
			resultado = "Elemento no encontrado";
		} else {
			int contador = -1;
			while (!encontrado) {
				contador++;
				n = contador;
				suma = suma + valores[contador];
				encontrado = (suma < electrones) ? false : true;
			}
			diferencia = valores[n] - (suma - electrones);
			for (int x = 0; x < n; x++) {
				resultado = resultado + orbitas[x] + "<sup>" + valores[x] + "</sup> ";
			}
			resultado = "<html>" + resultado + orbitas[n] + "<sup>" + diferencia + "</sup>";
		}
		return resultado;
	}
}
