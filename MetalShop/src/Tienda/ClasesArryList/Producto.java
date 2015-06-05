package Tienda.ClasesArryList;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

import Tienda.Enumeraciones.Estilo;
import Tienda.Enumeraciones.Localizacion;
import Tienda.Excepciones.EstiloNoElegidoException;
import Tienda.Excepciones.LocalizacionNoElegidaException;
import Tienda.Excepciones.NombreBandaNoValidoException;
import Tienda.Excepciones.PrecioNoValidoException;
import Tienda.Interfaces.Igualable;

public class Producto implements Serializable, Igualable {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = 6207873462969525675L;

	/**
	 * Identificador inequ&iacute;voco del objeto
	 */
	protected String id;

	/**
	 * Nombre de la banda al que pertenece el objeto
	 */
	protected String banda;

	/**
	 * Lugar donde se expone el objeto
	 */
	protected Localizacion localizacion;

	/**
	 * Precio al que se vende el objeto
	 */
	protected float precio;
	
	/**
	 * Fecha en la que se a&ntilde;ade el objeto al stock
	 */
	protected String fecha;
	
	/**
	 * Formato de salida para la fecha de creaci&oacute;n del objeto
	 */
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	

	/**
	 * Estilo al que pertenece el objeto
	 */
	protected Estilo estilo;

	/**
	 * Patr&oacute;n para comprobar que los nombres de banda y t&iacute,tulo son
	 * correctos
	 */
	protected static final Pattern patronNombres = Pattern.compile("^[A-ZÑÁÉÍÓÚ].{2,20}$");

	/**
	 * Constructor para crear un objeto producto
	 * 
	 * @param banda Nombre de la banda al que pertenece el objeto
	 * @param localizacion Lugar donde se expone el objeto
	 * @param precio Precio al que se vende el objeto
	 * @param estilo Estilo al que pertenece el objeto
	 * 
	 * @throws EstiloNoElegidoException Controla que el estilo ha sido elegido
	 * @throws PrecioNoValidoException Controla que el precio no es menor de 0
	 * @throws NombreBandaNoValidoException Controla que el nombre de la banda es correcto
	 * @throws LocalizacionNoElegidaException Controla que el lugar donde se expone el objeto ha sido elegido
	 * @throws ParseException 
	 */
	Producto(String banda, Localizacion localizacion, float precio,
			Estilo estilo) throws EstiloNoElegidoException,
			PrecioNoValidoException, NombreBandaNoValidoException,
			LocalizacionNoElegidaException {
		setBanda(banda);
		setLocalizacion(localizacion);
		setPrecio(precio);
		setFecha();
		setEstilo(estilo);
	}

	/**
	 * Constructor para comparable
	 */
	protected Producto() {
	}

	/**
	 * Constructor para buscar un objeto por su ID
	 * 
	 * @param id El identificador del objeto
	 */
	Producto(String id) {
		this.id = id;
	}

	/**
	 * Comprueba si un valor es correcto seg&uacute;n el patr&oacute;n
	 * 
	 * @param string El valor a comprobar
	 * @param pattern El patr&oacute; para su comprobaci&oacute;n
	 * 
	 * @return True/False si ha encontrado o no coincidencia
	 */
	protected static boolean esValido(String string, Pattern pattern) {
		return pattern.matcher(string).matches();
	}

	/**
	 * Obtiene el valor de ID del objeto
	 * 
	 * @return El valor ID del objeto
	 */
	public String getId() {
		return id;
	}

	/**
	 * Obtiene el nombre de la banda al que pertence el objeto
	 * 
	 * @return El nombre de la banda
	 */
	public String getBanda() {
		return banda;
	}

	/**
	 * Modifica el valor del nombre de la banda al que pertenece el objeto
	 * 
	 * @param banda Nombre de la banda
	 * 
	 * * @throws NombreBandaNoValidoException Controla que el nombre de la banda es correcto
	 */
	private void setBanda(String banda) throws NombreBandaNoValidoException {
		if (esValido(banda, patronNombres))
			this.banda = banda;
		else
			throw new NombreBandaNoValidoException("El nombre de la banda no es correcto");
	}

	/**
	 * Obtiene el lugar donde se expone el objeto
	 * 
	 * @return El lugar donde se expone
	 */
	public Localizacion getLocalizacion() {
		return localizacion;
	}

	/**
	 * Modifica el lugar donde se expone el objeto
	 * 
	 * @param localizacion El lugar donde se expone
	 * 
	 * @throws LocalizacionNoElegidaException Controla que el lugar donde se expone el objeto ha sido elegido
	 */
	private void setLocalizacion(Localizacion localizacion)
			throws LocalizacionNoElegidaException {
		if (localizacion != Localizacion.ELIGE)
			this.localizacion = localizacion;
		else
			throw new LocalizacionNoElegidaException(
					"ELige una localización, por favor");
	}

	/**
	 * Obtiene el precio de venta del producto
	 * 
	 * @return El precio de venta
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * Modifica el precio de venta del producto
	 * 
	 * @param precio El precio de venta
	 * 
	 * @throws PrecioNoValidoException Controla que el precio no es menor de 0
	 */
	private void setPrecio(float precio) throws PrecioNoValidoException {
		if (precio > 0)
			this.precio = precio;
		else
			throw new PrecioNoValidoException("El precio no es válido");
	}

	/**
	 * Obtiene el la fecha de alta del producto
	 * 
	 * @return La fecha de alta
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Modifica la fecha de alta del producto
	 */
	private void setFecha() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		this.fecha = formato.format(cal.getTime());
	}

	/**
	 * Obtiene el estilo del producto
	 * 
	 * @return El estilo del producto
	 */
	public Estilo getEstilo() {
		return estilo;
	}

	/**
	 * Modifica el estilo del producto
	 * 
	 * @param estilo El estilo del producto
	 * 
	 * @throws EstiloNoElegidoException Controla que el estilo ha sido elegido
	 */
	private void setEstilo(Estilo estilo) throws EstiloNoElegidoException {
		if (estilo != Estilo.ELIGE)
			this.estilo = estilo;
		else
			throw new EstiloNoElegidoException("Elige un estilo por favor");
	}

	/**
	 * Comprueba si el tipo de un Producto
	 */
	@Override
	public boolean igualable(Producto producto) {
		return false;
	}
	
	/**
	 * Convierte en String los campos del Objeto para usarlo en la Factura
	 */
	@Override
	public String toString() {
		return "<br/>id: " + id + "<br/>Banda: " + banda + "<br/>Localizacion: "
				+ localizacion + "<br/>Precio: " + precio + "<br/>Fecha: " + fecha
				+ "<br/>Estilo: " + estilo;
	}
}