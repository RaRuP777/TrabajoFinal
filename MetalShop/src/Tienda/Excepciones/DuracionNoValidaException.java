package Tienda.Excepciones;

/**
 * Clase para recoger el error cuando una duraci&oacute;n no es v&aacute;lida
 * 
 * @author Pedro J. Ramos
 *
 */
public class DuracionNoValidaException extends Exception {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = 5038472734510414154L;

	/**
	 * Muestra un mensaje cuando sucede esta excepci&oacute;n
	 * 
	 * @param mensaje Mensaje de error
	 */
	public DuracionNoValidaException(String mensaje) {
		super(mensaje);
	}
}
