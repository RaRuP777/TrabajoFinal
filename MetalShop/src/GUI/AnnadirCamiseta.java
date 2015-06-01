package GUI;

import Tienda.Enumeraciones.Estilo;
import Tienda.Enumeraciones.Localizacion;
import Tienda.Enumeraciones.Talla;
import Tienda.Excepciones.EstiloNoElegidoException;
import Tienda.Excepciones.LocalizacionNoElegidaException;
import Tienda.Excepciones.NombreBandaNoValidoException;
import Tienda.Excepciones.PrecioNoValidoException;
import Tienda.Excepciones.ProductoYaExisteException;
import Tienda.Excepciones.SexoNoValidoException;
import Tienda.Excepciones.TallaNoValidaException;
import Tienda.Excepciones.TituloNoValidoException;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Agrega Productos del tipo Camiseta a la tienda
 * 
 * @author Pedro J. Ramos
 *
 */
public class AnnadirCamiseta extends Padre {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = 6383214785869413588L;

	/**
	 * Crea la ventana
	 */
	public AnnadirCamiseta() {
		super();
		setModal(true);
		duracion.setEnabled(false);
		canciones.setEnabled(false);
		id.setEditable(false);
		id.setEnabled(false);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Fichero.tienda.annadir(banda.getText().trim(),titulo.getText().trim(), (Localizacion) comboBoxLocalizacion.getSelectedItem(),
							Float.valueOf(precio.getText().trim()).floatValue(),
							(Estilo) comboBoxEstilo.getSelectedItem(), (Talla) comboBoxTalla.getSelectedItem(), getSexo());
					mensajeInfo("Una camiseta ha sido añadida");
				} catch (NumberFormatException e) {
					mensajeError("No puedes dejar campos en blanco");
				} catch (ProductoYaExisteException e) {
					mensajeError(e.getMessage());
				} catch (EstiloNoElegidoException e) {
					comboBoxEstilo.setForeground(java.awt.Color.RED);
					mensajeError(e.getMessage());
				} catch (PrecioNoValidoException e) {
					precio.setForeground(java.awt.Color.RED);
					mensajeError(e.getMessage());
				} catch (NombreBandaNoValidoException e) {
					banda.setForeground(java.awt.Color.RED);
					mensajeError(e.getMessage());
				} catch (TallaNoValidaException e) {
					comboBoxTalla.setForeground(java.awt.Color.RED);
					mensajeError(e.getMessage());
				} catch (SexoNoValidoException e) {
					radiobuttonHombre.setForeground(java.awt.Color.RED);
					radiobuttonMujer.setForeground(java.awt.Color.RED);
					mensajeError(e.getMessage());
				} catch (LocalizacionNoElegidaException e) {
					comboBoxLocalizacion.setForeground(java.awt.Color.RED);
					mensajeError(e.getMessage());
				} catch (TituloNoValidoException e) {
					titulo.setForeground(java.awt.Color.RED);
					mensajeError(e.getMessage());
				}
			}
		});
		okButton.setText("A\u00F1adir");
		siguiente.setVisible(false);
		anterior.setVisible(false);
		canciones.setVisible(false);
		lblCanciones.setVisible(false);
		duracion.setVisible(false);
		lblDuracion.setVisible(false);
		comboBoxTipo.setVisible(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AnnadirCamiseta.class.getResource("/GUI/iconos/tshirt18.png")));
		setTitle("A\u00F1adir Camiseta");
		setResizable(false);
		setBounds(100, 100, 450, 300);
	}
}