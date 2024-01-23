package modelo.DAO;

import excepciones.DAOException;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz genérica para operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la capa de persistencia.
 *
 * @param <T> Tipo de objeto
 * @param <K> Tipo de clave
 */
public interface DAOCliente<T, K> extends DAO<T, K>{

    /**
     * Obtiene una lista de todos los objetos de la capa de persistencia.
     *
     * @return Lista de objetos
     * @throws DAOException si ocurre un error específico del DAO
     * @throws SQLException si ocurre un error de SQL
     */
    public List<T> listarTodosTipo(K k) throws DAOException, SQLException;



}
