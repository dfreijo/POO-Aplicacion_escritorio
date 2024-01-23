package excepciones;

/**
 * Excepción personalizada para manejar errores en operaciones DAO (Data Access Object).
 * Puede ocurrir cuando un elemento no existe en el sistema.
 */
public class DAOException extends Exception {

    /**
     * Constructor que inicializa la excepción sin un mensaje específico.
     */
    public DAOException() {
        super();
    }

    /**
     * Constructor que inicializa la excepción con un mensaje personalizado.
     *
     * @param message Mensaje de error específico.
     */
    public DAOException(String message) {
        super(message);
    }

    /**
     * Constructor que inicializa la excepción con un mensaje y una causa subyacente.
     *
     * @param message Mensaje de error específico.
     * @param cause   Causa original de la excepción.
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que inicializa la excepción con una causa subyacente.
     *
     * @param cause Causa original de la excepción.
     */
    public DAOException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor que permite inicializar la excepción con detalles más específicos.
     *
     * @param message            Mensaje de error específico.
     * @param cause              Causa original de la excepción.
     * @param enableSuppression  Habilitar o deshabilitar la supresión de excepciones.
     * @param writableStackTrace Determina si la traza de la pila debe ser escribible o no.
     */
    protected DAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * Método para obtener un mensaje predeterminado de error.
     *
     * @return Mensaje de error predeterminado.
     */
    public String getError() {
        return "Este elemento no existe en el sistema.";
    }
}