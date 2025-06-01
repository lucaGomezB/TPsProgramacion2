package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import model.Producto;
import java.sql.Statement;
import java.math.BigDecimal;
import java.util.ArrayList;
/**
 *
 * @author lucaGomezB
 */
public class ProductoDAO extends BaseDAO<Producto, Integer> {

    public ProductoDAO() {
        super(Producto.class, "producto", "id");
    }

    @Override
    protected Producto mapResultSetToObject(ResultSet rs) throws SQLException {
        //Acá se construye un objeto Categoría a partir de lo obtenido en la consulta.
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        String descripcion = rs.getString("descripcion");
        BigDecimal precio = rs.getBigDecimal("precio");
        int cantidad = rs.getInt("cantidad");
        int id_categoria = rs.getInt("id_categoria");
        return new Producto(id, nombre, descripcion, precio, cantidad, id_categoria);
    }

    @Override
    protected PreparedStatement prepareStatementForInsert(Connection conn, Producto entity) throws SQLException {
        String sql = "INSERT INTO"+tableName+"(nombre, descripcion, precio, cantidad, id_categoria) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, entity.getNombre());
        pstmt.setString(2, entity.getDescripcion());
        pstmt.setBigDecimal(3, entity.getPrecio());
        pstmt.setInt(4, entity.getCantidad());
        pstmt.setInt(5, entity.getId_categoria());
        return pstmt;
    }

    @Override
    protected PreparedStatement prepareStatementForUpdate(Connection conn, Producto entity) throws SQLException {
        String sql = "UPDATE " + tableName + " SET " +
                     "nombre = ?, " +
                     "descripcion = ?, " +
                     "precio = ?, " +
                     "cantidad = ?, " +
                     "id_categoria = ? " +
                     "WHERE " + idColumnName + " = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, entity.getNombre());
        pstmt.setString(2, entity.getDescripcion());
        pstmt.setBigDecimal(3, entity.getPrecio());
        pstmt.setInt(4, entity.getCantidad());
        pstmt.setInt(5, entity.getId_categoria());
        pstmt.setInt(6, entity.getId());
        return pstmt;  
    }
    
    public List<Producto> listarPorCategoria(Connection conn, int idCategoria) throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName + " WHERE id_categoria = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idCategoria);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    productos.add(mapResultSetToObject(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar productos por categoría: " + e.getMessage());
            throw e;
        }
        return productos;
    }
    
    public boolean existeCategoria(Connection conn, int idCategoria) throws SQLException {
        String sql = "SELECT COUNT(*) FROM categoria WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idCategoria);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar si la categoría existe: " + e.getMessage());
            throw e;
        }
        return false;
    }
    
    public boolean existeNombre(Connection conn, String nombre) throws SQLException {
        String sql = "SELECT COUNT(*) FROM " + tableName + " WHERE nombre = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar si el nombre del producto existe: " + e.getMessage());
            throw e;
        }
        return false;
    }
}
