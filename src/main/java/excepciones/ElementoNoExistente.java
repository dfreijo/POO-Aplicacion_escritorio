package excepciones;

/**
 * Excepción lanzada cuando se intenta mostrar un elemento que no existe en el sistema.
 */
public class ElementoNoExistente extends Exception{
    public ElementoNoExistente(){
        super("Este elemento no existe en el sistema. \n======================================================================================================================\n");
    }
}
