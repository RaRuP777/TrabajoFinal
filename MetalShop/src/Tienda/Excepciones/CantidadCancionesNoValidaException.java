package Tienda.Excepciones;

/**
 * Clase para recoger el error cuando la cantidad de canciones de un disco no es correcta
 * 
 * @author Pedro J. Ramos
 *
 */
public class CantidadCancionesNoValidaException extends Exception {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = -2088889483097587467L;

	/**
	 * Muestra un mensaje cuando sucede esta excepci&oacute;n
	 * 
	 * @param mensaje Mensaje de error
	 */
	public CantidadCancionesNoValidaException(String mensaje) {
		super(mensaje);
	}
}
