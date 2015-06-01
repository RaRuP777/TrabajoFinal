package Tienda.Enumeraciones;

/**
 * Estilos disponibles para todos los productos
 * 
 * @author Pedro J. Ramos
 *
 */
public enum Estilo{

	ELIGE,
	ALTERNATIVE,
	DEATH,
	DOOM,
	FOLK,
	GOTHIC,
	GROOVE,
	HEAVY,
	INDUSTRIAL,
	METALCORE,
	POWER,
	ROCK,
	SYMPHONIC,
	TRASH;
		
	/**
	 * Array que contiene todos los estilos
	 */
	private static final Estilo[] VALUES = Estilo.values();

	/**
	 * Devuelve un array que contiene los estilos
	 * 
	 * @return Array de los estilos
	 */
	public static Estilo[] getValues() {
		return VALUES;
	}
}