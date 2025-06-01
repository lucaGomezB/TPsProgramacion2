package service;

import config.DatabaseConnection;
import dao.GenericDAO;
import model.Producto;
import dao.ProductoDAO;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author lucaGomezB
 */
public class ProductoService extends BaseService<Producto, Integer>{
    private final ProductoDAO productoDAO;
    public ProductoService(ProductoDAO dao) {
        super(dao);
        this.productoDAO = dao;
    }
    
    @Override
    public Producto create(Producto producto) {
        String nombreNormalizado = producto.getNombre();
        if (producto == null) {
            throw new IllegalArgumentException("El producto a crear no puede ser nulo.");
        }
        if (producto.getNombre() == null || nombreNormalizado.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
        }
        nombreNormalizado = producto.getNombre().trim();
        if (producto.getDescripcion() != null && producto.getDescripcion().length() > 255) {
            throw new IllegalArgumentException("La descripción del producto es demasiado larga (máx 255 caracteres).");
        }
        if (producto.getPrecio() == null || producto.getPrecio().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El precio del producto debe ser mayor a 0.");
        }
        if (producto.getCantidad() <= 0) {
            throw new IllegalArgumentException("La cantidad del producto debe ser mayor a 0.");
        }
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);
            if (this.productoDAO.existeNombre(conn, nombreNormalizado)) {
                throw new IllegalArgumentException("Ya existe un producto con el nombre: '" + nombreNormalizado + "'.");
            }

            // Validate category ID
            if (producto.getId_categoria() <= 0) {
                throw new IllegalArgumentException("El ID de categoría no es válido.");
            }
            if (!this.productoDAO.existeCategoria(conn, producto.getId_categoria())) {
                throw new IllegalArgumentException("La categoría con ID " + producto.getId_categoria() + " no existe.");
            }
            Producto productoCreado = dao.create(producto);
            conn.commit();
            return productoCreado;
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException rbEx) {
                    System.err.println("Error al realizar rollback: " + rbEx.getMessage());
                }
            }
            System.err.println("Error al crear el producto: " + e.getMessage());
            throw new RuntimeException("Error en la operación de base de datos al crear el producto.", e);
        } catch (IllegalArgumentException e) {
            // Rollback if a validation fails that doesn't involve SQL but interrupts transaction
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException rbEx) {
                    System.err.println("Error al realizar rollback: " + rbEx.getMessage());
                }
            }
            throw e; // Re-throw the validation exception
        } finally {
            // Always close the connection
            if (conn != null) {
                try {
                    conn.setAutoCommit(true); // Reset auto-commit to default
                    conn.close();
                } catch (SQLException closeEx) {
                    System.err.println("Error al cerrar la conexión: " + closeEx.getMessage());
                }
            }
        }
    }
    
    @Override
    public Producto update(Producto producto) {
        Optional<Producto> existingCategory = super.read(producto.getId());
        if (existingCategory.isEmpty()) {
            throw new IllegalArgumentException("No se encontró la categoría con ID " + producto.getId() + " para actualizar.");
        }
        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la categoría no puede estar vacío.");
        }
        if (producto.getDescripcion() != null && producto.getDescripcion().length() > 255) {
            throw new IllegalArgumentException("La descripción de la categoría es demasiado larga (máx 255 caracteres).");
        }
        Producto productoToUpdate = existingCategory.get();
        productoToUpdate.setNombre(producto.getNombre().trim());
        productoToUpdate.setDescripcion(producto.getDescripcion() != null ? producto.getDescripcion().trim() : null);
        return dao.update(productoToUpdate);
    }
    
    @Override
    public void delete(Integer id) {
        super.delete(id);
    }
    public List<Producto> obtenerProductosOrdenadasPorNombre() {
        List<Producto> productos = dao.findAll();
        productos.sort((c1, c2) -> c1.getNombre().compareToIgnoreCase(c2.getNombre()));
        return productos;
    }
}
