package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gist.beans.Admin;
import gist.daos.AminDao;

public final class viewCategories_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    Admin admin = (Admin)session.getAttribute("admin"); 
    if(admin==null)
    {
      response.sendRedirect("../login.jsp");
      return; 
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html dir=\"ltr\" lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <!-- Tell the browser to be responsive to screen width -->\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta name=\"keywords\"\n");
      out.write("        content=\"wrappixel, admin dashboard, html css dashboard, web dashboard, bootstrap 5 admin, bootstrap 5, css3 dashboard, bootstrap 5 dashboard, Monsterlite admin bootstrap 5 dashboard, frontend, responsive bootstrap 5 admin template, Monster admin lite design, Monster admin lite dashboard bootstrap 5 dashboard template\">\n");
      out.write("    <meta name=\"description\"\n");
      out.write("        content=\"Monster Lite is powerful and clean admin dashboard template, inpired from Bootstrap Framework\">\n");
      out.write("    <meta name=\"robots\" content=\"noindex,nofollow\">\n");
      out.write("    <title>Monster Lite Template by WrapPixel</title>\n");
      out.write("    <link rel=\"canonical\" href=\"https://www.wrappixel.com/templates/monster-admin-lite/\" />\n");
      out.write("    <!-- Favicon icon -->\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"assets/images/favicon.png\">\n");
      out.write("    <!-- Custom CSS -->\n");
      out.write("    <link href=\"assets/plugins/chartist/dist/chartist.min.css\" rel=\"stylesheet\">\n");
      out.write("    <!-- Custom CSS -->\n");
      out.write("    <link href=\"css/style.min.css\" rel=\"stylesheet\">\n");
      out.write("    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("    <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n");
      out.write("    <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("<![endif]-->\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <!-- ============================================================== -->\n");
      out.write("    <!-- Preloader - style you can find in spinners.css -->\n");
      out.write("    <!-- ============================================================== -->\n");
      out.write("    <div class=\"preloader\">\n");
      out.write("        <div class=\"lds-ripple\">\n");
      out.write("            <div class=\"lds-pos\"></div>\n");
      out.write("            <div class=\"lds-pos\"></div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- ============================================================== -->\n");
      out.write("    <!-- Main wrapper - style you can find in pages.scss -->\n");
      out.write("    <!-- ============================================================== -->\n");
      out.write("    <div id=\"main-wrapper\" data-layout=\"vertical\" data-navbarbg=\"skin6\" data-sidebartype=\"full\"\n");
      out.write("        data-sidebar-position=\"absolute\" data-header-position=\"absolute\" data-boxed-layout=\"full\">\n");
      out.write("        <!-- ============================================================== -->\n");
      out.write("        <!-- Topbar header - style you can find in pages.scss -->\n");
      out.write("        <!-- ============================================================== -->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("        <!-- ============================================================== -->\n");
      out.write("        <!-- End Topbar header -->\n");
      out.write("        <!-- ============================================================== -->\n");
      out.write("        <!-- ============================================================== -->\n");
      out.write("        <!-- Left Sidebar - style you can find in sidebar.scss  -->\n");
      out.write("        <!-- ============================================================== -->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sidebar.jsp", out, false);
      out.write("\n");
      out.write("        <!-- ============================================================== -->\n");
      out.write("        <!-- End Left Sidebar - style you can find in sidebar.scss  -->\n");
      out.write("        <!-- ============================================================== -->\n");
      out.write("        <!-- ============================================================== -->\n");
      out.write("        <!-- Page wrapper  -->\n");
      out.write("        <!-- ============================================================== -->\n");
      out.write("        <div class=\"page-wrapper\">\n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("            <!-- Bread crumb and right sidebar toggle -->\n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("            \n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("            <!-- End Bread crumb and right sidebar toggle -->\n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("            <!-- Container fluid  -->\n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("            <div class=\"container-fluid\"> \n");
      out.write("                <h1>Category Management </h1>\n");
      out.write("            \n");
      out.write("            </div>\n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("            <!-- End Container fluid  -->\n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("            <!-- footer -->\n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("            <!-- End footer -->\n");
      out.write("            <!-- ============================================================== -->\n");
      out.write("        </div>\n");
      out.write("        <!-- ============================================================== -->\n");
      out.write("        <!-- End Page wrapper  -->\n");
      out.write("        <!-- ============================================================== -->\n");
      out.write("    </div>\n");
      out.write("    <!-- ============================================================== -->\n");
      out.write("    <!-- End Wrapper -->\n");
      out.write("    <!-- ============================================================== -->\n");
      out.write("    <!-- ============================================================== -->\n");
      out.write("    <!-- All Jquery -->\n");
      out.write("    <!-- ============================================================== -->\n");
      out.write("    <script src=\"assets/plugins/jquery/dist/jquery.min.js\"></script>\n");
      out.write("    <!-- Bootstrap tether Core JavaScript -->\n");
      out.write("    <script src=\"assets/plugins/bootstrap/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("    <script src=\"js/app-style-switcher.js\"></script>\n");
      out.write("    <!--Wave Effects -->\n");
      out.write("    <script src=\"js/waves.js\"></script>\n");
      out.write("    <!--Menu sidebar -->\n");
      out.write("    <script src=\"js/sidebarmenu.js\"></script>\n");
      out.write("    <!--Custom JavaScript -->\n");
      out.write("    <script src=\"js/custom.js\"></script>\n");
      out.write("    <!--This page JavaScript -->\n");
      out.write("    <!--flot chart-->\n");
      out.write("    <script src=\"assets/plugins/flot/jquery.flot.js\"></script>\n");
      out.write("    <script src=\"assets/plugins/flot.tooltip/js/jquery.flot.tooltip.min.js\"></script>\n");
      out.write("    <script src=\"js/pages/dashboards/dashboard1.js\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
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
