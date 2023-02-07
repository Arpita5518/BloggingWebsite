package gist.controllers;

import gist.beans.Blogger;
import gist.daos.BloggerDao;
import gist.util.ImageUtility;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class BloggerController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String op = request.getParameter("op");
        if(op!=null && op.equalsIgnoreCase("checkuserid")){
            String userid  = request.getParameter("userid");
            BloggerDao bd = new BloggerDao();
            System.out.println("data :"  + userid);
            if(bd.isExist(userid))
                out.println("<font color='red'>Sorry! this userid is already registred !!</font>");
            else
               out.println("<font color='blue'>Congrates! this userid is available </font>");
        }
     }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        String op = request.getParameter("op");
        if(op!=null && op.equalsIgnoreCase("add")){
            String imagePath = ImageUtility.uploadImage(request, getServletConfig(),"blogger/profilePics" );
            HttpSession session = request.getSession();
            Blogger blogger = (Blogger)session.getAttribute("blogger");
            blogger.setImage(imagePath);
            String cids[] = (String[]) session.getAttribute("cids");
            System.out.println("1");
            BloggerDao bd = new BloggerDao();
            if(bd.add(blogger, cids))
                response.sendRedirect("login.jsp");
            else
                out.println("unable to registered...");
        }
        }

   
}
