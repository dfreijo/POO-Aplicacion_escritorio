package modelo.DAO;

/**
 * Interfaz para la factoría de DAO que proporciona métodos para obtener instancias de varios tipos de DAO.
 */
public class DAOFactory {

        /**
         * Obtiene una instancia del DAO para la gestión de Artículos.
         *
         * @return Instancia del DAO de Artículos
         */
        public ArticuloDAO getArticuloDAO() {
                return new ArticuloDAO();
        };

        /**
         * Obtiene una instancia del DAO para la gestión de Clientes.
         *
         * @return Instancia del DAO de Clientes
         */
        public ClienteDAO getClienteDAO() {
                return new ClienteDAO();
        }

        /**
         * Obtiene una instancia del DAO para la gestión de Pedidos.
         *
         * @return Instancia del DAO de Pedidos
         */
        public PedidoDAO getPedidoDAO() {
                return new PedidoDAO();
        }
}