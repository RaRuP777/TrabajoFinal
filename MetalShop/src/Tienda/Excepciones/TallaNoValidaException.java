package Tienda.Excepciones;

/**
 * Clase para recoger el error cuando una talla no es seleccionada
 * 
 * @author Pedro
 *
 */
public class TallaNoValidaException extends Exception {

	/**
	 * ID serial para serializable
	 */
	private static final long serialVersionUID = -3576052047254184034L;

	/**
	 * Muestra un mensaje cuando sucede esta excepci&oacute;n
	 * 
	 * @param mensaje Mensaje de error
	 */
	public TallaNoValidaException(String mensaje) {
		super(mensaje);
	}
}
