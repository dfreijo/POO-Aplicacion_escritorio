package controlador;

/**
 * Clase principal que inicia online store
 */
public class OnlineStore {
    Controlador controlador = new Controlador();

    /**
     * Método de inicio de la aplicación que crea una instancia de Online store y la inicia.
     */
    public static void main(String[] args)  throws Exception {
        OnlineStore onlineStore = new OnlineStore();
        onlineStore.iniciar();
    }

    /**
     * Inicia Online store a través del controlador.
     */
    void iniciar() throws Exception {
        controlador.start();
    }
}