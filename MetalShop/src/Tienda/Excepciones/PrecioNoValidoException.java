package Tienda.Excepciones;

/**
 * Clase para recoger el error cuando se marca un precio no correcto
 * 
 * @author Pedro J. Ramos
 *
 */
public class PrecioNoValidoException extends Exception {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = 5719167806510576759L;

	/**
	 * Muestra un mensaje cuando sucede esta excepci&oacute;n
	 * 
	 * @param mensaje Mensaje de error
	 */
	public PrecioNoValidoException(String mensaje) {
		super(mensaje);
	}
}
