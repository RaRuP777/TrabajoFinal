package GUI;

import java.awt.Toolkit;

import javax.swing.JOptionPane;

import Tienda.ClasesArryList.Camiseta;
import Tienda.Enumeraciones.Localizacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Ventana de b&uacute;squedas para productos del tipo Camiseta
 * 
 * @author Pedro J. Ramos
 *
 */
public class BuscarCamisetaLocalizacion extends Padre {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = -1570967969792531952L;

	/**
	 * Crea la Ventana
	 */
	public BuscarCamisetaLocalizacion() {
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
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Fichero.tienda.tamaño() == 0)
					JOptionPane.showMessageDialog(jFrame,"No hay productos en la tienda", "Fallido",JOptionPane.ERROR_MESSAGE);
				else {
					tiendaAux.setTienda(Fichero.tienda.getProductoCamiseta());
					stockAux.setTienda(tiendaAux.getProductoLocalizacion((Localizacion) comboBoxLocalizacion.getSelectedItem()));
					if (stockAux.tamaño() == 0)
						JOptionPane.showMessageDialog(jFrame,"No hay productos para esta búsqueda", "Fallido",JOptionPane.ERROR_MESSAGE);
					else {	
						mostrarCamiseta((Camiseta) stockAux.get(indice));
						comprobarBotones();
						okButton.setEnabled(false);
						vender.setEnabled(true);
					}
				}
			}
		});
		banda.setEnabled(false);
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuscarCamisetaLocalizacion.class.getResource("/GUI/iconos/buscar2.png")));
		setTitle("Buscar Camiseta Localizaci\u00F3n");
		setResizable(false);
		setBounds(100, 100, 450, 300);
	}
	
	/**
	 * Pasa al siguiente objeto de la b&uacute;squeda
	 */
	protected void mostrarSiguiente() {
		mostrarCamiseta((Camiseta) stockAux.get(++indice));
		comprobarBotones();
	}

	/**
	 * Pasa al anterior objeto de la b&uacute;squeda
	 */
	protected void mostrarAnterior() {
		mostrarCamiseta((Camiseta) stockAux.get(--indice));
		comprobarBotones();
	}
}
