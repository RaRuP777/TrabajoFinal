package Tienda.Excepciones;

/**
 * Clase para recoger el error cuando un tipo no es seleccionado
 * 
 * @author Pedro
 *
 */
public class TipoNoValidoException extends Exception {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = 1420037445136596012L;

	/**
	 * Muestra un mensaje cuando sucede esta excepci&oacute;n
	 * 
	 * @param mensaje Mensaje de error
	 */
	public TipoNoValidoException(String mensaje) {
		super(mensaje);
	}
}