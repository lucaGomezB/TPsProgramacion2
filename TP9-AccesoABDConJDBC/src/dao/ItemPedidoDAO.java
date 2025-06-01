package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.ItemPedido;

/**
 *
 * @author lucaGomezB
 */
public class ItemPedidoDAO extends BaseDAO<ItemPedido,Integer> {

    public ItemPedidoDAO(Class<ItemPedido> entityClass, String tableName, String idColumnName) {
        super(entityClass, tableName, idColumnName);
    }

    @Override
    protected ItemPedido mapResultSetToObject(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int pedido_id = rs.getInt("pedido_id");
        int producto_id = rs.getInt("producto_id");
        int cantidad = rs.getInt("cantidad");
        BigDecimal subtotal = rs.getBigDecimal("subtotal");
        return new ItemPedido(id,pedido_id,producto_id,cantidad,subtotal);
    }

    @Override
    protected PreparedStatement prepareStatementForInsert(Connection conn, ItemPedido entity) throws SQLException {
        String sql = "INSERT INTO items_pedido (pedido_id, producto_id, cantidad, subtotal) VALUES (?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setInt(1, entity.getId_pedido());
        pstmt.setInt(2, entity.getId_producto());
        pstmt.setInt(3, entity.getCantidad());
        pstmt.setBigDecimal(4, entity.getSubtotal());
        return pstmt;
    }

    @Override
    protected PreparedStatement prepareStatementForUpdate(Connection conn, ItemPedido entity) throws SQLException {
        String sql = "UPDATE items_pedido SET pedido_id = ?, producto_id = ?, cantidad = ?, subtotal = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, entity.getId_pedido());
        pstmt.setInt(2, entity.getId_producto());
        pstmt.setInt(3, entity.getCantidad());
        pstmt.setBigDecimal(4, entity.getSubtotal());
        return pstmt;
    }
    
}
