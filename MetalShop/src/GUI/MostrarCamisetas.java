package GUI;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Tienda.ClasesArryList.Camiseta;

/**
 * Ventana de mostrar todos los productos del tipo Camiseta
 * 
 * @author Pedro J. Ramos
 *
 */
public class MostrarCamisetas extends Padre {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = 2916388790454119118L;

	/**
	 * Crea la Ventana
	 */
	public MostrarCamisetas() {
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
		anterior.setEnabled(true);
		siguiente.setEnabled(true);
		banda.setEnabled(false);
		banda.setEditable(false);
		stockAux.setTienda(Fichero.tienda.getProductoCamiseta());
		mostrarCamiseta((Camiseta) stockAux.get(indice));
		comprobarBotones();
		vender.setEnabled(true);
		okButton.setVisible(false);
		comboBoxLocalizacion.setEnabled(false);
		radiobuttonMujer.setEnabled(false);
		fecha.setEnabled(false);
		precio.setEnabled(false);
		id.setEnabled(false);
		comboBoxTalla.setEnabled(false);
		lblDuracion.setEnabled(false);
		radiobuttonHombre.setEnabled(false);
		comboBoxEstilo.setEnabled(false);
		titulo.setEnabled(false);
		canciones.setVisible(false);
		lblCanciones.setVisible(false);
		duracion.setVisible(false);
		lblDuracion.setVisible(false);
		comboBoxTipo.setVisible(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MostrarCamisetas.class.getResource("/GUI/iconos/buscar2.png")));
		setTitle("Mostrar Todas las Camisetas");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 450, 300);
	}

	/**
	 * Pasa al siguiente objeto del ArrayList
	 */
	private void mostrarSiguiente() {
		mostrarCamiseta((Camiseta) stockAux.get(++indice));
		comprobarBotones();
	}

	/**
	 * Pasa al anterior objeto del ArrayList
	 */
	private void mostrarAnterior() {
		mostrarCamiseta((Camiseta) stockAux.get(--indice));
		comprobarBotones();
	}
}