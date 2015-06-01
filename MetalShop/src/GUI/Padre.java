package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import Tienda.ClasesArryList.Accesorio;
import Tienda.ClasesArryList.Camiseta;
import Tienda.ClasesArryList.Disco;
import Tienda.ClasesArryList.Stock;
import Tienda.Enumeraciones.Estilo;
import Tienda.Enumeraciones.Localizacion;
import Tienda.Enumeraciones.Sexo;
import Tienda.Enumeraciones.Talla;
import Tienda.Enumeraciones.Tipo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Ventana Padre
 * 
 * @author Pedro J. Ramos
 *
 */
public class Padre extends JDialog {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = -7007158703390881136L;

	protected JPanel contentPanel = new JPanel();
	protected JPanel buttonPane = new JPanel();

	protected JTextField banda;
	protected JTextField titulo;
	protected JTextField id;
	protected JTextField precio;
	protected JTextField fecha;
	protected JTextField canciones;
	protected JTextField duracion;

	protected JButton cancelButton = new JButton("Volver");
	protected JButton okButton = new JButton("OK");
	protected JButton siguiente = new JButton(">");
	protected JButton anterior = new JButton("<");
	protected JButton vender = new JButton("\u00BFVender?");

	protected JRadioButton radiobuttonMujer = new JRadioButton("Mujer");
	protected JRadioButton radiobuttonHombre = new JRadioButton("Hombre");
	protected final ButtonGroup buttonGroup = new ButtonGroup();

	protected JLabel lblBanda = new JLabel("Banda");
	protected JLabel lblTitulo = new JLabel("Titulo");
	protected JLabel lblId = new JLabel("id");
	protected JLabel lblPrecio = new JLabel("Precio");
	protected JLabel lblFechaAlta = new JLabel("Fecha Alta");
	protected JLabel lblEstilos = new JLabel("Estilos");
	protected JLabel lblLocalizacion = new JLabel("Localizacion");
	protected JLabel lblDuracion = new JLabel("Duracion");
	protected JLabel lblTalla = new JLabel("Talla");
	protected JLabel lblCanciones = new JLabel("Canciones");

	protected JComboBox<Estilo> comboBoxEstilo = new JComboBox<Estilo>();
	protected JComboBox<Tipo> comboBoxTipo = new JComboBox<Tipo>();
	protected JComboBox<Talla> comboBoxTalla = new JComboBox<Talla>();
	protected JComboBox<Localizacion> comboBoxLocalizacion = new JComboBox<Localizacion>();

	protected JFrame jFrame = new JFrame();

	/**
	 * Tienda auxiliar para almacenar temporalmente las b&uacute;squedas
	 */
	protected Stock tiendaAux = new Stock();
	/**
	 * Stock auxiliar para almacenar temporalmente las b&uacute;squedas
	 */
	protected Stock stockAux = new Stock();
	
	/**
	 * &Iacute;ncide para recorrer los ArrayList
	 */
	protected int indice=0;

	/**
	 * Crea la Ventana
	 */
	public Padre() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblBanda.setBounds(10, 11, 75, 14);
			contentPanel.add(lblBanda);
		}

		banda = new JTextField();
		banda.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				banda.setForeground(java.awt.Color.BLACK);
			}
		});
		banda.setBounds(95, 8, 118, 20);
		contentPanel.add(banda);
		banda.setColumns(10);

		lblTitulo.setBounds(10, 36, 46, 14);
		contentPanel.add(lblTitulo);

		titulo = new JTextField();
		titulo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				titulo.setForeground(java.awt.Color.BLACK);
			}
		});
		titulo.setText("");
		titulo.setBounds(95, 33, 118, 20);
		contentPanel.add(titulo);
		titulo.setColumns(10);
		comboBoxEstilo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				comboBoxEstilo.setForeground(java.awt.Color.BLACK);
			}
		});

		comboBoxEstilo.setModel(new DefaultComboBoxModel<Estilo>(
				Tienda.Enumeraciones.Estilo.values()));
		comboBoxEstilo.setBounds(95, 64, 118, 20);
		contentPanel.add(comboBoxEstilo);

		lblId.setBounds(307, 11, 46, 14);
		contentPanel.add(lblId);

		id = new JTextField();
		id.setEnabled(false);
		id.setEditable(false);
		id.setBounds(349, 8, 75, 20);
		contentPanel.add(id);
		id.setColumns(10);

		lblPrecio.setBounds(285, 36, 46, 14);
		contentPanel.add(lblPrecio);

		precio = new JTextField();
		precio.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				precio.setForeground(java.awt.Color.BLACK);
			}
		});
		precio.setBounds(349, 33, 75, 20);
		contentPanel.add(precio);
		precio.setColumns(10);
		comboBoxLocalizacion.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				comboBoxLocalizacion.setForeground(java.awt.Color.BLACK);
			}
		});

		comboBoxLocalizacion.setModel(new DefaultComboBoxModel<Localizacion>(Tienda.Enumeraciones.Localizacion.values()));
		comboBoxLocalizacion.setBounds(321, 92, 103, 20);
		contentPanel.add(comboBoxLocalizacion);

		lblFechaAlta.setBounds(266, 64, 73, 14);
		contentPanel.add(lblFechaAlta);

		fecha = new JTextField();
		fecha.setEditable(false);
		fecha.setEnabled(false);
		fecha.setText("");
		fecha.setBounds(349, 61, 75, 20);
		contentPanel.add(fecha);
		fecha.setColumns(10);

		lblEstilos.setBounds(10, 67, 46, 14);
		contentPanel.add(lblEstilos);

		lblLocalizacion.setBounds(228, 95, 83, 14);
		contentPanel.add(lblLocalizacion);

		lblCanciones.setBounds(10, 108, 75, -17);
		contentPanel.add(lblCanciones);

		canciones = new JTextField();
		canciones.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				canciones.setForeground(java.awt.Color.BLACK);
			}
		});
		canciones.setBounds(95, 95, 118, 20);
		contentPanel.add(canciones);
		canciones.setColumns(10);

		lblDuracion.setBounds(10, 123, 75, 14);
		contentPanel.add(lblDuracion);

		duracion = new JTextField();
		duracion.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				duracion.setForeground(java.awt.Color.BLACK);
			}
		});
		duracion.setBounds(95, 120, 118, 20);
		contentPanel.add(duracion);
		duracion.setColumns(10);

		buttonGroup.add(radiobuttonHombre);
		radiobuttonHombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				radiobuttonHombre.setForeground(java.awt.Color.BLACK);
				radiobuttonMujer.setForeground(java.awt.Color.BLACK);
			}
		});
		radiobuttonHombre.setBounds(61, 91, 109, 23);
		contentPanel.add(radiobuttonHombre);

		buttonGroup.add(radiobuttonMujer);
		radiobuttonMujer.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				radiobuttonHombre.setForeground(java.awt.Color.BLACK);
				radiobuttonMujer.setForeground(java.awt.Color.BLACK);
			}
		});
		radiobuttonMujer.setBounds(61, 116, 109, 23);
		contentPanel.add(radiobuttonMujer);
		comboBoxTalla.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				comboBoxTalla.setForeground(java.awt.Color.BLACK);
			}
		});

		comboBoxTalla.setModel(new DefaultComboBoxModel<Talla>(Tienda.Enumeraciones.Talla.values()));
		comboBoxTalla.setBounds(95, 151, 118, 20);
		contentPanel.add(comboBoxTalla);
		comboBoxTipo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				comboBoxTipo.setForeground(java.awt.Color.BLACK);
			}
		});

		comboBoxTipo.setModel(new DefaultComboBoxModel<Tipo>(Tienda.Enumeraciones.Tipo.values()));
		comboBoxTipo.setBounds(46, 95, 103, 20);
		contentPanel.add(comboBoxTipo);

		lblTalla.setBounds(10, 154, 75, 14);
		contentPanel.add(lblTalla);
		lblCanciones.setBounds(10, 95, 75, 14);

		contentPanel.add(lblCanciones);
		vender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fichero.tienda.vender(id.getText());
				JOptionPane.showMessageDialog(contentPanel,
								new JLabel("<HTML><BODY BGCOLOR=#FFCCCC><center>Producto Vendido y elminado"
												+ stockAux.vender(id.getText())
												+ "<br/>¡Gracias por su compra!</center></BODY></HTML>"),
								"Factura", JOptionPane.INFORMATION_MESSAGE);
				vender.setEnabled(false);
			}
		});

		vender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		vender.setEnabled(false);
		vender.setBounds(264, 150, 146, 54);
		contentPanel.add(vender);
		{
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			anterior.setEnabled(false);
			buttonPane.add(anterior);
			siguiente.setEnabled(false);
			buttonPane.add(siguiente);
			{
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	/**
	 * Comprueba y habilita/deshabilita los botones siguiente y anterior si hay o no algo que mostrar
	 */
	protected void comprobarBotones() {
		if (stockAux.get(indice + 1) == null)
			siguiente.setEnabled(false);
		else
			siguiente.setEnabled(true);

		if (stockAux.get(indice - 1) == null)
			anterior.setEnabled(false);
		else
			anterior.setEnabled(true);
	}

	/**
	 * Muestra un disco
	 * 
	 * @param disco Disco a mostrar
	 */
	protected void mostrarDisco(Disco disco) {
		banda.setText(disco.getBanda());
		titulo.setText(disco.getTitulo());
		comboBoxEstilo.setSelectedItem(disco.getEstilo());
		canciones.setText(Integer.toString(disco.getCanciones()));
		duracion.setText(Integer.toString(disco.getDuracion()) + " minutos");
		id.setText(disco.getId());
		if (Principal.getDia()==6)
			precio.setText(Float.toString(disco.descuento(disco.getPrecio())) + " €");
		else
			precio.setText(Float.toString(disco.getPrecio()) + " €");
		fecha.setText(disco.getFecha());
		comboBoxLocalizacion.setSelectedItem(disco.getLocalizacion());
	}

	/**
	 * Muestra una camiseta
	 * 
	 * @param camiseta Camiseta a mostrar
	 */
	protected void mostrarCamiseta(Camiseta camiseta) {
		banda.setText(camiseta.getBanda());
		titulo.setText(camiseta.getTitulo());
		comboBoxEstilo.setSelectedItem(camiseta.getEstilo());
		id.setText(camiseta.getId());
		if (Principal.getDia()==4)
			precio.setText(Float.toString(camiseta.descuento(camiseta.getPrecio())) + " €");
		else
			precio.setText(Float.toString(camiseta.getPrecio()) + " €");
		fecha.setText(camiseta.getFecha());
		comboBoxLocalizacion.setSelectedItem(camiseta.getLocalizacion());
		comboBoxTalla.setSelectedItem(camiseta.getTalla());
		switch (camiseta.getSexo()) {
		case HOMBRE:
			radiobuttonHombre.setSelected(true);
			break;
		case MUJER:
			radiobuttonMujer.setSelected(true);
			break;
		default:
			break;
		}
	}

	/**
	 * Muestra un accesorio
	 * 
	 * @param accesorio Accesorio a mostrar
	 */
	protected void mostrarAccesorio(Accesorio accesorio) {
		banda.setText(accesorio.getBanda());
		comboBoxEstilo.setSelectedItem(accesorio.getEstilo());
		id.setText(accesorio.getId());
		if (Principal.getDia()==2)
			precio.setText(Float.toString(accesorio.descuento(accesorio.getPrecio())) + " €");
		else
			precio.setText(Float.toString(accesorio.getPrecio()) + " €");
		fecha.setText(accesorio.getFecha());
		comboBoxLocalizacion.setSelectedItem(accesorio.getLocalizacion());
		comboBoxTipo.setSelectedItem(accesorio.getTipo());
	}

	/**
	 * Obtiene el sexo seleccionado
	 * 
	 * @return Sexo seleccionado
	 */
	protected Sexo getSexo() {
		if (radiobuttonHombre.isSelected())
			return Sexo.HOMBRE;
		else if (radiobuttonMujer.isSelected())
			return Sexo.MUJER;
		else
			return null;
	}

	/**
	 * Mensaje de error
	 * 
	 * @param mensaje Mensaje a mostrar 
	 */
	protected void mensajeError(String mensaje) {
		JOptionPane.showMessageDialog(jFrame,mensaje, "Error",JOptionPane.ERROR_MESSAGE);	
	}
	
	/**
	 * Mensaje de informaci&oacute;n
	 * 
	 * @param mensaje Mensaje a mostrar
	 */
	protected void mensajeInfo(String mensaje){
		JOptionPane.showMessageDialog(jFrame, mensaje, "Info",JOptionPane.INFORMATION_MESSAGE);
	}
}