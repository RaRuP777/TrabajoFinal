package GUI;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import Tienda.Enumeraciones.Estilo;
import Tienda.Enumeraciones.Localizacion;
import Tienda.Enumeraciones.Tipo;
import Tienda.Excepciones.EstiloNoElegidoException;
import Tienda.Excepciones.LocalizacionNoElegidaException;
import Tienda.Excepciones.NombreBandaNoValidoException;
import Tienda.Excepciones.PrecioNoValidoException;
import Tienda.Excepciones.ProductoYaExisteException;

/**
 * Agrega Productos del tipo Accesorios a la tienda
 * 
 * @author Pedro J. Ramos
 *
 */

public class AnnadirAccesorio extends Padre {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = 6579428860076656884L;

	/**
	 * Crea la ventana
	 */
	public AnnadirAccesorio() {
		super();
		setModal(true);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Fichero.tienda.annadir(banda.getText().trim(),(Localizacion) comboBoxLocalizacion.getSelectedItem(),
								Float.valueOf(precio.getText().trim()).floatValue(), 
								(Estilo) comboBoxEstilo.getSelectedItem(), (Tipo) comboBoxTipo.getSelectedItem());
					JOptionPane.showMessageDialog(contentPanel,"Un accesorio ha sido añadido", "Info",JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(contentPanel, e.getMessage(),"Fallido", JOptionPane.ERROR_MESSAGE);
				} catch (ProductoYaExisteException e) {
					JOptionPane.showMessageDialog(contentPanel, e.getMessage(),"Fallido", JOptionPane.ERROR_MESSAGE);
				} catch (EstiloNoElegidoException e) {
					comboBoxEstilo.setForeground(java.awt.Color.RED);
					JOptionPane.showMessageDialog(contentPanel, e.getMessage(),"Fallido", JOptionPane.ERROR_MESSAGE);
				} catch (PrecioNoValidoException e) {
					precio.setForeground(java.awt.Color.RED);
					JOptionPane.showMessageDialog(contentPanel, e.getMessage(),"Fallido", JOptionPane.ERROR_MESSAGE);
				} catch (NombreBandaNoValidoException e) {
					banda.setForeground(java.awt.Color.RED);
					JOptionPane.showMessageDialog(contentPanel, e.getMessage(),"Fallido", JOptionPane.ERROR_MESSAGE);
				} catch (LocalizacionNoElegidaException e) {
					comboBoxLocalizacion.setForeground(java.awt.Color.RED);
					JOptionPane.showMessageDialog(contentPanel, e.getMessage(),"Fallido", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		okButton.setText("A\u00F1adir");
		id.setEditable(false);
		id.setEnabled(false);
		siguiente.setVisible(false);
		anterior.setVisible(false);
		titulo.setVisible(false);
		lblTitulo.setVisible(false);
		canciones.setVisible(false);
		lblCanciones.setVisible(false);
		duracion.setVisible(false);
		lblDuracion.setVisible(false);
		comboBoxTalla.setVisible(false);
		lblTalla.setVisible(false);
		radiobuttonHombre.setVisible(false);
		radiobuttonMujer.setVisible(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AnnadirAccesorio.class.getResource("/GUI/iconos/accesorios.png")));
		setTitle("A\u00F1adir Accesorio");
		setResizable(false);
		setBounds(100, 100, 450, 300);
	}
}