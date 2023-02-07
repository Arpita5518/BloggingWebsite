
<%@page import="gist.beans.Blogger"%>
<%@page import="gist.daos.BloggerDao"%>
<%@page import="gist.beans.Admin"%>
<%@page import="gist.daos.AdminDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
Blogger blogger = (Blogger) session.getAttribute("blogger");
Admin admin = (Admin) session.getAttribute("admin"); 
if(blogger!=null)
 response.sendRedirect("blogger/dashboard.jsp"); 
else if(admin!=null)
 response.sendRedirect("admin/dashboard.jsp");

%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="TemplateMo">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i&display=swap" rel="stylesheet">

    <title>Login page</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-stand-blog.css">
    <link rel="stylesheet" href="assets/css/owl.css">

    <script>
        function checkRole(){
            roles = document.getElementsByName("role");
            cn=0;
            for(role of roles){
               if(role.checked)
                  cn++;
            }
            if(cn==0)
            {
                alert("please select any role ");
                return false;
            }
            else 
                return true;
        }
        </script>
  </head>

  <body>

    <!-- ***** Preloader Start ***** -->
    <div id="preloader">
        <div class="jumper">
            <div></div>
            <div></div>
            <div></div>
        </div>
    </div>  
    <!-- ***** Preloader End ***** -->

    <!-- Header -->
    <jsp:include page="header.jsp"></jsp:include>

    <!-- Page Content -->
    <!-- Banner Starts Here -->
    <div class="main-banner header-text">
      <div class="container-fluid">
      </div>
    </div>
   <br/><br/>
    <section class="blog-posts">
      <div class="container">
        <div class="row">
          <div class="col-lg-8">
            <div class="all-blog-posts">
              <div class="row">
                  <!-- main conent area -->
                  
                  <div class="col-lg-12" style="height: 100vh">
                    <h2> Login page </h2> <br/><br/>
                    <span style="color:red;font-weight: bold;font-size: 20px">${param.msg}</span><br/>
                  <%
                  Cookie cookies[] = request.getCookies();
                  String uid="";
                  String pwd="";
                  for(Cookie c: cookies ){
                      if(c.getName().equals("userid"))
                          uid = c.getValue();
                      if(c.getName().equals("password"));
                            pwd = c.getValue();
                  }
                  %>
                    <form method="get" onsubmit="return checkRole();">
                        <table class="table" width='50%'>
                        <tr>
                            <td>Select Role </td>
                            <td>
                                <input type="radio" name="role" value="admin"/>Admin 
                                <span style="width:100px;display: inline-block"> </span>
                                <input type="radio" name="role" value="blogger"/>Blogger
                            </td>
                        </tr>
                        <tr>
                            <td>Enter Userid</td>
                            <td><input type="email" name="userid" value="<%=uid%>" required class="form-control"/></td>
                        </tr>
                        <tr>
                            <td>Enter Password</td>
                            <td><input type="password" name="password" value="<%=pwd%>" required class="form-control"/></td>
                        </tr>
                        <tr>
                            <td>Check the Box for Saving Details</td>
                            <td><input type="checkbox" name="remember" value="remember"/>Remember Me
                        </tr>
                    <tr>
                         <tr>
                             <td>Forget Password? <a href="#">Cick Here to recover</td>
                             <td><a href="register.jsp">Register as Blogger</a></td>
                        </tr>
                        <br/><br/>
                    <tr>
                        <td colspan="2"><input type="submit" name="submit" value="Login" class="btn btn-primary form-control "/></td>
                        </tr>
                    
                    </table>
                    </form>
                </div>
                
                
                </div>
            </div>
          </div>
          <!-- sidebr -->
        
        </div>
      </div>
    </section>

    
    <jsp:include page="footer.jsp"></jsp:include>
    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Additional Scripts -->
    <script src="assets/js/custom.js"></script>
    <script src="assets/js/owl.js"></script>
    <script src="assets/js/slick.js"></script>
    <script src="assets/js/isotope.js"></script>
    <script src="assets/js/accordions.js"></script>

    <script language = "text/Javascript"> 
      cleared[0] = cleared[1] = cleared[2] = 0; //set a cleared flag for each field
      function clearField(t){                   //declaring the array outside of the
      if(! cleared[t.id]){                      // function makes it static and global
          cleared[t.id] = 1;  // you could use true and false, but that's more typing
          t.value='';         // with more chance of typos
          t.style.color='#fff';
          }
      }
    </script>

    <%
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
        %>
    
    
  </body>
</html>