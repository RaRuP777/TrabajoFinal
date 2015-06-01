package GUI;

import javax.swing.JOptionPane;

import Tienda.ClasesArryList.Accesorio;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Ventana de b&uacute;squedas para productos del tipo Accesorio
 * 
 * @author Pedro J. Ramos
 *
 */
public class BuscarAccesorioBanda extends Padre {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = -3088919005654279173L;

	/**
	 * Crea la Ventana
	 */
	public BuscarAccesorioBanda() {
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
		setResizable(false);
		comboBoxLocalizacion.setEnabled(false);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Fichero.tienda.tama�o() == 0)
					JOptionPane.showMessageDialog(jFrame,"No hay productos en la tienda", "Fallido",JOptionPane.ERROR_MESSAGE);
				else {
					tiendaAux.setTienda(Fichero.tienda.getProductoAccesorio());
					stockAux.setTienda(tiendaAux.getProductoBanda(banda.getText()));
					if (stockAux.tama�o() == 0)
						JOptionPane.showMessageDialog(jFrame,"No hay productos para esta b�squeda","Fallido", JOptionPane.ERROR_MESSAGE);
					else {
						mostrarAccesorio((Accesorio) stockAux.get(indice));
						comprobarBotones();
						okButton.setEnabled(false);
						vender.setEnabled(true);
					}
				}
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuscarAccesorioLocalizacion.class.getResource("/GUI/iconos/buscar2.png")));
		setTitle("Buscar Accesorio por Banda");
		banda.setEditable(false);
		okButton.setText("Buscar");
		fecha.setEnabled(false);
		precio.setEnabled(false);
		id.setEnabled(false);
		comboBoxTipo.setEnabled(false);
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