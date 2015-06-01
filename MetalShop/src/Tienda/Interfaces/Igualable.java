package Tienda.Interfaces;

import Tienda.ClasesArryList.Producto;

/**
 * Interfaz que compara dos productos
 * 
 * @author Pedro J. Ramos
 *
 */
public interface Igualable {

	/**
	 * Compara el productos para ver si son del mismo tipo
	 */
	public boolean comparable(Producto producto);
}
