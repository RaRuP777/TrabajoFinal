package Tienda.ClasesArryList;

import java.io.Serializable;
import java.util.ArrayList;
import Tienda.Enumeraciones.Estilo;
import Tienda.Enumeraciones.Localizacion;
import Tienda.Enumeraciones.Sexo;
import Tienda.Enumeraciones.Talla;
import Tienda.Enumeraciones.Tipo;
import Tienda.Excepciones.CantidadCancionesNoValidaException;
import Tienda.Excepciones.DuracionNoValidaException;
import Tienda.Excepciones.EstiloNoElegidoException;
import Tienda.Excepciones.LocalizacionNoElegidaException;
import Tienda.Excepciones.NombreBandaNoValidoException;
import Tienda.Excepciones.PrecioNoValidoException;
import Tienda.Excepciones.ProductoNoExisteException;
import Tienda.Excepciones.ProductoYaExisteException;
import Tienda.Excepciones.SexoNoValidoException;
import Tienda.Excepciones.TallaNoValidaException;
import Tienda.Excepciones.TituloNoValidoException;

/**
 * Manejo del stock de productos de la tienda
 * 
 * @author Pedro J. Ramos
 *
 */
public class Stock implements Serializable {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = 2654010054188444791L;

	/**
	 * Cuando hay cambios en el stock sin guardar
	 */
	private boolean esModificado = false;

	/**
	 * Tienda que almacena los productos
	 */
	private ArrayList<Producto> tienda = new ArrayList<Producto>();

	/**
	 * Añade un disco a la Tienda
	 * 
	 * @param banda Banda a la que pertenece
	 * @param titulo T&iacute;tulo del disco a la que pertenece
	 * @param localizacion Lugar donde se expone
	 * @param precio Precio al que se vende
	 * @param estilo Estilo al que pertence
	 * @param duracion Duraci&oacute;n total del disco en minutos
	 * @param canciones Cantidad de canciones que contiene el disco
	 * 
	 * @return True/False si es añadido o no
	 * 
	 * @throws EstiloNoElegidoException Cuando el estilo ha no sido seleccionado
	 * @throws PrecioNoValidoException Cuando el precio no es un valor de 0 o menor
	 * @throws NombreBandaNoValidoException Cuando el nombre de la banda no es correcto
	 * @throws LocalizacionNoElegidaException Cuando el lugar donde se expone ha no sido elegido
	 * @throws TituloNoValidoException Cuando el t&iacute;tulo es no correcto
	 * @throws DuracionNoValidaException Cuando la durari&oacute;n es menor que 0 o mayor que 72 minutos 
	 * @throws CantidadCancionesNoValidaException Cuando la cantidad de canciones es menor de 1
	 * @throws ProductoYaExisteException Cuando se va a añadir un prodcuto que ya existe
	 */
	public boolean annadir(String banda, Localizacion localizacion,
			float precio, Estilo estilo, String titulo, int duracion,
			int canciones) throws EstiloNoElegidoException,
			PrecioNoValidoException, DuracionNoValidaException,
			CantidadCancionesNoValidaException, NombreBandaNoValidoException,
			LocalizacionNoElegidaException, TituloNoValidoException,
			ProductoYaExisteException {
		Producto disco = new Disco(banda, localizacion, precio, estilo, titulo,
				duracion, canciones);
		for (Producto producto : getProductoDisco()) {
			if (disco.comparable(producto))
				throw new ProductoYaExisteException("El disco ya existe en la tienda");
		}
		setEsModificado(true);
		return tienda.add(disco);
	}

	/**
	 * Añade una camiseta a la Tienda
	 * 
	 * @param banda Banda a la que pertenece
	 * @param titulo T&iacute;tulo del disco a la que pertenece
	 * @param localizacion Lugar donde se expone
	 * @param precio Precio al que se vende
	 * @param estilo Estilo al que pertence
	 * @param talla Talla de la camiseta
	 * @param sexo Sexo de la camiseta
	 * 
	 * @return True/False si es añadido o no
	 * 
	 * @throws EstiloNoElegidoException Cuando el estilo no ha sido seleccionado
	 * @throws PrecioNoValidoException Cuando el precio es un valor de 0 o menor
	 * @throws NombreBandaNoValidoException Cuando el nombre de la banda no es correcto
	 * @throws LocalizacionNoElegidaException Cuando el lugar donde se expone no ha sido elegido
	 * @throws TituloNoValidoException Contorla que el t&iacute;tulo no es correcto
	 * @throws TallaNoValidaException Cuando una talla no ha sido elegida
	 * @throws SexoNoValidoException Cuando el sexo no ha sido elegido
	 * @throws ProductoYaExisteException Cuando se va a añadir un prodcuto que ya existe
	 */
	public boolean annadir(String banda, String titulo,
			Localizacion localizacion, float precio, Estilo estilo,
			Talla talla, Sexo sexo) throws EstiloNoElegidoException,
			PrecioNoValidoException, TituloNoValidoException,
			NombreBandaNoValidoException, TallaNoValidaException,
			SexoNoValidoException, LocalizacionNoElegidaException,
			ProductoYaExisteException {
		Producto camiseta = new Camiseta(banda, titulo, localizacion, precio,
				estilo, talla, sexo);
		for (Producto producto : getProductoCamiseta()) {
			if (camiseta.comparable(producto))
				throw new ProductoYaExisteException("La camiseta ya existe en la tienda");
		}
		setEsModificado(true);
		return tienda.add(camiseta);
	}

	/**
	 * Añade un accesorio a la Tienda
	 * 
	 * @param banda Nombre de la banda
	 * @param localizacion Lugar de la tienda donde se expone
	 * @param precio Precio al que se vende
	 * @param estilo Estilo al que pertenece
	 * @param tipo Tipo de accesorio
	 * 
	 * @return True/False si es añadido o no
	 * 
	 * @throws EstiloNoElegidoException Cuando el estilo no ha sido seleccionado
	 * @throws PrecioNoValidoException Cuando el precio es un valor de 0 o menor
	 * @throws NombreBandaNoValidoException Cuando el nombre de la banda no es correcto
	 * @throws LocalizacionNoElegidaException Cuando el lugar donde se expone no ha sido elegido
	 * @throws ProductoYaExisteException Cuando se va a añadir un prodcuto que ya existe
	 */
	public boolean annadir(String banda, Localizacion localizacion,
			float precio, Estilo estilo, Tipo tipo)
			throws EstiloNoElegidoException, PrecioNoValidoException,
			NombreBandaNoValidoException, LocalizacionNoElegidaException,
			ProductoYaExisteException {
		Producto accesorio = new Accesorio(banda, localizacion, precio, estilo,
				tipo);
		for (Producto producto : getProductoAccesorio()) {
			if (accesorio.comparable(producto))
				throw new ProductoYaExisteException("El accesorio ya existe en la tienda");
		}
		setEsModificado(true);
		return tienda.add(accesorio);
	}

	/**
	 * Vende y elimina de la Tienda un Producto
	 * 
	 * @param id ID del producto
	 * 
	 * @return True/False si ha sido eliminado o no
	 */
	public Producto vender(String id) {
		for (Producto producto : tienda) {
			if (producto.getId().equals(id)) {
				setEsModificado(true);
				tienda.remove(producto);
				return producto;
			}
		}
		return null;
	}

	/**
	 * Obtiene la cantidad de productos almacenados
	 * 
	 * @return La cantidad de productos
	 */
	public int tamaño() {
		return tienda.size();
	}

	/**
	 * Busca y almacena todos los productos de un Estilo
	 * 
	 * @param estilo El estilo a buscar
	 * 
	 * @return Tienda con todos los productos encontrados
	 */
	public ArrayList<Producto> getProductoEstilo(Estilo estilo) {
		ArrayList<Producto> productoEstilo = new ArrayList<Producto>();
		for (Producto producto : tienda) {
			if (producto.getEstilo() == estilo)
				productoEstilo.add(producto);
		}
		return productoEstilo;
	}

	/**
	 * Busca y almacena todos los productos en un lugar expuestos
	 * 
	 * @param localizacion Localizacion a buscar
	 * 
	 * @return Tienda con todos los productos encontrados
	 */
	public ArrayList<Producto> getProductoLocalizacion(Localizacion localizacion) {
		ArrayList<Producto> productoEstilo = new ArrayList<Producto>();
		for (Producto producto : tienda) {
			if (producto.getLocalizacion() == localizacion)
				productoEstilo.add(producto);
		}
		return productoEstilo;
	}

	/**
	 * Busca y almacena todos los productos de una Banda
	 * 
	 * @param banda Banda a buscar
	 * 
	 * @return Tienda con todos los productos encontrados
	 */
	public ArrayList<Producto> getProductoBanda(String banda) {
		ArrayList<Producto> productoBanda = new ArrayList<Producto>();
		for (Producto producto : tienda) {
			if (producto.getBanda().equalsIgnoreCase(banda))
				productoBanda.add(producto);
		}
		return productoBanda;
	}

	/**
	 * Busca y almacena todos las camisetas de un Sexo y talla
	 * 
	 * @param sexo Sexo a buscar
	 * @param talla Talla a buscar
	 * 
	 * @return Tienda con todos los productos encontrados
	 */
	public ArrayList<Producto> getCamisetaSexoTalla(Sexo sexo, Talla talla) {
		ArrayList<Producto> camisetaSexoTalla = new ArrayList<Producto>();
		for (Producto producto : tienda) {
			if (((Camiseta) producto).getSexo() == sexo
					& ((Camiseta) producto).getTalla() == talla)
				camisetaSexoTalla.add((Camiseta) producto);
		}
		return camisetaSexoTalla;
	}

	/**
	 * Busca y almacena todos los accesorios de un tipo
	 * 
	 * @param tipo Tipo a buscar
	 * 
	 * @return Tienda con todos los productos encontrados
	 */
	public ArrayList<Producto> getAccesorioTipo(Tipo tipo) {
		ArrayList<Producto> accesorioTipo = new ArrayList<Producto>();
		for (Producto producto : tienda) {
			if (((Accesorio) producto).getTipo() == tipo)
				accesorioTipo.add((Accesorio) producto);
		}
		return accesorioTipo;
	}

	/**
	 * Busca y almacena todos los discos del stock
	 * 
	 * @return Tienda con todos los productos encontrados
	 */
	public ArrayList<Producto> getProductoDisco() {
		Disco disco = new Disco();
		ArrayList<Producto> mostrar = new ArrayList<Producto>();
		for (Producto producto : tienda) {
			if ((producto.getClass() == disco.getClass()))
				mostrar.add((Disco) producto);
		}
		return mostrar;
	}

	/**
	 * Busca y almacena todos las camisetas del stock
	 * 
	 * @return Tienda con todos los productos encontrados
	 */
	public ArrayList<Producto> getProductoCamiseta() {
		Camiseta camiseta = new Camiseta();
		ArrayList<Producto> mostrar = new ArrayList<Producto>();
		for (Producto producto : tienda) {
			if ((producto.getClass() == camiseta.getClass()))
				mostrar.add((Camiseta) producto);
		}
		return mostrar;
	}

	/**
	 * Busca y almacena todos los accesorios del stock
	 * 
	 * @return Tienda con todos los productos encontrados
	 */
	public ArrayList<Producto> getProductoAccesorio() {
		Accesorio accesorio = new Accesorio();
		ArrayList<Producto> mostrar = new ArrayList<Producto>();
		for (Producto producto : tienda) {
			if ((producto.getClass() == accesorio.getClass()))
				mostrar.add((Accesorio) producto);
		}
		return mostrar;
	}

	/**
	 * Busca y almacena todos los productos del stock bajo un precio dado
	 * 
	 * @param precio Precio sobre el que buscamos
	 * 
	 * @return Tienda con todos los productos encontrados
	 */
	public ArrayList<Producto> getProductoPrecio(String precio) {
		ArrayList<Producto> productoPrecio = new ArrayList<Producto>();
		for (Producto producto : tienda) {
			if (producto.getPrecio() < Float.parseFloat(precio))
				productoPrecio.add(producto);
		}
		return productoPrecio;
	}

	/**
	 * Busca un producto en el Tienda
	 * 
	 * @param index Indice del producto a buscar
	 * 
	 * @return El producto encontrado
	 */
	public Producto get(int index) {
		if (tienda.isEmpty())
			return null;
		if (index < 0 | index > tienda.size() - 1)
			return null;
		return tienda.get(index);
	}

	/**
	 * Obtiene un prodcuto almacenado por su ID
	 * 
	 * @param id ID del producto
	 * 
	 * @return Producto encontrado
	 * 
	 * @throws ProductoNoExisteException Cuando el producto no existe
	 */
	public Producto get(String id) throws ProductoNoExisteException {
		Producto producto = new Producto(id);
		int index = tienda.indexOf(producto);
		if (index != -1) {
			return tienda.get(index);
		} else
			throw new ProductoNoExisteException(
					"Este producto no esta disponible en la tienda");
	}

	/**
	 * Obtiene la Tienda del stock
	 * 
	 * @param tienda La Tienda del stock
	 */
	public void setTienda(ArrayList<Producto> tienda) {
		this.tienda = tienda;
	}

	/**
	 * Obtiene si el Stock esta modificado o no
	 * 
	 * @return True/False si esta modificado
	 */
	public boolean getEsModificado() {
		return esModificado;
	}

	/**
	 * Modifica si el stock esta modificado o no
	 * 
	 * @param esModificado El estado del stock
	 */
	public void setEsModificado(boolean esModificado) {
		this.esModificado = esModificado;
	}
}