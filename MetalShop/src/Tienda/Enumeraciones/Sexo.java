package Tienda.Enumeraciones;

/**
 * Sexo disponible para las Camisetas
 * 
 * @author Pedro J. Ramos
 *
 */
public enum Sexo {

	ELIGE,
	HOMBRE,
	MUJER;
	
	/**
	 * Array que contiene todos los sexos
	 */
	private static final Sexo[] VALUES = Sexo.values();

	/**
	 * Devuelve un array que contiene los sexos
	 * 
	 * @return Array de los estilos
	 */
	public static Sexo[] getValues() {
		return VALUES;
	}
}
