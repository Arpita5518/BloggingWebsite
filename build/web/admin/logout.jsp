
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.removeAttribute("admin");
    response.sendRedirect("../login.jsp");
%>
    