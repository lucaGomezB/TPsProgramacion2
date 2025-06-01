package config;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author lucaGomezB
 */
public class DatabaseConnectionPool {
    private static final HikariConfig config = new HikariConfig();
}
