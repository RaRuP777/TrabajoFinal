package GUI;

import javax.swing.JOptionPane;

import Tienda.ClasesArryList.Accesorio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

/**
 * Ventana de b&uacute;squedas para productos del tipo Accesorio
 * 
 * @author Pedro J. Ramos
 *
 */
public class BuscarAccesorioPrecio extends Padre {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = 8886193901037977736L;

	/**
	 * Crea la Ventana
	 */
	public BuscarAccesorioPrecio() {
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
					tiendaAux.setTienda(Fichero.tienda.getProductoAccesorio());
					stockAux.setTienda(tiendaAux.getProductoPrecio(precio.getText()));
					if (stockAux.tamaño() == 0)
						JOptionPane.showMessageDialog(jFrame,"No hay productos para esta búsqueda","Fallido", JOptionPane.ERROR_MESSAGE);
					else {
						mostrarAccesorio((Accesorio) stockAux.get(indice));
						comprobarBotones();
						okButton.setEnabled(false);
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
		setTitle("Buscar Accesorio por Precio");
		setResizable(false);
		setBounds(100, 100, 450, 300);
	}
	
	/**
	 * Pasa al siguiente objeto de la b&uacute;squeda
	 */
	protected void mostrarSiguiente() {
		mostrarAccesorio((Accesorio) stockAux.get(++indice));
		comprobarBotones();
	}
	
	/**
	 * Pasa al anterior objeto de la b&uacute;squeda
	 */
	protected void mostrarAnterior() {
		mostrarAccesorio((Accesorio) stockAux.get(--indice));
		comprobarBotones();
	}
}