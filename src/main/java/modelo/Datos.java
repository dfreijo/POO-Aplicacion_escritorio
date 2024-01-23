package modelo;

import modelo.DAO.DAO;
import modelo.DAO.DAOFactory;
import excepciones.CliArtNoExisteException;
import excepciones.DAOException;
import modelo.DAO.DAOPedido;
import modelo.DAO.DAOCliente;

import java.sql.SQLException;
import java.util.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Map;


/**
 * Clase que representa el modelo de datos de una tienda en línea.
 */
public class Datos {
    private DAO articuloDAO;
    private DAOFactory daoFactory = new DAOFactory();
    private DAOCliente clienteDAO;
    private DAOPedido pedidoDAO;


    /**
     * Constructor por defecto de Datos.
     */
    public Datos() {
        articuloDAO = daoFactory.getArticuloDAO();
        clienteDAO = daoFactory.getClienteDAO();
        pedidoDAO = daoFactory.getPedidoDAO();
    }

    /**
     * Agrega un artículo al modelo de datos.
     *
     * @param codigo       El código del artículo.
     * @param descripcion  La descripción del artículo.
     * @param precio       El precio del artículo.
     * @param gastos       Los gastos asociados al artículo.
     * @param preparacion  El tiempo de preparación del artículo en minutos.
     */
    public void agregarArticulo(String codigo, String descripcion, Float precio, Float gastos, int preparacion) throws DAOException, SQLException {
        Articulo articulo = new Articulo(codigo, descripcion, precio, gastos, preparacion);
        articuloDAO.insertar(articulo);
    }

    /**
     * Obtiene la lista de artículos del modelo de datos.
     *
     * @return La lista de artículos.
     */
    public String getArticulo(String codigo) throws DAOException, SQLException {
        String articuloString;
        articuloString = articuloDAO.listarUno(codigo).toString();
        return articuloString;
    }
    /**
     * Comprueba si existe un artículo en la lista de artículos a través de su código.
     *
     * @param codigo El código del artículo a verificar.
     * @return true si el artículo con el código dado existe en la lista, false en caso contrario.
     */
    public boolean existeArticulo(String codigo) throws DAOException, SQLException {
        return articuloDAO.existe(codigo);
    }

    public void modificarArticulo(String codigo, Map<String, Object> params) throws DAOException, SQLException {
        Articulo articulo;
        String newCodigo = getParameter(params,"newCodigo", null);
        String newDescripcion = getParameter(params,"newDescripcion", null);
        Float newPrecio = getParameter(params,"newPrecio", null);
        Float newGastos = getParameter(params,"newGastos", null);
        Integer newPreparacion = getParameter(params,"newPreparacion", null);
        if (articuloDAO.existe(codigo)) {
            articulo = (Articulo) articuloDAO.listarUno(codigo);
            if (newCodigo != null) {
                articulo.setCodigo(newCodigo);
            }
            if (newDescripcion != null) {
                articulo.setDescripcion(newDescripcion);
            }
            if (newPrecio != null) {
                articulo.setPrecio(newPrecio);
            }
            if (newGastos != null) {
                articulo.setGastoEnvio(newGastos);
            }
            if (newPreparacion != null) {
                articulo.setPreparacion(newPreparacion.intValue());
            }
            articuloDAO.modificar(articulo);
        }
}

    /**
     * Agrega un cliente al modelo de datos.
     *
     * @param nombre    El nombre del cliente.
     * @param domicilio La dirección del cliente.
     * @param nif       El NIF del cliente.
     * @param email     El correo electrónico del cliente.
     * @param tipo      El tipo de cliente (PREMIUM o ESTANDAR).
     * @param descuento El descuento aplicable al cliente (solo para clientes PREMIUM).
     * @param cuota     La cuota mensual (solo para clientes PREMIUM).
     */
    public void agregarCliente(String nif, String nombre, String domicilio, String email, String tipo, Float descuento, Float cuota) throws DAOException, SQLException {
        Cliente cliente = new Cliente(nif, nombre, domicilio,  email, tipo, descuento, cuota);
        clienteDAO.insertar(cliente);
    }

    /**
     * Obtiene la lista de clientes del modelo de datos.
     *
     * @return La lista de clientes.
     */
    public String getCliente(String nif) throws DAOException, SQLException {
        String clienteString = null;
        clienteString = clienteDAO.listarUno(nif).toString();

        return clienteString;
    }

    /**
     * Comprueba si existe un cliente en la lista de clientes a través de su NIF.
     *
     * @param nif El NIF del cliente a verificar.
     * @return true si el cliente con el NIF dado existe en la lista, false en caso contrario.
     */
    public boolean existeCliente(String nif) throws DAOException, SQLException {
        return clienteDAO.existe(nif);
    }


    /**
     * Agrega un pedido al modelo de datos.
     *
     * @param id      El ID del pedido.
     * @param idCliente El NIF del cliente que realiza el pedido.
     * @param idArticulo El código del artículo solicitado en el pedido.
     * @param cantidad La cantidad de unidades del artículo solicitado.
     * @param fecha   La fecha en que se realiza el pedido.
     * @param estado  El estado del pedido (ENVIADO o PENDIENTE).
     */
    public void agregarPedido(String id, String idCliente, String idArticulo, int cantidad, Date fecha, String estado) throws DAOException, SQLException, CliArtNoExisteException {
        Cliente cliente;
        Articulo articulo;

        cliente = (Cliente) clienteDAO.listarUno(idCliente);
        articulo = (Articulo) articuloDAO.listarUno(idArticulo);

        if (cliente == null){
            throw new CliArtNoExisteException();
        }else if (articulo == null){
            throw new CliArtNoExisteException();
        }else{
            Pedido newPedido = new Pedido(id, cantidad, fecha, estado, articulo, cliente);
            pedidoDAO.insertar(newPedido);
        }
    }

    /**
     * Obtiene la lista de pedidos del modelo de datos.
     *
     * @return La lista de pedidos.
     */
    public String getPedido(String id) throws DAOException, SQLException {
        String pedido = pedidoDAO.listarUno(id).toString();
        return pedido;
    }

    /**
     * Obtiene la información de los pedidos pendientes.
     *
     * @return Una cadena que contiene información sobre los pedidos pendientes.
     */
    public String getPedidoPend() throws DAOException, SQLException {
        String pedido = pedidoDAO.listarTodosEstado("PENDIENTE").toString();
        return pedido;
    }

    /**
     * Obtiene la información de los pedidos enviados.
     *
     * @return Una cadena que contiene información sobre los pedidos enviados.
     */
    public String getPedidoEnvi() throws DAOException, SQLException {
        String pedido = pedidoDAO.listarTodosEstado("ENVIADO").toString();
        return pedido;
    }

    /**
     * Borra un pedido del modelo de datos basado en su ID.
     *
     * @param id El ID del pedido a borrar.
     */
    public void borrarPedido(String id) throws DAOException, SQLException {
            pedidoDAO.eliminar(id);
    }


    /**
     * Comprueba si existe un pedido en el modelo de datos a través de su número de pedido.
     *
     * @param num El número de pedido a verificar.
     * @return true si el pedido con el número dado existe en el modelo de datos, false en caso contrario.
     */
    public boolean existePedido(String num) throws SQLException, DAOException {
        Boolean existe = pedidoDAO.existe(num);
        return existe;
    }

    private static <T> T getParameter(Map<String, Object> map, String key, T defaultValue) {
        return (map.containsKey(key)) ? (T) map.get(key) : defaultValue;
    }

    public String getClientePremium() throws DAOException, SQLException {
        String pedido = clienteDAO.listarTodosTipo("Premium").toString();
        return pedido;
    }

    public String getClienteEstandar() throws DAOException, SQLException {
        String pedido = clienteDAO.listarTodosTipo("Estandar").toString();
        return pedido;
    }
}
