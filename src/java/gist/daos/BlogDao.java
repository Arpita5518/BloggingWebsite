
package gist.daos;
import gist.beans.Blog;
import gist.db.ConnectionProvider;
import java.sql.*;
import java.util.ArrayList;

public class BlogDao {
public boolean add(Blog blog, String[] catIds){
    boolean status= false;
        Connection con = ConnectionProvider.getConnection();
       if(con!=null){
        try{
        con.setAutoCommit(false);
        String sql1 = "insert into blogs(title,description,image,date,bloggerid) values(?,?,?,?,?)";
        PreparedStatement smt1 = con.prepareStatement(sql1);
        smt1.setString(1,blog.getTitle());
        smt1.setString(2, blog.getDescription());
        smt1.setString(3, blog.getImage());
        smt1.setString(4, blog.getDate());
        smt1.setInt(5, blog.getBloggerId());
        
            System.out.println("Date : " + blog.getDate());
        int n = smt1.executeUpdate();
        
            System.out.println("1");
        if(n>0){
            String sql2 = "select id from blogs order by id desc limit 1";
            PreparedStatement smt2 = con.prepareStatement(sql2);
            ResultSet rs = smt2.executeQuery();
            int blogId = 0;
            if(rs.next()){
                blogId = rs.getInt("id");
            }
            System.out.println("2");
            
          //insert into Relational table
          for(String cid : catIds){
              String sql3 = "insert into blog_category(blogId,categoryId) values(?,?)";
              PreparedStatement smt3 = con.prepareStatement(sql3);
              smt3.setInt(1, blogId);
              smt3.setInt(2, Integer.parseInt(cid));
              smt3.executeUpdate();
              System.out.println("loop...");
          }
        }
        con.commit();
        status=true;
        con.close();
        }catch(Exception e){
            System.out.println("Error : " + e.getMessage());
           try{ con.rollback();}catch(SQLException se){System.out.println("Sql error : " +se.getMessage());}
        }
       }
       else 
            System.out.println("Connection cannot be esablised! Please checck Connection Provider..");
        return status;
    
}    
public Blog findById(int id){
   Blog blog = null;
   try{
       Connection con = ConnectionProvider.getConnection();
       String sql = "select id,title,description, DATE_FORMAT(date,'%D %b, %Y')\"date\",image,bloggerId,status from blogs where id=?";
       PreparedStatement smt = con.prepareStatement(sql);
       smt.setInt(1, id);
       ResultSet rs = smt.executeQuery();
       if(rs.next()){
           blog = new Blog();
           blog.setId(rs.getInt("id"));
           blog.setTitle(rs.getString("title"));
           blog.setDescription(rs.getString("description"));
           blog.setDate(rs.getString("date"));
           blog.setImage(rs.getString("image"));
           blog.setBloggerId(rs.getInt("bloggerId"));
           blog.setStatus(rs.getString("status"));
       }
       con.close();
   }catch(Exception e){
       System.out.println("Error : " + e.getMessage());
   }
   return blog;
}

public ArrayList<Blog> findAll(){
   ArrayList<Blog> blogList = new ArrayList();
   try{
       Connection con = ConnectionProvider.getConnection();
       String sql = "select id,title,description, DATE_FORMAT(date,'%D %b, %Y')\"date\",image,bloggerId,status from blogs";
       PreparedStatement smt = con.prepareStatement(sql);
       ResultSet rs = smt.executeQuery();
       while(rs.next()){
           Blog blog = new Blog();
           blog.setId(rs.getInt("id"));
           blog.setTitle(rs.getString("title"));
           blog.setDescription(rs.getString("description"));
           blog.setDate(rs.getString("date"));
           blog.setImage(rs.getString("image"));
           blog.setBloggerId(rs.getInt("bloggerId"));
            blog.setStatus(rs.getString("status"));
           
           blogList.add(blog);
       }
       con.close();
   }catch(Exception e){
       System.out.println("Error : " + e.getMessage());
   }
   return blogList;
  
}



public ArrayList<Blog> findRecentPost(int num){
   ArrayList<Blog> blogList = new ArrayList();
   try{
       Connection con = ConnectionProvider.getConnection();
       String sql = "select id,title,description, DATE_FORMAT(date,'%D %b, %Y')\"date\",image,bloggerId,status from blogs order by id desc limit ?";
       PreparedStatement smt = con.prepareStatement(sql);
       smt.setInt(1, num);
       ResultSet rs = smt.executeQuery();
       while(rs.next()){
           Blog blog = new Blog();
           blog.setId(rs.getInt("id"));
           blog.setTitle(rs.getString("title"));
           blog.setDescription(rs.getString("description"));
           blog.setDate(rs.getString("date"));
           blog.setImage(rs.getString("image"));
           blog.setBloggerId(rs.getInt("bloggerId"));
            blog.setStatus(rs.getString("status"));
           
           blogList.add(blog);
       }
       con.close();
   }catch(Exception e){
       System.out.println("Error : " + e.getMessage());
   }
   return blogList;
  
}

public ArrayList<Blog> findByCategoryId(int catid){
   ArrayList<Blog> blogList = new ArrayList();
   try{
       Connection con = ConnectionProvider.getConnection();
       String sql = "select id,title,description, DATE_FORMAT(date,'%D %b, %Y')\"date\",image,bloggerId,status from blogs where id in(select blogId from blog_category where categoryId=?)";
       PreparedStatement smt = con.prepareStatement(sql);
       smt.setInt(1, catid);
       ResultSet rs = smt.executeQuery();
       while(rs.next()){
           Blog blog = new Blog();
           blog.setId(rs.getInt("id"));
           blog.setTitle(rs.getString("title"));
           blog.setDescription(rs.getString("description"));
           blog.setDate(rs.getString("date"));
           blog.setImage(rs.getString("image"));
           blog.setBloggerId(rs.getInt("bloggerId"));
            blog.setStatus(rs.getString("status"));
           blogList.add(blog);
       }
       con.close();
   }catch(Exception e){
       System.out.println("Error : " + e.getMessage());
   }
   return blogList;
   
}

public ArrayList<Blog> findByBloggerId(int bloggerId){
    ArrayList<Blog> blogList = new ArrayList();
   try{
       Connection con = ConnectionProvider.getConnection();
       String sql = "select id,title,description, DATE_FORMAT(date,'%D %b, %Y')\"date\",image,bloggerId,status from blogs where bloggerId=?";
       PreparedStatement smt = con.prepareStatement(sql);
       smt.setInt(1, bloggerId);
       
       ResultSet rs = smt.executeQuery();
       while(rs.next()){
           Blog blog = new Blog();
           blog.setId(rs.getInt("id"));
           blog.setTitle(rs.getString("title"));
           blog.setDescription(rs.getString("description"));
           blog.setDate(rs.getString("date"));
           blog.setImage(rs.getString("image"));
           blog.setBloggerId(rs.getInt("bloggerId"));
            blog.setStatus(rs.getString("status"));
           blogList.add(blog);
       }
       con.close();
   }catch(Exception e){
       System.out.println("Error : " + e.getMessage());
   }
   return blogList;
}

public boolean updateStatus(int id, String newStatus){
    boolean status=false;
    try{
        Connection con =ConnectionProvider.getConnection();
        String sql = "update blogs set status=? where id=?";
        PreparedStatement smt = con.prepareStatement(sql);
        smt.setString(1, newStatus);
        smt.setInt(2,id);
        int n = smt.executeUpdate();
        if(n>0)
            status=true;
    }catch(Exception e){
        System.out.println("error : " +e.getMessage());
    }
    
    return status;
}

}
