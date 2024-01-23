package excepciones;

/**
 * Excepción personalizada para manejar situaciones donde un Cliente o Artículo no existe en el sistema.
 */
public class CliArtNoExisteException extends Exception {

    /**
     * Constructor que inicializa la excepción con un mensaje predeterminado.
     */
    public CliArtNoExisteException() {
        super("Este Cliente o Articulo no existe en el sistema. \n======================================================================================================================\n");
    }
}