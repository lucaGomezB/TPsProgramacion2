package dao;
/**
 *
 * @author lucaGomezB
 */
import model.Categoria; // Importa tu clase Categoria del paquete model
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoriaDAO extends BaseDAO<Categoria, Integer> {

    public CategoriaDAO() {
        super(Categoria.class, "categoria", "id"); // Nombre de la tabla y columna ID
    }

    @Override
    protected Categoria mapResultSetToObject(ResultSet rs) throws SQLException {
        //Acá se construye un objeto Categoría a partir de lo obtenido en la consulta.
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        String descripcion = rs.getString("descripcion");
        return new Categoria(id, nombre, descripcion);
    }

    @Override
    protected PreparedStatement prepareStatementForInsert(Connection conn, Categoria categoria) throws SQLException {
        String sql = "INSERT INTO categorias (nombre, descripcion) VALUES (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, categoria.getNombre());
        pstmt.setString(2, categoria.getDescripcion());
        return pstmt;
    }

    @Override
    protected PreparedStatement prepareStatementForUpdate(Connection conn, Categoria categoria) throws SQLException {
        String sql = "UPDATE categorias SET nombre = ?, descripcion = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, categoria.getNombre());
        pstmt.setString(2, categoria.getDescripcion());
        pstmt.setInt(3, categoria.getId()); // Asume que la entidad ya tiene el ID
        return pstmt;
    }
    
    
}
