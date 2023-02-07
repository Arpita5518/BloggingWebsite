package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gist.beans.Category;
import java.util.ArrayList;
import gist.daos.CategoryDao;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Blogger Registraion </title>\n");
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
      out.write("    <script> \n");
      out.write("    function validate(){\n");
      out.write("        p1 = document.getElementById(\"password\").value;\n");
      out.write("        p2 = document.getElementById(\"repassword\").value;\n");
      out.write("        categories = document.getElementsByName(\"category\");\n");
      out.write("        cn=0;\n");
      out.write("        if(p1!==p2)\n");
      out.write("        {\n");
      out.write("            document.getElementById(\"s2\").innerHTML  = \"Password and Confirm password not matched\";\n");
      out.write("            return false;\n");
      out.write("        }\n");
      out.write("        else \n");
      out.write("            document.getElementById(\"s2\").innerHTML  = \"\";\n");
      out.write("            \n");
      out.write("        \n");
      out.write("        for(c of categories)\n");
      out.write("            if (c.checked)\n");
      out.write("                cn++;\n");
      out.write("       \n");
      out.write("       if(cn==0)\n");
      out.write("       {\n");
      out.write("         document.getElementById(\"s3\").innerHTML = \"Please Select any Category\";\n");
      out.write("         return false;\n");
      out.write("       }\n");
      out.write("        \n");
      out.write("    } \n");
      out.write("    \n");
      out.write("    function checkUserid(userid,result){\n");
      out.write("        ajax= new XMLHttpRequest();\n");
      out.write("        ajax.open(\"GET\",\"BloggerController?op=checkuserid&userid=\"+userid, true);\n");
      out.write("        ajax.send();\n");
      out.write("        ajax.onreadystatechange = function(){\n");
      out.write("           if(this.readyState==4 && this.status==200)\n");
      out.write("           {\n");
      out.write("               result.innerHTML = this.responseText;\n");
      out.write("        }\n");
      out.write("        };\n");
      out.write("    }\n");
      out.write("    </script>\n");
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
      out.write("                    <h2> Blogger Registration </h2>\n");
      out.write("                    <form action=\"register2.jsp\" method=\"post\" onsubmit=\"return validate();\">\n");
      out.write("                        <table class=\"table\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td> Enter Name </td>\n");
      out.write("                            <td> <input type=\"text\" name=\"name\" class=\"form-control\" required/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td> Enter Contact number </td>\n");
      out.write("                            <td> <input type=\"text\" name=\"contact\" class=\"form-control\" required/></td>\n");
      out.write("                        </tr>\n");
      out.write("                    \n");
      out.write("                        <tr>\n");
      out.write("                            <td> Enter Userid </td>\n");
      out.write("                            <td> <input type=\"email\" name=\"userid\" class=\"form-control\" onchange=\"checkUserid(this.value,s1);\" required/>\n");
      out.write("                                <br/>\n");
      out.write("                                <span id=\"s1\" style=\"font-size: 20px;\"></span>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    \n");
      out.write("                        <tr>\n");
      out.write("                            <td> Enter Password </td>\n");
      out.write("                            <td>Password (UpperCase, LowerCase, Number/SpecialChar and min 8 Chars)\n");
      out.write("                                 <input type=\"password\" id=\"password\" name=\"password\" class=\"form-control\" pattern=\"(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$\" required/>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    \n");
      out.write("                        <tr>\n");
      out.write("                            <td> Re-Enter Password </td>\n");
      out.write("                            <td> <input type=\"password\" id=\"repassword\" name=\"repassword\" class=\"form-control\" required/>\n");
      out.write("                            <br/>\n");
      out.write("                            <span id=\"s2\" style=\"font-size:20px;color:red\"></span>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    <tr>\n");
      out.write("                            <td> Enter Address </td>\n");
      out.write("                            <td> <input type=\"text\" name=\"address\" class=\"form-control\"/></td>\n");
      out.write("                            <br/>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                            <td> Select Categories </td>\n");
      out.write("                            <td>   \n");
      out.write("                                <span id=\"s3\" style=\"font-size: 20px; color:red\"></span><br/>\n");
      out.write("                                ");

                                CategoryDao cd = new CategoryDao();
                                ArrayList<Category> catlist = cd.findAll();
                                for(Category c : catlist){
      out.write("\n");
      out.write("                                <input type=\"checkbox\" name=\"category\" value=\"");
      out.print(c.getId());
      out.write("\"/> ");
      out.print(c.getName());
      out.write(" \n");
      out.write("                                <br/>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td colspan=\"2\"><input type=\"submit\" name=\"submit\" value=\"Next Page\" class=\"btn btn-primary form-control\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    </table>\n");
      out.write("                \n");
      out.write("                    </form>\n");
      out.write("                    </div>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          <!-- sidebar -->\n");
      out.write("        \n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </section>\n");
      out.write("<br/><br/>\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("   \n");
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
