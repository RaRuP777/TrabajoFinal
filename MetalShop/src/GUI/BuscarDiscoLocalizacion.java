package GUI;

import java.awt.Toolkit;
import Tienda.ClasesArryList.Disco;
import Tienda.Enumeraciones.Localizacion;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Ventana de b&uacute;squedas para productos del tipo Disco
 * 
 * @author Pedro J. Ramos
 *
 */
public class BuscarDiscoLocalizacion extends Padre {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = -5484716268429527353L;

	/**
	 * Crea la Ventana
	 */
	public BuscarDiscoLocalizacion() {
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
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Fichero.tienda.tamaño() == 0)
					mensajeError("No hay productos en la tienda");
				else {
					tiendaAux.setTienda(Fichero.tienda.getProductoDisco());
					stockAux.setTienda(tiendaAux.getProductoLocalizacion((Localizacion) comboBoxLocalizacion.getSelectedItem()));
					encontrado.setText(Integer.toString(stockAux.tamaño()));
					if (stockAux.tamaño() == 0)
						mensajeError("No hay productos para esta búsqueda");
					else {	
						mostrarDisco((Disco) stockAux.get(indice));
						comprobarBotones();
						vender.setEnabled(true);
					}
				}
			}
		});
		comboBoxEstilo.setEnabled(false);
		banda.setEnabled(false);
		fecha.setEnabled(false);
		precio.setEnabled(false);
		id.setEnabled(false);
		duracion.setEnabled(false);
		canciones.setEnabled(false);
		titulo.setEnabled(false);
		lblDuracion.setBounds(10, 123, 75, 14);
		okButton.setText("Buscar");
		comboBoxTalla.setVisible(false);
		lblTalla.setVisible(false);
		comboBoxTipo.setVisible(false);
		radiobuttonHombre.setVisible(false);
		radiobuttonMujer.setVisible(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuscarDiscoLocalizacion.class.getResource("/GUI/iconos/buscar2.png")));
		setTitle("Buscar Disco por Locacalizaci\u00F3n");
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