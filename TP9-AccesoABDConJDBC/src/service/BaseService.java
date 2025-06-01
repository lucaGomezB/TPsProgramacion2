package service;
/**
 *
 * @author lucaGomezB
 */
import dao.GenericDAO;
import java.util.List;
import java.util.Optional;

public abstract class BaseService<T, ID> implements GenericService<T, ID> {
    protected GenericDAO<T, ID> dao;
    
    public BaseService(GenericDAO<T, ID> dao) {
        this.dao = dao;
    }

    @Override
    public T create(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("La entidad a crear no puede ser nula.");
        }
        return dao.create(entity);
    }

    @Override
    public Optional<T> read(ID id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID para leer no puede ser nulo.");
        }
        return dao.read(id);
    }

    @Override
    public T update(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("La entidad a actualizar no puede ser nula.");
        }
        return dao.update(entity);
    }

    @Override
    public void delete(ID id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID para eliminar no puede ser nulo.");
        }
        dao.delete(id);
    }

    @Override
    public List<T> findAll() {
        return dao.findAll();
    }
}