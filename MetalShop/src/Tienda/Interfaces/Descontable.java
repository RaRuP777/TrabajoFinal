package Tienda.Interfaces;

/**
 * Interfaz que recoge los descuentos dependiendo del dia de la semana que es
 * 
 * @author Pedro
 *
 */
public interface Descontable {

	/**
	 * Descuento a aplicar al precio
	 * 
	 * @param precio Precio al que aplicar el descuento
	 * 
	 * @return Precio final con el descuento aplicado
	 */
	float descuento(float precio);
}
