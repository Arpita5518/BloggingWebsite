package gist.daos;
import java.sql.*;
import gist.beans.Admin;
import gist.db.ConnectionProvider;


public class AdminDao {
public Admin find (String userid ,String password){
    Admin admin = null;
    try{
        Connection con = ConnectionProvider.getConnection();
        String sql = "select * from admin where userid=? and password=?";
        
        PreparedStatement smt = con.prepareStatement(sql);
        smt.setString(1, userid);
        smt.setString(2, password);
        ResultSet rs = smt.executeQuery();
        if(rs.next()){
            admin= new Admin();
            admin.setId(rs.getInt("id"));
            admin.setName(rs.getString("name"));
            admin.setUserid(rs.getString("userid"));
            admin.setPassword(rs.getString("password"));
        }
    }catch(Exception e){
        System.out.println("Error : " + e.getMessage());
    }
    return admin;
}

public Admin find (int id){
    Admin admin = null;
    try{
        Connection con = ConnectionProvider.getConnection();
        String sql = "select * from admin where id=?";
        PreparedStatement smt = con.prepareStatement(sql);
        smt.setInt(1, id);
        ResultSet rs = smt.executeQuery();
        if(rs.next()){
            admin= new Admin();
            admin.setId(rs.getInt("id"));
            admin.setName(rs.getString("name"));
            admin.setUserid(rs.getString("userid"));
            admin.setPassword(rs.getString("password"));
        }
    }catch(Exception e){
        System.out.println("Error : " + e.getMessage());
    }
    return admin;
}    

}
