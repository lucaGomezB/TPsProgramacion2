package pruebaconexionadb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import config.DatabaseConnection;
/**
 *
 * @author lucaGomezB
 */
public class TestConexion {
    public static void main(String[] args) {
        // Como buena práctica se usa try-with-resources
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null) {
                System.out.println("Conexión exitosa!");
                String sql = "SELECT * FROM Productos";
                // Acá se crea la consulta con preparedStatement
                try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
                    System.out.println("Listado de productos : ");
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String nombre = rs.getString("nombre");
                        double precio = rs.getDouble("precio");
                        System.out.println(" ID = " + id + " | Nombre = " + nombre + " | Precio = " + precio);
                    }
                } catch (SQLException e) {
                    System.out.println("Excepción al recuperar los datos. " + e.getMessage());
                }
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar la base de datos : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
