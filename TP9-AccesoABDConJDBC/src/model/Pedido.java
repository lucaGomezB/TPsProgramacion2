package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.Date;
/**
 *
 * @author lucaGomezB
 */
public class Pedido {
    private int id;
    private Date fecha;
    private ArrayList<ItemPedido> items;
    private BigDecimal total;

    public Pedido(int id, Date fecha, BigDecimal total) {
        this.id = id;
        this.fecha = fecha;
        this.items = new ArrayList<>();
        this.total = calcularTotal(this.items);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<ItemPedido> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemPedido> items) {
        this.items = items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    private BigDecimal calcularTotal(ArrayList<ItemPedido> items){
        BigDecimal total = BigDecimal.ZERO;
        if (items != null) {
            for (ItemPedido item : items) {
                if (item != null && item.getSubtotal() != null) {
                    total = total.add(item.getSubtotal());
                }else {
                     System.err.println("Advertencia: ItemPedido nulo o subtotal nulo encontrado. Se ignorará.");
                }
            }
        }
        return total;
    }
}
