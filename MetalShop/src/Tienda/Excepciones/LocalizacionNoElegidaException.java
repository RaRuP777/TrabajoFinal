package Tienda.Excepciones;

/**
 * Clase para recoger el error cuando la localizaci&oacute,n no es elegida
 * 
 * @author Pedro J. Ramos
 *
 */
public class LocalizacionNoElegidaException extends Exception {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = 4084140278014117202L;

	/**
	 * Muestra un mensaje cuando sucede esta excepci&oacute;n
	 * 
	 * @param mensaje Mensaje de error
	 */
	public LocalizacionNoElegidaException(String mensaje) {
		super(mensaje);
	}
}
