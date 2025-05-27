package com.mycompany.tp8.genericos;
import java.time.LocalDate;
import java.util.Comparator;
/**
 *
 * @author lucaGomezB
 */
public class ComparadorPedidosPorFecha implements Comparator<Pedido> {
    @Override
    public int compare(Pedido pedido1, Pedido pedido2) {
        // Compara las fechas de los dos pedidos.
        // LocalDate.compareTo() ya devuelve un int apropiado para el Comparator.
        return pedido1.getFecha().compareTo(pedido2.getFecha());
    }
}