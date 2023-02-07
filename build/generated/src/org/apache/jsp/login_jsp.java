package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gist.beans.Blogger;
import gist.daos.BloggerDao;
import gist.beans.Admin;
import gist.daos.AdminDao;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

Blogger blogger = (Blogger) session.getAttribute("blogger");
Admin admin = (Admin) session.getAttribute("admin"); 
if(blogger!=null)
 response.sendRedirect("blogger/dashboard.jsp"); 
else if(admin!=null)
 response.sendRedirect("admin/dashboard.jsp");


      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("  <head>\n");
      out.write("\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"TemplateMo\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i&display=swap\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <title>Login page</title>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap core CSS -->\n");
      out.write("    <link href=\"vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- Additional CSS Files -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/fontawesome.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/templatemo-stand-blog.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/owl.css\">\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        function checkRole(){\n");
      out.write("            roles = document.getElementsByName(\"role\");\n");
      out.write("            cn=0;\n");
      out.write("            for(role of roles){\n");
      out.write("               if(role.checked)\n");
      out.write("                  cn++;\n");
      out.write("            }\n");
      out.write("            if(cn==0)\n");
      out.write("            {\n");
      out.write("                alert(\"please select any role \");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("            else \n");
      out.write("                return true;\n");
      out.write("        }\n");
      out.write("        </script>\n");
      out.write("  </head>\n");
      out.write("\n");
      out.write("  <body>\n");
      out.write("\n");
      out.write("    <!-- ***** Preloader Start ***** -->\n");
      out.write("    <div id=\"preloader\">\n");
      out.write("        <div class=\"jumper\">\n");
      out.write("            <div></div>\n");
      out.write("            <div></div>\n");
      out.write("            <div></div>\n");
      out.write("        </div>\n");
      out.write("    </div>  \n");
      out.write("    <!-- ***** Preloader End ***** -->\n");
      out.write("\n");
      out.write("    <!-- Header -->\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("    <!-- Page Content -->\n");
      out.write("    <!-- Banner Starts Here -->\n");
      out.write("    <div class=\"main-banner header-text\">\n");
      out.write("      <div class=\"container-fluid\">\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("   <br/><br/>\n");
      out.write("    <section class=\"blog-posts\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("          <div class=\"col-lg-8\">\n");
      out.write("            <div class=\"all-blog-posts\">\n");
      out.write("              <div class=\"row\">\n");
      out.write("                  <!-- main conent area -->\n");
      out.write("                  \n");
      out.write("                  <div class=\"col-lg-12\" style=\"height: 100vh\">\n");
      out.write("                    <h2> Login page </h2> <br/><br/>\n");
      out.write("                    <span style=\"color:red;font-weight: bold;font-size: 20px\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span><br/>\n");
      out.write("                  ");

                  Cookie cookies[] = request.getCookies();
                  String uid="";
                  String pwd="";
                  for(Cookie c: cookies ){
                      if(c.getName().equals("userid"))
                          uid = c.getValue();
                      if(c.getName().equals("password"));
                            pwd = c.getValue();
                  }
                  
      out.write("\n");
      out.write("                    <form method=\"get\" onsubmit=\"return checkRole();\">\n");
      out.write("                        <table class=\"table\" width='50%'>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Select Role </td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"radio\" name=\"role\" value=\"admin\"/>Admin \n");
      out.write("                                <span style=\"width:100px;display: inline-block\"> </span>\n");
      out.write("                                <input type=\"radio\" name=\"role\" value=\"blogger\"/>Blogger\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Enter Userid</td>\n");
      out.write("                            <td><input type=\"email\" name=\"userid\" value=\"");
      out.print(uid);
      out.write("\" required class=\"form-control\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Enter Password</td>\n");
      out.write("                            <td><input type=\"password\" name=\"password\" value=\"");
      out.print(pwd);
      out.write("\" required class=\"form-control\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Check the Box for Saving Details</td>\n");
      out.write("                            <td><input type=\"checkbox\" name=\"remember\" value=\"remember\"/>Remember Me\n");
      out.write("                        </tr>\n");
      out.write("                    <tr>\n");
      out.write("                         <tr>\n");
      out.write("                             <td>Forget Password? <a href=\"#\">Cick Here to recover</td>\n");
      out.write("                             <td><a href=\"register.jsp\">Register as Blogger</a></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <br/><br/>\n");
      out.write("                    <tr>\n");
      out.write("                        <td colspan=\"2\"><input type=\"submit\" name=\"submit\" value=\"Login\" class=\"btn btn-primary form-control \"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                    \n");
      out.write("                    </table>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          <!-- sidebr -->\n");
      out.write("        \n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </section>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("    <!-- Bootstrap core JavaScript -->\n");
      out.write("    <script src=\"vendor/jquery/jquery.min.js\"></script>\n");
      out.write("    <script src=\"vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Additional Scripts -->\n");
      out.write("    <script src=\"assets/js/custom.js\"></script>\n");
      out.write("    <script src=\"assets/js/owl.js\"></script>\n");
      out.write("    <script src=\"assets/js/slick.js\"></script>\n");
      out.write("    <script src=\"assets/js/isotope.js\"></script>\n");
      out.write("    <script src=\"assets/js/accordions.js\"></script>\n");
      out.write("\n");
      out.write("    <script language = \"text/Javascript\"> \n");
      out.write("      cleared[0] = cleared[1] = cleared[2] = 0; //set a cleared flag for each field\n");
      out.write("      function clearField(t){                   //declaring the array outside of the\n");
      out.write("      if(! cleared[t.id]){                      // function makes it static and global\n");
      out.write("          cleared[t.id] = 1;  // you could use true and false, but that's more typing\n");
      out.write("          t.value='';         // with more chance of typos\n");
      out.write("          t.style.color='#fff';\n");
      out.write("          }\n");
      out.write("      }\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("    ");

        if(request.getParameter("submit")!=null){
            String role = request.getParameter("role");
            if(role.equalsIgnoreCase("admin")){
                String userid = request.getParameter("userid");
                String password = request.getParameter("password");
                AdminDao ad =new AdminDao();
                 admin =ad.find(userid,password);
                if(admin!=null){
                    String remember = request.getParameter("remember"); 
                    if(remember!=null && remember.equalsIgnoreCase("remember")){
                        Cookie c1 = new Cookie("userid", userid);
                        Cookie c2 = new Cookie("password", password);
                        c1.setMaxAge(60*60*24*7);
                        c2.setMaxAge(60*60*24*7);
                        response.addCookie(c1);
                        response.addCookie(c2);
                    }
                    session.setAttribute("admin", admin);
                    response.sendRedirect("admin/dashboard.jsp");
                }
                else 
                    response.sendRedirect("login.jsp?msg=Invalid Userid or Password");
            }
            else if(role.equalsIgnoreCase("blogger")){
                String userid = request.getParameter("userid");
                String password = request.getParameter("password");
                BloggerDao bd =new BloggerDao();
                 blogger =bd.find(userid,password);
                if(blogger!=null){
                    if (blogger.getStatus().equalsIgnoreCase("approved")){
                        String remember = request.getParameter("remember"); 
                        if(remember!=null && remember.equalsIgnoreCase("remember")){
                        Cookie c1 = new Cookie("userid", userid);
                        Cookie c2 = new Cookie("password", password);
                        c1.setMaxAge(60*60*24*7);
                        c2.setMaxAge(60*60*24*7);
                        response.addCookie(c1);
                        response.addCookie(c2);
                    }
                    
                    session.setAttribute("blogger", blogger);
                    response.sendRedirect("blogger/dashboard.jsp");
                    }
                    else 
                    response.sendRedirect("login.jsp?msg=Blogger is not Approved By Admin!");
                 
                }
                else 
                    response.sendRedirect("login.jsp?msg=Invalid Userid or Password");
            
            }
        }
        
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("  </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
