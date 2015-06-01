package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

/**
 * Ventana Ayuda
 * 
 * @author Pedro J. Ramos
 *
 */
public class Ayuda extends JDialog {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = 7030349616407898400L;
	
	/**
	 * Panel para contener elementos
	 */
	private final JPanel contentPanel = new JPanel();

	/**
	 * Crea la ventana
	 */
	public Ayuda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ayuda.class.getResource("/GUI/iconos/ayuda2.png")));
		setResizable(false);
		setTitle("Ayuda");
		setBounds(100, 100, 574, 495);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 548, 412);
			contentPanel.add(scrollPane);
			
			JEditorPane dtrpnAaaaaaaaaaa = new JEditorPane();
			dtrpnAaaaaaaaaaa.setEditable(false);
			dtrpnAaaaaaaaaaa.setContentType("text/plains");
			scrollPane.setViewportView(dtrpnAaaaaaaaaaa);
			dtrpnAaaaaaaaaaa.setText("1. Ventana Principal\r\n\u2022 Al abrir el programa lo primero que aparecer\u00E1 ser\u00E1 un mensaje emergente que nos dir\u00E1 el descuento del d\u00EDa que se aplicar\u00E1 autom\u00E1ticamente a los productos que est\u00E9n de oferta\r\n\u2022 El icono de la ventana principal es fijo y es el mismo que aparece en la barra de tareas\r\n\u2022 La ventana principal tiene un icono que ocupa toda su superficie, es una imagen PNG con licencia como todas las utilizadas en este proyecto\r\n\u2022 El nombre de la ventana cambia cuando se abre un fichero nuevo o uno existente o cuando el nuevo cambia de nombre al ser guardado como\u2026\r\n\u2022 El bot\u00F3n de cerrar (X) tiene un mensaje de advertencia para preguntar al usuario si desea guardar su trabajo antes de salir si ha realizado alg\u00FAn cambio en el archivo actualmente guardado\r\n\r\n2. Men\u00FA Ficheros\r\n\u2022 Nuevo crea un arrylist vac\u00EDo y un file para guardarlo nuevo, si tenemos abierto uno sin guardar cambios antes de hacerlo nos pregunta si deseamos guardarlo con una ventana con tres opciones, si/no/cancel. Si, lo guarda y justamente despu\u00E9s crea nuevo; no descarta los cambios y crea uno nuevo; si le damos a cancel vuelve hacia atr\u00E1s sin hacer nada.\r\n\u2022 Abrir nos permite abrir un archivo filtrado .obj que contiene un arrylist, al igual que Nuevo si tenemos abierto uno con cambios sin guardar tambi\u00E9n nos preguntar\u00E1 y act\u00FAa igual que el caso de nuevo.\r\n\u2022 Guardar, guarda el arraylist actual si ya ha sido guardado alguna vez directamente o nos pedir\u00E1 un nombre para guardarlo si es la primera vez\r\n\u2022 Guardar como nos pide, mediante una ventana el nombre con la extensi\u00F3n .ojb para guardar nuestro trabajo, si el archivo que elegimos ya existe nos preguntar\u00E1 si queremos sobrescribir\r\n\u2022 Salir, sale del programa y al igual que nuevo y abrir, si tenemos un trabajo con cambios sin guardar nos insta a guardarlo\r\n\r\n3. Men\u00FA Tienda\r\n\u2022 A\u00F1adir a\u00F1ade un disco mientras:\r\n   o Nombre de la Banda y T\u00EDtulo tenga un nombre v\u00E1lido, que empiece por may\u00FAscula y tenga una dimensi\u00F3n de entre 3 y 20 caracteres.\r\n   o Estilo como la Localizaci\u00F3n sea elegida de una lista desplegable mostrada.\r\n   o N\u00FAmeros de canciones debe ser m\u00EDnimo de 2 y m\u00E1ximo de 30. \r\n   o Duraci\u00F3n m\u00E1xima es de 72 minutos y no sea menor de 0\r\n   o Precio un valor mayor de 0.\r\n\u2022 A\u00F1adir a\u00F1ade una camiseta mientras:\r\n   o Nombre de la Banda y T\u00EDtulo tenga un nombre v\u00E1lido, que empiece por may\u00FAscula y tenga una dimensi\u00F3n de entre 3 y 20 caracteres.\r\n   o Estilo, talla y Localizaci\u00F3n sea elegida de una lista desplegable mostrada.\r\n   o Precio un valor mayor de 0.\r\n   o Sexo sea elegido entre hombre o mujer.\r\n\u2022 A\u00F1adir a\u00F1ade un accesorio mientras:\r\n    o Nombre de la Banda tenga un nombre v\u00E1lido, que empiece por may\u00FAscula y tenga una dimensi\u00F3n de entre 3 y 20 caracteres.\r\n   o Estilo, tipo de Accesorio y Localizaci\u00F3n sea elegida de una lista desplegable mostrada.\r\n   o Precio un valor mayor de 0.\r\n\u2022 Contar muestra el total de productos almacenados en nuestra tienda mediante un mensaje emergente, especificando el total y el tipo de cada producto que tenemos (disco/camiseta/accesorio)\r\n\u2022 Mostrar nos da la posibilidad de mostrar todos los productos de una determinada clase: Discos, Camisetas o Accesorios.\r\n\r\n4. Men\u00FA Buscar\r\n\u2022 Buscar disco ofrece diferentes b\u00FAsquedas a trav\u00E9s de par\u00E1metros que elige o introduce el usuario (banda, estilo, localizaci\u00F3n y precio), habilitando un bot\u00F3n de anterior y siguiente si el resultado de la b\u00FAsqueda es m\u00E1s de un producto.\r\n\u2022 Buscar camiseta ofrece diferentes b\u00FAsquedas a trav\u00E9s de par\u00E1metros que elige o introduce el usuario (banda, estilo, localizaci\u00F3n, sexo/talla y precio), habilitando un bot\u00F3n de anterior y siguiente si el resultado de la b\u00FAsqueda es m\u00E1s de un producto. \r\n\u2022 Buscar accesorio ofrece diferentes b\u00FAsquedas a trav\u00E9s de par\u00E1metros que elige o introduce el usuario (banda, estilo, localizaci\u00F3n, precio o Tipo de accesorio), habilitando un bot\u00F3n de anterior y siguiente si el resultado de la b\u00FAsqueda es m\u00E1s de un producto. \r\n   o En el momento en que se muestran los resultados de la b\u00FAsqueda se habilita en todos ellos el bot\u00F3n de Vender. Vender significa venderlo y eliminarlo de la tienda\r\n\r\n5. Men\u00FA Ayuda\r\n\u2022 Un men\u00FA de ayuda para ayudarnos en caso de dudas en una ventana que podemos tener abierta mientras usamos el resto del programa.\r\n\u2022 Tambi\u00E9n podemos ver esta misma ayuda en el navegador predeterminado de nuestro equipo pulsando en la segunda opci\u00F3n de este men\u00FA\r\n\u2022 Acerca de, con los datos personales del autor y versi\u00F3n del programa.");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Volver");
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
}