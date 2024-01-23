package excepciones;

/**
 * Excepción lanzada cuando se selecciona una opción inválida en el menú.
 */
public class OpcionInvalida extends Exception{
    public OpcionInvalida(){
        super("Ha seleccionado una opción invalida, porfavor seleccione de nuevo.\n======================================================================================================================\n");
    }
}
