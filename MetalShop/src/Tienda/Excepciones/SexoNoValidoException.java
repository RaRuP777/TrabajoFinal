package Tienda.Excepciones;

/**
 * Clase para recoger el error cuando un sexo no es elegido
 * 
 * @author Pedro J. Ramos
 *
 */
public class SexoNoValidoException extends Exception {
	
	/**
	 * ID serial para serializable
	 */
	private static final long serialVersionUID = 3075019307723494294L;

	/**
	 * Muestra un mensaje cuando sucede esta excepci&oacute;n
	 * 
	 * @param mensaje Mensaje de error
	 */
	public SexoNoValidoException(String mensaje) {
		super(mensaje);
	}
}
