package Tienda.Excepciones;

/**
 * Clase para recoger el error cuando un estilo no es elegido
 * 
 * @author Pedro J. Ramos
 *
 */
public class EstiloNoElegidoException extends Exception {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = 4084140278014117202L;

	/**
	 * Muestra un mensaje cuando sucede esta excepci&oacute;n
	 * 
	 * @param mensaje Mensaje de error
	 */
	public EstiloNoElegidoException(String mensaje) {
		super(mensaje);
	}
}
