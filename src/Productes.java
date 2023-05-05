import java.sql.Date;

public class Productes {

    private String Codigo_articulo;
    private String Seccion;
    private String Nombre;
    private double Precio;
    private String Pais;
    private java.sql.Date Fecha;

    public Productes(String codigoArticulo, String seccion, String nombre, double precio, String pais, Date fecha) {

    }

    public String getCodigo_articulo() {
        return Codigo_articulo;
    }

    public void setCodigo_articulo(String codigo_articulo) {
        Codigo_articulo = codigo_articulo;
    }

    public String getSeccion() {
        return Seccion;
    }

    public void setSeccion(String seccion) {
        Seccion = seccion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }
}
