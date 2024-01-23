package modelo;

/**
 * Clase que representa un cliente de tipo Premium.
 */
public class Premium extends Cliente {

    /**
     * Constructor con argumentos para inicializar un cliente Premium.
     *
     * @param nombre    El nombre del cliente.
     * @param domicilio El domicilio del cliente.
     * @param nif       El NIF (Número de Identificación Fiscal) del cliente.
     * @param email     El correo electrónico del cliente.
     * @param tipo      El tipo de cliente.
     * @param descuento El descuento aplicado al cliente Premium.
     * @param cuota     La cuota del cliente Premium.
     */
    public Premium(String nombre, String domicilio, String nif, String email, String tipo, Float descuento, Float cuota) {
        super(nombre, domicilio, nif, email, tipo, descuento, cuota);
    }

    /**
     * Obtiene el descuento aplicado al cliente Premium.
     *
     * @return El descuento del cliente.
     */

    /**
     * Establece el descuento aplicado al cliente Premium.
     *
     * @param descuento El descuento a establecer.
     */

    /**
     * Obtiene la cuota del cliente Premium.
     *
     * @return La cuota del cliente.
     */

    /**
     * Establece la cuota del cliente Premium.
     *
     * @param cuota La cuota a establecer.
     */
    /**
     * Devuelve el tipo de cliente.
     */
    public String tipoCliente() {
        return "Premium";
    }

    /**
     * Calcula la cuota anual.
     */
    public float calcAnual() {
        Float cuotaAn = super.getCuota() * 12;
        return cuotaAn;
    }

    /**
     * Calcula el descuento de gastos de envío.
     */

    /**
     * Retorna una representación en forma de cadena del cliente Premium.
     *
     * @return Una cadena que representa al cliente Premium.
     */
    @Override
    public String toString() {
        return super.toString() +
                "Tipo= " + tipoCliente() + " €\n" +
                "Descuento= " + getDescuento() + " €\n" +
                "Cuota=" + calcAnual() + "€/año }\n" + "======================================================================================================================\n";
    }
}