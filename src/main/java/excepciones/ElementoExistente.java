package excepciones;

/**
 * Excepción lanzada cuando se intenta introducir un elemento que ya existe.
 */
public class ElementoExistente extends Exception {
    public ElementoExistente() {
        super("Este elemento ya existe en el sistema. \n======================================================================================================================\n");
    }
}


