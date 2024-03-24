package config;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class dbConnector {
    
    private Connection connect;
    
    public dbConnector(){
            try{
                
                connect = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/lawtest", "root", "");
                
            }catch(SQLException ex){
                    System.out.println("Can't connect to database"+ex.getMessage());
            }
        }
    public ResultSet getData(String sql) throws SQLException{
    
        Statement statement = connect.createStatement();
        ResultSet rst = statement.executeQuery(sql);
        return rst;
    
    }
    
}
