package Tienda.Enumeraciones;

/**
 * Tipos de Accesorios disponibles
 * 
 * @author Pedro J. Ramos
 *
 */
public enum Tipo {

	ELIGE,
	ANILLO,
	BRAZALETE,
	CADENA,
	COLGANTE,
	PENDIENTE,
	PULSERA;
	
	/**
	 * Array que contiene todos los tipos de Accesorios
	 */
	private static final Tipo[] VALUES = Tipo.values();

	/**
	 * Devuelve un array que contiene los tipos de Accesorios 
	 * 
	 * @return Array de los tipos
	 */
	public static Tipo[] getValues() {
		return VALUES;
	}
}
