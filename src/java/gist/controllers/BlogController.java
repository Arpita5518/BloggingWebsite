package gist.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import gist.beans.Blog;
import gist.beans.Blogger;
import gist.daos.BlogDao;
import gist.util.ImageUtility;
import javax.servlet.http.HttpSession;

public class BlogController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String op = request.getParameter("op");
        if(op!=null && op.equals("add")){
            String imgPath = ImageUtility.uploadImage(request, getServletConfig(), "blogger/blogImages/");
            HttpSession session = request.getSession();
            Blog blog = (Blog)session.getAttribute("blog");
            blog.setImage(imgPath);
            String catIds[] = (String[])session.getAttribute("catIds");
            BlogDao bd = new BlogDao();
            if(bd.add(blog, catIds)){
                response.sendRedirect("blogger/viewEditPost.jsp");
            }
            else {
                out.println("Blog not Saved !!!");
            }
        }
    }

}
