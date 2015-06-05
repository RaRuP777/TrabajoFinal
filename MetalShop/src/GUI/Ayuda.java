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
			dtrpnAaaaaaaaaaa.setContentType("text/html");
			scrollPane.setViewportView(dtrpnAaaaaaaaaaa);
			dtrpnAaaaaaaaaaa.setText("<ul>\r\n\t<li style=\"text-align: justify;\">Al abrir el programa lo primero que aparecer&aacute; ser&aacute; un mensaje emergente que nos dir&aacute; el descuento del d&iacute;a que se aplicar&aacute; autom&aacute;ticamente a los productos que est&eacute;n de oferta</li>\r\n\t<li style=\"text-align: justify;\">El icono de la ventana principal es fijo y es el mismo que aparece en la barra de tareas</li>\r\n\t<li style=\"text-align: justify;\">La ventana principal tiene un icono que ocupa toda su superficie, es una imagen PNG con licencia como todas las utilizadas en este proyecto</li>\r\n\t<li style=\"text-align: justify;\">El nombre de la ventana cambia cuando se abre un fichero nuevo o uno existente o cuando el nuevo cambia de nombre al ser guardado como&hellip;</li>\r\n\t<li style=\"text-align: justify;\">El bot&oacute;n de cerrar (X) tiene un mensaje de advertencia para preguntar al usuario si desea guardar su trabajo antes de salir si ha realizado alg&uacute;n cambio en el archivo actualmente guardado</li>\r\n</ul>\r\n\r\n<p style=\"text-align: justify;\">&nbsp;</p>\r\n\r\n<h2 style=\"text-align: justify;\"><strong>2. Men&uacute; Ficheros</strong></h2>\r\n\r\n<ul>\r\n\t<li style=\"text-align: justify;\">Nuevo crea un arrylist vac&iacute;o y un file para guardarlo nuevo, si tenemos abierto uno sin guardar cambios antes de hacerlo nos pregunta si deseamos guardarlo con una ventana con tres opciones, si/no/cancel. Si, lo guarda y justamente despu&eacute;s crea nuevo; no descarta los cambios y crea uno nuevo; si le damos a cancel vuelve hacia atr&aacute;s sin hacer nada.</li>\r\n\t<li style=\"text-align: justify;\">Abrir nos permite abrir un archivo filtrado .obj que contiene un arrylist, al igual que Nuevo si tenemos abierto uno con cambios sin guardar tambi&eacute;n nos preguntar&aacute; y act&uacute;a igual que el caso de nuevo.</li>\r\n\t<li style=\"text-align: justify;\">Guardar, guarda el arraylist actual si ya ha sido guardado alguna vez directamente o nos pedir&aacute; un nombre para guardarlo si es la primera vez</li>\r\n\t<li style=\"text-align: justify;\">Guardar como nos pide, mediante una ventana el nombre con la extensi&oacute;n .ojb para guardar nuestro trabajo, si el archivo que elegimos ya existe nos preguntar&aacute; si queremos sobrescribir</li>\r\n\t<li style=\"text-align: justify;\">Salir, sale del programa y al igual que nuevo y abrir, si tenemos un trabajo con cambios sin guardar nos insta a guardarlo</li>\r\n</ul>\r\n\r\n<p style=\"text-align: justify;\">&nbsp;</p>\r\n\r\n<h2 style=\"text-align: justify;\"><strong>3. Men&uacute; Tienda</strong></h2>\r\n\r\n<ul>\r\n\t<li style=\"text-align: justify;\">A&ntilde;adir a&ntilde;ade un disco mientras:\r\n\t<ul>\r\n\t\t<li style=\"text-align: justify;\">Nombre de la Banda y T&iacute;tulo tenga un nombre v&aacute;lido, que empiece por may&uacute;scula y tenga una dimensi&oacute;n de entre 3 y 20 caracteres.</li>\r\n\t\t<li style=\"text-align: justify;\">Estilo como la Localizaci&oacute;n sea elegida de una lista desplegable mostrada.</li>\r\n\t\t<li style=\"text-align: justify;\">N&uacute;meros de canciones debe ser m&iacute;nimo de 2 y m&aacute;ximo de 30.</li>\r\n\t\t<li style=\"text-align: justify;\">Duraci&oacute;n m&aacute;xima es de 72 minutos y no sea menor de 0</li>\r\n\t\t<li style=\"text-align: justify;\">Precio un valor mayor de 0.</li>\r\n\t</ul>\r\n\t</li>\r\n\t<li style=\"text-align: justify;\">A&ntilde;adir a&ntilde;ade una camiseta mientras:\r\n\t<ul>\r\n\t\t<li style=\"text-align: justify;\">Nombre de la Banda y T&iacute;tulo tenga un nombre v&aacute;lido, que empiece por may&uacute;scula y tenga una dimensi&oacute;n de entre 3 y 20 caracteres.</li>\r\n\t\t<li style=\"text-align: justify;\">Estilo, talla y Localizaci&oacute;n sea elegida de una lista desplegable mostrada.</li>\r\n\t\t<li style=\"text-align: justify;\">Precio un valor mayor de 0.</li>\r\n\t\t<li style=\"text-align: justify;\">Sexo sea elegido entre hombre o mujer.</li>\r\n\t</ul>\r\n\t</li>\r\n\t<li style=\"text-align: justify;\">A&ntilde;adir a&ntilde;ade un accesorio mientras:\r\n\t<ul>\r\n\t\t<li style=\"text-align: justify;\">Nombre de la Banda tenga un nombre v&aacute;lido, que empiece por may&uacute;scula y tenga una dimensi&oacute;n de entre 3 y 20 caracteres.</li>\r\n\t\t<li style=\"text-align: justify;\">Estilo, tipo de Accesorio y Localizaci&oacute;n sea elegida de una lista desplegable mostrada.</li>\r\n\t\t<li style=\"text-align: justify;\">Precio un valor mayor de 0.</li>\r\n\t</ul>\r\n\t</li>\r\n\t<li style=\"text-align: justify;\">Contar muestra el total de productos almacenados en nuestra tienda mediante un mensaje emergente, especificando el total y el tipo de cada producto que tenemos (disco/camiseta/accesorio)</li>\r\n\t<li style=\"text-align: justify;\">Mostrar nos da la posibilidad de mostrar todos los productos de una determinada clase: Discos, Camisetas o Accesorios.</li>\r\n</ul>\r\n\r\n<p style=\"text-align: justify;\">&nbsp;</p>\r\n\r\n<h2 style=\"text-align: justify;\"><strong>4. Men&uacute; Buscar</strong></h2>\r\n\r\n<ul>\r\n\t<li style=\"text-align: justify;\">Buscar disco ofrece diferentes b&uacute;squedas a trav&eacute;s de par&aacute;metros que elige o introduce el usuario (banda, estilo, localizaci&oacute;n y precio), habilitando un bot&oacute;n de anterior y siguiente si el resultado de la b&uacute;squeda es m&aacute;s de un producto.</li>\r\n\t<li style=\"text-align: justify;\">Buscar camiseta ofrece diferentes b&uacute;squedas a trav&eacute;s de par&aacute;metros que elige o introduce el usuario (banda, estilo, localizaci&oacute;n, sexo/talla y precio), habilitando un bot&oacute;n de anterior y siguiente si el resultado de la b&uacute;squeda es m&aacute;s de un producto.</li>\r\n\t<li style=\"text-align: justify;\">Buscar accesorio ofrece diferentes b&uacute;squedas a trav&eacute;s de par&aacute;metros que elige o introduce el usuario (banda, estilo, localizaci&oacute;n, precio o Tipo de accesorio), habilitando un bot&oacute;n de anterior y siguiente si el resultado de la b&uacute;squeda es m&aacute;s de un producto.\r\n\t<ul>\r\n\t\t<li style=\"text-align: justify;\">En el momento en que se muestran los resultados de la b&uacute;squeda se habilita en todos ellos el bot&oacute;n de Vender. Vender significa venderlo y eliminarlo de la tienda</li>\r\n\t</ul>\r\n\t</li>\r\n</ul>\r\n\r\n<p style=\"text-align: justify;\">&nbsp;</p>\r\n\r\n<h2 style=\"text-align: justify;\"><strong>5. Men&uacute; Ayuda</strong></h2>\r\n\r\n<ul>\r\n\t<li style=\"text-align: justify;\">Un men&uacute; de ayuda para ayudarnos en caso de dudas en una ventana que podemos tener abierta mientras usamos el resto del programa.</li>\r\n\t<li style=\"text-align: justify;\">Tambi&eacute;n podemos ver esta misma ayuda en el navegador predeterminado de nuestro equipo pulsando en la segunda opci&oacute;n de este men&uacute;</li>\r\n\t<li style=\"text-align: justify;\">Acerca de, con los datos personales del autor y versi&oacute;n del programa.</li>\r\n</ul>");
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