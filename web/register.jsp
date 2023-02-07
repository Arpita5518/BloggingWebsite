
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
    function validate(){
        p1 = document.getElementById("password").value;
        p2 = document.getElementById("repassword").value;
        categories = document.getElementsByName("category");
        cn=0;
        if(p1!==p2)
        {
            document.getElementById("s2").innerHTML  = "Password and Confirm password not matched";
            return false;
        }
        else 
            document.getElementById("s2").innerHTML  = "";
            
        
        for(c of categories)
            if (c.checked)
                cn++;
       
       if(cn==0)
       {
         document.getElementById("s3").innerHTML = "Please Select any Category";
         return false;
       }
        
    } 
    
    function checkUserid(userid,result){
        ajax= new XMLHttpRequest();
        ajax.open("GET","BloggerController?op=checkuserid&userid="+userid, true);
        ajax.send();
        ajax.onreadystatechange = function(){
           if(this.readyState==4 && this.status==200)
           {
               result.innerHTML = this.responseText;
        }
        };
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
                    <h2> Blogger Registration </h2>
                    <form action="register2.jsp" method="post" onsubmit="return validate();">
                        <table class="table">
                        <tr>
                            <td> Enter Name </td>
                            <td> <input type="text" name="name" class="form-control" required/></td>
                        </tr>
                        <tr>
                            <td> Enter Contact number </td>
                            <td> <input type="text" name="contact" class="form-control" required/></td>
                        </tr>
                    
                        <tr>
                            <td> Enter Userid </td>
                            <td> <input type="email" name="userid" class="form-control" onchange="checkUserid(this.value,s1);" required/>
                                <br/>
                                <span id="s1" style="font-size: 20px;"></span>
                            </td>
                        </tr>
                    
                        <tr>
                            <td> Enter Password </td>
                            <td>Password (UpperCase, LowerCase, Number/SpecialChar and min 8 Chars)
                                 <input type="password" id="password" name="password" class="form-control" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" required/>
                            </td>
                        </tr>
                    
                        <tr>
                            <td> Re-Enter Password </td>
                            <td> <input type="password" id="repassword" name="repassword" class="form-control" required/>
                            <br/>
                            <span id="s2" style="font-size:20px;color:red"></span>
                            </td>
                        </tr>
                    <tr>
                            <td> Enter Address </td>
                            <td> <input type="text" name="address" class="form-control"/></td>
                            <br/>
                    </tr>
                    <tr>
                            <td> Select Categories </td>
                            <td>   
                                <span id="s3" style="font-size: 20px; color:red"></span><br/>
                                <%
                                CategoryDao cd = new CategoryDao();
                                ArrayList<Category> catlist = cd.findAll();
                                for(Category c : catlist){%>
                                <input type="checkbox" name="category" value="<%=c.getId()%>"/> <%=c.getName()%> 
                                <br/>
                                <%}%>
                            </td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" name="submit" value="Next Page" class="btn btn-primary form-control"/></td>
                    </tr>
                    </table>
                
                    </form>
                    </div>
                
                
                </div>
            </div>
          </div>
          <!-- sidebar -->
        
        </div>
      </div>
    </section>
<br/><br/>
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