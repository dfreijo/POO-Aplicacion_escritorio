package modelo;

/**
 * Clase que representa un cliente de tipo Estandar.
 */
public class Estandar extends Cliente {

    public Estandar(String nombre, String domicilio, String nif, String email, String tipo) {
        super(nombre, domicilio, nif, email, tipo, null, null);
    }

    /**
     * Devuelve el tipo de cliente.
     */
    public String tipoCliente() {
        return "Estándar";
    }

    /**
     * Calcula la cuota anual.
     */
    public float calcAnual() {
        return 0;
    }

    /**
     * Calcula el descuento de gastos de envío.
     */
    public float descuentoEnv() {
        return 0;
    }

    /**
     * Retorna una representación en forma de cadena del cliente Estandar.
     *
     * @return Una cadena que representa al cliente Estandar.
     */
    @Override
    public String toString() {
        return super.toString() +
                "Tipo= " + tipoCliente() + "\n" +
                "Descuento=" + descuentoEnv() + " €" +" }\n" + "======================================================================================================================\n";
    }
}
