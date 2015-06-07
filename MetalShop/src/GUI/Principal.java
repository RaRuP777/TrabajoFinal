package GUI;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.JLabel;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;

/**
 * Ventana principal del programa
 * 
 * @author Pedro J. Ramos
 *
 */
public class Principal {

	private JFrame principal;
	private JFrame jFrame = new JFrame();
	private JPanel contentPanel = new JPanel();
	private Ayuda ayuda = new Ayuda();
	/**
	 * Almacena el dia de la semana en el que estamos
	 */
	private final static int dia = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

	/**
	 * Lanza la aplicaci&oacute;n
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.principal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea la aplicaci&oacute;n
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Inicializa los contenidos de la ventana
	 */
	private void initialize() {
		principal = new JFrame();
		principal.setBackground(new Color(0, 0, 0));
		principal.setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/GUI/iconos/shop.png")));
		principal.setForeground(Color.BLACK);
		principal.setResizable(false);
		principal.setTitle("MetalShop - ");
		principal.setBounds(100, 100, 549, 381);
		principal.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		WindowListener exitListener = new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				if (cambiosSinGuardar())
					return;
				else
					System.exit(0);
			}
		};
		principal.addWindowListener(exitListener);

		ImageIcon icon = crearImagen("iconos/portada.png", "MetalShop");
		JLabel imagen = new JLabel("", icon, JLabel.CENTER);
		imagen.setBackground(Color.BLACK);

		imagen.setBounds(0, 0, 543, 331);
		principal.getContentPane().add(imagen);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		principal.setJMenuBar(menuBar);

		JMenu mnFicheros = new JMenu("Ficheros");
		mnFicheros.setForeground(Color.RED);
		mnFicheros.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 18));
		mnFicheros.setIcon(new ImageIcon(Principal.class
				.getResource("/GUI/iconos/fichero.png")));
		mnFicheros.setMnemonic('F');
		menuBar.add(mnFicheros);

		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 14));
		mntmNuevo.setForeground(Color.RED);
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cambiosSinGuardar())
					return;
				else
					Fichero.nuevo();
				principal.setTitle("MetalShop - " + Fichero.getName());
			}
		});
		mntmNuevo.setIcon(new ImageIcon(Principal.class
				.getResource("/GUI/iconos/nuevo.png")));
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnFicheros.add(mntmNuevo);

		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 14));
		mntmAbrir.setForeground(Color.RED);
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cambiosSinGuardar())
					return;
				else
					Fichero.abrir();
				principal.setTitle("MetalShop - " + Fichero.getName());
			}
		});
		mntmAbrir.setIcon(new ImageIcon(Principal.class.getResource("/GUI/iconos/abrir.png")));
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
		mnFicheros.add(mntmAbrir);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 14));
		mntmGuardar.setForeground(Color.RED);
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fichero.guardar();
			}
		});
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
		mntmGuardar.setIcon(new ImageIcon(Principal.class.getResource("/GUI/iconos/guardar.png")));
		mnFicheros.add(mntmGuardar);

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 14));
		mntmGuardarComo.setForeground(Color.RED);
		mntmGuardarComo.setIcon(new ImageIcon(Principal.class.getResource("/GUI/iconos/guardarComo.png")));
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fichero.guardarComo();
				principal.setTitle(Fichero.getName());
			}
		});
		mntmGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnFicheros.add(mntmGuardarComo);

		JSeparator separator = new JSeparator();
		mnFicheros.add(separator);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 14));
		mntmSalir.setForeground(Color.RED);
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cambiosSinGuardar())
					return;
				else
					System.exit(0);
			}
		});
		mntmSalir.setIcon(new ImageIcon(Principal.class.getResource("/GUI/iconos/salir2.png")));
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,InputEvent.ALT_MASK));
		mnFicheros.add(mntmSalir);

		JMenu mnTienda = new JMenu("Tienda");
		mnTienda.setForeground(Color.BLUE);
		mnTienda.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 18));
		mnTienda.setIcon(new ImageIcon(Principal.class.getResource("/GUI/iconos/tienda.png")));
		mnTienda.setMnemonic('T');
		menuBar.add(mnTienda);

		JSeparator separator_2 = new JSeparator();
		mnTienda.add(separator_2);

		JMenuItem mntmContarStock = new JMenuItem("Contar Stock");
		mntmContarStock.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 14));
		mntmContarStock.setForeground(Color.BLUE);
		mntmContarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Fichero.tienda.tamaño() == 0)
					mensajeError("La tienda esta Vacia");
				else {
					mensajeInfo("Hay "
							+ Fichero.tienda.tamaño()
							+ " productos en stock en la tienda:\n"
							+ Fichero.tienda.getProductoDisco().size()
							+ " son Discos\n"
							+ Fichero.tienda.getProductoCamiseta().size()
							+ " son Camisetas\n"
							+ Fichero.tienda.getProductoAccesorio().size()
							+ " son Accesorios\n");
				}
			}
		});

		JMenu mnAadir = new JMenu("A\u00F1adir...");
		mnAadir.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 14));
		mnAadir.setForeground(Color.BLUE);
		mnAadir.setIcon(new ImageIcon(Principal.class.getResource("/GUI/iconos/annadir.png")));
		mnTienda.add(mnAadir);

		JMenuItem mntmDiscos_1 = new JMenuItem("Discos");
		mntmDiscos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AnnadirDisco annadir = new AnnadirDisco();
				annadir.setVisible(true);
			}
		});
		mntmDiscos_1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		mntmDiscos_1.setForeground(Color.BLUE);
		mntmDiscos_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mntmDiscos_1.setIcon(new ImageIcon(Principal.class.getResource("/GUI/iconos/disco.png")));
		mnAadir.add(mntmDiscos_1);

		JMenuItem mntmAadir_1 = new JMenuItem("Camisetas");
		mntmAadir_1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		mntmAadir_1.setForeground(Color.BLUE);
		mnAadir.add(mntmAadir_1);
		mntmAadir_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		mntmAadir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnnadirCamiseta annadir = new AnnadirCamiseta();
				annadir.setVisible(true);
			}
		});
		mntmAadir_1.setIcon(new ImageIcon(Principal.class.getResource("/GUI/iconos/tshirt18.png")));

		JMenuItem mntmAadir_2 = new JMenuItem("Accesorios");
		mntmAadir_2.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		mntmAadir_2.setForeground(Color.BLUE);
		mnAadir.add(mntmAadir_2);
		mntmAadir_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
		mntmAadir_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnnadirAccesorio annadir = new AnnadirAccesorio();
				annadir.setVisible(true);
			}
		});
		mntmAadir_2.setIcon(new ImageIcon(Principal.class.getResource("/GUI/iconos/accesorios.png")));
		mntmContarStock.setIcon(new ImageIcon(Principal.class.getResource("/GUI/iconos/contar.png")));
		mntmContarStock.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		mnTienda.add(mntmContarStock);

		JMenu mnMostrar = new JMenu("Mostrar Stock...");
		mnMostrar.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 14));
		mnMostrar.setForeground(Color.BLUE);
		mnMostrar.setIcon(new ImageIcon(Principal.class.getResource("/GUI/iconos/mostrar.png")));
		mnTienda.add(mnMostrar);

		JMenuItem mntmDiscos = new JMenuItem("Discos");
		mntmDiscos.setForeground(Color.BLUE);
		mntmDiscos.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		mntmDiscos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0));
		mntmDiscos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Fichero.tienda.tamaño() == 0
						|| Fichero.tienda.getProductoDisco().size() == 0)
					mensajeError("No hay productos para esta búsqueda");
				else {
					MostrarDiscos mostrar = new MostrarDiscos();
					mostrar.setVisible(true);
				}
			}
		});
		mntmDiscos.setIcon(new ImageIcon(Principal.class.getResource("/GUI/iconos/disco.png")));
		mnMostrar.add(mntmDiscos);

		JMenuItem mntmCamisetas = new JMenuItem("Camisetas");
		mntmCamisetas.setForeground(Color.BLUE);
		mntmCamisetas.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		mntmCamisetas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0));
		mntmCamisetas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Fichero.tienda.tamaño() == 0
						|| Fichero.tienda.getProductoCamiseta().size() == 0)
					mensajeError("No hay productos para esta búsqueda");
				else {
					MostrarCamisetas mostrar = new MostrarCamisetas();
					mostrar.setVisible(true);
				}
			}
		});
		mntmCamisetas.setIcon(new ImageIcon(Principal.class.getResource("/GUI/iconos/tshirt18.png")));
		mnMostrar.add(mntmCamisetas);

		JMenuItem mntmAccesorios = new JMenuItem("Accesorios");
		mntmAccesorios.setForeground(Color.BLUE);
		mntmAccesorios.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		mntmAccesorios
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0));
		mntmAccesorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Fichero.tienda.tamaño() == 0||Fichero.tienda.getProductoAccesorio().size() == 0)
					mensajeError("No hay productos para esta búsqueda");
				else {
					MostrarAccesorios mostrar = new MostrarAccesorios();
					mostrar.setVisible(true);
				}
			}
		});
		mntmAccesorios.setIcon(new ImageIcon(Principal.class.getResource("/GUI/iconos/accesorios.png")));
		mnMostrar.add(mntmAccesorios);

		JMenu mnDiscos = new JMenu("Buscar");
		mnDiscos.setForeground(new Color(107, 142, 35));
		mnDiscos.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 18));
		mnDiscos.setIcon(new ImageIcon(Principal.class.getResource("/GUI/iconos/buscar2.png")));
		mnDiscos.setMnemonic('B');
		menuBar.add(mnDiscos);

		JSeparator separator_1 = new JSeparator();
		mnDiscos.add(separator_1);

		JMenu mnBuscar = new JMenu("Discos por...");
		mnBuscar.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 14));
		mnBuscar.setForeground(new Color(107, 142, 35));
		mnBuscar.setIcon(new ImageIcon(Principal.class.getResource("/GUI/iconos/disco.png")));
		mnDiscos.add(mnBuscar);

		JMenuItem mntmTitulo = new JMenuItem("Precio");
		mntmTitulo.setForeground(new Color(107, 142, 35));
		mntmTitulo.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		mntmTitulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Fichero.tienda.tamaño() == 0)
					mensajeError("La tienda esta vacia");
				else {
					BuscarDiscoPrecio buscar = new BuscarDiscoPrecio();
					buscar.setVisible(true);
				}
			}
		});

		JMenuItem mntmBanda = new JMenuItem("Banda");
		mntmBanda.setForeground(new Color(107, 142, 35));
		mntmBanda.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		mnBuscar.add(mntmBanda);
		mntmBanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Fichero.tienda.tamaño() == 0)
					mensajeError("La tienda esta vacia");
				else {
					BuscarDiscoBanda buscar = new BuscarDiscoBanda();
					buscar.setVisible(true);
				}
			}
		});

		JMenuItem mntmEstilo = new JMenuItem("Estilo");
		mntmEstilo.setForeground(new Color(107, 142, 35));
		mntmEstilo.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		mnBuscar.add(mntmEstilo);
		mntmEstilo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Fichero.tienda.tamaño() == 0)
					mensajeError("La tienda esta vacia");
				else {
					BuscarDiscoEstilo buscar = new BuscarDiscoEstilo();
					buscar.setVisible(true);
				}
			}
		});

		JMenuItem mntmNewMenuItem = new JMenuItem("Localizaci\u00F3n");
		mntmNewMenuItem.setForeground(new Color(107, 142, 35));
		mntmNewMenuItem.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		mnBuscar.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Fichero.tienda.tamaño() == 0)
					mensajeError("La tienda esta vacia");
				else {
					BuscarDiscoLocalizacion buscar = new BuscarDiscoLocalizacion();
					buscar.setVisible(true);
				}
			}
		});
		mnBuscar.add(mntmTitulo);

		JMenu mnBuscar_1 = new JMenu("Camisetas por...");
		mnBuscar_1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 14));
		mnBuscar_1.setForeground(new Color(107, 142, 35));
		mnDiscos.add(mnBuscar_1);
		mnBuscar_1.setIcon(new ImageIcon(Principal.class.getResource("/GUI/iconos/tshirt18.png")));

		JMenuItem mntmLocalizacin = new JMenuItem("Localizaci\u00F3n");
		mntmLocalizacin.setForeground(new Color(107, 142, 35));
		mntmLocalizacin
				.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		mntmLocalizacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Fichero.tienda.tamaño() == 0)
					mensajeError("La tienda esta vacia");
				else {
					BuscarCamisetaLocalizacion buscar = new BuscarCamisetaLocalizacion();
					buscar.setVisible(true);
				}
			}
		});

		JMenuItem mntmBanda_1 = new JMenuItem("Banda");
		mntmBanda_1.setForeground(new Color(107, 142, 35));
		mntmBanda_1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		mntmBanda_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Fichero.tienda.tamaño() == 0)
					mensajeError("La tienda esta vacia");
				else {
					BuscarCamisetaBanda buscar = new BuscarCamisetaBanda();
					buscar.setVisible(true);
				}
			}
		});
		mnBuscar_1.add(mntmBanda_1);
		mnBuscar_1.add(mntmLocalizacin);

		JMenuItem mntmSexoYTalla = new JMenuItem("Sexo y Talla");
		mntmSexoYTalla.setForeground(new Color(107, 142, 35));
		mntmSexoYTalla.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		mntmSexoYTalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Fichero.tienda.tamaño() == 0)
					mensajeError("La tienda esta vacia");
				else {
					BuscarCamisetaSexoTalla buscar = new BuscarCamisetaSexoTalla();
					buscar.setVisible(true);
				}
			}
		});
		mnBuscar_1.add(mntmSexoYTalla);

		JMenuItem mntmPrecio = new JMenuItem("Precio");
		mntmPrecio.setForeground(new Color(107, 142, 35));
		mntmPrecio.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		mntmPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Fichero.tienda.tamaño() == 0)
					mensajeError("La tienda esta vacia");
				else {
					BuscarCamisetaPrecio buscar = new BuscarCamisetaPrecio();
					buscar.setVisible(true);
				}
			}
		});
		mnBuscar_1.add(mntmPrecio);

		JMenu mnNewMenu = new JMenu("Accesorios por...");
		mnNewMenu.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 14));
		mnNewMenu.setForeground(new Color(107, 142, 35));
		mnDiscos.add(mnNewMenu);
		mnNewMenu.setIcon(new ImageIcon(Principal.class.getResource("/GUI/iconos/accesorios.png")));

		JMenuItem mntmLocalizacin_1 = new JMenuItem("Localizaci\u00F3n");
		mntmLocalizacin_1.setForeground(new Color(107, 142, 35));
		mntmLocalizacin_1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN,12));
		mntmLocalizacin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Fichero.tienda.tamaño() == 0)
					mensajeError("La tienda esta vacia");
				else {
					BuscarAccesorioLocalizacion buscar = new BuscarAccesorioLocalizacion();
					buscar.setVisible(true);
				}
			}
		});

		JMenuItem mntmBanda_2 = new JMenuItem("Banda");
		mntmBanda_2.setForeground(new Color(107, 142, 35));
		mntmBanda_2.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		mntmBanda_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Fichero.tienda.tamaño() == 0)
					mensajeError("La tienda esta vacia");
				else {
					BuscarAccesorioBanda buscar = new BuscarAccesorioBanda();
					buscar.setVisible(true);
				}
			}
		});
		mnNewMenu.add(mntmBanda_2);
		mnNewMenu.add(mntmLocalizacin_1);

		JMenuItem mntmTipo = new JMenuItem("Tipo");
		mntmTipo.setForeground(new Color(107, 142, 35));
		mntmTipo.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		mntmTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Fichero.tienda.tamaño() == 0)
					mensajeError("La tienda esta vacia");
				else {
					BuscarAccesorioTipo buscar = new BuscarAccesorioTipo();
					buscar.setVisible(true);
				}
			}
		});
		mnNewMenu.add(mntmTipo);

		JMenuItem mntmPrecio_1 = new JMenuItem("Precio");
		mntmPrecio_1.setForeground(new Color(107, 142, 35));
		mntmPrecio_1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		mntmPrecio_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Fichero.tienda.tamaño() == 0)
					mensajeError("La tienda esta vacia");
				else {
					BuscarAccesorioPrecio buscar = new BuscarAccesorioPrecio();
					buscar.setVisible(true);
				}
			}
		});
		mnNewMenu.add(mntmPrecio_1);

		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setForeground(Color.BLACK);
		mnAyuda.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 18));
		mnAyuda.setIcon(new ImageIcon(Principal.class.getResource("/GUI/iconos/ayuda.png")));
		mnAyuda.setMnemonic('A');
		menuBar.add(mnAyuda);

		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 14));
		mntmAyuda.setForeground(Color.BLACK);
		mntmAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ayuda.setVisible(true);
			}
		});
		mntmAyuda.setIcon(new ImageIcon(Principal.class.getResource("/GUI/iconos/ayuda2.png")));
		mnAyuda.add(mntmAyuda);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 14));
		mntmAcercaDe.setForeground(Color.BLACK);
		mntmAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0));
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AcercaDe acercade = new AcercaDe();
				acercade.setVisible(true);
			}
		});

		JMenuItem mntmAyudaEnHtml = new JMenuItem("Ayuda en HTML");
		mntmAyudaEnHtml.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 14));
		mntmAyudaEnHtml.setForeground(Color.BLACK);
		mntmAyudaEnHtml.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F11,
				0));
		mntmAyudaEnHtml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirArchivo("http://sysmana.hostinazo.com/index.htm");
			}
		});
		mntmAyudaEnHtml.setIcon(new ImageIcon(Principal.class.getResource("/GUI/iconos/html.png")));
		mnAyuda.add(mntmAyudaEnHtml);
		mntmAcercaDe.setIcon(new ImageIcon(Principal.class.getResource("/GUI/iconos/acercade.png")));
		mnAyuda.add(mntmAcercaDe);
		principal.getContentPane().setLayout(null);
		JOptionPane.showMessageDialog(contentPanel, new JLabel(
				"<HTML><BODY BGCOLOR=#FFCCCC><center>" + mensajeDia()
						+ "</center></BODY></HTML>"), "Mensaje del Dia",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Crea una imagen
	 * 
	 * @param url URL de la imagen de origen
	 * @param descripcion Descripci&oacute;n de la imagen
	 * 
	 * @return La imagen
	 */
	private ImageIcon crearImagen(String url, String descripcion) {
		java.net.URL imagenUrl = getClass().getResource(url);
		if (imagenUrl != null) {
			return new ImageIcon(imagenUrl, descripcion);
		} else {
			return null;
		}
	}

	/**
	 * Abre cualquier tipo de archivo con el programa predeterminado que tenga el sistema
	 * 
	 * @param url Direcci&oacute;n del archivo a abrir
	 */
	public void abrirArchivo(String url) {

		try {
			Desktop.getDesktop().browse(new URI(url));
		} catch (URISyntaxException ex) {
			System.out.println(ex);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * Comprueba si hay cambios y ofrece opciones para que hacer con ellos
	 * 
	 * @return True/False para interrumpir lo que se estaba haciendo o continuar
	 */
	private boolean cambiosSinGuardar() {
		if (Fichero.tienda.getEsModificado()) {
			int confirmacionSalida = JOptionPane.showOptionDialog(null,
					"¿Desea Guardar el trabajo actual?", "Cambios detectados",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (confirmacionSalida == 0)
				Fichero.guardar();
			if (confirmacionSalida == 2)
				return true;
		}
		return false;
	}

	/**
	 * Genera el mensaje del dia al iniciar el programa dependiendo del dia que es y el descuento a aplicar
	 * 
	 * @return El mensaje a mostrar
	 */
	public String mensajeDia() {
		switch (Principal.dia) {
		case 2:
			return "Hoy es Lunes<br/>Descuento del dia:<br/>30% en Accesorios";
		case 4:
			return "Hoy es Miercoles<br/>Descuento del dia:<br/>20% en Camisetas";
		case 6:
			return "Hoy es Viernes<br/>Descuento del dia:<br/>10% en Discos";
		default:
			return "Hoy no hay descuento del dia";
		}
	}
	
	/**
	 * Obtiene el valor del dia
	 * 
	 * @return El valor del dia
	 */
	static int getDia() {
		return dia;
	}
	
	/**
	 * Mensaje de error
	 * 
	 * @param mensaje Mensaje a mostrar 
	 */
	private void mensajeError(String mensaje) {
		JOptionPane.showMessageDialog(jFrame,mensaje, "Error",JOptionPane.ERROR_MESSAGE);	
	}
	
	/**
	 * Mensaje de informaci&oacute;n
	 * 
	 * @param mensaje Mensaje a mostrar
	 */
	private void mensajeInfo(String mensaje){
		JOptionPane.showMessageDialog(jFrame, mensaje, "Info",JOptionPane.INFORMATION_MESSAGE);
	}
}