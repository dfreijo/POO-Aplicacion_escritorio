package modelo.DAO;

import excepciones.DAOException;
import jakarta.persistence.*;
import modelo.Articulo;

import java.sql.SQLException;
import java.util.List;

public class ArticuloDAO implements DAO<Articulo, String> {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction transaction = entityManager.getTransaction();


    @Override
    public void insertar(Articulo articulo) throws DAOException, SQLException {
       try {
            transaction.begin();
            entityManager.merge(articulo);
            transaction.commit();
        }
       finally {
            if (transaction.isActive()) {
                transaction.rollback();
                throw new DAOException("Puede que el INSERT NO haya creado el artículo");
            }
        }
    }

    @Override
    public void modificar(Articulo articulo) throws DAOException, SQLException {
        try {
            transaction.begin();
            entityManager.merge(articulo);
            transaction.commit();
        }
        finally {
            if (transaction.isActive()) {
                transaction.rollback();
                throw new DAOException("Puede que el UPDATE NO haya update el artículo");
            }
        }
    }


    @Override
    public void eliminar(String idArticulo) throws DAOException, SQLException {
        try {
            transaction.begin();
            Query query = entityManager.createNamedQuery("Articulo.borrarByCodigo");
            query.setParameter(1, idArticulo);
            query.executeUpdate();
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }


    }

    @Override
    public List<Articulo> listarTodos() throws DAOException, SQLException {
        try {
            transaction.begin();
            TypedQuery<Articulo> query = entityManager.createNamedQuery("Articulo.ListarArticulos", Articulo.class);
            List <Articulo> articulos = query.getResultList();
            transaction.commit();
            return  articulos;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
                throw new DAOException("NO se ha encontrado articulos");
            }
        }
    }

    /**
     * Obtiene un artículo de la base de datos por su código.
     *
     * @param codigo El código del artículo a obtener.
     * @return El artículo encontrado.
     * @throws DAOException Si ocurre un error relacionado con el DAO.
     * @throws SQLException Si ocurre un error de SQL.
     */
    @Override
    public Articulo listarUno(String codigo) throws DAOException, SQLException {
        try {
            transaction.begin();
            TypedQuery<Articulo> query = entityManager.createNamedQuery("Articulo.byCodigo", Articulo.class);
            query.setParameter(1, codigo);
            Articulo articulo = query.getSingleResult();
            transaction.commit();
            return  articulo;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
                throw new DAOException("NO se ha encontrado ese REGISTRO.");
            }
        }
    }

    /**
     * Verifica si un artículo existe en la base de datos por su código.
     *
     * @param codigo El código del artículo a verificar.
     * @return True si el artículo existe, de lo contrario False.
     * @throws SQLException Si ocurre un error de SQL.
     */
    @Override
    public boolean existe(String codigo) throws SQLException, DAOException {
        try {
            transaction.begin();
            TypedQuery<Long> query = entityManager.createNamedQuery("Articulo.ExisteArticulo", Long.class);
            query.setParameter(1, codigo);
            int existe =  query.getSingleResult().intValue();
            transaction.commit();
            return existe != 0;
        } finally {
            if (transaction.isActive()) {
               transaction.rollback();
               throw new DAOException("NO se ha encontrado ese REGISTRO.");
           }
       }
    }


}
