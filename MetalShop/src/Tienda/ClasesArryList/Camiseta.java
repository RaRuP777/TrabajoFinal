package Tienda.ClasesArryList;

import GUI.Fichero;
import Tienda.Enumeraciones.Estilo;
import Tienda.Enumeraciones.Localizacion;
import Tienda.Enumeraciones.Sexo;
import Tienda.Enumeraciones.Talla;
import Tienda.Excepciones.EstiloNoElegidoException;
import Tienda.Excepciones.LocalizacionNoElegidaException;
import Tienda.Excepciones.NombreBandaNoValidoException;
import Tienda.Excepciones.PrecioNoValidoException;
import Tienda.Excepciones.SexoNoValidoException;
import Tienda.Excepciones.TallaNoValidaException;
import Tienda.Excepciones.TituloNoValidoException;
import Tienda.Interfaces.Descontable;
import Tienda.Interfaces.Igualable;

/**
 * Objeto del tipo Camiseta
 * 
 * @author Pedro J. Ramos
 *
 */
public class Camiseta extends Producto implements Igualable, Descontable {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = 7058848577765932189L;
	
	/**
	 * T&iacute;tulo del disco al que pertenece la camiseta
	 */
	private String titulo;

	/**
	 * Talla de la camiseta
	 */
	private Talla talla;
	
	/**
	 * Sexo de la camiseta
	 */
	private Sexo sexo;

	/**
	 * Constructor para crear una camiseta
	 * 
	 * @param banda Banda a la que pertenece
	 * @param titulo T&iacute;tulo del disco a la que pertenece
	 * @param localizacion Lugar donde se expone
	 * @param precio Precio al que se vende
	 * @param estilo Estilo al que pertence
	 * @param talla Talla de la camiseta
	 * @param sexo Sexo de la camiseta
	 * 
	 * @throws EstiloNoElegidoException Controla que el estilo ha sido seleccionado
	 * @throws PrecioNoValidoException Controla que el precio no es un valor de 0 o menor
	 * @throws NombreBandaNoValidoException Controla que el nombre de la banda es correcto
	 * @throws LocalizacionNoElegidaException Controla que el lugar donde se expone ha sido elegido
	 * @throws TituloNoValidoException Contorla que el t&iacute;tulo es correcto
	 * @throws TallaNoValidaException Controla que una talla ha sido elegida
	 * @throws SexoNoValidoException Controla que el sexo ha sido elegido
	 */
	Camiseta(String banda, String titulo, Localizacion localizacion, float precio, 
			Estilo estilo, Talla talla, Sexo sexo) throws EstiloNoElegidoException, 
			PrecioNoValidoException, NombreBandaNoValidoException, LocalizacionNoElegidaException,
			TituloNoValidoException, TallaNoValidaException, SexoNoValidoException {
		super(banda, localizacion, precio, estilo);
		setId();
		setTitulo(titulo);
		setTalla(talla);
		setSexo(sexo);
	}

	/**
	 * Constructor para comparable
	 */
	Camiseta() {
	}

	/**
	 * Crea un ID para el objeto
	 */
	private void setId() {
		if (Fichero.tienda.tamaño() < 10)
			this.id = "CAM00" + Integer.toString(Fichero.tienda.tamaño() + 1);
		else
			this.id = "CAM0" + Integer.toString(Fichero.tienda.tamaño() + 1);
	}

	/**
	 * Obtiene la talla de la camiseta
	 * 
	 * @return La talla
	 */
	public Talla getTalla() {
		return talla;
	}

	/**
	 * Modifica el t&itulo del disco al que pertenece la camiseta
	 * 
	 * @param titulo T&iacute;tulo de la camiseta
	 * @throws TituloNoValidoException Controla que el t&iacute;tulo es v&aacute;lido 
	 */
	private void setTitulo(String titulo) throws TituloNoValidoException {
		if (esValido(titulo, patronNombres))
			this.titulo = titulo;
		else
			throw new TituloNoValidoException("El título del disco no es correcto");
	}
	
	/**
	 * Obtiene el t&iacute;tulo del disco al que pertenece la camiseta
	 * 
	 * @return El t&iacute;tulo del disco de la camiseta
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Modifica la talla de la camiseta
	 * 
	 * @param talla La talla de la camiseta
	 * @throws TallaNoValidaException Controla que la talla ha sido elegida
	 */
	private void setTalla(Talla talla) throws TallaNoValidaException {
		if (talla != Talla.ELIGE)
			this.talla = talla;
		else
			throw new TallaNoValidaException("Elige una talla, por favor");
	}
	
	/**
	 * Obtiene el sexo de una camiseta
	 * 
	 * @return El sexo de la camiseta
	 */
	public Sexo getSexo() {
		return sexo;
	}

	/**
	 * Modifica el sexo de una camiseta
	 * 
	 * @param sexo El sexo de la camiseta
	 * @throws SexoNoValidoException Controla que el sexo de una camiseta ha sido elegido
	 */
	private void setSexo(Sexo sexo) throws SexoNoValidoException {
		if (sexo != null)
			this.sexo = sexo;
		else
			throw new SexoNoValidoException("El sexo no es válido");
	}

	/**
	 * Compara si un producto es un Camiseta
	 * 
	 * @param producto Producto a comparar
	 * @return True/False si es o no un Accesorio
	 */
	@Override
	public boolean comparable(Producto producto) {
		Camiseta camiseta = (Camiseta) producto;
		if (this.sexo.equals(camiseta.getSexo())&this.talla.equals(getTalla())&this.banda.equals(camiseta.getBanda())&this.titulo.equals(camiseta.getTitulo()))
			return true;
		return false;
	}

	/**
	 * Aplica un descuento sobre el precio 
	 */
	@Override
	public float descuento(float precio) {
		return (float) (precio*0.8);
	}
}
