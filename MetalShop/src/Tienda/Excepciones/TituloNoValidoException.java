package Tienda.Excepciones;

/**
 * Clase para recoger el error cuando el t&iacute;tulo no corresponde con el patr&oacute;n fijado
 * 
 * @author Pedro J. Ramos
 *
 */
public class TituloNoValidoException extends Exception {

	/**
	 * ID serial para serializable
	 */
	private static final long serialVersionUID = -3061672049607916773L;

	/**
	 * Muestra un mensaje cuando sucede esta excepci&oacute;n
	 * 
	 * @param mensaje Mensaje de error
	 */
	public TituloNoValidoException(String mensaje) {
		super(mensaje);
	}
}
