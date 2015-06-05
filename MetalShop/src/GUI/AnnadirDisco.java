package GUI;

import Tienda.Enumeraciones.Estilo;
import Tienda.Enumeraciones.Localizacion;
import Tienda.Excepciones.CantidadCancionesNoValidaException;
import Tienda.Excepciones.DuracionNoValidaException;
import Tienda.Excepciones.EstiloNoElegidoException;
import Tienda.Excepciones.LocalizacionNoElegidaException;
import Tienda.Excepciones.NombreBandaNoValidoException;
import Tienda.Excepciones.PrecioNoValidoException;
import Tienda.Excepciones.ProductoYaExisteException;
import Tienda.Excepciones.TituloNoValidoException;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Agrega Productos del tipo Disco a la tienda
 * 
 * @author Pedro J. Ramos
 *
 */
public class AnnadirDisco extends Padre {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = 751472261233213426L;

	/**
	 * Crea la Ventana
	 */
	public AnnadirDisco() {
		super();
		setModal(true);
		id.setEditable(false);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Fichero.tienda.annadir(banda.getText().trim(), (Localizacion) comboBoxLocalizacion.getSelectedItem(), 
							Float.valueOf(precio.getText().trim()).floatValue(), (Estilo) comboBoxEstilo.getSelectedItem(), 
							titulo.getText().trim(), Integer.valueOf(duracion.getText().trim()), Integer.valueOf(canciones.getText().trim()));
					mensajeInfo("Un disco ha sido a�adido");
				} catch (NumberFormatException e) {
					mensajeError("No puedes dejar campos en blanco");
				} catch (EstiloNoElegidoException e) {
					comboBoxEstilo.setForeground(java.awt.Color.RED);
					mensajeError(e.getMessage());
				} catch (PrecioNoValidoException e) {
					precio.setForeground(java.awt.Color.RED);
					mensajeError(e.getMessage());
				} catch (DuracionNoValidaException e) {
					duracion.setForeground(java.awt.Color.RED);
					mensajeError(e.getMessage());
				} catch (CantidadCancionesNoValidaException e) {
					canciones.setForeground(java.awt.Color.RED);
					mensajeError(e.getMessage());
				} catch (NombreBandaNoValidoException e) {
					banda.setForeground(java.awt.Color.RED);
					mensajeError(e.getMessage());
				} catch (LocalizacionNoElegidaException e) {
					comboBoxLocalizacion.setForeground(java.awt.Color.RED);
					mensajeError(e.getMessage());
				} catch (TituloNoValidoException e) {
					titulo.setForeground(java.awt.Color.RED);
					mensajeError(e.getMessage());
				} catch (ProductoYaExisteException e) {
					mensajeError(e.getMessage());
				}
}
		});
		lblEncontrados.setVisible(false);
		encontrado.setVisible(false);
		lblDuracion.setBounds(10, 123, 75, 14);
		okButton.setText("A\u00F1adir");
		siguiente.setVisible(false);
		anterior.setVisible(false);
		comboBoxTalla.setVisible(false);
		lblTalla.setVisible(false);
		comboBoxTipo.setVisible(false);
		radiobuttonHombre.setVisible(false);
		radiobuttonMujer.setVisible(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AnnadirDisco.class.getResource("/GUI/iconos/disco.png")));
		setTitle("A\u00F1adir Disco");
		setResizable(false);
		setBounds(100, 100, 450, 300);
	}
}