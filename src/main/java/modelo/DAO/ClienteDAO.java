package modelo.DAO;

import excepciones.DAOException;
import jakarta.persistence.*;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Pedido;

import java.sql.SQLException;
import java.util.List;

public class ClienteDAO implements DAOCliente<Cliente, String> {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction transaction = entityManager.getTransaction();

    @Override
    public void insertar(Cliente cliente) throws DAOException, SQLException {
        try {
            transaction.begin();
            entityManager.merge(cliente);
            transaction.commit();
       }
        finally {
            if (transaction.isActive()) {
                transaction.rollback();
        throw new DAOException("Puede que el INSERT NO haya creado el cliente");
        }
        }


    }



    @Override
    public void modificar(Cliente cliente) throws DAOException, SQLException {
        try {
            transaction.begin();
            entityManager.merge(cliente);
            transaction.commit();
        }
        finally {
            if (transaction.isActive()) {
                transaction.rollback();
                throw new DAOException("Puede que el UPDATE NO haya update el cliente");
            }
        }


    }

    @Override
    public void eliminar(String nif) throws DAOException, SQLException {
        try {
            transaction.begin();
            Query query = entityManager.createNamedQuery("Cliente.borrarByNif");
            query.setParameter(1, nif);
            query.executeUpdate();
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }

    }

    @Override
    public List<Cliente> listarTodos() throws DAOException, SQLException {
        try {
            transaction.begin();
            TypedQuery<Cliente> query = entityManager.createNamedQuery("Cliente.ListarClientes", Cliente.class);
            List <Cliente> clientes = query.getResultList();
            transaction.commit();
            return  clientes;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
                throw new DAOException("NO se ha encontrado articulos");
            }
        }

    }

    @Override
    public Cliente listarUno(String nif) throws DAOException, SQLException {
        try {
            transaction.begin();
            TypedQuery<Cliente> query = entityManager.createNamedQuery("Cliente.ByNif", Cliente.class);
            query.setParameter(1, nif);
            Cliente cliente = query.getSingleResult();
            transaction.commit();
            return  cliente;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
                throw new DAOException("NO se ha encontrado ese REGISTRO.");
            }
        }
    }

    @Override
    public boolean existe(String nif) throws SQLException, DAOException {
        try {
            transaction.begin();
            TypedQuery<Long> query = entityManager.createNamedQuery("Cliente.ExisteCliente", Long.class);
            query.setParameter(1, nif);
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

    @Override
    public List<Cliente> listarTodosTipo(String tipo) throws DAOException, SQLException {
        try {
            transaction.begin();
            TypedQuery<Cliente> query = entityManager.createNamedQuery("Cliente.ListarClientesByTipo", Cliente.class);
            query.setParameter(1, tipo);
            List <Cliente> clientesByTipo = query.getResultList();
            transaction.commit();
            return  clientesByTipo;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
                throw new DAOException("NO se ha encontrado clientes de este tipo");
            }
        }
    };
}
