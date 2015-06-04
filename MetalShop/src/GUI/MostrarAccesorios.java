package GUI;

import Tienda.ClasesArryList.Accesorio;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana de mostrar todos los productos del tipo Accesorio
 * 
 * @author Pedro J. Ramos
 *
 */
public class MostrarAccesorios extends Padre {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = -2878629197888268648L;

	/**
	 * Crea la Ventana
	 */
	public MostrarAccesorios() {
		super();
		banda.setEnabled(false);
		comboBoxLocalizacion.setEnabled(false);
		titulo.setEditable(false);
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
		setResizable(false);
		setModal(true);
		anterior.setEnabled(true);
		siguiente.setEnabled(true);
		precio.setEditable(false);
		id.setEditable(false);
		stockAux.setTienda(Fichero.tienda.getProductoAccesorio());
		encontrado.setText(Integer.toString(stockAux.tamaño()));
		mostrarAccesorio((Accesorio) stockAux.get(indice));
		comprobarBotones();
		vender.setEnabled(true);
		okButton.setVisible(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuscarAccesorioLocalizacion.class.getResource("/GUI/iconos/buscar2.png")));
		setTitle("Mostar Todos los Accesorios");
		banda.setEditable(false);
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
	 * Pasa al siguiente objeto del ArrayList
	 */
	private void mostrarSiguiente() {
		mostrarAccesorio((Accesorio) stockAux.get(++indice));
		comprobarBotones();
	}

	/**
	 * Pasa al anterior objeto del ArrayList
	 */
	private void mostrarAnterior() {
		mostrarAccesorio((Accesorio) stockAux.get(--indice));
		comprobarBotones();
	}
}