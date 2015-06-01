package GUI;

import javax.swing.JOptionPane;

import Tienda.ClasesArryList.Disco;
import Tienda.Enumeraciones.Estilo;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Ventana de b&uacute;squedas para productos del tipo Disco
 * 
 * @author Pedro J. Ramos
 *
 */
public class BuscarDiscoEstilo extends Padre {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = 7844352531474681061L;

	/**
	 * Crea la Ventana
	 */
	public BuscarDiscoEstilo() {
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
					JOptionPane.showMessageDialog(jFrame,"No hay productos en la tienda", "Fallido",JOptionPane.ERROR_MESSAGE);
				else {
					tiendaAux.setTienda(Fichero.tienda.getProductoDisco());
					stockAux.setTienda(tiendaAux.getProductoEstilo((Estilo) comboBoxEstilo.getSelectedItem()));
					if (stockAux.tamaño() == 0)
						JOptionPane.showMessageDialog(jFrame,"No hay productos para esta búsqueda", "Fallido",JOptionPane.ERROR_MESSAGE);
					else {	
						mostrarDisco((Disco) stockAux.get(indice));
						comprobarBotones();
						vender.setEnabled(true);
					}
				}
			}
		});
		banda.setEnabled(false);
		comboBoxLocalizacion.setEnabled(false);
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
		anterior.setEnabled(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuscarDiscoEstilo.class.getResource("/GUI/iconos/buscar2.png")));
		setTitle("Buscar Disco por Estilo");
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