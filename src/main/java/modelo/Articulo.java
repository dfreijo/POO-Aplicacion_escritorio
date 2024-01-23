package modelo;

import jakarta.persistence.*;

@Entity
@NamedQuery(name= "Articulo.borrarByCodigo", query = "DELETE FROM Articulo WHERE codigo = ?1")
@NamedQuery(name= "Articulo.byCodigo", query = "SELECT DISTINCT e FROM Articulo e WHERE codigo = ?1")
@NamedQuery(name= "Articulo.ListarArticulos", query = "SELECT DISTINCT e FROM Articulo e")
@NamedQuery(name= "Articulo.ExisteArticulo", query = "SELECT COUNT(1) FROM Articulo WHERE codigo = ?1")

public class Articulo {
    @Id
    @Column(name = "codigo", nullable = false, length = 45)
    private String codigo;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;
    @Basic
    @Column(name = "precio", nullable = false, precision = 2)
    private Float precio;
    @Basic
    @Column(name = "gastoEnvio", nullable = false, precision = 2)
    private Float gastoEnvio;
    @Basic
    @Column(name = "preparacion", nullable = false)
    private int preparacion;

    public Articulo() {}

    public Articulo(String codigo, String descripcion, Float precio, Float gastoEnvio, int preparacion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.gastoEnvio = gastoEnvio;
        this.preparacion = preparacion;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Float getGastoEnvio() {
        return gastoEnvio;
    }

    public void setGastoEnvio(Float gastoEnvio) {
        this.gastoEnvio = gastoEnvio;
    }

    public int getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(int preparacion) {
        this.preparacion = preparacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Articulo articulo = (Articulo) o;

        if (preparacion != articulo.preparacion) return false;
        if (codigo != null ? !codigo.equals(articulo.codigo) : articulo.codigo != null) return false;
        if (descripcion != null ? !descripcion.equals(articulo.descripcion) : articulo.descripcion != null)
            return false;
        if (precio != null ? !precio.equals(articulo.precio) : articulo.precio != null) return false;
        if (gastoEnvio != null ? !gastoEnvio.equals(articulo.gastoEnvio) : articulo.gastoEnvio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codigo != null ? codigo.hashCode() : 0;
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (precio != null ? precio.hashCode() : 0);
        result = 31 * result + (gastoEnvio != null ? gastoEnvio.hashCode() : 0);
        result = 31 * result + preparacion;
        return result;
    }

    @Override
    public String toString() {
        return  "Codigo = " + codigo + ",\n" +
                "Descripcion = " + descripcion + ",\n" +
                "Precio = " + precio + "€,\n" +
                "GastoEnvio = " + gastoEnvio + "€,\n" +
                "Preparacion = " + preparacion + "h,\n" ;
    }
}
