import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

import static java.sql.DriverManager.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        ArrayList<Productes> productes = new ArrayList<>();
        try (Connection con = ConexionBBDD.getConexion()) {
            Statement stmt = con.createStatement();




        if (!ConexionBBDD.existeTabla("productos2")) {
            ConexionBBDD.crearTabla("productos2");
        }
            ResultSet rs = stmt.executeQuery("SELECT * FROM productos2");




            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM productos2");

            String query = "SELECT * FROM productos2 WHERE SECCION = ? AND PAIS = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, "DEPORTES");
            pstmt.setString(2, "ALEMANIA");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("CODIGO_ARTICULO: " + rs.getString("CODIGO_ARTICULO"));
                System.out.println("SECCION: " + rs.getString("SECCION"));
                System.out.println("NOMBRE: " + rs.getString("NOMBRE"));
                System.out.println("PRECIO: " + rs.getDouble("PRECIO"));
                System.out.println("PAIS: " + rs.getString("PAIS"));
                System.out.println("FECHA: " + rs.getDate("FECHA"));
                System.out.println();
            }

            String query2 = "UPDATE productos2 SET PRECIO = ? WHERE SECCION = ? AND PAIS = ?";
            PreparedStatement pstmt2 = con.prepareStatement(query2);

            pstmt2.setDouble(1, 9999);
            pstmt2.setString(2, "DEPORTES");
            pstmt2.setString(3, "ALEMANIA");

            int filasAfectadas = pstmt2.executeUpdate();

            System.out.println("Filas afectadas: " + filasAfectadas);


            String query3 = "SELECT * FROM productos2 ";
            pstmt = con.prepareStatement(query3);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                productes.add(new Productes(rs.getString("CODIGO_ARTICULO"), rs.getString("SECCION"), rs.getString("NOMBRE"), rs.getDouble("PRECIO"), rs.getString("PAIS"), rs.getDate("FECHA")));

            }

            System.out.println("Productes del arraylist: ");
            for (Productes p : productes) {
                System.out.println("CODIGO_ARTICULO: " + p.getCodigo_articulo());
                System.out.println("SECCION: " + p.getSeccion());
                System.out.println("NOMBRE: " + p.getNombre());
                System.out.println("PRECIO: " + p.getPrecio());
                System.out.println("PAIS: " + p.getPais());
                System.out.println("FECHA: " + p.getFecha());
                System.out.println();
            }


        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (ConexionBBDD.getConexion() != null) {
                try {
                    ConexionBBDD.getConexion().close();
                } catch (SQLException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
}
}
