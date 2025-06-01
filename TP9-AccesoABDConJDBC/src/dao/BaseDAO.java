
package dao;

/**
 *
 * @author lucaGomezB
 */
// src/main/java/com/tuapp/dao/BaseDAO.java
import config.DatabaseConnection; // Necesitarás una clase para manejar la conexión
import java.sql.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class BaseDAO<T, ID> implements GenericDAO<T, ID> {

    protected Connection connection;
    protected Class<T> entityClass; // El tipo de entidad que manejará este DAO
    protected String tableName;
    protected String idColumnName;

    public BaseDAO(Class<T> entityClass, String tableName, String idColumnName) {
        this.entityClass = entityClass;
        this.tableName = tableName;
        this.idColumnName = idColumnName;
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            System.err.println("Error al obtener la conexión a la base de datos: " + e.getMessage());
            throw new RuntimeException("No se pudo establecer la conexión a la base de datos.", e);
        }
    }
    protected abstract T mapResultSetToObject(ResultSet rs) throws SQLException;
    protected abstract PreparedStatement prepareStatementForInsert(Connection conn, T entity) throws SQLException;
    protected abstract PreparedStatement prepareStatementForUpdate(Connection conn, T entity) throws SQLException;

    @Override
    public T create(T entity) {
        String sql = "";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = prepareStatementForInsert(connection, entity);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("La creación de la entidad falló, no se afectaron filas.");
            }

            // Si la base de datos soporta auto-incremento de ID
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    // Intenta obtener el ID generado y establecerlo en el objeto entity
                    // Esto asume que el ID es un int o long. Adapta si es otro tipo.
                    try {
                        Method setIdMethod = entityClass.getMethod("set" + capitalize(idColumnName), generatedKeys.getObject(1).getClass());
                        setIdMethod.invoke(entity, generatedKeys.getObject(1));
                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                        System.err.println("Advertencia: No se pudo establecer el ID generado en el objeto. " + e.getMessage());
                    }
                }
            }
            return entity;
        } catch (SQLException e) {
            System.err.println("Error al crear la entidad: " + e.getMessage());
            throw new RuntimeException("Error en la base de datos al crear entidad.", e);
        } finally {
            closeResources(pstmt, rs);
        }
    }

    @Override
    public Optional<T> read(ID id) {
        String sql = "SELECT * FROM " + tableName + " WHERE " + idColumnName + " = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setObject(1, id); // Asume que el ID puede ser establecido como Object
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return Optional.of(mapResultSetToObject(rs));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            System.err.println("Error al leer la entidad con ID " + id + ": " + e.getMessage());
            throw new RuntimeException("Error en la base de datos al leer entidad.", e);
        } finally {
            closeResources(pstmt, rs);
        }
    }

    @Override
    public T update(T entity) {
        // El SQL se construirá en prepareStatementForUpdate
        PreparedStatement pstmt = null;
        try {
            pstmt = prepareStatementForUpdate(connection, entity);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("La actualización de la entidad falló, no se encontró el ID o no se modificaron datos.");
            }
            return entity;
        } catch (SQLException e) {
            System.err.println("Error al actualizar la entidad: " + e.getMessage());
            throw new RuntimeException("Error en la base de datos al actualizar entidad.", e);
        } finally {
            closeResources(pstmt, null);
        }
    }

    @Override
    public void delete(ID id) {
        String sql = "DELETE FROM " + tableName + " WHERE " + idColumnName + " = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setObject(1, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                System.out.println("No se encontró la entidad con ID " + id + " para eliminar.");
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar la entidad con ID " + id + ": " + e.getMessage());
            throw new RuntimeException("Error en la base de datos al eliminar entidad.", e);
        } finally {
            closeResources(pstmt, null);
        }
    }

    @Override
    public List<T> findAll() {
        List<T> entities = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                entities.add(mapResultSetToObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar todas las entidades de " + tableName + ": " + e.getMessage());
            throw new RuntimeException("Error en la base de datos al listar entidades.", e);
        } finally {
            closeResources(pstmt, rs);
        }
        return entities;
    }
    
    public boolean existeNombre(String nombre) {
        String sql = "SELECT COUNT(*) FROM " + tableName + " WHERE nombre = ?"; // Acá casi permito inyecciones SQL sin querer xd, casi me olvido de usar prepared statements.
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, nombre);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
            return false;
        } catch (SQLException e) {
            System.err.println("Error al verificar la existencia del nombre '" + nombre + "' en la tabla " + tableName + ": " + e.getMessage());
            throw new RuntimeException("Error en la base de datos al verificar existencia por nombre.", e);
        } finally {
            closeResources(pstmt, rs);
        }
    }

    protected void closeResources(Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            // Si la conexión se cierra acá, cada operación de DAO abrirá y cerrará la conexión.
        } catch (SQLException e) {
            System.err.println("Error al cerrar recursos JDBC: " + e.getMessage());
        }
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}