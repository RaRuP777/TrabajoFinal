package GUI;

import Tienda.ClasesArryList.Camiseta;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

/**
 * Ventana de b&uacute;squedas para productos del tipo Camiseta
 * 
 * @author Pedro J. Ramos
 *
 */
public class BuscarCamisetaBanda extends Padre {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = -7170139396832068409L;

	/**
	 * Crea la Ventana
	 */
	public BuscarCamisetaBanda() {
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
		siguiente.setEnabled(false);
		setModal(true);
		titulo.setEditable(false);
		anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAnterior();
			}
		});
		siguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente();
			}
		});
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Fichero.tienda.tama�o() == 0)
					mensajeError("No hay productos en la tienda");
				else {
					tiendaAux.setTienda(Fichero.tienda.getProductoCamiseta());
					stockAux.setTienda(tiendaAux.getProductoBanda(banda.getText()));
					encontrado.setText(Integer.toString(stockAux.tama�o()));
					if (stockAux.tama�o() == 0)
						mensajeError("No hay productos para esta b�squeda");
					else {
						mostrarCamiseta((Camiseta) stockAux.get(indice));
						comprobarBotones();
						vender.setEnabled(true);
					}
				}
			}
		});
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
		okButton.setText("Buscar");
		canciones.setVisible(false);
		lblCanciones.setVisible(false);
		duracion.setVisible(false);
		lblDuracion.setVisible(false);
		comboBoxTipo.setVisible(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuscarCamisetaBanda.class.getResource("/GUI/iconos/buscar2.png")));
		setTitle("Buscar Camiseta por Banda");
		setResizable(false);
		setBounds(100, 100, 450, 300);
	}
	
	/**
	 * Pasa al siguiente objeto de la b&uacute;squeda
	 */
	private void mostrarSiguiente() {
		mostrarCamiseta((Camiseta) stockAux.get(++indice));
		comprobarBotones();
	}

	/**
	 * Pasa al anterior objeto de la b&uacute;squeda
	 */
	private void mostrarAnterior() {
		mostrarCamiseta((Camiseta) stockAux.get(--indice));
		comprobarBotones();
	}
}