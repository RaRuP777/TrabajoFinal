package GUI;

import Tienda.ClasesArryList.Accesorio;
import Tienda.Enumeraciones.Localizacion;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Ventana de b&uacute;squedas para productos del tipo Accesorio
 * 
 * @author Pedro J. Ramos
 *
 */
public class BuscarAccesorioLocalizacion extends Padre {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = 2910246818106843414L;

	/**
	 * Crea la Ventana
	 */
	public BuscarAccesorioLocalizacion() {
		super();
		titulo.setEnabled(false);
		titulo.setEditable(false);
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
				if (Fichero.tienda.tama�o() == 0)
					mensajeError("No hay productos en la tienda");
				else {
					tiendaAux.setTienda(Fichero.tienda.getProductoAccesorio());
					stockAux.setTienda(tiendaAux.getProductoLocalizacion((Localizacion) comboBoxLocalizacion.getSelectedItem()));
					encontrado.setText(Integer.toString(stockAux.tama�o()));
					if (stockAux.tama�o() == 0)
						mensajeError("No hay productos para esta b�squeda");
					else {	
						mostrarAccesorio((Accesorio) stockAux.get(indice));
						comprobarBotones();
						vender.setEnabled(true);
					}
				}
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuscarAccesorioLocalizacion.class.getResource("/GUI/iconos/buscar2.png")));
		setTitle("Buscar Accesorio por Localizaci\u00F3n");
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