
<%@page import="gist.beans.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="gist.daos.CategoryDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="TemplateMo">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i&display=swap" rel="stylesheet">

    <title>Blogger Registraion </title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-stand-blog.css">
    <link rel="stylesheet" href="assets/css/owl.css">

  <script>

            function showImage(input,output) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();

                    reader.onload = function (e) {
                        output.src = e.target.result;
                    };

                    reader.readAsDataURL(input.files[0]);
                }
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
              <jsp:useBean class="gist.beans.Blogger" id="blogger" scope="session"></jsp:useBean>
              <jsp:setProperty name="blogger" property="*"/>
              <%
                  String cids[] = request.getParameterValues("category");
                  session.setAttribute("cids", cids);
                  %>
              
                  <div class="col-lg-12" style="height: 100vh">
                    <h2> Upload Profile Image </h2>
                    <form action="BloggerController?op=add" method="post" enctype="multipart/form-data">
                        <table class="table">
                        <tr>
                            <td> Select Profile Image </td>
                          </tr>
                        <tr>
                            <td>
                                <img src="" style="width:200px; height: 300px; border-style: solid;border-width: 2px" id="pic"/>
                            </td>    
                        </tr>
                    
                        <tr>
                            <td> <input type="file" id="image" name="image"onchange="showImage(this,pic)"/> </td>
                        </tr>
                    
                        
                    <tr>
                        <td colspan="2"><input type="submit" name="submit" value="Register" class="btn btn-primary form-control"/></td>
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

  </body>
</html>