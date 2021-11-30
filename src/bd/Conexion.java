
package bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Tamara Gutierrez
 */
public class Conexion {
    
     public Connection obtenerConexion(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/videojuegos","root","");
            System.out.println("Conexión Exitosa");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
        
        return connection;
        
    }
    
}
