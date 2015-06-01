package GUI;

import javax.swing.JOptionPane;
import Tienda.ClasesArryList.Accesorio;
import Tienda.Enumeraciones.Tipo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

/**
 * Ventana de b&uacute;squedas para productos del tipo Accesorio
 * 
 * @author Pedro J. Ramos
 *
 */
public class BuscarAccesorioTipo extends Padre {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = 6161637736454104338L;

	/**
	 * Crea la Ventana
	 */
	public BuscarAccesorioTipo() {
		super();
		banda.setEnabled(false);
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
		setResizable(false);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Fichero.tienda.tamaño() == 0)
					JOptionPane.showMessageDialog(jFrame,"No hay productos en la tienda", "Fallido",JOptionPane.ERROR_MESSAGE);
				else {
					tiendaAux.setTienda(Fichero.tienda.getProductoAccesorio());
					stockAux.setTienda(tiendaAux.getAccesorioTipo((Tipo) comboBoxTipo.getSelectedItem()));
					if (stockAux.tamaño() == 0)
						JOptionPane.showMessageDialog(jFrame,"No hay productos para esta búsqueda", "Fallido",JOptionPane.ERROR_MESSAGE);
					else {	
						mostrarAccesorio((Accesorio) stockAux.get(indice));
						comprobarBotones();
						okButton.setEnabled(false);
						vender.setEnabled(true);
					}
				}
			}
		});
		comboBoxLocalizacion.setEnabled(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuscarAccesorioLocalizacion.class.getResource("/GUI/iconos/buscar2.png")));
		setTitle("Buscar Accesorio por Tipo");
		banda.setEditable(false);
		okButton.setText("Buscar");
		fecha.setEnabled(false);
		precio.setEnabled(false);
		id.setEnabled(false);
		comboBoxEstilo.setEnabled(false);
		titulo.setVisible(false);
		lblTitulo.setVisible(false);
		canciones.setVisible(false);
		lblCanciones.setVisible(false);
		duracion.setVisible(false);
		lblDuracion.setVisible(false);
		radiobuttonHombre.setVisible(false);
		radiobuttonMujer.setVisible(false);
		lblTalla.setVisible(false);
		comboBoxTalla.setVisible(false);
		setBounds(100, 100, 450, 300);
	}
	
	/**
	 * Pasa al siguiente objeto de la b&uacute;squeda
	 */
	private void mostrarSiguiente() {
		mostrarAccesorio((Accesorio) stockAux.get(++indice));
		comprobarBotones();
	}
	
	/**
	 * Pasa al anterior objeto de la b&uacute;squeda
	 */
	private void mostrarAnterior() {
		mostrarAccesorio((Accesorio) stockAux.get(--indice));
		comprobarBotones();
	}
}