package GUI;

import java.awt.Toolkit;

import Tienda.ClasesArryList.Disco;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Ventana de mostrar todos los productos del tipo Disco
 * 
 * @author Pedro J. Ramos
 *
 */
public class MostrarDiscos extends Padre {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = 7154946595713738255L;

	/**
	 * Crea la Ventana
	 */
	public MostrarDiscos() {
		super();
		anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAnterior();
			}
		});
		siguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarSiguiente();
			}
		});
		stockAux.setTienda(Fichero.tienda.getProductoDisco());
		encontrado.setText(Integer.toString(stockAux.tamaño()));
		mostrarDisco((Disco) stockAux.get(indice));
		comprobarBotones();
		vender.setEnabled(true);
		okButton.setVisible(false);
		banda.setEnabled(false);
		comboBoxLocalizacion.setEnabled(false);
		comboBoxEstilo.setEnabled(false);
		fecha.setEnabled(false);
		precio.setEnabled(false);
		id.setEnabled(false);
		duracion.setEnabled(false);
		canciones.setEnabled(false);
		titulo.setEnabled(false);
		lblDuracion.setBounds(10, 123, 75, 14);
		comboBoxTalla.setVisible(false);
		lblTalla.setVisible(false);
		comboBoxTipo.setVisible(false);
		radiobuttonHombre.setVisible(false);
		radiobuttonMujer.setVisible(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MostrarDiscos.class.getResource("/GUI/iconos/buscar2.png")));
		setTitle("Mostrar Todos los Discos");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 450, 300);
	}
	
	/**
	 * Pasa al siguiente objeto del ArrayList
	 */
	private void mostrarSiguiente() {
		mostrarDisco((Disco) stockAux.get(++indice));
		comprobarBotones();
	}

	/**
	 * Pasa al anterior objeto del ArrayList
	 */
	private void mostrarAnterior() {
		mostrarDisco((Disco) stockAux.get(--indice));
		comprobarBotones();
	}
}