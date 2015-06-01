package Tienda.Enumeraciones;

/**
 * Tallas disponibles para las Camisetas
 * 
 * @author Pedro J. Ramos
 *
 */
public enum Talla {

	ELIGE,
	XS,
	S,
	M,
	XL,
	XXL,
	XXXL;
	
	/**
	 * Array que contiene todos las tallas
	 */
	private static final Talla[] VALUES = Talla.values();

	/**
	 * Devuelve un array que contiene las tallas 
	 * 
	 * @return Array de los estilos
	 */
	public static Talla[] getValues() {
		return VALUES;
	}
}
