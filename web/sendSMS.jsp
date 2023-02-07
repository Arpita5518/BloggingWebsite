<%-- 
    Document   : sendSMS
    Created on : 27-Apr-2022, 09:25:53
    Author     : DELL
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <pre>
        <form action="SmsController?op=sendmessage" method="post">
            Enter Number    <input type="text" name="mobile" required/>
            
            Enter Message : 
            <textarea name="message" rows="5" cols="20">
                
            </textarea>
            
            <input type="submit" name="submit" value="send message"/>
        </form>
        </pre>
        
      </body>
</html>
