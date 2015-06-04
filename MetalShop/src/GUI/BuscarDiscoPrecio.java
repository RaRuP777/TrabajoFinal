package GUI;

import java.awt.Toolkit;

import javax.swing.JOptionPane;

import Tienda.ClasesArryList.Disco;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Ventana de b&uacute;squedas para productos del tipo Disco
 * 
 * @author Pedro J. Ramos
 *
 */
public class BuscarDiscoPrecio extends Padre {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = -8637773303410472201L;

	/**
	 * Crea la Ventana
	 */
	public BuscarDiscoPrecio() {
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
		titulo.setEnabled(false);
		titulo.setEditable(false);
		banda.setEnabled(false);
		banda.setEditable(false);
		duracion.setEditable(false);
		canciones.setEditable(false);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Fichero.tienda.tamaño() == 0)
					JOptionPane.showMessageDialog(jFrame,"No hay productos en la tienda", "Fallido",JOptionPane.ERROR_MESSAGE);
				else {
					tiendaAux.setTienda(Fichero.tienda.getProductoDisco());
					stockAux.setTienda(tiendaAux.getProductoPrecio(precio.getText()));
					encontrado.setText(Integer.toString(stockAux.tamaño()));
					if (stockAux.tamaño() == 0)
						JOptionPane.showMessageDialog(jFrame,"No hay productos para esta búsqueda","Fallido", JOptionPane.ERROR_MESSAGE);
					else {
						mostrarDisco((Disco) stockAux.get(indice));
						comprobarBotones();
						vender.setEnabled(true);
					}
				}
			}
		});
		comboBoxEstilo.setEnabled(false);
		comboBoxLocalizacion.setEnabled(false);
		fecha.setEnabled(false);
		id.setEnabled(false);
		duracion.setEnabled(false);
		canciones.setEnabled(false);
		lblDuracion.setBounds(10, 123, 75, 14);
		okButton.setText("Buscar");
		comboBoxTalla.setVisible(false);
		lblTalla.setVisible(false);
		comboBoxTipo.setVisible(false);
		radiobuttonHombre.setVisible(false);
		radiobuttonMujer.setVisible(false);
		anterior.setEnabled(false);
		siguiente.setEnabled(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuscarDiscoBanda.class.getResource("/GUI/iconos/buscar2.png")));
		setTitle("Buscar Disco por Precio");
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