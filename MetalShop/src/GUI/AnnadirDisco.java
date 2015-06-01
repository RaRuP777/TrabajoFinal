package GUI;

import javax.swing.JOptionPane;
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
					JOptionPane.showMessageDialog(contentPanel,"Un disco ha sido añadido", "Info",JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(contentPanel, "No puedes dejar campos en blanco","Fallido", JOptionPane.ERROR_MESSAGE);
				} catch (EstiloNoElegidoException e) {
					comboBoxEstilo.setForeground(java.awt.Color.RED);
					JOptionPane.showMessageDialog(contentPanel, e.getMessage(),"Fallido", JOptionPane.ERROR_MESSAGE);
				} catch (PrecioNoValidoException e) {
					precio.setForeground(java.awt.Color.RED);
					JOptionPane.showMessageDialog(contentPanel, e.getMessage(),"Fallido", JOptionPane.ERROR_MESSAGE);
				} catch (DuracionNoValidaException e) {
					duracion.setForeground(java.awt.Color.RED);
					JOptionPane.showMessageDialog(contentPanel, e.getMessage(),"Fallido", JOptionPane.ERROR_MESSAGE);
				} catch (CantidadCancionesNoValidaException e) {
					canciones.setForeground(java.awt.Color.RED);
					JOptionPane.showMessageDialog(contentPanel, e.getMessage(),"Fallido", JOptionPane.ERROR_MESSAGE);
				} catch (NombreBandaNoValidoException e) {
					banda.setForeground(java.awt.Color.RED);
					JOptionPane.showMessageDialog(contentPanel, e.getMessage(),"Fallido", JOptionPane.ERROR_MESSAGE);
				} catch (LocalizacionNoElegidaException e) {
					comboBoxLocalizacion.setForeground(java.awt.Color.RED);
					JOptionPane.showMessageDialog(contentPanel, e.getMessage(),"Fallido", JOptionPane.ERROR_MESSAGE);
				} catch (TituloNoValidoException e) {
					titulo.setForeground(java.awt.Color.RED);
					JOptionPane.showMessageDialog(contentPanel, e.getMessage(),"Fallido", JOptionPane.ERROR_MESSAGE);
				} catch (ProductoYaExisteException e) {
					JOptionPane.showMessageDialog(contentPanel, e.getMessage(),"Fallido", JOptionPane.ERROR_MESSAGE);
				}
}
		});
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