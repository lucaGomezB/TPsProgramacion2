package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author lucaGomezB
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/db";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    static {
        try{
            //Se carga el dtiver JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            throw new RuntimeException("Ha ocurrido la siguiente excepción : No se encontró el driver JDBC.", e);
        }
    }
    
    /*Acá se obtiene la conexión a la BD, 
    retorna Connection si la conexión es exitosa, sino
    tira la SQLException al haber un problema en la conexión.*/
    
    public static Connection getConnection() throws SQLException{
        //Doble validación para asegurar que las credenciales no estén vacías.
        if(URL == null || URL.isEmpty() || USER == null || USER.isEmpty() || PASSWORD == null){
            throw new SQLException("Configuración de la base de datos incompleta o inválida");
        }
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
