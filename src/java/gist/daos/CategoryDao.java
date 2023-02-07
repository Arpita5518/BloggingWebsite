package gist.daos;
import java.sql.*;
import gist.beans.Category;
import gist.db.ConnectionProvider;
import java.util.ArrayList;
public class CategoryDao {
    public boolean add(Category category){
        boolean status = false;
        try{
           Connection con = ConnectionProvider.getConnection();
           String sql = "insert into categories (name,description) values(?,?)";
           PreparedStatement smt = con.prepareStatement(sql);
           smt.setString(1, category.getName());
           smt.setString(2,category.getDescription());
           int n = smt.executeUpdate();
           if(n>0)
               status=true;
           con.close();
        }catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return status;
    }
    
    
 public boolean delete(int id){
        boolean status = false;
        try{
           Connection con = ConnectionProvider.getConnection();
           String sql = "delete from categories where id=?";
           PreparedStatement smt = con.prepareStatement(sql);
           smt.setInt(1, id);
           int n = smt.executeUpdate();
           if(n>0)
               status=true;
           con.close();
        }catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return status;
    }
       
    
public Category find(int id){
    Category category=null;
    try{
        Connection con = ConnectionProvider.getConnection();
        String sql = "select * from categories where id=?";
        PreparedStatement smt = con.prepareStatement(sql);
        smt.setInt(1, id);
        ResultSet rs = smt.executeQuery();
        if(rs.next())
        {
         category = new Category();
         category.setId(rs.getInt("id"));
         category.setName(rs.getString("name"));
         category.setDescription(rs.getString("description"));
        }
    }catch(Exception e){
        System.out.println("Error " + e.getMessage());
    }
    return category;
}

public ArrayList<Category> findAll(){
    ArrayList<Category> catList = new ArrayList();
    try{
        Connection con = ConnectionProvider.getConnection();
        String sql = "select * from categories";
        PreparedStatement smt = con.prepareStatement(sql);
        ResultSet rs = smt.executeQuery();
        while(rs.next())
        {
          Category category  = new Category();
         category = new Category();
         category.setId(rs.getInt("id"));
         category.setName(rs.getString("name"));
         category.setDescription(rs.getString("description"));
         
         catList.add(category);
        }
    }catch(Exception e){
        System.out.println("Error " + e.getMessage());
    }
    return catList;
}


public ArrayList<Category> findByBloggerId(int bloggerId){
    ArrayList<Category> catList = new ArrayList();
    try{
        Connection con = ConnectionProvider.getConnection();
        String sql = "select * from categories where id in (select categoryId from blogger_category where bloggerId=?)";
        PreparedStatement smt = con.prepareStatement(sql);
        smt.setInt(1, bloggerId);
        ResultSet rs = smt.executeQuery();
        while(rs.next())
        {
          Category category  = new Category();
         category = new Category();
         category.setId(rs.getInt("id"));
         category.setName(rs.getString("name"));
         category.setDescription(rs.getString("description"));
         
         catList.add(category);
        }
    }catch(Exception e){
        System.out.println("Error " + e.getMessage());
    }
    return catList;
}


public ArrayList<Category> findByBlogId(int blogId){
    ArrayList<Category> catList = new ArrayList();
    try{
        Connection con = ConnectionProvider.getConnection();
        String sql = "select * from categories where id in (select categoryId from blog_category where blogId=?)";
        PreparedStatement smt = con.prepareStatement(sql);
        smt.setInt(1, blogId);
        ResultSet rs = smt.executeQuery();
        while(rs.next())
        {
          Category category  = new Category();
         category = new Category();
         category.setId(rs.getInt("id"));
         category.setName(rs.getString("name"));
         category.setDescription(rs.getString("description"));
         
         catList.add(category);
        }
    }catch(Exception e){
        System.out.println("Error " + e.getMessage());
    }
    return catList;
}

}
