package Tienda.Excepciones;

/**
 * Clase para recoger el error cuando el nombre de la banda no corresponde con el patr&oacute;n
 * 
 * @author Pedro J. Ramos
 *
 */
public class NombreBandaNoValidoException extends Exception {

	/**
	 * Serial para Serializable
	 */
	private static final long serialVersionUID = 5780429575066735130L;

	/**
	 * Muestra un mensaje cuando sucede esta excepci&oacute;n
	 * 
	 * @param mensaje Mensaje de error
	 */
	public NombreBandaNoValidoException(String mensaje) {
		super(mensaje);
	}
}
