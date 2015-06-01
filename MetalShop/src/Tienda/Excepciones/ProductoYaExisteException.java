package Tienda.Excepciones;

/**
 * Clase para recoger el error cuando un producto ya existe en la tienda
 * 
 * @author Pedro J. Ramos
 *
 */
public class ProductoYaExisteException extends Exception {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = 3161813170658154701L;

	/**
	 * Muestra un mensaje cuando sucede esta excepci&oacute;n
	 * 
	 * @param mensaje Mensaje de error
	 */
	public ProductoYaExisteException(String mensaje) {
		super(mensaje);
	}
}

