package modelo.DAO;

import excepciones.DAOException;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Interfaz genérica para operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la capa de persistencia.
 *
 * @param <T> Tipo de objeto
 * @param <K> Tipo de clave
 */
public interface DAO<T, K> {

    /**
     * Inserta un objeto en la capa de persistencia.
     *
     * @param t Objeto a insertar
     * @throws DAOException si ocurre un error específico del DAO
     * @throws SQLException si ocurre un error de SQL
     */
    void insertar(T t) throws DAOException, SQLException;

    /**
     * Modifica un objeto en la capa de persistencia.
     *
     * @param t Objeto a modificar
     * @throws DAOException si ocurre un error específico del DAO
     * @throws SQLException si ocurre un error de SQL
     */
    void modificar(T t) throws DAOException, SQLException;

    /**
     * Elimina un objeto de la capa de persistencia basado en su clave.
     *
     * @param k key del objeto a eliminar
     * @throws DAOException si ocurre un error específico del DAO
     * @throws SQLException si ocurre un error de SQL
     */
    void eliminar(K k) throws DAOException, SQLException;

    /**
     * Obtiene una lista de todos los objetos de la capa de persistencia.
     *
     * @return Lista de objetos
     * @throws DAOException si ocurre un error específico del DAO
     * @throws SQLException si ocurre un error de SQL
     */
    List<T> listarTodos() throws DAOException, SQLException;

    /**
     * Obtiene un único objeto de la capa de persistencia basado en su clave.
     *
     * @param k Clave del objeto a obtener
     * @return Objeto obtenido
     * @throws DAOException si ocurre un error específico del DAO
     * @throws SQLException si ocurre un error de SQL
     */
    T listarUno(K k) throws DAOException, SQLException;

    /**
     * Verifica si un objeto existe en la capa de persistencia basado en su clave.
     *
     * @param k Clave del objeto a verificar
     * @return Verdadero si el objeto existe, falso si no existe
     * @throws SQLException si ocurre un error de SQL
     */
    boolean existe(K k) throws SQLException, DAOException;


}
