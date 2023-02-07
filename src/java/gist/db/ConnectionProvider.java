package gist.db;
import java.sql.*;

public class ConnectionProvider {
public static Connection getConnection(){
    Connection con = null;
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
       }catch(Exception e){
        System.out.println("Connection error :  " + e.getMessage());
    }
    
return con;
}    
}
