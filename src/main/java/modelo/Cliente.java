package modelo;

import jakarta.persistence.*;

@Entity
@NamedQuery(name= "Cliente.borrarByNif", query = "DELETE FROM Cliente WHERE nif = ?1")
@NamedQuery(name= "Cliente.ByNif", query = "SELECT DISTINCT e FROM Cliente e WHERE nif = ?1")
@NamedQuery(name= "Cliente.ListarClientes", query = "SELECT DISTINCT e FROM Cliente e")
@NamedQuery(name= "Cliente.ExisteCliente", query = "SELECT COUNT(1) FROM Cliente WHERE nif = ?1")
@NamedQuery(name= "Cliente.ModificarCliente", query = "SELECT COUNT(1) FROM Cliente WHERE nif = ?1")
@NamedQuery(name= "Cliente.ListarClientesByTipo", query = "SELECT DISTINCT e FROM Cliente e WHERE tipo = ?1")


public class Cliente {
    @Id
    @Column(name = "nif", nullable = false, length = 45)
    private String nif;
    @Basic
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic
    @Column(name = "domicilio", nullable = false, length = 45)
    private String domicilio;
    @Basic
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    @Basic
    @Column(name = "tipo", nullable = false)
    private String tipo;
    @Basic
    @Column(name = "descuento", nullable = true, precision = 0)
    private Float descuento;
    @Basic
    @Column(name = "cuota", nullable = true, precision = 0)
    private Float cuota;

    public Cliente(String nif, String nombre, String domicilio, String email, String tipo, Float descuento, Float cuota) {
        this.nif = nif;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.email = email;
        this.tipo = tipo;
        this.descuento = descuento;
        this.cuota = cuota;
    }

    public Cliente() {
    }


    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public Float getCuota() {
        return cuota;
    }

    public void setCuota(Float cuota) {
        this.cuota = cuota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (nif != null ? !nif.equals(cliente.nif) : cliente.nif != null) return false;
        if (nombre != null ? !nombre.equals(cliente.nombre) : cliente.nombre != null) return false;
        if (domicilio != null ? !domicilio.equals(cliente.domicilio) : cliente.domicilio != null) return false;
        if (email != null ? !email.equals(cliente.email) : cliente.email != null) return false;
        if (tipo != null ? !tipo.equals(cliente.tipo) : cliente.tipo != null) return false;
        if (descuento != null ? !descuento.equals(cliente.descuento) : cliente.descuento != null) return false;
        if (cuota != null ? !cuota.equals(cliente.cuota) : cliente.cuota != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nif != null ? nif.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (domicilio != null ? domicilio.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (descuento != null ? descuento.hashCode() : 0);
        result = 31 * result + (cuota != null ? cuota.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  "Nif = " + nif  + ",\n" +
                "Nombre = " + nombre + ",\n" +
                "Domicilio = " + domicilio + ",\n" +
                "Email = " + email + ",\n" +
                "TipoCliente = " + tipo + ",\n" +
                "Descuento = " + descuento + "€,\n" +
                "Cuota = " + cuota + "€,\n" ;
    }
}
