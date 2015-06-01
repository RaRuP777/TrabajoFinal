package Tienda.Excepciones;

/**
 * Clase para recoger el error cuando un producto no existe en la tienda
 * 
 * @author Pedro J. Ramos
 *
 */
public class ProductoNoExisteException extends Exception {

	/**
	 * ID Serial para serializable
	 */
	private static final long serialVersionUID = -2185818650342401233L;

	/**
	 * Muestra un mensaje cuando sucede esta excepci&oacute;n
	 * 
	 * @param mensaje Mensaje de error
	 */
	public ProductoNoExisteException(String mensaje) {
		super(mensaje);
	}
}
