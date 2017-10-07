
package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Reginaldo
 */
public class ConnectionFactory {

    private String url;
    private String password;
    private String user;
    private String driver;
    private static ConnectionFactory instance = null;

    public ConnectionFactory() {
        this.url = "jdbc:postgresql://localhost:5432/tcc";
        this.password = "123456";
        this.user = "postgres";
        this.driver = "org.postgresql.Driver";
    }

    public static ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        try {
            Class.forName(this.driver);
            return DriverManager.getConnection(this.url, this.user, this.password);
        } catch (ClassNotFoundException ex){
            throw new SQLException(ex);
        }
    }
   
    
} 
