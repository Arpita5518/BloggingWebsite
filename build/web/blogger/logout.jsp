<%-- 
    Document   : logout
    Created on : 27-Apr-2022, 08:19:22
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    session.removeAttribute("blogger");
    response.sendRedirect("../login.jsp");
%>
    