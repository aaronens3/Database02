import javax.xml.transform.Result;
import java.sql.*;

import static java.sql.DriverManager.*;

public class Main {
    public static void main(String[] args) {
        try (Connection con = ConexionBBDD.getConexion()) {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM productos");

            while (rs.next()) {
                System.out.println("CODIGO_ARTICULO: " + rs.getString("CODIGO_ARTICULO"));
                System.out.println("SECCION: " + rs.getString("SECCION"));
                System.out.println("NOMBRE: " + rs.getString("NOMBRE"));
                System.out.println("PRECIO: " + rs.getDouble("PRECIO"));
                System.out.println("PAIS: " + rs.getString("PAIS"));
                System.out.println("FECHA: " + rs.getDate("FECHA"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}