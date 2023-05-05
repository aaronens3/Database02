import javax.xml.transform.Result;
import java.sql.*;

public class ConexionBBDD {
    private static final String URL = "jdbc:mysql://localhost:3306/uf13";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static boolean existeTabla(String nombreTabla) throws SQLException {
        try (Connection con = getConexion()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM information_schema.tables WHERE table_name = '" + nombreTabla + "'");
            rs.next();
            return rs.getInt(1) > 0;
        }
    }

    public static void crearTabla(String nombreTabla) throws SQLException {
        try (Connection con = getConexion()) {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS productos2 (CODIGO_ARTICULO VARCHAR(10) PRIMARY KEY, SECCION VARCHAR(50) NOT NULL, NOMBRE VARCHAR(50) NOT NULL, PRECIO DOUBLE NOT NULL, PAIS VARCHAR(50) NOT NULL, FECHA DATE NOT NULL)");
            stmt.executeUpdate("INSERT INTO productos2 (CODIGO_ARTICULO, SECCION, NOMBRE, PRECIO, PAIS, FECHA) VALUES ('P001', 'ROPA', 'CAMISETA', 9.99, 'ESPAÑA', '2023-04-21')");
            stmt.executeUpdate("INSERT INTO productos2 (CODIGO_ARTICULO, SECCION, NOMBRE, PRECIO, PAIS, FECHA) VALUES ('P002', 'ELECTRÓNICA', 'SMARTPHONE', 599.99, 'FRANCIA', '2023-04-21')");
            stmt.executeUpdate("INSERT INTO productos2 (CODIGO_ARTICULO, SECCION, NOMBRE, PRECIO, PAIS, FECHA) VALUES ('P003', 'DEPORTES', 'RAQUETA', 29.90, 'ALEMANIA', '2023-04-21')");
            stmt.executeUpdate("INSERT INTO productos2 (CODIGO_ARTICULO, SECCION, NOMBRE, PRECIO, PAIS, FECHA) VALUES ('P004', 'JUGUETES', 'Licuadora', 14.99, 'ITALIA', '2023-04-21')");
            stmt.executeUpdate("INSERT INTO productos2 (CODIGO_ARTICULO, SECCION, NOMBRE, PRECIO, PAIS, FECHA) VALUES ('P005', 'HOGAR', 'LÁMPARA', 39.99, 'REINO UNIDO', '2023-04-21')");
        }
    }
}
