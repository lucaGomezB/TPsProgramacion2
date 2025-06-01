package service;

import dao.GenericDAO;
import dao.PedidoDAO;
import model.Pedido;
import model.Producto;

/**
 *
 * @author lucaGomezB
 */
public class PedidoService extends BaseService<Pedido, Integer>{
    public PedidoService(PedidoDAO dao) {
        super(dao);
    }
}
