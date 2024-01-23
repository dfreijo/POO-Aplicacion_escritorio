package modelo;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@NamedQuery(name= "Pedido.borrarPedido", query = "DELETE FROM Pedido WHERE idPedido = ?1")
@NamedQuery(name= "Pedido.ById", query = "SELECT DISTINCT e FROM Pedido e WHERE idPedido = ?1")
@NamedQuery(name= "Pedido.ListarPedidos", query = "SELECT DISTINCT e FROM Pedido e")
@NamedQuery(name= "Pedido.ListarPedidosEstado", query = "SELECT DISTINCT e FROM Pedido e where estado = ?1")
@NamedQuery(name= "Pedido.ExistePedido", query = "SELECT COUNT(1) FROM Pedido WHERE idPedido = ?1")

public class Pedido {

    @Id
    @Column(name = "idPedido", nullable = false, length = 45)
    private String idPedido;
    @Basic
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Basic
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    @Basic
    @Column(name = "estado", nullable = false, length = 45)
    private String estado;
    @ManyToOne
    @JoinColumn(name = "idArticulo", referencedColumnName = "codigo", nullable = false)
    private Articulo articuloByIdArticulo;
    @ManyToOne
    @JoinColumn(name = "Cliente_nif", referencedColumnName = "nif", nullable = false)
    private Cliente clienteByClienteNif;

    public Pedido(String idPedido, int cantidad, Date fecha, String estado, Articulo articuloByIdArticulo, Cliente clienteByClienteNif) {
        this.idPedido = idPedido;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.estado = estado;
        this.articuloByIdArticulo = articuloByIdArticulo;
        this.clienteByClienteNif = clienteByClienteNif;
    }

    public Pedido() {

    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getIdArticulo() {
        return articuloByIdArticulo.getCodigo();
    }

    public String getClienteNif() {
        return clienteByClienteNif.getNif();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pedido pedido = (Pedido) o;

        if (cantidad != pedido.cantidad) return false;
        if (idPedido != null ? !idPedido.equals(pedido.idPedido) : pedido.idPedido != null) return false;
        if (getIdArticulo() != null ? !getIdArticulo().equals(pedido.getIdArticulo()) : pedido.getIdArticulo() != null) return false;
        if (getClienteNif() != null ? !getClienteNif().equals(pedido.getClienteNif()) : pedido.getClienteNif() != null) return false;
        if (fecha != null ? !fecha.equals(pedido.fecha) : pedido.fecha != null) return false;
        if (estado != null ? !estado.equals(pedido.estado) : pedido.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPedido != null ? idPedido.hashCode() : 0;
        result = 31 * result + (getIdArticulo() != null ? getIdArticulo().hashCode() : 0);
        result = 31 * result + (getClienteNif() != null ? getClienteNif().hashCode() : 0);
        result = 31 * result + cantidad;
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    public Articulo getArticuloByIdArticulo() {
        return articuloByIdArticulo;
    }

    public void setArticuloByIdArticulo(Articulo articuloByIdArticulo) {
        this.articuloByIdArticulo = articuloByIdArticulo;
    }

    public Cliente getClienteByClienteNif() {
        return clienteByClienteNif;
    }

    public void setClienteByClienteNif(Cliente clienteByClienteNif) {
        this.clienteByClienteNif = clienteByClienteNif;
    }

    @Override
    public String toString() {
        return  "INFO PEDIDO \n" +
                "ID_Pedido = " + idPedido + ",\n" +
                "Cantidad = " + cantidad + ",\n" +
                "Fecha = " + fecha + ",\n" +
                "Estado='" + estado + ",\n" +
                articuloByIdArticulo +
                clienteByClienteNif ;

    }
}
