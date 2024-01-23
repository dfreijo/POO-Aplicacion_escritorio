package modelo.DAO;

import excepciones.DAOException;
import jakarta.persistence.*;
import modelo.Articulo;
import modelo.Pedido;

import java.sql.SQLException;
import java.util.List;

public class PedidoDAO implements DAOPedido<Pedido, String>{
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction transaction = entityManager.getTransaction();
    @Override
    public List<Pedido> listarTodosEstado(String estado) throws DAOException, SQLException {
        try {
            transaction.begin();
            TypedQuery<Pedido> query = entityManager.createNamedQuery("Pedido.ListarPedidosEstado", Pedido.class);
            query.setParameter(1, estado);
            List <Pedido> pedidos = query.getResultList();
            transaction.commit();
            return  pedidos;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
                throw new DAOException("NO se ha encontrado pedidos");
            }
        }
    }

    @Override
    public void insertar(Pedido pedido) throws DAOException, SQLException {
        try {
            transaction.begin();
            entityManager.merge(pedido);
            transaction.commit();
        }
        finally {
            if (transaction.isActive()) {
                transaction.rollback();
                 throw new DAOException("Puede que el INSERT NO haya creado el pedido");
                }
            }
    }

    @Override
    public void modificar(Pedido pedido) throws DAOException, SQLException {
        try {
            transaction.begin();
            entityManager.merge(pedido);
            transaction.commit();
        }
        finally {
            if (transaction.isActive()) {
                transaction.rollback();
                throw new DAOException("Puede que el UPDATE NO haya update el pedido");
            }
        }


    }

    @Override
    public void eliminar(String idPedido) throws DAOException, SQLException {
        try {
            transaction.begin();
            Query query = entityManager.createNamedQuery("Pedido.borrarPedido");
            query.setParameter(1, idPedido);
            query.executeUpdate();
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }

    }

    @Override
    public List<Pedido> listarTodos() throws DAOException, SQLException {
        try {
            transaction.begin();
            TypedQuery<Pedido> query = entityManager.createNamedQuery("Pedido.ListarPedidos", Pedido.class);
            List <Pedido> pedidos = query.getResultList();
            transaction.commit();
            return  pedidos;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
                throw new DAOException("NO se ha encontrado pedidos");
            }
        }
    }

    @Override
    public Pedido listarUno(String idPedido) throws DAOException, SQLException {
        try {
            transaction.begin();
            TypedQuery<Pedido> query = entityManager.createNamedQuery("Pedido.ById", Pedido.class);
            query.setParameter(1, idPedido);
            Pedido pedido = query.getSingleResult();
            transaction.commit();
            return  pedido;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
                throw new DAOException("NO se ha encontrado ese REGISTRO.");
            }
        }
    }

    @Override
    public boolean existe(String idPedido) throws SQLException, DAOException {
       try {
            transaction.begin();
            TypedQuery<Long> query = entityManager.createNamedQuery("Pedido.ExistePedido", Long.class);
            query.setParameter(1, idPedido);
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

