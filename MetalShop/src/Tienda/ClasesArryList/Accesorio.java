package Tienda.ClasesArryList;

import GUI.Fichero;
import Tienda.Enumeraciones.Estilo;
import Tienda.Enumeraciones.Localizacion;
import Tienda.Enumeraciones.Tipo;
import Tienda.Excepciones.EstiloNoElegidoException;
import Tienda.Excepciones.LocalizacionNoElegidaException;
import Tienda.Excepciones.NombreBandaNoValidoException;
import Tienda.Excepciones.PrecioNoValidoException;
import Tienda.Excepciones.TipoNoValidoException;
import Tienda.Interfaces.Descontable;
import Tienda.Interfaces.Igualable;

/**
 * Objeto del tipo Accesorio
 * 
 * @author Pedro J. Ramos
 *
 */

public class Accesorio extends Producto implements Igualable, Descontable {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = 8484913041405187607L;
	
	/**
	 * Tipo de accesorio
	 */
	private Tipo tipo;

	/**
	 * Constructor para un nuevo Accesorio
	 * 
	 * @param banda Nombre de la banda
	 * @param localizacion Lugar de la tienda donde se expone
	 * @param precio Precio al que se vende
	 * @param estilo Estilo al que pertenece
	 * @param tipo Tipo de accesorio
	 * 
	 * @throws EstiloNoElegidoException Controla que el estilo ha sido seleccionado
	 * @throws PrecioNoValidoException Controla que el precio no es un valor de 0 o menor
	 * @throws NombreBandaNoValidoException Controla que el nombre de la banda es correcto
	 * @throws LocalizacionNoElegidaException Controla que el lugar donde se expone ha sido elegido
	 * @throws TipoNoValidoException Controla que el tipo ha sido elegido
	 */
	Accesorio(String banda, Localizacion localizacion, float precio,
			Estilo estilo, Tipo tipo)
			throws EstiloNoElegidoException, PrecioNoValidoException,
			NombreBandaNoValidoException, LocalizacionNoElegidaException, TipoNoValidoException {
		super(banda, localizacion, precio, estilo);
		setId();
		setTipo(tipo);
	}

	/**
	 * Modifica el tipo de accesorio
	 * 
	 * @param tipo Tipo de accesorio
	 * 
	 * @throws TipoNoValidoException Controla que el tipo ha sido seleccionado 
	 */
	private void setTipo(Tipo tipo) throws TipoNoValidoException {
		if (tipo != Tipo.ELIGE)
			this.tipo = tipo;
		else
			throw new TipoNoValidoException("Elige un tipo, por favor");
	}

	/**
	 * Contructor para comparaciones
	 */
	Accesorio() {
	}

	/**
	 * Crea un ID para el objeto
	 */
	private void setId() {
		if (Fichero.tienda.tamaño() < 10)
			this.id = "ACC00" + Integer.toString(Fichero.tienda.tamaño() + 1);
		else
			this.id = "ACC0" + Integer.toString(Fichero.tienda.tamaño() + 1);
	}

	/**
	 * Devuelve el tipo de accesorio
	 * 
	 * @return el Tipo de accesorio
	 */
	public Tipo getTipo() {
		return tipo;
	}
	
	/**
	 * Compara si un producto es un Accesorio
	 * 
	 * @param producto Producto a comparar
	 * @return True/False si es o no un Accesorio
	 */
	@Override
	public boolean igualable(Producto producto) {
		Accesorio accesorio = (Accesorio) producto;
		if (this.tipo.equals(accesorio.getTipo())&this.banda.equals(accesorio.getBanda()))
			return true;
		return false;
	}
	
	/**
	 * Aplica un descuento sobre el precio 
	 */
	@Override
	public float descuento(float precio) {
		return (float) (precio*0.7);
	}
}