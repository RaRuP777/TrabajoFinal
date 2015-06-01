package Tienda.Enumeraciones;

/**
 * Localizaci&oacute;n de los Productos
 * 
 * @author Pedro J. Ramos
 *
 */
public enum Localizacion {

	ELIGE,
	ESCAPARATE, 
	ESTANTERIA1, 
	ESTANTERIA2,
	VITRINA;

	/**
	 * Array que contiene todos las locacalizaciones
	 */
	private static final Localizacion[] VALUES = Localizacion.values();

	/**
	 * Devuelve un array que contiene las localizaciones
	 * 
	 * @return Array de las localizaciones
	 */
	public static Localizacion[] getValues() {
		return VALUES;
	}
}