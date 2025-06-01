package dao;

import com.mysql.cj.xdevapi.Statement;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import model.Pedido;

/**
 *
 * @author lucaGomezB
 */
public class PedidoDAO extends BaseDAO<Pedido, Integer>{
    public PedidoDAO() {
        super(Pedido.class, "pedidos", "id");
    }
    @Override
    protected Pedido mapResultSetToObject(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        Date fecha = rs.getDate("fecha");
        BigDecimal total = rs.getBigDecimal("total");
        return new Pedido(id,fecha,total);
    }

    @Override
    protected PreparedStatement prepareStatementForInsert(Connection conn, Pedido entity) throws SQLException {
        String sql = "INSERT INTO pedidos (total) VALUES (?)";
        PreparedStatement pstmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
        pstmt.setBigDecimal(0, entity.getTotal());
        return pstmt;
    }

    @Override
    protected PreparedStatement prepareStatementForUpdate(Connection conn, Pedido entity) throws SQLException {
        String sql = "UPDATE pedidos SET total = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setBigDecimal(0, entity.getTotal());
        return pstmt;
    }
    
}
