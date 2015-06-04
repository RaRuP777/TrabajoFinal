package GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Tienda.ClasesArryList.Stock;

/**
 * Clase para almacenar y guardar nuestra tienda
 * 
 * @author Pedro J. Ramos
 *
 */
public class Fichero {

	/**
	 * ArrayList que contiene el stock de la tienda
	 */
	public static Stock tienda = new Stock();

	/**
	 * Fichero para almacenar el stock en disco
	 */
	private static File file = new File("Sin_titulo.prd");

	/**
	 * Ventaja para selecci&oacute;n de ficheros
	 */
	private static JFileChooser fileChooser = new JFileChooser();

	/**
	 * Frame para contener los mensajes de info y error
	 */
	private static JFrame jFrame = new JFrame();

	/**
	 * Filtro para controlar la salida y entrada de ficheros
	 */
	private final static Filtro filtro = new Filtro(".prd", "Objeto");

	/**
	 * Nombra al nombre con el que escribimos
	 * 
	 * @param nombre
	 *            Nombre del fichero
	 */
	public static void setFile(String nombre) {
		file = new File(nombre + ".prd");
	}

	/**
	 * Modifica el File del fichero
	 * 
	 * @param file
	 *            El File del fichero
	 */
	private static void setFile(File file) {
		Fichero.file = file;
	}

	/**
	 * Crea un nuevo stock y fichero
	 */
	public static void nuevo() {
		file = new File("Sin_titulo.prd");
		tienda = new Stock();
	}

	/**
	 * Obtiene el nombre del fichero cargado
	 * 
	 * @return El nombre del fichero
	 */
	public static String getName() {
		return file.getName();
	}

	/**
	 * Abre un fichero
	 */
	public static void abrir() {
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(filtro);
		if (fileChooser.showOpenDialog(jFrame) == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
			try (ObjectInputStream in = new ObjectInputStream(
					new FileInputStream(file))) {
				tienda = (Stock) in.readObject();
				tienda.setEsModificado(false);
			} catch (ClassNotFoundException | IOException e) {
				JOptionPane.showMessageDialog(jFrame, e.getMessage(),
						"Fallido", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Guarda un fichero si ya tiene nombre elegido
	 */
	public static void guardar() {
		if (getName().equals("Sin_titulo.prd"))
			guardarComo();
		else {
			try (ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(file))) {
				out.writeObject(Fichero.tienda);
				tienda.setEsModificado(false);
				JOptionPane.showMessageDialog(jFrame, "Archivo Guardado", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(jFrame, e.getMessage(), "Fallido",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Guarda el fichero con el nuevo nombre que elegimos
	 */
	public static void guardarComo() {
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(filtro);
		if (fileChooser.showSaveDialog(jFrame) == JFileChooser.APPROVE_OPTION) {
			setFile(fileChooser.getSelectedFile());
			if (file.exists()) {
				int confirm = JOptionPane.showOptionDialog(null,
						"¿Desea Sobreescribir el fichero actual?",
						"Sobreescritura", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (confirm == 1)
					return;
			}
			try (ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(Fichero.file))) {
				out.writeObject(Fichero.tienda);
				tienda.setEsModificado(false);
				JOptionPane.showMessageDialog(jFrame, "Archivo Guardado",
						"Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(jFrame, e.getMessage(),
						"Fallido", JOptionPane.ERROR_MESSAGE);
			}
		}

	}
}