
package gist.daos;
import java.sql.*;
import gist.db.ConnectionProvider;
import gist.beans.Feedback;
import java.util.ArrayList;

public class FeedbackDao {
    public boolean add(Feedback feedback){
        boolean status=false;
        try{
            Connection con =ConnectionProvider.getConnection();
            String sql = "insert into feedback (name,feedback,blogid) values(?,?,?)";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, feedback.getName());
            smt.setString(2, feedback.getFeedback());
            smt.setInt(3, feedback.getBlogId());
            int n = smt.executeUpdate();
            if (n>0)
                status=true;
            con.close();
        }catch(Exception e){
            System.out.println("Error : " + e.getMessage());
        }
        return status;
    }
    
    public boolean addReply(int blogId, String msg){
        boolean status =false;
         try{
            Connection con =ConnectionProvider.getConnection();
            String sql = "update feedback set reply = ? where id=?";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, msg);
            smt.setInt(2, blogId);
            int n = smt.executeUpdate();
            if (n>0)
                status=true;
            con.close();
        }catch(Exception e){
            System.out.println("Error : " + e.getMessage());
        }
       
        return status;
    }
    
    public ArrayList<Feedback> findByBlogId(int blogId){
        ArrayList<Feedback> fblist = new ArrayList();
         try{
            Connection con =ConnectionProvider.getConnection();
            String sql = "select * from feedback where blogId=?";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setInt(1, blogId);
            ResultSet rs = smt.executeQuery();
            while(rs.next()){
                Feedback feedback = new Feedback();
                feedback.setId(rs.getInt("id"));
                feedback.setName(rs.getString("name"));
                feedback.setFeedback(rs.getString("feedback"));
                feedback.setBlogId(rs.getInt("blogId"));
                feedback.setReply(rs.getString("reply"));
               
                fblist.add(feedback);
            }
            con.close();
        }catch(Exception e){
            System.out.println("Error : " + e.getMessage());
        }
        return fblist;
    }
    
    public ArrayList<Feedback> findByBloggerId(int bloggerId){
       ArrayList<Feedback> fblist = new ArrayList();
         try{
            Connection con =ConnectionProvider.getConnection();
            String sql = "select * from feedback where blogId in (select id from blogs where bloggerId = ?)";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setInt(1, bloggerId);
            ResultSet rs = smt.executeQuery();
            while(rs.next()){
                Feedback feedback = new Feedback();
                feedback.setId(rs.getInt("id"));
                feedback.setName(rs.getString("name"));
                feedback.setFeedback(rs.getString("feedback"));
                feedback.setBlogId(rs.getInt("blogId"));
                feedback.setReply(rs.getString("reply"));
               
                fblist.add(feedback);
            }
            con.close();
        }catch(Exception e){
            System.out.println("Error : " + e.getMessage());
        }
        return fblist;
     
    }
}
