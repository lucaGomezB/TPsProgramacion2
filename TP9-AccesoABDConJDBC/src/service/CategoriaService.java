package service;
/**
 *
 * @author lucaGomezB
 */
import model.Categoria;
import dao.CategoriaDAO;
import dao.GenericDAO;
import java.util.List;
import java.util.Optional;

public class CategoriaService extends BaseService<Categoria, Integer> {
    private CategoriaDAO categoriaDAOimpl;
    public CategoriaService(CategoriaDAO categoriaDAO) {
        super(categoriaDAO);
        this.categoriaDAOimpl = categoriaDAO;
    }
    @Override
    public Categoria create(Categoria categoria) {
        String nombreNormalizado = categoria.getNombre().trim();
        if (categoria == null) {
            throw new IllegalArgumentException("La categoría a crear no puede ser nula.");
        }
        if (categoria.getNombre() == null || nombreNormalizado.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la categoría no puede estar vacío.");
        }
        if (categoria.getDescripcion() != null && categoria.getDescripcion().length() > 255) {
            throw new IllegalArgumentException("La descripción de la categoría es demasiado larga (máx 255 caracteres).");
        }
        if (this.categoriaDAOimpl.existeNombre(nombreNormalizado)) {
            throw new IllegalArgumentException("Ya existe una categoría con el nombre: '" + nombreNormalizado + "'.");
        }
        return dao.create(categoria);
    }
    
    @Override
    public Categoria update(Categoria categoria) {
        Optional<Categoria> existingCategory = super.read(categoria.getId());
        if (existingCategory.isEmpty()) {
            throw new IllegalArgumentException("No se encontró la categoría con ID " + categoria.getId() + " para actualizar.");
        }
        if (categoria.getNombre() == null || categoria.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la categoría no puede estar vacío.");
        }
        if (categoria.getDescripcion() != null && categoria.getDescripcion().length() > 255) {
            throw new IllegalArgumentException("La descripción de la categoría es demasiado larga (máx 255 caracteres).");
        }
        Categoria categoriaToUpdate = existingCategory.get();
        categoriaToUpdate.setNombre(categoria.getNombre().trim());
        categoriaToUpdate.setDescripcion(categoria.getDescripcion() != null ? categoria.getDescripcion().trim() : null);
        return dao.update(categoriaToUpdate);
    }
    @Override
    public void delete(Integer id) {
        super.delete(id);
    }
    public List<Categoria> obtenerCategoriasOrdenadasPorNombre() {
        List<Categoria> categorias = dao.findAll();
        categorias.sort((c1, c2) -> c1.getNombre().compareToIgnoreCase(c2.getNombre()));
        return categorias;
    }
}
