package model;

import java.math.BigDecimal;

/**
 *
 * @author lucaGomezB
 */
public class ItemPedido {
    private int id;
    private int id_pedido;
    private int id_producto;
    private int cantidad;
    private BigDecimal subtotal;

    public ItemPedido(int id, int id_pedido, int id_producto, int cantidad, BigDecimal subtotal) {
        this.id = id;
        this.id_pedido = id_pedido;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        BigDecimal cantidadBigDecimal = new BigDecimal(cantidad);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
    
    
    
    
}
