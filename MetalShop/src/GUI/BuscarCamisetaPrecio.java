package GUI;

import javax.swing.JOptionPane;

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
public class BuscarCamisetaPrecio extends Padre {

	/**
	 * Serial para Serializable
	 */
	private static final long serialVersionUID = 3109301541831895176L;

	/**
	 * Crea la Ventana
	 */
	public BuscarCamisetaPrecio() {
		super();
		comboBoxTalla.setEnabled(false);
		radiobuttonMujer.setEnabled(false);
		radiobuttonHombre.setEnabled(false);
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
		setModal(true);
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
					tiendaAux.setTienda(Fichero.tienda.getProductoCamiseta());
					stockAux.setTienda(tiendaAux.getProductoPrecio(precio.getText()));
					if (stockAux.tamaño() == 0)
						JOptionPane.showMessageDialog(jFrame,"No hay productos para esta búsqueda","Fallido", JOptionPane.ERROR_MESSAGE);
					else {
						mostrarCamiseta((Camiseta) stockAux.get(indice));
						comprobarBotones();
						okButton.setEnabled(false);
						vender.setEnabled(true);
					}
				}
			}
		});
		comboBoxEstilo.setEnabled(false);
		comboBoxLocalizacion.setEnabled(false);
		lblCanciones.setVisible(false);
		canciones.setVisible(false);
		lblDuracion.setVisible(false);	
		duracion.setVisible(false);
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
		setTitle("Buscar Camiseta por Precio");
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