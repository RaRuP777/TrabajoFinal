package GUI;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * Clase para controlar el filtro del selector de ficheros
 * 
 * @author Pedro J. Ramos
 *
 */
public class Filtro extends FileFilter {

	/**
	 * Extensi&oacute;n del fichero
	 */
	private String extension;
	
	/**
	 * Descripci&oacute;n del fichero
	 */
	private String description;

	/**
	 * Modifica la extensi&oacute;n y descripci&oacute;n del filtro
	 * 
	 * @param extension Extensi&oacute;n del filtro
	 * @param description Descripci&oacute;n del filtro
	 */
	public Filtro(String extension, String description) {
		this.extension = extension;
		this.description = description;
	}

	/**
	 * Comprueba si el archivo existe o no en el directorio
	 */
	@Override
	public boolean accept(File file) {
		if (file.isDirectory()) {
			return true;
		}
		return file.getName().endsWith(extension);
	}

	/**
	 * Define la descripci&oacute;n para el tipo de archivo
	 */
	@Override
	public String getDescription() {
		return description + String.format(" (*%s)", extension);
	}

	/**
	 * Obtiene la extensi&oacute;n del filtro
	 * 
	 * @return La Extensi&oacute;n del filtro
	 */
	public String getExtension() {
		return extension;
	}
}