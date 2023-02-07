package gist.daos;
import java.sql.*;
import gist.db.ConnectionProvider;
import gist.beans.Blogger;
import java.util.ArrayList;

public class BloggerDao {
    public boolean add(Blogger blogger,String catIds[]) {
        boolean status= false;
        Connection con = ConnectionProvider.getConnection();
       if(con!=null){
        try{
        con.setAutoCommit(false);
        String sql1 = "insert into blogger(name,contact,userid,password,image,address)values(?,?,?,?,?,?)";
        PreparedStatement smt1 = con.prepareStatement(sql1);
        smt1.setString(1,blogger.getName());
        smt1.setString(2, blogger.getContact());
        smt1.setString(3, blogger.getUserid());
        smt1.setString(4, blogger.getPassword());
        smt1.setString(5, blogger.getImage());
        smt1.setString(6, blogger.getAddress());
        int n = smt1.executeUpdate();
        if(n>0){
            String sql2 = "select id from blogger order by id desc limit 1";
            PreparedStatement smt2 = con.prepareStatement(sql2);
            ResultSet rs = smt2.executeQuery();
            int bloggerId = 0;
            if(rs.next()){
                bloggerId = rs.getInt("id");
            }
            
          //insert into Relational table
          for(String cid : catIds){
              String sql3 = "insert into blogger_category(bloggerId,categoryId) values(?,?)";
              PreparedStatement smt3 = con.prepareStatement(sql3);
              smt3.setInt(1, bloggerId);
              smt3.setInt(2, Integer.parseInt(cid));
              smt3.executeUpdate();
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

 public boolean delete(int id){
        boolean status= false;
        try{
            Connection con = ConnectionProvider.getConnection();
            
        }catch(Exception e){
            System.out.println("Deltetion error : " +e.getMessage());
        }
        return status;
    }
 
 
  public boolean update(Blogger blogger){
        boolean status= false;
        
        return status;
   }
  
  public boolean updateStatus(int id, String newStatus){
        boolean status=false;
        try{
            Connection con = ConnectionProvider.getConnection();
            String sql = "update blogger set status=? where id=?";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, newStatus);
            smt.setInt(2, id);
            int n = smt.executeUpdate();
            if(n>0)
                status=true;
        }catch(Exception e){
            System.out.println("Error : " + e.getMessage());
        }
        return status; 
   }
  
  
  public Blogger find(int id){
      Blogger blogger =null;
      try{
          Connection con = ConnectionProvider.getConnection();
          String sql = "select * from blogger where id=?";
          PreparedStatement smt = con.prepareStatement(sql);
          smt.setInt(1, id);
          ResultSet rs = smt.executeQuery();
          if(rs.next()){
              blogger = new Blogger();
              blogger.setId(rs.getInt("id"));
              blogger.setName(rs.getString("name"));
              blogger.setContact(rs.getString("contact"));
              blogger.setUserid(rs.getString("userid"));
              blogger.setPassword(rs.getString("password"));
              blogger.setImage(rs.getString("image"));
              blogger.setStatus(rs.getString("status"));
              blogger.setAddress(rs.getString("address"));
          }
      }
      catch(Exception e){
          System.out.println("Error : " +e.getMessage());
      }
      return blogger;
  }

public Blogger find(String userid , String password){
      Blogger blogger =null;
      try{
          Connection con = ConnectionProvider.getConnection();
          String sql = "select * from blogger where userid=? and password=?";
          PreparedStatement smt = con.prepareStatement(sql);
          smt.setString(1, userid);
          smt.setString(2, password);
          ResultSet rs = smt.executeQuery();
          if(rs.next()){
              blogger = new Blogger();
              blogger.setId(rs.getInt("id"));
              blogger.setName(rs.getString("name"));
              blogger.setContact(rs.getString("contact"));
              blogger.setUserid(rs.getString("userid"));
              blogger.setPassword(rs.getString("password"));
              blogger.setImage(rs.getString("image"));
              blogger.setStatus(rs.getString("status"));
              blogger.setAddress(rs.getString("address"));
          }
      }
      catch(Exception e){
          System.out.println("Error : " +e.getMessage());
      }
      
      return blogger;
  }

public Blogger findByUserid_mobile(String userid , String contact){
      Blogger blogger =null;
      try{
          Connection con = ConnectionProvider.getConnection();
          String sql = "select * from blogger where userid=? and contact=?";
          PreparedStatement smt = con.prepareStatement(sql);
          smt.setString(1, userid);
          smt.setString(2, contact);
          System.out.println("inside Dao ...");
          ResultSet rs = smt.executeQuery();
          if(rs.next()){
              System.out.println("data found ...");
              blogger = new Blogger();
              blogger.setId(rs.getInt("id"));
              blogger.setName(rs.getString("name"));
              blogger.setContact(rs.getString("contact"));
              blogger.setUserid(rs.getString("userid"));
              blogger.setPassword(rs.getString("password"));
              blogger.setImage(rs.getString("image"));
              blogger.setStatus(rs.getString("status"));
              blogger.setAddress(rs.getString("address"));
          }
      }
      catch(Exception e){
          System.out.println("Error : " +e.getMessage());
      }
      
      return blogger;
  }


public boolean isExist(String userid){
    boolean status=false; 
    try{
          Connection con = ConnectionProvider.getConnection();
          String sql = "select * from blogger where userid=?";
          PreparedStatement smt = con.prepareStatement(sql);
          smt.setString(1, userid);
          ResultSet rs = smt.executeQuery();
          if(rs.next()){
              status=true;
              }
      }
      catch(Exception e){
          System.out.println("Error : " +e.getMessage());
      }
      
      return status;
  }


public ArrayList<Blogger> findAll(){
      ArrayList<Blogger> bloggerList = new ArrayList();
      try{
          Connection con = ConnectionProvider.getConnection();
          String sql = "select * from blogger";
          PreparedStatement smt = con.prepareStatement(sql);
          ResultSet rs = smt.executeQuery();
          while(rs.next()){
              Blogger blogger = new Blogger();
              blogger = new Blogger();
              blogger.setId(rs.getInt("id"));
              blogger.setName(rs.getString("name"));
              blogger.setContact(rs.getString("contact"));
              blogger.setUserid(rs.getString("userid"));
              blogger.setPassword(rs.getString("password"));
              blogger.setImage(rs.getString("image"));
              blogger.setStatus(rs.getString("status"));
              blogger.setAddress(rs.getString("address"));
              
              bloggerList.add(blogger);
          }
      }
      catch(Exception e){
          System.out.println("Error : " +e.getMessage());
      }
      
      return bloggerList;
  }

public ArrayList<Blogger> findByCatId(int catId){
      ArrayList<Blogger> bloggerList = new ArrayList();
      try{
          Connection con = ConnectionProvider.getConnection();
          String sql = "select * from blogger where id in (select bloggerId from blogger_category where categoryId=?)";
          PreparedStatement smt = con.prepareStatement(sql);
          smt.setInt(1, catId);
          ResultSet rs = smt.executeQuery();
          while(rs.next()){
              Blogger blogger = new Blogger();
              blogger = new Blogger();
              blogger.setId(rs.getInt("id"));
              blogger.setName(rs.getString("name"));
              blogger.setContact(rs.getString("contact"));
              blogger.setUserid(rs.getString("userid"));
              blogger.setPassword(rs.getString("password"));
              blogger.setImage(rs.getString("image"));
              blogger.setStatus(rs.getString("status"));
              blogger.setAddress(rs.getString("address"));
              
              bloggerList.add(blogger);
          }
      }
      catch(Exception e){
          System.out.println("Error : " +e.getMessage());
      }
      
      return bloggerList;
  }

}
