package Tienda.ClasesArryList;

import GUI.Fichero;
import Tienda.Enumeraciones.Estilo;
import Tienda.Enumeraciones.Localizacion;
import Tienda.Excepciones.CantidadCancionesNoValidaException;
import Tienda.Excepciones.DuracionNoValidaException;
import Tienda.Excepciones.EstiloNoElegidoException;
import Tienda.Excepciones.LocalizacionNoElegidaException;
import Tienda.Excepciones.NombreBandaNoValidoException;
import Tienda.Excepciones.PrecioNoValidoException;
import Tienda.Excepciones.TituloNoValidoException;
import Tienda.Interfaces.Descontable;
import Tienda.Interfaces.Idable;
import Tienda.Interfaces.Igualable;

public class Disco extends Producto implements Idable, Igualable, Descontable {

	/**
	 * Serial para serializable
	 */
	private static final long serialVersionUID = 7206391333259112029L;

	/**
	 * Nombre del disco
	 */
	private String titulo;

	/**
	 * Duraci&oacute;n total del disco en minutos
	 */
	private int duracion;

	/**
	 * Cantidad de canciones que contiene el disco
	 */
	private int canciones;

	/**
	 * Constructor para crear un nuevo disco
	 * 
	 * @param banda Banda a la que pertenece
	 * @param titulo T&iacute;tulo del disco a la que pertenece
	 * @param localizacion Lugar donde se expone
	 * @param precio Precio al que se vende
	 * @param estilo Estilo al que pertence
	 * @param duracion Duraci&oacute;n total del disco en minutos
	 * @param canciones Cantidad de canciones que contiene el disco
	 * 
	 * @throws EstiloNoElegidoException Controla que el estilo ha sido seleccionado
	 * @throws PrecioNoValidoException Controla que el precio no es un valor de 0 o menor
	 * @throws NombreBandaNoValidoException Controla que el nombre de la banda es correcto
	 * @throws LocalizacionNoElegidaException Controla que el lugar donde se expone ha sido elegido
	 * @throws TituloNoValidoException Controla que el t&iacute;tulo es correcto
	 * @throws DuracionNoValidaException Controla que la durari&oacute;n no es menor que 0 ni mayor que 72 minutos
	 * @throws CantidadCancionesNoValidaException Controla que la cantidad de canciones no es menor de 1
	 */
	Disco(String banda, Localizacion localizacion, float precio, Estilo estilo,
			String titulo, int duracion, int canciones)
			throws EstiloNoElegidoException, PrecioNoValidoException,
			DuracionNoValidaException, TituloNoValidoException,
			CantidadCancionesNoValidaException, NombreBandaNoValidoException,
			LocalizacionNoElegidaException {
		super(banda, localizacion, precio, estilo);
		setID();
		setTitulo(titulo);
		setDuracion(duracion);
		setCanciones(canciones);
	}

	/**
	 * Constructor para comparable
	 */
	Disco() {
	}

	/**
	 * Modifica el valor del ID del disco
	 */
	public void setID() {
		if (Fichero.tienda.tamaño() < 10)
			this.id = "DIS00" + Integer.toString(Fichero.tienda.tamaño() + 1);
		else
			this.id = "DIS0" + Integer.toString(Fichero.tienda.tamaño() + 1);
	}

	/**
	 * Modifica el t&itulo del disco al que pertenece la camiseta
	 * 
	 * @param titulo
	 *            T&iacute;tulo de la camiseta
	 * 
	 * @throws TituloNoValidoException
	 *             Controla que el t&iacute;tulo es v&aacute;lido
	 */
	private void setTitulo(String titulo) throws TituloNoValidoException {
		if (esValido(titulo, patronNombres))
			this.titulo = titulo;
		else
			throw new TituloNoValidoException("Título no correcto (Debe comenzar por mayúscula y tener una longitud de entre 3 y 20 caracteres)");
	}

	/**
	 * Obtiene el t&iacute;tulo del disco
	 *
	 * return El t&iacute;tulo del disco
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Obtiene la duraci&oacute;n del disco
	 * 
	 * @return La duraci&oacute;n del disco en minutos
	 */
	public int getDuracion() {
		return duracion;
	}

	/**
	 * Modifica la duraci&oacute;n del disco
	 * 
	 * @param duracion
	 *            La duraci&oacute;n del disco en minutos
	 * 
	 * @throws DuracionNoValidaException
	 *             Controla que la durari&oacute;n no es menor que 0 ni mayor
	 *             que 72 minutos
	 */
	private void setDuracion(int duracion) throws DuracionNoValidaException {
		if (duracion > 1 && duracion < 73)
			this.duracion = duracion;
		else
			throw new DuracionNoValidaException("Duracion no válida (Mínimo 2 máximo 72)");
	}

	/**
	 * Obtiene la cantidad de canciones que tiene el disco
	 * 
	 * @return La cantidad de canciones del disco
	 */
	public int getCanciones() {
		return canciones;
	}

	/**
	 * Modifica la cantidad de canciones que tiene el disco
	 * 
	 * @param canciones
	 *            La cantidad de canciones del disco
	 * 
	 * @throws CantidadCancionesNoValidaException
	 *             Controla que la cantidad de canciones no es menor de 1
	 */
	private void setCanciones(int canciones)
			throws CantidadCancionesNoValidaException {
		if (canciones > 1 && canciones<30)
			this.canciones = canciones;
		else
			throw new CantidadCancionesNoValidaException("Cantidad de cancione no válida (Mínimo 2 máximo 30)");
		this.canciones = canciones;
	}

	private void reproducirDisco() {
	}

	private void pasarSiguienteCancion() {
	}

	private void pasarAnteriorCancion() {
	}

	/**
	 * Compara si un producto es un Accesorio
	 * 
	 * @param producto Producto a comparar
	 * @return True/False si es o no un Accesorio
	 */
	@Override
	public boolean igualable(Producto producto) {
		Disco disco = (Disco) producto;
		if (this.canciones == disco.getCanciones()
				& this.duracion == disco.getDuracion()
				& this.banda.equals(disco.getBanda())
				& this.titulo.equals(disco.getTitulo()))
			return true;
		return false;
	}

	/**
	 * Aplica un descuento sobre el precio 
	 */
	@Override
	public float descuento(float precio) {
		return (float) (precio*0.9);
	}
}